package dp.trees;

import tree.TreeNode;

public class BinaryTreeMaxPathSum {

	int maxSum;
    public int maxPathSum(TreeNode root) {
        maxSum = 0;
        dfs(root);
        return maxSum;
    }

    private int dfs(TreeNode node) {
        if (node == null) return 0;

        int leftSum = Math.max(dfs(node.left), 0);
        int rightSum = Math.max(dfs(node.right), 0);

        maxSum = Math.max(maxSum, leftSum + rightSum + node.val);

        return Math.max(leftSum, rightSum) + node.val;

    }

    /**
    
    
    The function returns the path sum gain contributed by the subtree.

The path sum gain contributed by the subtree can be derived from a path that includes at most one child of the root. You may wonder, why can't we include both children? If we include both children in the path, the path would have to make a fork at the root. The root is already connected to its parent. Now, if we include both children as well, with three connections, it wouldn't be a valid path anymore. Therefore, we can say that the path would consist of at most one child of the root.

The recursive function compares left_gain and right_gain and adds the maximum of the two to the value of the root. The sum, gain_from_subtree is then returned to the caller.

left_gain = max(gain_from_left_subtree, 0)
right_gain = max(gain_from_right_subtree, 0)
gain_from_subtree = max(left_gain, right_gain) + root.val
We use max(gain_from_left_subtree, 0) because we want to consider the gain only if it is positive. If it is negative, we ignore it or consider it as zero.

The function keeps track of the maximum path sum.

Assuming that the maximum path sum passes through the root of the subtree, as explained earlier, we consider all four possibilities - (1) The path goes through the left subtree (2) The path goes through the right subtree (3) The path goes through both left and right subtrees (4) The path doesn't involve left or right subtrees. So we include the left and right gain if they are positive and the value of the root node. We compare this sum with the current maximum path sum and update it if necessary. The following code segment takes care of all four possibilities.

max_path_sum = max(max_path_sum, left_gain + right_gain + root.val)
Algorithm
Main function body
Initialize a global variable max_sum to -Infinity.
Call the function gain_from_subtree on the tree's root.
Return the value of max_sum.
Body of the recursive function gain_from_subtree. It accepts root of the subtree as the input.
If the root is null, return 0. This is the base case. If a node doesn't have a left or right child, then the path sum contributed by the respective subtree is 0.
Call the function recursively on the left and right child of the root. Store the results in gain_from_left and gain_from_right, respectively.
If either is negative, set it to 0. This is because we don't want to include a path sum contributed by a subtree if it is negative.
Update the maximum path sum (max_sum) seen so far. To do so, compare max_sum with the sum of the following, and update it if it is smaller.
The value of the root itself.
gain_from_left (0 if negative)
gain_from_right (0 if negative)
Return the path sum gain contributed by the subtree. This is the maximum of the following two values.
The value of the root plus gain_from_left.
The value of the root plus gain_from_right.
 */


}