package com.abhi.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.abhi.model.Employee;
import com.abhi.repository.DepartmentRepository;
import com.abhi.repository.EmployeeRepository;
import com.abhi.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	@Autowired private EmployeeRepository employeeRepository;
	@Autowired private DepartmentRepository departmentRepository;

	@Override
	public void saveEmployee(Employee employee) {
		employeeRepository.save(employee);
		departmentRepository.updatTotalEmployee(employee.getDepartment().getDid());
		
	}

	@Override
	public Employee getRecord(int eid) {
		
		return employeeRepository.findById(eid).orElse(null);
	}

}
