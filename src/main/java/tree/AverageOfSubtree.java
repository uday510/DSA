package tree;

import com.sun.source.tree.Tree;

public class AverageOfSubtree {
    int res = 0;
    public static void main(String[] args) {
        TreeNode root = new TreeNode(4,
                        new TreeNode(8, new TreeNode(0), new TreeNode(1)),
                        new TreeNode(5, null, new TreeNode(6)));
    }
    int avgCnt;

    public int averageOfSubtree(TreeNode root) {
        avgCnt = 0;
        dfs(root);
        return avgCnt;
    }
    public State dfs(TreeNode node) {
        if (node == null) return new State(0, 0);

        State left = dfs(node.left);
        State right = dfs(node.right);

        int currSum = left.nodeSum + right.nodeSum + node.val;
        int nodeCnt = left.nodeCnt + right.nodeCnt + 1;

        if (node.val == (currSum/nodeCnt)) avgCnt++;

        return new State(currSum, nodeCnt);
    }
    static class State {
        int nodeCnt;
        int nodeSum;

        State(int nodeCnt, int nodeSum) {
            this.nodeCnt = nodeCnt;
            this.nodeSum = nodeSum;
        }
    }
}

