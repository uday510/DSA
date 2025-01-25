package tree;
import java.util.*;

public class BottomViewOfBinaryTree {
    public static class Pair {
        TreeNode node;
        int level;
        Pair(TreeNode node, int level) {
            this.node = node;
            this.level = level;
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(20, new TreeNode(8, new TreeNode(5), new TreeNode(3)), new TreeNode(22, null, new TreeNode(25)));

        // Inputting Data
        ArrayList<Integer> ans = solve(root);
        System.out.println(ans);
    }
    public static ArrayList<Integer> solve(TreeNode root) {
        // O(N) time | O(N) space
        ArrayList<Integer> ans = new ArrayList<>();

        if (root == null) return ans;

        Map<Integer, Integer> tm = new TreeMap<>();

        ArrayDeque<Pair> queue = new ArrayDeque<>() {{
            offer(new Pair(root, 0));
        }};

        while (!queue.isEmpty()) {
            Pair currPair = queue.poll();
            TreeNode currNode = currPair.node;
            int currNodeLevel = currPair.level;

            // we need last element of vertical view, so keep adding until last element
            tm.put(currNodeLevel, currNode.val);

            if (currNode.left != null) {
                queue.offer(new Pair(currNode.left, currNodeLevel - 1));
            }
            if (currNode.right != null) {
                queue.offer(new Pair(currNode.right, currNodeLevel + 1));
            }
        }
        // traverse in tree map, which is from min to max and to ans
        for (Map.Entry<Integer, Integer> entry : tm.entrySet()) {
            ans.add(entry.getValue());
        }
        return ans;
    }
}
