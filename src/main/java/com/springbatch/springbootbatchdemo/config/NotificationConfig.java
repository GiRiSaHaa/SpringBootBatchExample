/*
 * Copyright (c) 2021. By GiRi SaHaa
 */

package com.springbatch.springbootbatchdemo.config;

import com.springbatch.springbootbatchdemo.tasklets.NotificationTasklet;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableBatchProcessing
public class NotificationConfig {

    @Autowired
    private JobBuilderFactory jobBuilderFactory;

    @Autowired
    private StepBuilderFactory stepBuilderFactory;

    @Autowired
    private NotificationTasklet notificationTasklet;

    protected Step createNotification(){
        return stepBuilderFactory.get("CreateNotification").tasklet(notificationTasklet).build();
    }
    public Job createNotificationJob() {
        return jobBuilderFactory.get("createNotificationJob").incrementer(new RunIdIncrementer())
                .start(createNotification()).build();
    }
}
