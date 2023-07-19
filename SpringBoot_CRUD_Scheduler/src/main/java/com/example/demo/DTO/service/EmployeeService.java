package com.example.demo.DTO.service;

import com.example.demo.DTO.EmployeeDTO;

public interface EmployeeService {
	public EmployeeDTO saveEmployee(EmployeeDTO dto);
	public EmployeeDTO findEmployeeById(int empid);
	public void deleteEmployee(int empid);
	
	
}
