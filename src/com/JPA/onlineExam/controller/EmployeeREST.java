package com.JPA.onlineExam.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.JPA.onlineExam.repository.EmployeeRepository;

@RestController
@RequestMapping(value = "/employee-management", produces = { MediaType.APPLICATION_JSON_VALUE })
public class EmployeeREST {

	@Autowired
	EmployeeRepository employeRepo;

	public EmployeeRepository getEmployeRepo() {
		return employeRepo;
	}

	public void setEmployeRepo(EmployeeRepository employeRepo) {
		this.employeRepo = employeRepo;
	}

	@GetMapping(value = "/ping", produces = { MediaType.TEXT_PLAIN_VALUE })
	public String allemp() {
		return "Hello World";
	}
}
