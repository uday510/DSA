package tree;

import java.util.*;

public class AmountOfTime {
    Map<TreeNode, List<TreeNode>> map;
    TreeNode stNode;
    public int amountOfTime(TreeNode root, int start) {
        map = new HashMap<>();
        stNode = null;
        setParent(root, null, start);

        Set<TreeNode> vis = new HashSet<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(stNode);
        vis.add(stNode);

        int elapsed = 0;

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            ++elapsed;

            for (TreeNode nei : map.get(node)) {
                if (vis.contains(nei)) continue;
                queue.offer(nei);
                vis.add(nei);
            }
        }
        return elapsed;
    }

    public void setParent(TreeNode curr, TreeNode parent, int start) {
        if (curr == null) return;

        if (!map.containsKey(curr)) map.put(curr, new ArrayList<>());

        if (curr.left != null) map.get(curr).add(curr.left);
        if (curr.right != null) map.get(curr).add(curr.right);

        if (curr.val == start) stNode = curr;

        setParent(curr.left, curr, start);
        setParent(curr.right, curr, start);
    }
}
