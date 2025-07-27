package com.abhi;

import com.abhi.controller.EmployeeController;
import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class EmployeeDepartmentServiceDtoModelmapperApplication {

    private final EmployeeController employeeController;

    EmployeeDepartmentServiceDtoModelmapperApplication(EmployeeController employeeController) {
        this.employeeController = employeeController;
    }

	public static void main(String[] args) {
		SpringApplication.run(EmployeeDepartmentServiceDtoModelmapperApplication.class, args);
	}
	
	@Bean
	ModelMapper getModelMapper() {
		System.out.println("Bean created..");
		return new ModelMapper();
	}

}
