package org.pract.demo.two.config;

import org.pract.demo.two.components.SampleJob;
import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnExpression;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.core.io.ClassPathResource;
import org.springframework.scheduling.quartz.SpringBeanJobFactory;

import java.io.IOException;

import static org.quartz.JobBuilder.newJob;
import static org.quartz.SimpleScheduleBuilder.simpleSchedule;
import static org.quartz.TriggerBuilder.newTrigger;

@Configuration
@ConditionalOnExpression("'${using.spring.schedulerFactory}'=='false'")
@Profile("prod")
public class QuartzSchedular {

    @Autowired
    private ApplicationContext applicationContext;

    @Bean
    public SpringBeanJobFactory springBeanJobFactory() {
        AutoWiringSpringBeanJobFactory jobFactory = new AutoWiringSpringBeanJobFactory();
        //logger.debug("Configuring Job factory");

        jobFactory.setApplicationContext(applicationContext);
        return jobFactory;
    }

    @Bean
    public Scheduler scheduler(Trigger trigger, JobDetail job) throws SchedulerException, IOException {

        StdSchedulerFactory factory = new StdSchedulerFactory();
        factory.initialize(new ClassPathResource("quartz.properties").getInputStream());

        //logger.debug("Getting a handle to the Scheduler");
        Scheduler scheduler = factory.getScheduler();
        scheduler.setJobFactory(springBeanJobFactory());
        scheduler.scheduleJob(job, trigger);

        //logger.debug("Starting Scheduler threads");
        scheduler.start();
        return scheduler;
    }

    @Bean
    public JobDetail jobDetail() {

        return newJob().ofType(SampleJob.class).storeDurably().withIdentity(JobKey.jobKey("Qrtz_Job_Detail")).withDescription("Invoke Sample Job service...").build();
    }

    @Bean
    public Trigger trigger(JobDetail job) {

        int frequencyInSec = 10;
        //logger.info("Configuring trigger to fire every {} seconds", frequencyInSec);

        return newTrigger().forJob(job).withIdentity(TriggerKey.triggerKey("Qrtz_Trigger")).withDescription("Sample trigger").withSchedule(simpleSchedule().withIntervalInSeconds(frequencyInSec).repeatForever()).build();
    }
}
