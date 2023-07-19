package com.example.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.Model.EmployeeModel;

@Repository("employeeRepo")
//public interface EmployeeRepository<EmployeeModel> extends JpaRepository<EmployeeModel,Integer>{
	
public interface EmployeeRepository extends JpaRepository<EmployeeModel,Integer>{

}
