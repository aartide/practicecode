package com.example.demo.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.DTO.EmployeeDTO;
import com.example.demo.DTO.service.EmployeeService;

//import lombok.ToString;

@RestController
@RequestMapping("/api/v1")

public class EmployeeControllers {

@Autowired 
	private EmployeeService employeeService;
	
// This is first API which saves record
@PostMapping("/employee")
public EmployeeDTO saveEmployee(@RequestBody EmployeeDTO dto)
{
	System.out.println("controller Class"+ dto);
	return employeeService.saveEmployee(dto);

}

//This is second API which fetches record by employee id

@GetMapping("/employee/{employeeId}")
public EmployeeDTO getEmployeeInfo(@PathVariable ("employeeId") int empid) {
	System.out.println("Fetching record for employee id "+empid);
	EmployeeDTO dto = employeeService.findEmployeeById(empid);
	
return dto;

}

	//Delete record
@DeleteMapping("/employee/{employeeId}")	
	public void deleteEmployee(@PathVariable("employeeId") Integer empid) {
		this.employeeService.deleteEmployee(empid);
		
	}
}

