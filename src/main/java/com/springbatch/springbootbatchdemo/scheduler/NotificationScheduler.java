/*
 * Copyright (c) 2021. By GiRi SaHaa
 */

package com.springbatch.springbootbatchdemo.scheduler;

import com.springbatch.springbootbatchdemo.config.NotificationConfig;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@EnableScheduling
public class NotificationScheduler {

    @Autowired
    private JobLauncher jobLauncher;

    @Autowired
    private NotificationConfig notificationConfig;

    @Scheduled(cron = "0 */1 * * * ?")
    public void executeNotificationScheduler(){
        JobParameters jobParameters = new JobParametersBuilder().addLong("time", System.currentTimeMillis()).toJobParameters();

        try {
            jobLauncher.run(notificationConfig.createNotificationJob(), jobParameters);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
