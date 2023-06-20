/**
 * Problem Description
 * Given two arrays of integers A and B of size N each, where each pair (A[i], B[i]) for 0 <= i < N represents a unique point (x, y) in a 2-D Cartesian plane.
 *
 * Find and return the number of unordered quadruplet (i, j, k, l) such that (A[i], B[i]), (A[j], B[j]), (A[k], B[k]) and (A[l], B[l]) form a rectangle with the rectangle having all the sides parallel to either x-axis or y-axis.
 *
 *
 *
 * Problem Constraints
 * 1 <= N <= 2000
 * 0 <= A[i], B[i] <= 109
 *
 *
 *
 * Input Format
 * The first argument given is the integer array A.
 * The second argument given is the integer array B.
 *
 *
 *
 * Output Format
 * Return the number of unordered quadruplets that form a rectangle.
 *
 *
 *
 * Example Input
 * Input 1:
 *
 *  A = [1, 1, 2, 2]
 *  B = [1, 2, 1, 2]
 * Input 1:
 *
 *  A = [1, 1, 2, 2, 3, 3]
 *  B = [1, 2, 1, 2, 1, 2]
 *
 *
 * Example Output
 * Output 1:
 *
 *  1
 * Output 2:
 *
 *  3
 *
 *
 * Example Explanation
 * Explanation 1:
 *
 *  All four given points make a rectangle. So, the answer is 1.
 * Explanation 2:
 *
 *  3 quadruplets which make a rectangle are: (1, 1), (2, 1), (2, 2), (1, 2)
 *                                            (1, 1), (3, 1), (3, 2), (1, 2)
 *                                            (2, 1), (3, 1), (3, 2), (2, 2)
 */

package Array.Arrays;

import java.util.HashMap;
import java.util.HashSet;

public class CountRectangles {
    public static void main(String[] args) {
        int[] a = {1, 1, 2, 2, 3, 3};
        int[] b = {1, 2, 1, 2, 1, 2};

        int ans = solve(a, b);
        System.out.println(ans);
    }

    public static int solve(int[] a, int[] b) {
        // O(N^2) time | O(N) space
        int n = a.length;
        HashMap<Integer, HashSet<Integer>> mpX = new HashMap<>();
        HashSet<Integer> h;

        // stores all the points
        for (int i = 0; i < n; i++) {
            if (mpX.containsKey(a[i])) {
                h = mpX.get(a[i]);
            } else {
                h = new HashSet<>();
            }
                h.add(b[i]);
                mpX.put(a[i], h);
        }
//        System.out.println(mpX);
        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                // checks if there exists a rectangle such that
                // i-th and
                // j-th points are the ends of a diagonal
                if (a[i] != a[j] && b[i] != b[j]) {
                    if (mpX.get(a[i]).contains(b[j]) && mpX.get(a[j]).contains(b[i])) {
                        ans++;
                    }
                }
            }
        }
        return ans >> 1; // diagonals / 2
    }
}
