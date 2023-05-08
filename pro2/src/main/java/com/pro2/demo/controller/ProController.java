package com.pro2.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProController {

	@GetMapping("/login")
	public String getLogin(@RequestParam String username,@RequestParam String password) {
		
		if(username.equals("admin")&& password.equals("12345"))
		{
			return "Login successfull";
		}
		else
		{
			return "Login failed...check your username and password";
		}
	}
}
