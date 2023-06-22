package com.app.controller;

import java.time.LocalDateTime;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller // mandatory to tell SC : following is req handling
//controller=Handler , containg req handling methods
public class HomePageController {
	public HomePageController() {
		System.out.println("in ctor of " + getClass());
	}

	// add req handling method to forward the clnt to index.jsp
	@RequestMapping("/") // can intercept get/put/post/delete...
	public ModelAndView showHomePage() {
		System.out.println("in show home page");
		// API o.s.w.s.ModelAndView(String lvn,String modelAttrName,
		// Object value)
		return new ModelAndView("/index", "timestamp", 
				LocalDateTime.now());
		//Handler method rets ---> MnV --> D.S -->sends LVN --> V.R
		//---> AVN : /WEB-INF/views/index.jsp --> D.S
		//chks for model attrs --> yes --> saves it under the request scope
		//---> why : since sever pull  --> RD rd=request.getRD("/WEB-INF/views/index.jsp");
		//rd.forward(request, resp) --> JSP --> ${...}
	}
}
