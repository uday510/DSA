/*
Given an integer n, return all the structurally unique BST's (binary search trees),
which has exactly n nodes of unique values from 1 to n.
Return the answer in any order.

 Input: n = 3
Output: [[1,null,2,null,3],[1,null,3,2],[2,1,3],[3,1,null,null,2],[3,2,null,1]]


 */
package binarysearchtree;

import Tree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class UniqueBinarySearchTrees2 {
    public static void main(String[] args) {
        int n = 3;
        System.out.println(generateTrees(n));
    }
    public static List<TreeNode> generateTrees(int n) {

//            List<List<TreeNode>> dp = new ArrayList<>();
//
//            for (int i = 0; i <= n; ++i) {
//                dp.add(new ArrayList<>()); // add empty list
//            }
//
//            // add base case
//            dp.get(0).add(null); // empty tree
//            dp.get(1).add(new TreeNode(1)); // only one node
//
//            if (n == 0) return dp.get(0);
//            if (n == 1) return dp.get(1);
//
//
//            for (int i = 2; i <= n; ++i) { // i is the number of nodes
//
//                for (int j = 1; j <= i; ++j) { // j is the root
//                    // 1 to i - 1 is the left subtree, i - j is the right subtree
//
//                    for (TreeNode left : dp.get(j - 1)) { // iterate through all left subtrees
//                        for (TreeNode right : dp.get(i - j)) { // iterate through all right subtrees
//
//                            TreeNode root = new TreeNode(j); // create root node
//                            root.left = left; // set left subtree why not clone? because we don't need to add offset to the left subtree, it's already unique
//                            root.right = clone(right, j); // set right subtree , why clone? because we need to add offset to the right subtree
//
//                            dp.get(i).add(root); // add to dp
//                        }
//                    }
//                }
//            }
//        return dp.get(n);

        List<List<TreeNode>> dp = new ArrayList<>();

        for (int i = 0; i <= n; ++i) {
            dp.add(new ArrayList<>());
        }

        dp.get(0).add(null);


        return generateTrees(n, new ArrayList<>(), 1, n);
    }


    public static List<TreeNode> generateTrees(int n, List<List<TreeNode>> dp, int left, int right) {

        if (left > right) {
            List<TreeNode> list = new ArrayList<>();
            list.add(null);
            return list;
        }

        if (left == right) {
            List<TreeNode> list = new ArrayList<>();
            list.add(new TreeNode(left));
            return list;
        }

        if (dp.get(left).size() > 0) {
            return dp.get(left);
        }

        if (dp.get(right).size() > 0) {
            return dp.get(right);
        }

        List<TreeNode> list = new ArrayList<>();

        for (int i = left; i <= right; ++i) {

            List<TreeNode> leftSubtree = generateTrees(n, dp, left, i - 1);
            List<TreeNode> rightSubtree = generateTrees(n, dp, i + 1, right);

            for (TreeNode leftNode : leftSubtree) {
                for (TreeNode rightNode : rightSubtree) {

                    TreeNode root = new TreeNode(i);
                    root.left = leftNode;
                    root.right = rightNode;

                    list.add(root);
                }
            }
        }
        return list;

    }
    public static TreeNode clone(TreeNode root, int offset) {

//        if (root == null) {
//            return null;
//        }
//
//        TreeNode node = new TreeNode(root.val + offset); // to make sure the value is unique, add offset
//        node.left = clone(root.left, offset); // clone left subtree
//        node.right = clone(root.right, offset); // clone right subtree
//
//        return node; // return cloned node

        if (root == null) return null; // base case

        Queue<TreeNode> queue = new LinkedList<>(); // queue for original tree
        Queue<TreeNode> clonedQueue = new LinkedList<>(); // queue for cloned tree


        queue.add(root); // add root to original queue

        TreeNode clonedRoot = new TreeNode(root.val + offset); // create cloned root. why add offset? to make sure the value is unique

        clonedQueue.add(clonedRoot); // add cloned root to cloned queue

        while (!queue.isEmpty()) {

            TreeNode node = queue.poll();
            TreeNode clonedNode = clonedQueue.poll();

            if (node.left != null) {
                assert clonedNode != null;
                clonedNode.left = new TreeNode(node.left.val + offset); // add offset to left subtree
                queue.add(node.left); // add left subtree to original queue
                clonedQueue.add(clonedNode.left); // add left subtree to cloned queue
            }

            if (node.right != null) { // same as left subtree
                assert clonedNode != null;
                clonedNode.right = new TreeNode(node.right.val + offset);
                queue.add(node.right);
                clonedQueue.add(clonedNode.right);
            }
        }

        return clonedRoot;
    }
}
