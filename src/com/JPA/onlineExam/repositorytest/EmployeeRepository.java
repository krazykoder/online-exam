package com.JPA.onlineExam.repositorytest;

import org.springframework.data.jpa.repository.JpaRepository;

import com.JPA.onlineExam.modeltest.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
