package binarysearch.solutionspace;

public class MinimumSpeedToArriveOnTime {

    int[] dist;
    double hr;
    int n;

    public int minSpeedOnTime(int[] dist, double hour) {
        this.dist = dist;
        hr = hour;
        this.n = dist.length;

        int l = 1, r = 1;
        while (!canReach(r)) r <<= 1;

        while (l < r) {
            int m = l + ((r - l) >> 1);

            if (canReach(m)) r = m;
            else l = m + 1;
        }

        return canReach(l) ? l : -1;
    }

    private boolean canReach(int m) {
        double h = 0.0;

        for (int i = 0; i < n - 1; ++i) h += (dist[i] + m - 1) / m;

        h += (double) dist[n - 1] / m;

        return h <= hr;
    }

}
