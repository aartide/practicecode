import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.List;
import java.util.StringTokenizer;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.BufferedReader;
import java.util.ArrayList;
import java.sql.Connection;

public class FileUtil {
	Connection con;
	
	public List<ReportDTO> ReadFromFile()  {
		//File F = new File("C:\\Users\\aartid\\Aarti\\Learning\\JavaTraining\\TestData\\climate\\Report.csv");
		

		/*
		 * DriverManager.registerDriver(new Driver()); con =
		 * DriverManager.getConnection("jdbc:mysql://localhost:3306/qa", "root",
		 * "10_03March");
		 * 
		 * PreparedStatement ps = con.prepareStatement("insert into report_table ");
		 */

		//List<ReportDTO> dtolist = new ArrayList<ReportDTO>();
		
		List<ReportDTO> dtolist = new ArrayList<>();
		try {
			File F = new File("C:/Users/aartid/Aarti/Learning/JavaTraining/TestData/climate/Report.csv");
			FileReader reader = new FileReader(F);
			BufferedReader bf = new BufferedReader(reader);
			String line = bf.readLine();

			while (line != null) {

				line = bf.readLine();

				if (line != null) {

					ReportDTO reportdto = new ReportDTO();

					StringTokenizer token = new StringTokenizer(line, ",");
					StringBuffer buff = new StringBuffer();

					int cntr = 0;

					while (token.hasMoreElements()) {
						cntr++;
						String value = token.nextToken();
						if (cntr == 1) {
							buff.append(value);
							reportdto.setPlaceName(value);
						}

						if (cntr == 2) {
							buff.append(value);
							reportdto.setPlaceDcid(value);
						}

						if (cntr == 3) {
							buff.append(value);
							reportdto.setPlaceType(value);
						}
					}
					System.out.println(buff);
					dtolist.add(reportdto);
				}
			}

		} catch (IOException e) {

			e.printStackTrace();
		}
		return dtolist;
	}
}
