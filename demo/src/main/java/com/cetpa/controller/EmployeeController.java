package com.cetpa.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.abhi.model.Employee;
import com.abhi.service.EmployeeService;

@Controller
@ResponseBody
public class EmployeeController 
{
	private EmployeeService service;
	public EmployeeController(EmployeeService service) {
		this.service=service;
	}
	@PostMapping("/add")
	public Employee addEmplopyee(@RequestBody Employee employee) {
		service.saveEmployee(employee);
		return employee;
	}
	 
}
