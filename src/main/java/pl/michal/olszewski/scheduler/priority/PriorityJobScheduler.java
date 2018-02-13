package pl.michal.olszewski.scheduler.priority;

import java.util.Comparator;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.PriorityBlockingQueue;

public class PriorityJobScheduler {

  private ExecutorService priorityJobPoolExecutor;
  private PriorityBlockingQueue<Job> priorityQueue;

  public PriorityJobScheduler(Integer poolSize, Integer queueSize) {
    priorityJobPoolExecutor = Executors.newFixedThreadPool(poolSize);
    priorityQueue = new PriorityBlockingQueue<>(queueSize, Comparator.comparing(Job::getJobPriority));
    ExecutorService priorityJobScheduler = Executors.newFixedThreadPool(4);
    priorityJobScheduler.execute(() -> {
      while (true) {
        try {
          priorityJobPoolExecutor.execute(priorityQueue.take());
        } catch (InterruptedException e) {
          break;
        }
      }
    });
  }

  public void scheduleJob(Job job) {
    priorityQueue.add(job);
  }
}