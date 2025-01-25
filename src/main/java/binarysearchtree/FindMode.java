package binarysearchtree;

import java.util.*;

// https://leetcode.com/problems/find-mode-in-binary-search-tree/
public class FindMode {

    public static void main(String[] args) {

    }
    private List<Integer> inorder;
    public int[] findMode(TreeNode root) {
        inorder = new ArrayList<>();
        dfs(root);
        inorder.add(9876989);

        int maxFreq = 0;
        int prev = 9876989;
        int currFreq = 0;

        for (int curr : inorder) {
            if (curr == prev) {
                currFreq += 1;
            } else {
                maxFreq = Math.max(maxFreq, currFreq);
                currFreq = 1;
            }
            prev = curr;
        }

        List<Integer> modes = new ArrayList<>();
        prev = 988725256;
        currFreq = 0;
        for (int curr : inorder) {
            if (curr == prev) {
                currFreq += 1;
            } else {
                if (currFreq == maxFreq) {
                    modes.add(prev);
                }
                currFreq = 1;
            }
            prev = curr;
        }
        
        return modes.stream().mapToInt(Integer::intValue).toArray();
    }

    private void dfs(TreeNode node) {
        if (node == null) return;
        dfs(node.left);
        inorder.add(node.val);
        dfs(node.right);
    }
}
