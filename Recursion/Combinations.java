/**
 * Problem Description
 * Given two integers A and B, return all possible combinations of B numbers out of 1 2 3 ... A.
 *
 * Make sure the combinations are sorted.
 *
 * To elaborate,
 *
 * Within every entry, elements should be sorted. [1, 4] is a valid entry while [4, 1] is not.
 * Entries should be sorted within themselves.
 * WARNING: DO NOT USE LIBRARY FUNCTION FOR GENERATING COMBINATIONS.
 *
 *
 *
 * Problem Constraints
 * 1 <= A, B <= 10
 *
 *
 *
 * Input Format
 * The first argument is an integer A.
 * The second argument is an integer B.
 *
 *
 *
 * Output Format
 * Return a 2-D vector denoting all possible combinations.
 *
 *
 *
 * Example Input
 * Input 1:
 *
 *  A = 4
 *  B = 2
 * Input 2:
 *
 *  A = 3
 *  B = 2
 *
 *
 * Example Output
 * Output 1:
 *
 *  [
 *   [1, 2],
 *   [1, 3],
 *   [1, 4],
 *   [2, 3],
 *   [2, 4],
 *   [3, 4],
 *  ]
 * Output 2:
 *
 *  [
 *   [1, 2],
 *   [1, 3],
 *   [2, 3]
 *  ]
 *
 *
 * Example Explanation
 * Explanation 1:
 *
 * All the possible combinations of size 2 in sorted order.
 */
package Recursion;

import java.util.ArrayList;
import java.util.List;

public class Combinations {
    static ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
    public static void main(String[] args) {
        int k = 2, n = 4;
        List<List<Integer>> res = solve(k, n);
        System.out.println(res);
    }
    public static List<List<Integer>> solve(int k, int n) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();

        solve(1, k, n, curr, ans);

        return ans;

    }

    public static void solve(int idx, int k, int n, List<Integer> curr, List<List<Integer>> ans) {

        if (curr.size() == k) {
            ans.add(new ArrayList<>(curr));
            return;
        }

        if (idx == n + 1) {
            return;
        }

        // add
        curr.add(idx);
        solve(idx + 1, k, n, curr, ans);

        // remove
        curr.remove(curr.size() - 1);
        solve(idx + 1, k, n, curr, ans);
    }
}
