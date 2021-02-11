package com.fatih.InventoryApp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import io.swagger.annotations.ApiOperation;

@Controller
public class AppController {
	
	@GetMapping
	@ApiOperation(value = "View Home Page")
	public String viewHomePage() {
		return "index";
	}
}
