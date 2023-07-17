package com.example.demo.Model;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;


@Table(name ="emp")
@Getter
@Setter
@Entity

public class EmployeeModel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY )
	
	private Integer employeeId;
	private String empName;
	private String empGender;
	private boolean empPf;	
	private boolean empGratutiy;
	private boolean empNps;
	private boolean empMediclaim;
	private boolean empMeal;
	private String officelocation;
	private Double empSalary;
	private String empAddress;
	
	

}
