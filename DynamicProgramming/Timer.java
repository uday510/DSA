package DynamicProgramming;

import com.google.common.base.Stopwatch;

public class Timer {
    public static void main(String[] args) {

        Stopwatch timer = Stopwatch.createStarted();

        for (int i = 0; i < Math.pow(10, 8); i++) {}

        System.out.println("Runtime " + timer.stop());
    }
}
