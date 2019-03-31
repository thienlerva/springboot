package com.mybatis.service;

import lombok.extern.slf4j.Slf4j;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.stereotype.Service;

import java.util.Date;

@Slf4j
@Service
public class QuartzJobSchedulerService implements Job {

    @Override
    public void execute(JobExecutionContext arg0) throws JobExecutionException {

        log.info("Hurray !! My scheduler is ruiing");
        log.info("The tiem now is {}", new Date());
    }
}
