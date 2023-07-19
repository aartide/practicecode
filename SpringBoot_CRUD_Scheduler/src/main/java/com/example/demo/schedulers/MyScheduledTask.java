package com.example.demo.schedulers;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class MyScheduledTask {

	@Scheduled(fixedRate =5000)
//	@Scheduled( cron  =" 0 0 23 30 ")
	public void DoMyPeriodicTask() {
	
 System.out.println("Scheduled task started");
 System.out.println("Scheduled task Ended");
	}
}
