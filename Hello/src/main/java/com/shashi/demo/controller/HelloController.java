package com.shashi.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
	
	@GetMapping("/hello")
	public String sayWish()
	{
		return "Hello SK Reddy";
	}

	@GetMapping("/wish")
public String wish(@RequestParam String name)
{
	return "Happy Birthday" + name;
}

}