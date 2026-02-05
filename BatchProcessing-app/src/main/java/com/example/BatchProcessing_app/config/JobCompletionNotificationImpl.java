package com.example.BatchProcessing_app.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.BatchStatus;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobExecutionListener;
import org.springframework.stereotype.Component;

@Component
public class JobCompletionNotificationImpl implements JobExecutionListener {


    private static final Logger log =
            LoggerFactory.getLogger(JobCompletionNotificationImpl.class);
    //private  Logger logger = (Logger) LoggerFactory.getLogger(JobCompletionNotificationImpl.class);


    @Override
    public void beforeJob(JobExecution jobExecution) {
       log.info("Job started");
    }

    @Override
    public void afterJob(JobExecution jobExecution) {
        if (jobExecution.getStatus() == BatchStatus.COMPLETED) {
            log.info("Job completed successfully");
        }
    }
}
