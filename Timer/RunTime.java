package Timer;

import com.google.common.base.Stopwatch;

public class RunTime {
    static Stopwatch timer;
    public RunTime() {
        startTimer();
    }
     public void startTimer() {

        timer = Stopwatch.createStarted();
     }
     public Stopwatch stopTimer() {
        return timer.stop();
     }
}
