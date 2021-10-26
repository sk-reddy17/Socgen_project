package com.shashi.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
	
	
	@GetMapping("/add/{x}/{y}")
public int add(@PathVariable int x, @PathVariable int y)
{
		return x + y;
}
	@GetMapping("/sub/{x}/{y}")
	public int sub(@PathVariable int x, @PathVariable int y)
	{
			return x - y;
	}
	@GetMapping("/mul/{x}/{y}")
	public double mul(@PathVariable double x, @PathVariable double y)
	{
			return x * y;
	}
	@GetMapping("/div/{x}/{y}")
	public double div(@PathVariable double x, @PathVariable double y)
	{
			return x / y;
	}
	@GetMapping("/pow/{x}/{y}")
	public double pow(@PathVariable double x, @PathVariable double y)
	{
			return Math.pow(x, y);
	}@GetMapping("/root/{x}")
	public double root(@PathVariable double x)
	{
			return Math.pow(x, 0.5);
	}
	

}