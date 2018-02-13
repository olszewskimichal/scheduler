package pl.michal.olszewski.scheduler.quartz;

import static org.quartz.JobBuilder.newJob;
import static org.quartz.SimpleScheduleBuilder.simpleSchedule;
import static org.quartz.TriggerBuilder.newTrigger;

import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SchedulerFactory;
import org.quartz.Trigger;
import org.quartz.impl.StdSchedulerFactory;

public class QuartzDemo {

  public static void main(String[] args) throws SchedulerException {
    SchedulerFactory schedFact = new StdSchedulerFactory();

    Scheduler sched = schedFact.getScheduler();

    sched.start();

    // define the job and tie it to our HelloJob class
    JobDetail job = newJob(HelloJob.class)
        .withIdentity("myJob", "group1")
        .build();

    Trigger trigger = newTrigger()
        .withIdentity("myTrigger", "group1")
        .startNow()
        .withSchedule(simpleSchedule()
            .withIntervalInSeconds(40)
            .repeatForever())
        .build();

    sched.scheduleJob(job, trigger);
  }

}
