package com.example.demo.DTO.service;

import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.demo.DTO.EmployeeDTO;
import com.example.demo.Model.EmployeeModel;
import com.example.demo.repo.EmployeeRepository;

@Service("employeeService")
public class EmployeeServiceImpl implements EmployeeService{

	@Autowired
	private EmployeeRepository employeeRepo;
	
	// Insert a record and update record same code ..only in postman for update in body need to send primary key
	
	@Override
	public EmployeeDTO saveEmployee(EmployeeDTO dto) {
		
		System.out.println("Implementation "+dto);  //To chk whether DTO values are coming in impl class
		EmployeeModel employeemodel = new EmployeeModel();
		 BeanUtils.copyProperties(dto, employeemodel);  /* this is used when variable names in DTO and model are same*/
		
		
		// Below code is used when values in DTO and model are different 
		 /*employeemodel.setEmpAddress(dto.getAddressDTO());
		employeemodel.setEmpGender(dto.getGenderDTO());
		employeemodel.setEmpName(dto.getEmpnameDTO());
		employeemodel.setEmpSalary(dto.getSalaryDTO());
		employeemodel.setOfficeLocation(dto.getOfficeLocationDTO());
		employeemodel.setEmpMeal(dto.isMealDTO());
		employeemodel.setEmpGratuity(dto.isGratuityDTO());
		employeemodel.setEmpMediclaim(dto.isMedicalDTO());
		employeemodel.setEmpNps(dto.isNpsDTO());
		employeemodel.setEmpPf(dto.isPfDTO());*/
		
		 
		employeeRepo.save(employeemodel);  //emp id was not present in dto object 
		dto.setEmployeeId(employeemodel.getEmployeeId());
		
		
		System.out.println("Implementation "+dto);
		return dto;
	}

	//Read a record
	
	@Override 
	public EmployeeDTO findEmployeeById(int empId) {
		EmployeeDTO empDTO  = new EmployeeDTO();
		

		Optional<EmployeeModel> optdto = this.employeeRepo.findById(empId);
		EmployeeModel empModel = optdto.get();   //optdto.get is returning model which we dont want convert it to dto
		BeanUtils.copyProperties(empModel,empDTO);
		
		
		return empDTO;
	}
	
	
	@Override
	public void deleteEmployee(int empid) {

		employeeRepo.deleteById(empid);
	}

}
