package Employee_DTO.Controller;

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
		
		String Action = e.getActionCommand().toLowerCase();
		getEmployeeDate(ef);
		
		switch(Action){
		case "save":
		
		break;
		
		case "update":
			
		break;
		case "delete":
		break;
		case "search":
		break;
		case "prev":
			break;
			
		}
	}
	
	public void getEmployeeDate( EmpFrame ef)
	{
		
	}
	

	}
