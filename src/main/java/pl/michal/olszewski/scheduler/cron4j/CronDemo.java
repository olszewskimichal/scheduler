package pl.michal.olszewski.scheduler.cron4j;

import it.sauronsoftware.cron4j.Scheduler;
import java.time.Instant;

public class CronDemo {

  public static void main(String[] args) {
    Scheduler s = new Scheduler();
    s.schedule("* * * * *", () -> System.out.println("Another minute ticked away..." + Instant.now()));
    s.start();
    try {
      Thread.sleep(1000L * 60L * 10L);
    } catch (InterruptedException ignored) {
    }
    s.stop();
  }
}
