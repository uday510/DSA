package dynamicprogramming;

import java.util.ArrayList;
import java.util.List;

public class NumTeams {
    public static void main(String[] args) {
        int[] rating = {2, 5, 3, 4, 1};
        System.out.println(numTeams(rating));
    }
    public static int numTeams(int[] rating) {
        int teams = 0;
        int n = rating.length;

        for (int i = 0; i < n; ++i) {
            for (int j = i; j < n; ++j) {

                if (rating[j] > rating[i]) {
                    teams += countTeams(rating, j, n, true);
                } else {
                    teams += countTeams(rating, j, n, false);
                }
            }
        }
        return teams;
    }
    public static int countTeams(int[] rating, int i, int n, boolean inc) {
        int teams = 0;
        for (int j = i; j < n; ++j) {
            if (inc && rating[j] > rating[i]) {
                 ++teams;
            } else if (!inc && rating[j] < rating[i]) {
                ++teams;
            }
        }

        return teams;
    }
}
