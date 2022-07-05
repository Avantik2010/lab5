package com.studentmanagment.controller;

import org.springframework.stereotype.Controller;

@Controller
public class HelloController {

	@RequestMapping(path = "/",method =RequestMethod.GET)
	public String showMainPage () {
		return"demo";
	}
}
