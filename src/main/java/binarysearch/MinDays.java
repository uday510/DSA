package binarysearch;

public class MinDays {
    public static void main(String[] args) {
        int[] bloomDay = {1, 10, 3, 10, 2};
        int m = 3;
        int k = 1;
        System.out.println(minDays(bloomDay, m, k));
    }
    public static int minDays(int[] bloomDay, int m, int k) {

        int n = bloomDay.length;

        if (m * k > n) return -1;

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for (int day : bloomDay) {
            min = Math.min(min, day);
            max = Math.max(max, day);
        }

        int left = min;
        int right = max;

        while (left < right) {
            int mid = (left + right) >>> 1;
            if (canMake(bloomDay, m, k, mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
    public static boolean canMake(int[] bloomDay, int requiredBouquets, int adj, int requiredDay) {
        int currentBouquets = 0;
        int currentAdj = 0;


        for (int day : bloomDay) {
            if (day <= requiredDay) {
                currentAdj++;
                if (currentAdj == adj) {
                    currentBouquets++;
                    currentAdj = 0;
                }
            } else {
                currentAdj = 0;
            }
        }

        return currentBouquets >= requiredBouquets;
    }

}
