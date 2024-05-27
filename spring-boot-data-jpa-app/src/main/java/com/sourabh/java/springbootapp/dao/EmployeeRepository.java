package com.sourabh.java.springbootapp.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sourabh.java.springbootapp.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}
