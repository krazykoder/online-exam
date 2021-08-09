package com.JPA.onlineExam.controllertest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.JPA.onlineExam.modeltest.Employee;
import com.JPA.onlineExam.repository.EmployeeRepository;

@RestController
@RequestMapping(value = "/employees", produces = { MediaType.APPLICATION_JSON_VALUE })
public class EmployeeREST {

	@Autowired
	EmployeeRepository repository;

	public EmployeeRepository getRepository() {
		return repository;
	}

	public void setRepository(EmployeeRepository repository) {
		this.repository = repository;
	}

	@GetMapping(value = "/ping", produces = { MediaType.TEXT_PLAIN_VALUE })
	public String allemp() {
		return "Hello World";
	}

	@GetMapping(value = "/employees")
	public List<Employee> getAllEmployees() {
		return repository.findAll();
	}

	@PostMapping("/employees")
	Employee createOrSaveEmployee(@RequestBody Employee newEmployee) {
		return repository.save(newEmployee);
	}
}
