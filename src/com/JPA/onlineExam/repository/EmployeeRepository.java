package com.JPA.onlineExam.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.JPA.onlineExam.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
