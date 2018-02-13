package pl.michal.olszewski.scheduler.priority;

public class Job implements Runnable {

  private String jobName;
  private JobPriority jobPriority;

  public Job(String name, JobPriority priority) {
    this.jobName = name;
    this.jobPriority = priority;
  }

  @Override
  public void run() {
    System.out.println("Job:" + jobName + " Priority:" + jobPriority);
    try {
      Thread.sleep(1000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }

  public JobPriority getJobPriority() {
    return jobPriority;
  }
}