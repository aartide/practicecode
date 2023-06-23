import java.io.IOException;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.ArrayList;

public class BulkInsertMainEntry {

	public static void main(String[] args) throws IOException {

		FileUtil util = new FileUtil();

		List<ReportDTO> MainDtoList = util.ReadFromFile();

		ReportService Reportservice = new ReportServiceimpl();

		// System.out.println(MainDtoList);

		System.out.println("The records read from files are " + MainDtoList.size());
		System.out.println("Current START time is " + System.currentTimeMillis());

		/*
		 * 1) following code saves data in table one record at a time taking 95 seconds
		 * for 5114 records
		 * 
		 * for (ReportDTO reportdto : MainDtoList) {
		 * Reportservice.SaveReportData(reportdto); }
		 */

		/*
		 * 2) Adding records in a batch ,inserts records faster so different method
		 * adddatain batch taking
		 * 
		 * Reportservice.SaveReportDatainBatch(MainDtoList);
		 */

		// 3) Now using concept of Multithreading to faster the process inserting of
		// records into table took 18 millisec

		int batchsize = 1000;
		List<ReportDTO> batchList = null; // list having thousand different elements in each iteration
		int batchmark = 0;
		int RecordCount = 0;
		List<ReportSaveTask> reportsavetaskList = new ArrayList<>();
		int StartPoint = 0;
		int cnt = 0;

		while (RecordCount <= MainDtoList.size()) {

			cnt++;
			batchList = MainDtoList.subList(StartPoint, batchmark);
			//System.out.println(" in a batch " + batchList.size());

			StartPoint = batchmark;
			batchmark = batchmark + batchsize;

			ReportSaveTask taskList = new ReportSaveTask(Reportservice, batchList);
			reportsavetaskList.add(taskList);
			RecordCount += batchsize;

		}
		System.out.println("cnt value is   " + cnt);
		batchList = MainDtoList.subList((cnt - 1) * batchsize, MainDtoList.size() - 1);
		ReportSaveTask taskList = new ReportSaveTask(Reportservice, batchList);
		reportsavetaskList.add(taskList);

		ExecutorService service = Executors.newFixedThreadPool(6);

		for (ReportSaveTask reportsavetask : reportsavetaskList) {
			service.submit(reportsavetask);

		}
		System.out.println("Finish time " + System.currentTimeMillis());
	}
}
	
