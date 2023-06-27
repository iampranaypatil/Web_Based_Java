package com.app.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.UserDTO;
import com.app.service.UserService;



@RestController
@RequestMapping("/users")
public class UserController {
//dep : service layer i/f
	@Autowired
	private UserService userService;
	//http://host:port/users/signup , method=POST
	@PostMapping("/signup")
	public ResponseEntity<?> signupUser(@RequestBody @Valid UserDTO dto)
	{
		System.out.println("in signup user "+dto);
		
		return ResponseEntity
				.status(HttpStatus.CREATED)
				.body(userService.registerNewUser(dto));
	}
}
