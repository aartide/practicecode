import java.sql.*;
import java.sql.PreparedStatement;
import java.util.List;

import BulkINsertDemo.util.DBHelper;

public class ReportServiceimpl implements ReportService {

	Connection conn;

	@Override
	public void SaveReportData(ReportDTO dto) {

		try {

			conn = DBHelper.getInstance().getconnection();
			PreparedStatement ps = conn.prepareStatement(
					"INSERT INTO qa.report_table\r\n " + "( place_name, place_dcid, plac_type)\r\n" + "VALUES(?,?,?);");

			ps.setString(1, dto.getPlaceName());
			ps.setString(2, dto.getPlaceDcid());
			ps.setString(3, dto.getPlaceType());

			ps.execute();

		} catch (Exception e) {

			e.printStackTrace();
		} finally {
			if (conn != null) {
				try {
					try {
						DBHelper.getInstance().getconnection().close();
					} catch (Exception e) {

						e.printStackTrace();
					}

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}

	}

	@Override
	public void SaveReportDatainBatch(List<ReportDTO> ReportDtoList) {

		int batchsize = 30;
		int counter = 0;

		try {
			conn = DBHelper.getInstance().getconnection();
			conn.setAutoCommit(false);

			PreparedStatement ps = conn.prepareStatement(
					"INSERT INTO qa.report_table\n " + "( place_name, place_dcid, plac_type)\n" + "VALUES(?,?,?)");

			for (ReportDTO reportdto : ReportDtoList) {

				counter++;
				ps.setString(1, reportdto.getPlaceName());
				ps.setString(2, reportdto.getPlaceDcid());
				ps.setString(3, reportdto.getPlaceType());
				ps.addBatch();
				// At a time 30 records are commited to table

				if (counter % 30 == 0) {
					ps.executeBatch();
					conn.commit();
				}
			}
			ps.executeBatch();
			conn.commit();

		} catch (Exception e) {

			e.printStackTrace();
		} finally {
			if (conn != null) {
				try {
					try {
						conn.commit();
						DBHelper.getInstance().getconnection().close();
					} catch (Exception e) {

						e.printStackTrace();
					}

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}

	}

}
