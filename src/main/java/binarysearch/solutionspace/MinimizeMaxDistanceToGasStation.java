package binarysearch.solutionspace;

public class MinimizeMaxDistanceToGasStation {

    public double minmaxGasDist(int[] stations, int k) {
        double l = 0;
        double r = 1e8;

        while (r - l > 1e-6) {
            double m = (l + r) / 2.0;
            if (isPossible(m, stations, k)) r = m;
            else l = m;
        }

        return l;
    }

    private boolean isPossible(double limit, int[] stations, int k) {
        int curr = 0;

        for (int i = 1; i < stations.length && curr <= k; ++i) {
            double d = stations[i] - stations[i - 1];
            if(d > limit) curr += (int) ( d/ limit);
        }

        return curr <= k;
    }

}
