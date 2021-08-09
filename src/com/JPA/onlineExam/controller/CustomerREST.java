package com.JPA.onlineExam.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.JPA.onlineExam.model.Customer;
import com.JPA.onlineExam.model.Employee;
import com.JPA.onlineExam.repository.CustomerRepository;

@RestController
@RequestMapping(value = "/customers", produces = { MediaType.APPLICATION_JSON_VALUE })
public class CustomerREST {

	@Autowired
	CustomerRepository repository;

	public CustomerRepository getRepository() {
		return repository;
	}

	public void setRepository(CustomerRepository repository) {
		this.repository = repository;
	} 
	
	@GetMapping(value = "/ping", produces = { MediaType.TEXT_PLAIN_VALUE })
	public String allemp() {
		return "Hello World";
	}

	@GetMapping(value = "/customers")
	public List<Customer> getAllEmployees() {
		return repository.findAll();
	}
}
