package com.example.demo.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
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
	
@PostMapping("/employee")
public EmployeeDTO saveEmployee(@RequestBody EmployeeDTO dto)
{
	System.out.println("controller Class"+ dto);
	return employeeService.saveEmployee(dto);

}
}