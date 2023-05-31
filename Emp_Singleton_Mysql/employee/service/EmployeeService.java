package employee.service;

import java.sql.SQLException;

import EmployeeDTO.dto.EmpDTO;

public interface EmployeeService {

	public void saveEmployee(EmpDTO empdto);
	public void updateEmployee(EmpDTO empdto);
	public EmpDTO searchEmployee(EmpDTO empdto);
	public void deleteEmployee(EmpDTO edto) ;
	public EmpDTO findFirstEmployee( );	
	public EmpDTO findLastEmployee();
	public EmpDTO findNextEmployee(EmpDTO edto);
	public EmpDTO findPrevEmployee(EmpDTO edto);
	
	
}
