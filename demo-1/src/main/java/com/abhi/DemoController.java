package com.abhi;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("greet")
public class DemoController {

	@GetMapping
	public String  sayHello() {
		return "Hello Abhishek Ji !";
	}
	
	@PostMapping
	public String  sayThankyou() {
		return "Thank You Abhishk ji";
	}
	@PutMapping	
	public String  sayGoodBye() {
		return "bye Abhishek ji !";
	}
}
