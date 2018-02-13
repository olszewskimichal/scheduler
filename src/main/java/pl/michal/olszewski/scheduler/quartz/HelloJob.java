package pl.michal.olszewski.scheduler.quartz;

import java.time.Instant;
import org.quartz.Job;
import org.quartz.JobExecutionContext;

public class HelloJob implements Job {

  public HelloJob() {
  }

  public void execute(JobExecutionContext context) {
    System.err.println("Hello!  HelloJob is executing. " + Instant.now());
  }
}