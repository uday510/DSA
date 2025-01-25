package tree;

import java.util.*;

public class LevelOrderBottomUp {

    public static void main(String[] args) {

        TreeNode root = new TreeNode(3, new TreeNode(9), new TreeNode(20, new TreeNode(15), new TreeNode(7)));

        List<List<Integer>> levelOrder = solve(root);
        System.out.println(levelOrder);
    }
//    public static ArrayList<ArrayList<Integer>> solve(TreeNode root) {
//        // O(N) time | O(N) space
//        ArrayList<ArrayList<Integer>> levels = new ArrayList<>();
//        if (root == null) return levels;
//
//        Queue<TreeNode> queue = new LinkedList<>();
//        queue.add(root);
//        int currLevel = 0;
//        while (!queue.isEmpty()) {
//            //start the current level
//            levels.add(new ArrayList<Integer>());
//
//            // number of elements in the current level
//            int levelLength = queue.size();
//            for (int i = 0; i < levelLength; ++i) {
//                TreeNode currNode = queue.remove();
//
//                // fulfill the current level
//                levels.get(currLevel).add(currNode.val);
//
//                // add child nodes of the current level
//                // in the queue for the next level
//                if (currNode.left != null) queue.add(currNode.left);
//                if (currNode.right != null) queue.add(currNode.right);
//            }
//            // go to next level
//            currLevel++;
//        }
//        Collections.reverse(levels);
//        return levels;
//    }
    public static List<List<Integer>> solve(TreeNode root) {
        LinkedList<List<Integer>> levels = new LinkedList<>();
        if (root == null) return levels;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            //start the current level
            List<Integer> level = new LinkedList<>();

            int levelLength = queue.size();
            for (int i = 0; i < levelLength; i++) {
                TreeNode currNode = queue.remove();
                level.add(currNode.val);

                if (currNode.left != null) queue.add(currNode.left);
                if (currNode.right != null) queue.add(currNode.right);
            }
            levels.addFirst(level);
        }
        return levels;
    }
}
