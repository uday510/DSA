import com.google.common.base.Stopwatch;

public class FindTimeAndSpace {
    public static void main(String[] args) {

        Stopwatch timer = Stopwatch.createStarted();

        for (int i = 0; i < (int) Math.pow(10, 6); i++) {}

        System.out.println("Runtime " + timer);
    }
}
