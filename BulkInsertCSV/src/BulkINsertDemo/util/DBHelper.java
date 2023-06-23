package BulkINsertDemo.util;

import java.sql.Connection;

import java.sql.DriverManager;

import com.mysql.cj.jdbc.Driver;
import com.mysql.cj.jdbc.JdbcConnection;

public class DBHelper {

	private static DBHelper helper = new DBHelper();

	private DBHelper() {

	}

	public static DBHelper getInstance() {
		if (helper == null) {
			helper = new DBHelper();

		}
		return helper;

	}

	public Connection getconnection() throws Exception {
		Connection con = null;

		DriverManager.registerDriver(new Driver());

		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/qa", "root", "10_03March");

		return con;

	}

}
