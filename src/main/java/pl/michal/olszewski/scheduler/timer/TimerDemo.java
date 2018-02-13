package pl.michal.olszewski.scheduler.timer;

import java.time.Instant;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class TimerDemo {

  public static void main(String[] args) {
    Timer timer = new Timer();
    Instant now = Instant.now();

    timer.scheduleAtFixedRate(new SayHello("ADAM"), Date.from(now.plusSeconds(60)), 15 * 1000);
    timer.scheduleAtFixedRate(new SayHello("MARIO"), Date.from(now), 1000);
  }
}

class SayHello extends TimerTask {

  private final String name;

  SayHello(String name) {
    this.name = name;
  }

  public void run() {
    System.out.println("Hello " + name + " - " + Instant.now());
  }
}
