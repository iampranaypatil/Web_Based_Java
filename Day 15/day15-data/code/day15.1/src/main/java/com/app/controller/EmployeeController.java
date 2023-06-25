package com.app.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.app.pojos.Employee;
import com.app.service.AddressService;
import com.app.service.EmployeeService;

@Controller
@RequestMapping("/emp")
public class EmployeeController {
	// dep : service layer i/f
	@Autowired
	private EmployeeService empService;

	@Autowired
	private AddressService adrService;

	public EmployeeController() {
		System.out.println("in ctor of " + getClass());
	}

	/*
	 * http://host:port/day14_boot/emp/list , method=post payload(req body) :
	 * dept_id=1
	 */
	// @RequestParam : annotation to bind incoming rq param -->
	// method argument , does the parsing also!
	// MATCH rq param name with method arg name
	// SC : Long dept_id=Long.parseLong(request.getParameter("dept_id"));
	@PostMapping("/list")
	public String listEmpsByDept(@RequestParam Long dept_id, Model map) {
		System.out.println("in list emps by dept " + dept_id);
		map.addAttribute("emp_list", empService.getAllEmpsByDeptId(dept_id));
		return "/emp/list";// AVN : /WEB-INF/views/emp/list.jsp
	}

	// http://host:port/day14_boot/emp/signin , method=GET
	@GetMapping("/signin")
	public String showLoginForm() {
		System.out.println("in show login form");
		return "/emp/login";// AVN : /WEB-INF/views/emp/login.jsp
	}

	// http://host:port/day14_boot/emp/signin , method=POST
	@PostMapping("/signin")
	public String processLoginForm(@RequestParam String email, @RequestParam String password, Model map,
			HttpSession hs) {
		System.out.println("in process login form " + email + " " + password);
		try {
			Employee emp = empService.authenticateEmp(email, password);
			hs.setAttribute("emp_dtls", emp);// scope of emp dtls : entire session
			// valid login --> get it's adr
			map.addAttribute("adr_details", 
					adrService.getAddressDetails(emp.getId()));
			
			return "/emp/details";// AVN : /WEB-INF/views/emp/details.jsp
		} catch (RuntimeException e) {
			System.out.println(e);
			map.addAttribute("message", e.getMessage());
			if(e.getMessage().contains("Address")) //=> adr yet assigned
				return "/emp/details";
			// => invalid login
			return "/emp/login";
		}

	}

	// http://localhost:8080/day15.1/emp/logout
	// add req handling method for emp's logout
	@GetMapping("/logout")
	public String empLogout(HttpSession session, Model map, HttpServletRequest request, HttpServletResponse resp) {
		System.out.println("in logout " + map);// {}
		// add emp dtls under model map , lifted from session
		map.addAttribute("details", session.getAttribute("emp_dtls"));
		// invalidate HttpSession
		session.invalidate();
		// set refresh header

		resp.setHeader("refresh", "5;url=" + request.getContextPath());
		return "/emp/logout";// AVN : /WEB-INF/views/emp/logout.jsp
	}
	// Controller --> D.S --> forwards the clnt logout.jsp -->
	// D.S sends resp (CORRECTION)--SC302|location=/day15.1 | body : logout mesg
	// clnt browser --> waits for the dly --sends NEW request :
	// --> http://localhost:8080/day15.1
}
