import java.util.List;

public interface ReportService {

	public void SaveReportData(ReportDTO dto);

	public void SaveReportDatainBatch(List<ReportDTO> ReportDtoList);

}
