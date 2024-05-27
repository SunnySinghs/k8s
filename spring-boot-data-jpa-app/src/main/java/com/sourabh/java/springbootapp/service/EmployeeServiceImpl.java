package com.sourabh.java.springbootapp.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sourabh.java.springbootapp.dao.EmployeeRepository;
import com.sourabh.java.springbootapp.entity.EmployeeEntity;
import com.sourabh.java.springbootapp.model.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	EmployeeRepository employeeRepository;
	
	@Autowired
	public EmployeeServiceImpl(EmployeeRepository employeeDao) {
		this.employeeRepository = employeeDao;
	}
	@Override
	public List<Employee> findAll() {
		List<EmployeeEntity> list = employeeRepository.findAll();
		
		List<Employee> employees = new ArrayList<>();
		for(EmployeeEntity entity: employeeRepository.findAll()) {
			Employee employee = new Employee();
			employee.setEmail(entity.getEmail());
			employee.setFirstName(entity.getFirstName());
			employee.setLastName(entity.getLastName());
			employees.add(employee);
		}
		
		return employees;
	}

	@Override
	public Employee findById(int id) {
		Optional<EmployeeEntity> result = employeeRepository.findById(id);
		EmployeeEntity entity = null;
		Employee employee = new Employee();
		
		if(result.isPresent()) {
			entity = result.get();
			employee.setEmail(entity.getEmail());
			employee.setFirstName(entity.getFirstName());
			employee.setLastName(entity.getLastName());
		}else {
			throw new RuntimeException("Exception in getting Employee."); 
		}
		
		
		return employee;
	}

	@Override
	public void save(Employee employee) {
		EmployeeEntity entity = new EmployeeEntity();
		entity.setEmail(employee.getEmail());
		entity.setFirstName(employee.getFirstName());
		entity.setLastName(employee.getLastName());
		employeeRepository.save(entity);

	}

	@Override
	public void deleteById(int id) {
		employeeRepository.deleteById(id);

	}

}
