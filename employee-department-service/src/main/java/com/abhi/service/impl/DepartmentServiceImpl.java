package com.abhi.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.abhi.model.Department;
import com.abhi.repository.DepartmentRepository;
import com.abhi.service.DepartmentService;

@Service
public class DepartmentServiceImpl implements DepartmentService {

	@Autowired private DepartmentRepository departmentRepository;

	@Override
	public void saveDepartment(Department department) {
	departmentRepository.save(department);
		
	}
}
