/**
 * Problem Description
 * Given a triangle, find the minimum path sum from top to bottom. Each step you may move to adjacent numbers on the row below.
 *
 * Adjacent numbers for jth column of ith row is jth and (j+1)th column of (i + 1)th row
 *
 *
 *
 * Problem Constraints
 * |A| <= 1000
 *
 * A[i] <= 1000
 *
 *
 *
 * Input Format
 * First and only argument is the vector of vector A defining the given triangle
 *
 *
 *
 * Output Format
 * Return the minimum sum
 *
 *
 *
 * Example Input
 * Input 1:
 *
 *
 * A = [
 *          [2],
 *         [3, 4],
 *        [6, 5, 7],
 *       [4, 1, 8, 3]
 *     ]
 * Input 2:
 *
 *  A = [ [1] ]
 *
 *
 * Example Output
 * Output 1:
 *
 *  11
 * Output 2:
 *
 *  1
 *
 *
 * Example Explanation
 * Explanation 1:
 *
 *  The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).
 * Explanation 2:
 *
 *  Only 2 can be collected.
 *
 *
 *
 * Expected Output
 * Enter your input as per the following guideline:
 * There are 1 lines in the input
 *
 * Line 1 ( Corresponds to arg 1 ) : Triangle array. The line starts with an integer N denoting the number of rows. Then the next number corresponds to first row. The next 2 numbers correspond to second row. And so on.
 * 	For example, N = 2 & Array: [[1], [2, 3]] will be written as "2 1 2 3"(without quotes).
 */
package dp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MinSumPathInTriangle {
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> A = new ArrayList<>();

        A.add(new ArrayList<>(List.of(2)));
        A.add(new ArrayList<>(List.of(3, 4)));
        A.add(new ArrayList<>(List.of(6, 5, 7)));
        A.add(new ArrayList<>(List.of(4, 1, 8, 3)));

        int res = solve(A);
        System.out.println(res);
    }
    public static int solve(ArrayList<ArrayList<Integer>> A) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        hm.put(0, A.get(0).get(0));

        int currSum = A.get(0).get(0);
       return minimumTotal(A, 0, 0, currSum);
    }
    public static int minimumTotal(ArrayList<ArrayList<Integer>> A, int i, int j, int currSum) {



        return currSum;
    }

}
