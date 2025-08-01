package com.abhi.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import com.abhi.dto.EmployeeDto;
import com.abhi.model.Employee;
import com.abhi.repository.DepartmentRepository;
import com.abhi.repository.EmployeeRepository;
import com.abhi.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	@Autowired private EmployeeRepository employeeRepository;
	@Autowired private DepartmentRepository departmentRepository;
	
	@Autowired @Lazy private ModelMapper modelMapper;

	@Override
	public void saveEmployee(Employee employee) {
		employeeRepository.save(employee);
		departmentRepository.updatTotalEmployee(employee.getDepartment().getDid());
		
	}

	@Override
	public Employee getRecord(int eid) {
		
		return employeeRepository.findById(eid).orElse(null);
	}

	@Override
	public EmployeeDto getRecordDto(int eid) {
		Employee employee=employeeRepository.findById(eid).orElse(null);
		EmployeeDto employeeDto=modelMapper.map(employee, EmployeeDto.class);
		employeeDto.setDepartmentId(employee.getDepartment().getDid());
		return employeeDto;
	}
	 
	

}
