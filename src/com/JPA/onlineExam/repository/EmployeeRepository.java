package com.JPA.onlineExam.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.JPA.onlineExam.modeltest.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
