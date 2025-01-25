/**
 * Problem Description
 * Given an array of integers A, the array is squareful if for every pair of adjacent elements, their sum is a perfect square.
 *
 * Find and return the number of permutations of A that are squareful. Two permutations A1 and A2 differ if and only if there is some index i such that A1[i] != A2[i].
 *
 *
 *
 * Problem Constraints
 * 1 <= length of the array <= 12
 *
 * 1 <= A[i] <= 109
 *
 *
 *
 * Input Format
 * The only argument given is the integer array A.
 *
 *
 *
 * Output Format
 * Return the number of permutations of A that are squareful.
 *
 *
 *
 * Example Input
 * Input 1:
 *
 *  A = [2, 2, 2]
 * Input 2:
 *
 *  A = [1, 17, 8]
 *
 *
 * Example Output
 * Output 1:
 *
 *  1
 * Output 2:
 *
 *  2
 *
 *
 * Example Explanation
 * Explanation 1:
 *
 *  Only permutation is [2, 2, 2], the sum of adjacent element is 4 and 4 and both are perfect square.
 * Explanation 2:
 *
 *  Permutation are [1, 8, 17] and [17, 8, 1].
 */
package backtracking;

public class NumberOfSquarefulArrays {
    static int res;
    public static void main(String[] args) {
        int[] nums = {18, 7, 2};

        int res = solve(nums);

        System.out.println(res);
    }
    public static int solve(int[] nums) {
//         O(N*N!) time | O(N*N!) space

        boolean[] visited = new boolean[nums.length];

        int[] currPerm = new int[nums.length];

        getPermutations(nums, 0, visited, currPerm);
        return 0;

    }

    public static void getPermutations(int[] nums, int idx, boolean[] visited, int[] currPerm) {
        if (idx == nums.length) {
            res++;
            return;
        }

        for (int i = 0; i < nums.length; ++i) { // All Possibilities
            if (!visited[i]) {
                visited[i] = true;    // make changes
                currPerm[idx] = nums[i];
                getPermutations(nums, i+1, visited, currPerm); // recursive call
                visited[i] = false; // undo changes
            }
        }
    }

    public boolean isSquare(int num) {
        int temp = (int) Math.sqrt(num);
        return temp * temp == num;
    }
}
