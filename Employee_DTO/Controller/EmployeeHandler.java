package Employee_DTO.Controller;

import java.awt.Checkbox;
import EmployeeDTO.dto.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import Employee_DTO.View.EmpFrame;

public class EmployeeHandler implements WindowListener, ActionListener{
	EmpFrame ef;
	

	public EmployeeHandler(EmpFrame empFrame) {
		// TODO Auto-generated constructor stub
		
		ef = empFrame;
		
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
		
		switch(action){
		case "save":
			//getEmployeeData(ef);
			saveorupdate(edto);
		break;
		
		case "update":
			getEmployeeData(ef);
			saveorupdate(edto);
		break;
		case "delete":
		break;
		case "search":
		break;
		case "prev":
			break;
			
		}
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
		Edto.setEmpIdDTO(Integer.parseInt(ef.getTxtEmpId().getText()));
		Edto.setEmpnameDTO(ef.getTxtEmpNm().getText());
		Edto.setGenderDTO(ef.getGenderGroup().getSelectedCheckbox().getLabel());
		Edto.setGratuityDTO(ef.getGratuityChk().getState());
		Edto.setMealDTO(ef.getMealptionChk().getState());
		Edto.setMedicalDTO(ef.getMediclaimChk().getState());
		Edto.setNpsDTO(ef.getNpsChk().getState());
		Edto.setPfDTO(ef.getPfOptionChk().getState());
		Edto.setOfficeLocationDTO(ef.getOfficeLocation().getSelectedItem());
		Edto.setSalaryDTO((Double.parseDouble(ef.getEmpsalaryTxt().getText())));
	
		System.out.println(Edto);
		return Edto;
		
		//above we are printing class object it will print byte code ..so need to convert it to TOString  by source right click ToString
	}
	
	

	}
