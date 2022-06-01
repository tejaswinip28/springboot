package com.usecase.springtraining;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.EnableScheduling;

import com.usecase.springtraining.ScheduleTImer.TaskSchedule;

import java.util.Timer;




@SpringBootApplication
@ComponentScan(basePackages = {"com.usecase.springtraining.*"} )
@EnableScheduling
public class SpringtrainingApplication {

	Timer time = new Timer();
	
	TaskSchedule task = new TaskSchedule();
	
	
	public static void main(String[] args) {
		SpringApplication.run(SpringtrainingApplication.class, args);
  
	}
	
	@EventListener(ApplicationReadyEvent.class)
    public void msgschedule()
    {
        time.schedule(task,0,60000);
    }

}
