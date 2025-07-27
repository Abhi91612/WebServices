package com.abhi.service;

import com.abhi.dto.EmployeeDto;
import com.abhi.model.Employee;

public interface EmployeeService {

	void saveEmployee(Employee employee);

	Employee getRecord(int eid);

	EmployeeDto getRecordDto(int eid);

}
