package org.pract.demo.two.components;

import org.pract.demo.two.service.SampleJobService;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.QuartzJobBean;
import org.springframework.stereotype.Component;

@Component
public class SampleJob extends QuartzJobBean {
    @Autowired
    private SampleJobService jobService;

    @Override
    protected void executeInternal(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        jobService.executeSampleJob();
    }
}
