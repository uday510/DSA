/**
 * Problem Description
 * Given a binary string A of size N. There are Q queries given by the array B of size Q*2.
 *
 * Each query has 2 integers :-
 *
 * First integer denotes the type of query. Type of query can be either 1 or 2.
 *
 * Second integer denotes index x.
 *
 * If type = 1, flip the value at index x.
 *
 * If type = 2, find the index of nearest 1 from index x. If there are multiple indices, return the one with lower value. If there is no such index, return -1.
 *
 * Note :- We use 1-based indexing
 *
 *
 *
 * Problem Constraints
 * 1 <= N <= 105
 *
 * 1 <= Q <= 105
 *
 * 1 <= B[i][0] <= 2
 *
 * 1 <= B[i][1] <= N
 *
 *
 *
 * Input Format
 * First argument A is a string.
 *
 * Second argument B is a 2D array of integers describing the queries.
 *
 *
 *
 * Output Format
 * Return an array of integers denoting the answers to each query of type 2.
 *
 *
 *
 * Example Input
 * Input 1:
 * A = "10010"
 * B = [[1, 2]
 *      [2, 3]]
 * Input 2:
 * A = "010000100"
 * B = [[2, 5]
 *      [1, 7]
 *      [2, 9]]
 *
 *
 * Example Output
 * Output 1:
 * [2]
 * Output 2:
 * [7, 2]
 *
 *
 * Example Explanation
 * For Input 1:
 * After first query, A = "11010".
 * For second query, X = 3. Both index 2 and index 4 are at the same
 * distance but we choose the lower index.
 * For Input 2:
 * For first query, the index 2 is at a distance 3 and index 7 is at a distance 2. So we choose
 * index 7.
 * After second query, A = "010000000"
 * For third query, the only index with '1' is 2.
 */
package Linear.Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.TreeSet;

public class FlipAndFindNearest {
    public static void main(String[] args) {
        String str = "01001001000110";
//          String str = "010000100";
//        String str = "10010";
        int[][] b = { {2, 9}, {1, 7}, {2, 6}, {1, 12}, {2, 9} };
//        int[][] b = { {2, 5}, {1, 7}, {2, 9} };
//        int[][] b = { {1, 3}, {1, 3}, {2, 4}, {2, 2}, {1, 1}, {2, 3}, {1, 5}, {1, 5} };

        int[] ans = solve(str, b);

        System.out.println(Arrays.toString(ans));
    }
    public static int[] solve(String string, int[][] queries) {
        final int inf = (int) (1e9);
        TreeSet<Integer> set = new TreeSet<>();
        ArrayList<Integer> ans = new ArrayList<Integer>();
        // set stores the index of all '1's
        for (int i = 0; i < string.length(); i++) {
            if (string.charAt(i) == '1') {
                set.add(i + 1);
            }
        }
        for (int[] query : queries) {
            int type = query[0];
            int x = query[1];
            if (type == 1) {
                if (set.contains(x)) {
                    // flip the bit from '1' to '0'
                    set.remove(x);
                } else {
                    // flip the bit from '0' to '1'
                    set.add(x);
                }
            } else {
                int left = -inf, right = inf;
                if (set.ceiling(x) != null) {
                    // finds the nearest '1' on the right
                    right = set.ceiling(x);
                }
                if (set.floor(x) != null) {
                        // finds the nearest '1' on the left
                        left = set.floor(x);
                }
                // update the ans
                if (left == -inf && right == inf) {
                    ans.add(-1);
                } else if (x - left <= right - x) {
                    ans.add(left);
                } else {
                    ans.add(right);
                }
            }
        }
        return ans.stream().mapToInt(i -> i).toArray();
    }
}
