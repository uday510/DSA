package NonLinear.BinaryTrees;

import java.util.ArrayList;

public class MorrisTraversal {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }

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

        }
        public static void morrisInorder(TreeNode root) {
            /**
             *  O(N) time | O(1) space
             * if left is null, print and go right.
             * if left is not null, keep temp = curr.left, iterate till curr.right != null
             */
            ArrayList<Integer> res = new ArrayList<>();


            TreeNode currNode = root;
            TreeNode tempNode;

            while (currNode != null) {
                if (currNode.left == null) {
                    res.add(currNode.val);
                    currNode = currNode.right;
                } else {
                    tempNode = currNode.left;
                    while (tempNode != null && tempNode.right != null) {
                            tempNode = tempNode.right;
                    }
                    if (tempNode.right == null) {
                        tempNode.right = currNode;
                        currNode = currNode.left;
                    } else {
                        tempNode.right = null;
                        res.add(currNode.val);
                        currNode = currNode.right;
                    }
                }
            }
        }
        public static void morrisPreorder(TreeNode root) {
            ArrayList<Integer> res = new ArrayList<>();

            TreeNode currNode = root;
            TreeNode tempNode;

            while (currNode != null) {
                if (currNode.left == null) {
                    res.add(currNode.val);
                    currNode = currNode.right;
                } else {
                    tempNode = currNode.left;
                    while (tempNode != null && tempNode.right != null) {
                        tempNode = tempNode.right;
                    }
                    if (tempNode.right == null) {
                        tempNode.right = currNode;
                        res.add(currNode.val);
                        currNode = currNode.left;
                    } else {
                        tempNode.right = null;
                        currNode = currNode.right;
                    }
                }
            }
        }
    }
}
