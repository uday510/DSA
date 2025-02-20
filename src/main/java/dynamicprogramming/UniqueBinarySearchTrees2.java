package dynamicprogramming;

import tree.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// https://leetcode.com/problems/unique-binary-search-trees-ii/?envType=study-plan-v2&envId=dynamic-programming

/**
 *
 */
public class UniqueBinarySearchTrees2 {
    private static List<TreeNode>[][] dp;
    public static void main(String[] args) {

    }
    public static List<TreeNode> generateTrees(int n) {
        dp = new ArrayList[n + 1][n + 1];

        return dfs(1, n);
    }

    private static List<TreeNode> dfs(int left, int right) {
        if (left > right) {
            return Collections.singletonList(null);
        }

        if (left == right) {
            return Collections.singletonList(new TreeNode(right));
        }

        if (dp[left][right] != null) {
            return dp[left][right];
        }

        var trees = new ArrayList<TreeNode>();

        for (int idx = left; idx <= right; ++idx) {

            var leftSubTrees = dfs(left, idx - 1);
            var rightSubTrees = dfs(idx + 1, right);

            for (var leftSubTree : leftSubTrees) {
                for (var rightSubTree : rightSubTrees) {
                    var tree =  new TreeNode(idx, leftSubTree, rightSubTree);
                    trees.add(tree);
                }
            }
        }

        return trees;
    }
}


