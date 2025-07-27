package com.abhi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.abhi.dto.EmployeeDto;
import com.abhi.model.Employee;
import com.abhi.service.EmployeeService;

@RestController
@RequestMapping("employee")
public class EmployeeController {

	@Autowired private EmployeeService employeeService;
	
	@PostMapping("add")
	public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee){
		employeeService.saveEmployee(employee);
		return ResponseEntity.status(HttpStatus.CREATED).body(employee);
	}
	@GetMapping("detail/{eid}")
	public ResponseEntity<Employee> getEmployeeByid(@PathVariable int eid){
		Employee employee= employeeService.getRecord(eid);
		if (employee==null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(employee);
	}
	@GetMapping("detail/byid")
	public ResponseEntity<EmployeeDto> getEmployee(@RequestParam int eid){
		EmployeeDto employeeDto= employeeService.getRecordDto(eid);
		if (employeeDto==null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(employeeDto);
	}
}
