package com.example.demo.DTO;

import lombok.Data;


@Data
public class EmployeeDTO {

	/*private int EmpIdDTO;
	private String  empnameDTO;
	private boolean pfDTO,mealDTO,npsDTO,gratuityDTO,medicalDTO;
	private String officeLocationDTO;
	private String genderDTO;
	private String addressDTO;
	private double salaryDTO;*/
	
	private int employeeId;
	private String empName;
	private String empGender;
	private boolean empPf;	
	private boolean empGratuity;
	private boolean empNps;
	private boolean empMediclaim;
	private boolean empMeal;
	private String officelocation;
	private Double empSalary;
	private String empAddress;
	
	
	
	
}
