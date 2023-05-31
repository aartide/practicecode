package Employee_DTO.Controller;

import java.awt.Checkbox;
import EmployeeDTO.dto.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.sql.SQLException;

import Employee_DTO.View.EmpFrame;
import employee.service.EmployeeService;
import employee.service.impl.EmployeeServiceImpl;

public class EmployeeHandler implements WindowListener, ActionListener{
	EmpFrame ef;
	
	EmployeeService employeeService;
	public EmployeeHandler(EmpFrame empFrame) {
		// TODO Auto-generated constructor stub
		
		ef = empFrame;
		employeeService = new EmployeeServiceImpl();
		
	}

	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowClosing(WindowEvent e) {
		// TODO Auto-generated method stub
		EmpFrame ef = (EmpFrame)e.getSource();
		ef.dispose();

	}

	@Override
	public void windowClosed(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowIconified(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowDeiconified(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowActivated(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowDeactivated(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		String action = e.getActionCommand().toLowerCase();
		//getEmployeeDate(ef);
		
		EmpDTO edto = getEmployeeData(ef);
		
		switch (action) {
		case "save":
			// getEmployeeData(ef);
			// saveorupdate(edto);
			System.out.println("Save clicked");
			employeeService.saveEmployee(edto);

			break;

		case "update":
			// getEmployeeData(ef);
			// saveorupdate(edto);
		//	System.out.println("Update clicked");

			//EmpDTO searchResult = employeeService.searchEmployee(edto);

		/*	if (searchResult.getEmpIdDTO() > 0) {
				refreshEmployeeForm(searchResult);
			}*/

			employeeService.updateEmployee(edto);
		//	refreshEmployeeForm(searchResult);
			break;

		case "delete":

			System.out.println("Delete clicked");

			EmpDTO searchRs = employeeService.searchEmployee(edto);

			if (searchRs.getEmpIdDTO() > 0) {
				refreshEmployeeForm(searchRs);
			}

			employeeService.deleteEmployee(edto);
			UIRefresh( searchRs);
		//	refreshEmployeeForm(searchRs);

			break;
		case "search":

			System.out.println("Search clicked");
			EmpDTO Result = employeeService.searchEmployee(edto);

			if (Result.getEmpIdDTO() > 0) {
				refreshEmployeeForm(Result);
			}
			System.out.println("Result set is " + Result);

			// ef.setAddressTxt(searchResult.getAddressDTO());
			break;
		case "prev":

			edto = employeeService.findPrevEmployee(edto);
			refreshEmployeeForm(edto);
			System.out.println("Previous clicked");

			break;
		case "next":

			edto = employeeService.findNextEmployee(edto);
			refreshEmployeeForm(edto);

			System.out.println("next clicked");
			break;
		case "first":

			edto = employeeService.findFirstEmployee();
			refreshEmployeeForm(edto);

			System.out.println("first clicked");
			break;
		case "last":

			edto = employeeService.findLastEmployee();
			refreshEmployeeForm(edto);

			System.out.println("last clicked");
			break;
		}
	}
	
	private void refreshEmployeeForm(EmpDTO searchResult) {
		ef.getTxtEmpId().setText(""+searchResult.getEmpIdDTO());
		ef.getTxtEmpNm().setText(searchResult.getEmpnameDTO());
		
		ef.getPfOptionChk().setState(searchResult.isPfDTO());
		ef.getMealptionChk().setState(searchResult.isMealDTO());
		ef.getMediclaimChk().setState(searchResult.isMedicalDTO());
		ef.getNpsChk().setState(searchResult.isNpsDTO());
		ef.getGratuityChk().setState(searchResult.isGratuityDTO());
		ef.getOfficeLocation().select(searchResult.getOfficeLocationDTO());
		ef.getEmpsalaryTxt().setText((""+searchResult.getSalaryDTO()));
		ef.getAddressTxt().setText(searchResult.getAddressDTO());
		//ef.getGenderGroup().setSelectedCheckbox(searchResult.getGenderDTO());
		
		
	}
	
	private void UIRefresh(EmpDTO searchResult) {
		ef.getTxtEmpId().setText("");
		ef.getTxtEmpNm().setText("");
		
		ef.getPfOptionChk().setState(false);
		ef.getMealptionChk().setState(false);
		ef.getGratuityChk().setState(false);
		ef.getMediclaimChk().setState(false);
		ef.getNpsChk().setState(false);
		
		ef.getOfficeLocation().select("");
		ef.getEmpsalaryTxt().setText("");
		ef.getAddressTxt().setText("");
		
		}

	private void saveorupdate(EmpDTO edto) {
		// TODO Auto-generated method stub
		
	}

	public EmpDTO getEmployeeData( EmpFrame ef)
	{
		// Note : first tried getting all the fields in form in method and printed in console .now defined new class for input elements on form in that class declared all privated variables.
		//object of that class is take all input data and send to d/b 
		
		//int empid = Integer.parseInt(ef.getTxtEmpId().getText());
		//String empname = ef.getTxtEmpNm().getText();
		//Checkbox selectedchkbox = ef.getGenderGroup().getSelectedCheckbox();
		//String gender = selectedchkbox.getLabel();
	//	boolean pf = ef.getPfOptionChk().getState();
	//	boolean meal = ef.getMealptionChk().getState();
		//boolean medical = ef.getMediclaimChk().getState();
		//boolean gratuity = ef.getGratuityChk().getState();
	//	boolean nps = ef.getNpsChk().getState();
	//	String offlocation = ef.getOfficeLocation().getSelectedItem();
	
		//System.out.println(empname + "-" + pf + "-" + meal + "-" + nps + "-" + gratuity + " - " + offlocation);
		//System.out.println(empname );
		EmpDTO Edto = new EmpDTO();
			
		try {
			Edto.setEmpIdDTO(Integer.parseInt(ef.getTxtEmpId().getText()));
			
			}catch(NumberFormatException t) {
				System.out.println("Number Format Exception for Employee Id.");
				}
			
		try {
			   if (ef.getTxtEmpNm().getText().isBlank()){
				
				   System.out.println("Enter name");
			   }		  
			   else
			   {			
				   Edto.setEmpnameDTO(ef.getTxtEmpNm().getText());
			   }
			
		//}	catch(NumberFormatException pop) {
		//	System.out.println("Name can not be null or number");
		//	}catch(ArithmeticException op) {
			//System.out.println("Name can only be in text");
			}catch(Exception e) {
				System.out.println("Name can only be in text");
				}
		Edto.setGenderDTO(ef.getGenderGroup().getSelectedCheckbox().getLabel());
		Edto.setGratuityDTO(ef.getGratuityChk().getState());
		Edto.setMealDTO(ef.getMealptionChk().getState());
		Edto.setMedicalDTO(ef.getMediclaimChk().getState());
		Edto.setNpsDTO(ef.getNpsChk().getState());
		Edto.setPfDTO(ef.getPfOptionChk().getState());
		Edto.setOfficeLocationDTO(ef.getOfficeLocation().getSelectedItem());
		Edto.setAddressDTO(ef.getAddressTxt().getText());
		
		try {
		Edto.setSalaryDTO((Double.parseDouble(ef.getEmpsalaryTxt().getText())));
			
		}catch(NumberFormatException k) {
			System.out.println("Salary can not be null or text");
					
		
	}
	
		System.out.println(Edto);
		//above we are printing class object it will print byte code ..so need to convert it to TOString  by source right click ToString
		return Edto;
	}
	}
