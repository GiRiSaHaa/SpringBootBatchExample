/*
 * Copyright (c) 2021. By GiRi SaHaa
 */

package com.springbatch.springbootbatchdemo.tasklets;

import org.springframework.batch.core.ExitStatus;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.StepExecutionListener;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.stereotype.Component;

@Component
public class NotificationTasklet implements Tasklet, StepExecutionListener {

    @Override
    public void beforeStep(StepExecution stepExecution) {
        System.out.println("Create Notification");
    }

    @Override
    public ExitStatus afterStep(StepExecution stepExecution) {
        System.out.println("Delete Notification");
        return null;
    }

    @Override
    public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) throws Exception {
        System.out.println("Process Notification");
        return null;
    }
}
