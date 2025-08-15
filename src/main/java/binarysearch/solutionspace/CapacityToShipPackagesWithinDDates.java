package binarysearch.solutionspace;

public class CapacityToShipPackagesWithinDDates {

    public int shipWithinDays(int[] weights, int days) {
        int l = 0, r = 0;

        for (int w : weights) {
            l = Math.max(l, w); // need max, if min choose cannot fit max
            r += w;
        }

        while (l < r) {
            int m = l + ((r - l) >> 1);
            if (canShip(weights, m, days)) r = m;
            else l = m + 1;
        }

        return l;
    }

    private boolean canShip(int[] w, int m, int d) {
        int curr = 0;
        int used = 1;

        for (int x : w) {
            if (x > m || used > d) return false;
            if (curr + x > m) {
                used++;
                curr = x;
            } else {
                curr += x;
            }
        }

        return used <= d;
    }

    /**
     *
     *
     * We’re trying to find the minimum ship capacity so all packages can be shipped in days days.
     * The binary search explores capacities between some lower bound l and upper bound r.
     *
     * ⸻
     *
     * Why Math.max, not Math.min
     * 	•	Each package has a weight w.
     * 	•	The ship’s capacity must be at least as large as the heaviest package, otherwise that package could never fit.
     * Example:
     * 	•	Weights = [3, 5, 7], days = 3.
     * 	•	If capacity = 6, then package 7 cannot fit → impossible.
     * 	•	So the minimum valid capacity is max(weights).
     */

}
