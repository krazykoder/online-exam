package com.JPA.onlineExam.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.JPA.onlineExam.model.Customer;
import com.JPA.onlineExam.repoTest.FromCSVtoDB;
import com.JPA.onlineExam.repository.CustomerRepository;

@RestController
@RequestMapping(value = "/customers", produces = { MediaType.APPLICATION_JSON_VALUE })
public class CustomerREST {

	@Autowired
	CustomerRepository repository;

	@Autowired
	FromCSVtoDB cv;

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

	@GetMapping(value = "/test", produces = { MediaType.ALL_VALUE })
	public String testcustomer() {
		// read CSV using FromCSVtoDB Service class
		try {
			cv.CreateData();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "Populating Customer from World<br>";
	}

	@GetMapping(value = "/customers")
	public List<Customer> getAllEmployees() {
		return repository.findAll();
	}
}
