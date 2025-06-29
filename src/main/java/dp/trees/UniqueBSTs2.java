package dp.trees;

import tree.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


/**
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */


// Time (4 ** N ) / ( N ** 1.5) | Space (4 ** N ) / ( N ** 1.5)
public class UniqueBSTs2 {

    public List<TreeNode> generateTrees(int n) {
        return dfs(1, n);
    }

    private List<TreeNode> dfs(int st, int en) {
        if (st > en) {
            return Collections.singletonList(null);
        }

        List<TreeNode> list = new ArrayList<>();

        for (int i = st; i <= en; ++i) {

            List<TreeNode> leftNodes = dfs(st, i - 1);
            List<TreeNode> rightNodes = dfs(i + 1, en);

            for (TreeNode left : leftNodes) {
                for (TreeNode right : rightNodes) {
                    TreeNode node = new TreeNode(i, left, right);
                    list.add(node);
                }
            }
        }

        return list;
    }

}
