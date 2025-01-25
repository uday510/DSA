/**
 *
 * Given the root of a binary tree and an integer targetSum, return all root-to-leaf paths where the sum of the node values in the path equals targetSum. Each path should be returned as a list of the node values, not node references.
 *
 * A root-to-leaf path is a path starting from the root and ending at any leaf node. A leaf is a node with no children.
 *
 * Input: root = [5,4,8,11,null,13,4,7,2,null,null,5,1], targetSum = 22
 * Output: [[5,4,11,2],[5,8,4,5]]
 * Explanation: There are two paths whose sum equals targetSum:
 * 5 + 4 + 11 + 2 = 22
 * 5 + 8 + 4 + 5 = 22
 */
package tree;

import java.util.ArrayList;
import java.util.List;

public class PathSum2 {
        public static void main(String[] args) {

            TreeNode root = new TreeNode(5, new TreeNode(4, new TreeNode(11, new TreeNode(7), new TreeNode(2)), null), new TreeNode(8, new TreeNode(13), new TreeNode(4, null, new TreeNode(1))));

            List<List<Integer>> ans = solve(root, 22);
            System.out.println(ans);

        }
        public static List<List<Integer>> solve(TreeNode root, int targetSum) {
            List<List<Integer>> pathsList = new ArrayList<>();
            List<Integer> currPath = new ArrayList<>();

            getPaths(root, targetSum, currPath, pathsList);
            return pathsList;
        }
        public static void getPaths(TreeNode currNode, int remainingSum, List<Integer> currPath, List<List<Integer>> pathLists) {
            /**
             * Time Complexity: O(N2)O(N^2)O(N
             * 2
             *  ) where NNN are the number of nodes in a tree. In the worst case, we could have a
             *  complete binary tree and if that is the case, then there would be N/2N/2N/2 leafs.
             *  For every leaf, we perform a potential O(N)O(N)O(N) operation of copying over the pathNodes
             *  nodes to a new list to be added to the final pathsList. Hence, the complexity in the worst case could be O(N2)O(N^2)O(N
             * 2
             *  ).
             *
             * Space Complexity: O(N)O(N)O(N). The space complexity, like many other problems is debatable here.
             * I personally choose not to consider the space occupied by the output in the space complexity.
             * So, all the new lists that we create for the paths are actually a part of the output and hence,
             * don't count towards the final space complexity. The only additional space that we use is the pathNodes list to keep track of nodes along a branch.
             */

            if (currNode == null) return;

            // Add the current node to the current path
            currPath.add(currNode.val);

            // check if the current node is a leaf and also, if it
            // equals remaining sum. if it does, add the currPath to
            // list of paths
            if (remainingSum == currNode.val && currNode.left == null && currNode.right == null) {
                pathLists.add(new ArrayList<>(currPath));
            } else {
                // recurse on the left and right children
                getPaths(currNode.left, remainingSum - currNode.val, currPath, pathLists);
                getPaths(currNode.right, remainingSum - currNode.val, currPath, pathLists);
            }

            // need to pop the node once we are done processing
            // ALL of it's subtrees
            currPath.remove(currPath.size() - 1);
        }
}
