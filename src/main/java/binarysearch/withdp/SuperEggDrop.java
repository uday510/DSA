package binarysearch.withdp;

public class SuperEggDrop {

    public int superEggDrop(int eggs, int floors) {
        int[][] dp = new int[eggs + 1][floors + 1];

        for (int egg = 1; egg <= eggs; egg++) {
            for (int floor = 1; floor <= floors; floor++) {

                if (egg == 1) {
                    dp[egg][floor] = floor;
                } else if (floor == 1)  {
                    dp[egg][floor] = 1;
                }  else {
                    int best = Integer.MAX_VALUE;
                    // int currMin = Integer.MAX_VALUE;
                    // for (int f = floor - 1, prevF = 0; f > -1; f--, prevF++) {
                    //     int v1 = dp[egg][f]; // egg survives
                    //     int v2 = dp[egg - 1][prevF]; // egg breaks
                    //     int v = Math.max(v1, v2);
                    //     currMin = Math.min(currMin, v);
                    // }

                    int l = 1, r = floor;

                    while (l <= r) {
                        int x = l + (( r - l) >> 1);
                        int broken = dp[egg - 1][x - 1];
                        int notBroken = dp[egg][floor - x];
                        int worst = Math.max(broken, notBroken);
                        best = Math.min(best, worst);

                        if (broken < notBroken) l = x + 1;
                        else r = x - 1;
                    }

                    dp[egg][floor] = best + 1;
                }
            }
        }

        return dp[eggs][floors];
    }

}
