import java.util.List;

public class ReportSaveTask implements Runnable {

	private ReportService reportservice;
	private List<ReportDTO> ReportDtoList;

	public ReportSaveTask(ReportService reportservice, List<ReportDTO> ReportDtoList) {
		this.reportservice = reportservice;
		this.ReportDtoList = ReportDtoList;

	}

	@Override
	public void run() {

		reportservice.SaveReportDatainBatch(ReportDtoList);

	}

}
