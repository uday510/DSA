/**
 * Problem Description
 *
 * Given preorder traversal of a binary tree, check if it is possible that it is also a preorder traversal of a Binary Search Tree (BST), where each internal node (non-leaf nodes) have exactly one child.
 *
 *
 *
 * Problem Constraints
 *
 * 1 <= number of nodes <= 100000
 *
 *
 *
 * Input Format
 *
 * First and only argument is an integer array denoting the preorder traversal of binary tree.
 *
 *
 *
 * Output Format
 *
 * Return a string "YES" if true else "NO".
 *
 *
 *
 * Example Input
 *
 * Input 1:
 *
 *  A : [4, 10, 5, 8]
 * Input 2:
 *
 *  A : [1, 5, 6, 4]
 *
 *
 * Example Output
 *
 * Output 1:
 *
 *  "YES"
 * Output 2:
 *
 *  "NO"
 *
 *
 * Example Explanation
 *
 * Explanation 1:
 *
 *  The possible BST is:
 *             4
 *              \
 *              10
 *              /
 *              5
 *               \
 *               8
 * Explanation 2:
 *
 *  There is no possible BST which have the above preorder traversal.
 */
package binarysearchtree;

public class CheckBSTWithOneChild {
    public static void main(String[] args) {
        int[] nums = {4, 10, 5, 8};

        String ans = solve(nums);
        System.out.println(ans);
    }
    public static String solve(int[] nums) {
        int root = nums[0];
        int min = Integer.MIN_VALUE;
        int max = Integer.MAX_VALUE;

        for (int i = 1; i < nums.length; i++) {
            int curr = nums[i];
            // check curr is < or >
            if (curr < root) {
                max = root;
            } else min = root;


            // check for BST condition
            if (curr < min || curr > max) return "NO";

            // change root to curr
            root = curr;
        }
        // valid BST
        return "YES";
    }
}
