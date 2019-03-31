package com.mybatis;

import com.mybatis.service.QuartzJobSchedulerService;
import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MybatisApplication {

	@Value("${bankaccount.interval.time}")
	Integer interval;

	public static void main(String[] args) throws SchedulerException {

		SpringApplication.run(MybatisApplication.class, args);

		JobDetail j = JobBuilder.newJob(QuartzJobSchedulerService.class).build();

		Trigger t = TriggerBuilder.newTrigger().withIdentity("CroneTrigger")
				.withSchedule(SimpleScheduleBuilder.simpleSchedule().withIntervalInSeconds(3)
				.repeatForever()).build();

		Scheduler s = StdSchedulerFactory.getDefaultScheduler();

		s.start();
		s.scheduleJob(j,t);
	}

}
