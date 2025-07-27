package com.abhi.service;
import org.springframework.stereotype.Service;

import com.abhi.model.Employee;
import com.cetpa.repository.EmployeeRepository;
@Service
public class EmployeeServiceImpl implements EmployeeService
{
	private EmployeeRepository repository;
	public EmployeeServiceImpl(EmployeeRepository repository) {
		this.repository=repository;
	}
	@Override
	public void saveEmployee(Employee employee) {
		
		
	}
}
