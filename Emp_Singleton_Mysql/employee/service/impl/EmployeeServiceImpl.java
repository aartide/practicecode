package employee.service.impl;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.mysql.cj.jdbc.Driver;

import EmployeeDTO.dto.EmpDTO;
import employee.service.EmployeeService;

public class EmployeeServiceImpl implements EmployeeService {

	Connection con;

	@Override
	public void saveEmployee(EmpDTO empdto) {
		// TODO Auto-generated method stub
		try {
			DriverManager.registerDriver(new Driver());
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/qa", "root", "10_03March");
			/*
			 * Statement stmt = con.createStatement(); String query = "INSERT INTO qa.emp\n"
			 * +
			 * "(emp_name, emp_gender, emp_pf, emp_gratutiy, emp_NPS, emp_mediclaim, emp_meal, OfficeLocation, emp_salary, emp_address)\n"
			 * + "VALUES('" + empdto.getEmpnameDTO() + "', '" + empdto.getGenderDTO() +
			 * "', " + empdto.isPfDTO() + ", " + empdto.isGratuityDTO() + "," +
			 * empdto.isNpsDTO() + ", " + empdto.isMedicalDTO() + ", " + empdto.isMealDTO()
			 * + ", '" + empdto.getOfficeLocationDTO() + "', " + empdto.getSalaryDTO() +
			 * ", '" + empdto.getAddressDTO() + "')";
			 */
			PreparedStatement st = con.prepareStatement("INSERT INTO qa.emp\n"
					+ "(emp_name, emp_gender, emp_pf, emp_gratutiy, emp_NPS, emp_mediclaim, emp_meal, OfficeLocation, emp_salary, emp_address)\n"
					+ "VALUES(?,?,?,?,?,?,?,?,?,?)");
			st.setString(1, empdto.getEmpnameDTO());
			st.setString(2, empdto.getGenderDTO());
			st.setBoolean(3, empdto.isPfDTO());
			st.setBoolean(4, empdto.isGratuityDTO());
			st.setBoolean(5, empdto.isNpsDTO());
			st.setBoolean(6, empdto.isMedicalDTO());
			st.setBoolean(7, empdto.isMealDTO());
			st.setString(8, empdto.getOfficeLocationDTO());
			st.setDouble(9, empdto.getSalaryDTO());
			st.setString(10, empdto.getAddressDTO());

			st.execute();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}
	}

