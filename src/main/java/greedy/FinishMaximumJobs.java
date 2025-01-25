/**
 * Problem Description
 * There are N jobs to be done, but you can do only one job at a time.
 *
 * Given an array A denoting the start time of the jobs and an array B denoting the finish time of the jobs.
 *
 * Your aim is to select jobs in such a way so that you can finish the maximum number of jobs.
 *
 * Return the maximum number of jobs you can finish.
 *
 *
 *
 * Problem Constraints
 * 1 <= N <= 105
 *
 * 1 <= A[i] < B[i] <= 109
 *
 *
 *
 * Input Format
 * The first argument is an integer array A of size N, denoting the start time of the jobs.
 * The second argument is an integer array B of size N, denoting the finish time of the jobs.
 *
 *
 *
 * Output Format
 * Return an integer denoting the maximum number of jobs you can finish.
 *
 *
 *
 * Example Input
 * Input 1:
 *
 *  A = [1, 5, 7, 1]
 *  B = [7, 8, 8, 8]
 * Input 2:
 *
 *  A = [3, 2, 6]
 *  B = [9, 8, 9]
 *
 *
 * Example Output
 * Output 1:
 *
 *  2
 * Output 2:
 *
 *  1
 *
 *
 * Example Explanation
 * Explanation 1:
 *
 *  We can finish the job in the period of time: (1, 7) and (7, 8).
 * Explanation 2:
 *
 *  Since all three jobs collide with each other. We can do only 1 job.
 */
package greedy;

import java.util.Arrays;
import java.util.Comparator;

public class FinishMaximumJobs {
    public static void main(String[] args) {
        int[] A = {4, 4, 8, 15, 6};
        int[] B = {9, 5, 15, 16, 7};

        int res = solve(A, B);
        System.out.println(res);
    }

    public static int solve(int[] A, int[] B) {
        int n = A.length;
        Pair[] pairs = new Pair[n];
        for (int i = 0; i < n; ++i) {
            Pair pair = new Pair(A[i], B[i]);
            pairs[i] = pair;
        }
        Arrays.sort(pairs, new CustomComparator());


        int res = 0;
        int lastEndTime = 0;

        for (int i = 0; i < n; i++) {
            Pair curr = pairs[i];
            if (curr.start >= lastEndTime) {
                ++res;
                lastEndTime = curr.end;
            }
        }
        return res;
    }
    static class Pair {
        int start;
        int end;

        Pair(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
    static class CustomComparator implements Comparator<Pair> {
        @Override
        public int compare(Pair p1, Pair p2) {
            return p1.end - p2.end;
        }
    }
}
