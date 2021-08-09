package com.JPA.onlineExam.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.JPA.onlineExam.model.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

}
