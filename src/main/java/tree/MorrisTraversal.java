package tree;

import java.util.ArrayList;

public class MorrisTraversal {

        public static void main(String[] args) {

            TreeNode root = new TreeNode(1, new TreeNode(2, new TreeNode(4), new TreeNode(5)), new TreeNode(3, new TreeNode(6), new TreeNode(7)));

        }
        public static void morrisInorder(TreeNode root) {
            /**
             *  O(N) time | O(1) space
             * if left is null, print and go right.
             * if left is not null, keep temp = curr.left, iterate till curr.right != null
             */
            ArrayList<Integer> res = new ArrayList<>();

            TreeNode currNode = root;
            TreeNode predecessor; //predecessor

            while (currNode != null) {
                if (currNode.left == null) {
                    res.add(currNode.val);
                    currNode = currNode.right;
                } else {
                    predecessor = currNode.left;
                    while (predecessor != null && predecessor.right != null) {
                            predecessor = predecessor.right;
                    }
                    if (predecessor.right == null) {
                        predecessor.right = currNode;
                        currNode = currNode.left;
                    } else {
                        predecessor.right = null;
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
