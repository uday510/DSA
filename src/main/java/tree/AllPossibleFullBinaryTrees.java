/*
Given an integer n, return a list of all possible full binary trees with n nodes. Each node of each tree in the answer must have Node.val == 0.

Each element of the answer is the root node of one possible tree. You may return the final list of trees in any order.

A full binary tree is a binary tree where each node has exactly 0 or 2 children.
 */
package tree;

import java.util.ArrayList;
import java.util.List;

public class AllPossibleFullBinaryTrees {
    public static void main(String[] args) {
        int n = 7;
        System.out.println(allPossibleFBT(n));
    }
    public static List<TreeNode> allPossibleFBT(int n) {
        List<List<TreeNode>> dp = new ArrayList<>();

        for (int i = 0; i <= n; ++i) {
            dp.add(new ArrayList<>());
        }

        dp.get(0).add(null);
        dp.get(1).add(new TreeNode(0));

        for (int i = 2; i <= n; i+=2) { // why i+=2? because we need to add 2 nodes at a time to make a full binary tree (1 root and 1 child)
            for (int j = 1; j < i; ++j) {
                for (TreeNode left : dp.get(j)) {
                    for (TreeNode right : dp.get(i - j - 1)) {
                        TreeNode root = new TreeNode(0);
                        root.left = left;
                        root.right = right;
                        dp.get(i).add(root);
                     }
                }
              }
       }

       return dp.get(n);
    }

}