	@Override
	public void updateEmployee(EmpDTO empdto) {
		// TODO Auto-generated method stub
		try {
			DriverManager.registerDriver(new Driver());
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/qa", "root", "10_03March");

			PreparedStatement ps = con.prepareStatement(
					"UPDATE qa.emp SET emp_name=?, emp_gender=?, emp_pf=?, emp_gratutiy=?, emp_NPS=?, emp_mediclaim=?, emp_meal=?, OfficeLocation=?, emp_salary=?, emp_address=? WHERE employee_id=?;");

			ps.setString(1, empdto.getEmpnameDTO());
			ps.setString(2, empdto.getGenderDTO());
			ps.setBoolean(3, empdto.isPfDTO());
			ps.setBoolean(4, empdto.isGratuityDTO());
			ps.setBoolean(5, empdto.isNpsDTO());
			ps.setBoolean(6, empdto.isMedicalDTO());
			ps.setBoolean(7, empdto.isMealDTO());
			ps.setString(8, empdto.getOfficeLocationDTO());
			ps.setDouble(9, empdto.getSalaryDTO());
			ps.setString(10, empdto.getAddressDTO());
			ps.setInt(11, empdto.getEmpIdDTO());
			// ps = copyFromDTOToDatabase(ps, empdto);
			ps.execute();
			System.out.println("rEcord updated");

		} catch (SQLException e) {

			e.printStackTrace();
			System.out.println("  Error Message" + e.getMessage());
		} finally {

			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	@Override
	public EmpDTO searchEmployee(EmpDTO empdto) {

		// EmpDTO eto = new EmpDTO();

		try {
			DriverManager.registerDriver(new Driver());
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/qa", "root", "10_03March");

			PreparedStatement ps = con.prepareStatement(
					"SELECT employee_id, emp_name, emp_gender, emp_pf, emp_gratutiy, emp_NPS, emp_mediclaim, emp_meal, OfficeLocation, emp_salary, emp_address\n"
							+ "FROM qa.emp where  employee_id =? ");
			ps.setInt(1, empdto.getEmpIdDTO());
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				copyFromDatabaseToEmployeeDTO(rs, empdto);
			}
			return empdto;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}
		return empdto;
	}

	@Override
	public void deleteEmployee(EmpDTO edto) {

		try {
			DriverManager.registerDriver(new Driver());
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/qa", "root", "10_03March");

			PreparedStatement ps = con.prepareStatement("DELETE FROM qa.emp WHERE employee_id=?\n");

			ps.setInt(1, edto.getEmpIdDTO());

			ps.execute();
			System.out.println("Record deleted");

		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			try {
				con.close();

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

	private EmpDTO copyFromDatabaseToEmployeeDTO(ResultSet rs, EmpDTO eto) throws SQLException {
		eto.setEmpIdDTO(rs.getInt(1));
		eto.setEmpnameDTO(rs.getString(2));
		eto.setGenderDTO(rs.getString(3));
		eto.setPfDTO(rs.getBoolean(4));
		eto.setGratuityDTO(rs.getBoolean(5));
		eto.setNpsDTO(rs.getBoolean(6));
		eto.setMedicalDTO(rs.getBoolean(7));
		eto.setMealDTO(rs.getBoolean(8));
		eto.setOfficeLocationDTO(rs.getString(9));
		eto.setSalaryDTO(rs.getDouble(10));
		eto.setAddressDTO(rs.getString(11));
		return eto;

	}

	private PreparedStatement copyFromDTOToDatabase(PreparedStatement ps, EmpDTO empdto) throws SQLException {

		/*
		 * emp_name=?, emp_gender=?, emp_pf=?, emp_gratutiy=?, emp_NPS=?,
		 * emp_mediclaim=?, emp_meal=?, OfficeLocation=?, emp_salary=?, emp_address=?\n"
		 */

		ps.setString(1, empdto.getEmpnameDTO());
		ps.setString(2, empdto.getGenderDTO());
		ps.setBoolean(3, empdto.isPfDTO());
		ps.setBoolean(4, empdto.isGratuityDTO());
		ps.setBoolean(5, empdto.isNpsDTO());
		ps.setBoolean(6, empdto.isMedicalDTO());
		ps.setBoolean(7, empdto.isMealDTO());
		ps.setString(8, empdto.getOfficeLocationDTO());
		ps.setDouble(9, empdto.getSalaryDTO());
		ps.setString(10, empdto.getAddressDTO());
		return ps;

	}

	@Override
	public EmpDTO findFirstEmployee() {
		EmpDTO edto = new EmpDTO();

		try {
			DriverManager.registerDriver(new Driver());
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/qa", "root", "10_03March");
			PreparedStatement ps = con.prepareStatement("SELECT * FROM qa.emp ;", +ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_UPDATABLE);

			ResultSet rs = ps.executeQuery();

			if (rs.first()) {
				copyFromDatabaseToEmployeeDTO(rs, edto);
			}

		} catch (Exception e) {

			e.printStackTrace();
		} finally {
			try {
				con.close();

			} catch (Exception e) {
				e.printStackTrace();
			}

		}
		return edto;
	}

	@Override
	public EmpDTO findLastEmployee() {
		EmpDTO edto = new EmpDTO();

		try {
			DriverManager.registerDriver(new Driver());
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/qa", "root", "10_03March");
			PreparedStatement ps = con.prepareStatement("SELECT * FROM qa.emp\n", +ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_UPDATABLE);

			ResultSet rs = ps.executeQuery();
			if (rs.last()) {
				copyFromDatabaseToEmployeeDTO(rs, edto);
			}

		} catch (Exception e) {

			e.printStackTrace();
		} finally {
			try {
				con.close();

			} catch (Exception e) {
				e.printStackTrace();
			}

		}
		return edto;

	}

	@Override
	public EmpDTO findNextEmployee(EmpDTO empdto) {
		EmpDTO edto = new EmpDTO();

		if (empdto.getEmpIdDTO() == 0) {
			return findFirstEmployee();
		}

		try {
			DriverManager.registerDriver(new Driver());
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/qa", "root", "10_03March");
			PreparedStatement ps = con.prepareStatement(
					"SELECT * FROM qa.emp\n"
							+ " where employee_id =(select min(employee_id) from qa.emp where employee_id > ?);",
					+ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);

			ps.setInt(1, empdto.getEmpIdDTO());
			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				copyFromDatabaseToEmployeeDTO(rs, edto);

			}

		} catch (Exception e) {

			e.printStackTrace();
		} finally {
			try {
				con.close();

			} catch (Exception e) {
				e.printStackTrace();
			}

		}
		return edto;
	}

	@Override
	public EmpDTO findPrevEmployee(EmpDTO empdto) {

		EmpDTO edto = new EmpDTO();

		if (empdto.getEmpIdDTO() == 0) {
			return findFirstEmployee();
		}

		try {
			DriverManager.registerDriver(new Driver());
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/qa", "root", "10_03March");
			PreparedStatement ps = con.prepareStatement(
					"SELECT * FROM qa.emp\n"
							+ " where employee_id =(select max(employee_id) from qa.emp where employee_id < ?);",
					+ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);

			ps.setInt(1, empdto.getEmpIdDTO());
			ResultSet rs = ps.executeQuery();

			if (rs.next()) {

				copyFromDatabaseToEmployeeDTO(rs, edto);

			}

		} catch (Exception e) {

			e.printStackTrace();
		} finally {
			try {
				con.close();

			} catch (Exception e) {
				e.printStackTrace();
			}

		}
		return edto;
	}

}

