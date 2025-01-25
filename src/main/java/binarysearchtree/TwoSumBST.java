/**
 * Problem Description
 * Given a binary search tree A, where each node contains a positive integer, and an integer B, you have to find whether or not there exist two different nodes X and Y such that X.value + Y.value = B.
 *
 * Return 1 to denote that two such nodes exist. Return 0, otherwise.
 *
 *
 *
 * Problem Constraints
 * 1 <= size of tree <= 100000
 *
 * 1 <= B <= 109
 *
 *
 *
 * Input Format
 * First argument is the head of the tree A.
 *
 * Second argument is the integer B.
 *
 *
 *
 * Output Format
 * Return 1 if such a pair can be found, 0 otherwise.
 *
 *
 *
 * Example Input
 * Input 1:
 *
 *          10
 *          / \
 *         9   20
 *
 * B = 19
 * Input 2:
 *
 *
 *           10
 *          / \
 *         9   20
 *
 * B = 40
 *
 *
 * Example Output
 * Output 1:
 *
 *  1
 * Output 2:
 *
 *  0
 *
 *
 * Example Explanation
 * Explanation 1:
 *
 *  10 + 9 = 19. Hence 1 is returned.
 * Explanation 2:
 *
 *  No such pair exists.
 */
package binarysearchtree;

import java.util.ArrayList;

public class TwoSumBST {
    public static void main(String[] args) {

        TreeNode node7 = new TreeNode(30, null, null);
        TreeNode node6 = new TreeNode(10, null, null);
        TreeNode node5 = new TreeNode(20, node6, node7);

        TreeNode node3 = new TreeNode(6, null, null);
        TreeNode node2 = new TreeNode(4, null, null);
        TreeNode node1 = new TreeNode(8, node2, node3);

        TreeNode root = new TreeNode(10, null, null);

        root.left = node1;
        root.right = node5;

        int ans = solve(root, 8);
        System.out.println(ans);
    }

    public static int solve(TreeNode root, int k) {
        ArrayList<Integer> list = new ArrayList<>();

        inorder(root, list);

        int l = 0;
        int r = list.size() - 1;

        while (l < r) {
            int sum = list.get(l) + list.get(r);

            if (sum == k) return 1;
            if (sum < k) l++;
            else r--;
        }
        return 0;
    }

    public static void inorder(TreeNode root, ArrayList<Integer> list) {
        if (root == null) return;

        inorder(root.left, list);
        list.add(root.val);
        inorder(root.right, list);
    }
}
