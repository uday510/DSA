package graph;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomInputGenerator {

    public static void main(String[] args) {
        int n = getRandomNumberInRange(2, 10000); // Number of persons
        int maxMeetingTime = 10000; // Maximum meeting time
        int maxStartTime = n - 1; // Maximum start time

        List<int[]> meetings = generateRandomMeetings(n, maxMeetingTime);
        int firstPerson = getRandomNumberInRange(1, n - 1);

        System.out.println("Input: n = " + n + ", meetings = " + meetings + ", firstPerson = " + firstPerson);
    }

    public static List<int[]> generateRandomMeetings(int n, int maxMeetingTime) {
        List<int[]> meetings = new ArrayList<>();
        Random random = new Random();

        int numMeetings = getRandomNumberInRange(1, (int) (Math.pow(10, 5)));

        for (int i = 0; i < numMeetings; i++) {
            int person1 = getRandomNumberInRange(0, n - 1);
            int person2 = getRandomNumberInRange(0, n - 1);

            // Ensure person1 and person2 are distinct
            while (person1 == person2) {
                person2 = getRandomNumberInRange(0, n - 1);
            }

            int duration = getRandomNumberInRange(1, maxMeetingTime);

            meetings.add(new int[]{person1, person2, duration});
        }

        return meetings;
    }

    static int getRandomNumberInRange(int min, int max) {
        Random random = new Random();
        return random.nextInt((max - min) + 1) + min;
    }
}
