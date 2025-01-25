/**
 * Given an integer array nums, return the maximum result of nums[i] XOR nums[j], where 0 <= i <= j < n.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [3,10,5,25,2,8]
 * Output: 28
 * Explanation: The maximum result is 5 XOR 25 = 28.
 * Example 2:
 *
 * Input: nums = [14,70,53,83,49,91,36,80,92,51,66,70]
 * Output: 127
 */
package trie;

public class MaximumXOROfTwoNumbers {
    public int findMaximumXOR(int[] nums) {

        Node root = new Node();
        Node currNode;
        int maxNum = nums[0];
        for(int num : nums) maxNum = Math.max(maxNum, num);
        int L = (Integer.toBinaryString(maxNum)).length();

        for (int num : nums) {
            currNode = root;
            for (int i = L-1; i > -1; i--) {
                if ( (num & (1 << i)) == 0) {
                    if (currNode.children[0] == null) {
                        currNode.children[0] = new Node();
                    }
                    currNode = currNode.children[0];
                } else {
                    if (currNode.children[1] == null) {
                        currNode.children[1] = new Node();
                    }
                    currNode = currNode.children[1];
                }
            }
        }
        int ans = 0;

        for (int num : nums) {
            int xor = 0;
            currNode = root;
            for (int i = L-1; i > -1; i--) {
                if ( (num & (1 << i )) == 0) {
                    if (currNode.children[1] != null) {
                        xor = (xor | (1 << i));
                        currNode = currNode.children[1];
                    } else {
                        currNode = currNode.children[0];
                    }
                } else {
                    if (currNode.children[0] != null) {
                        xor = (xor | (1 << i));
                        currNode = currNode.children[0];
                    } else {
                        currNode = currNode.children[1];
                    }
                }
                ans = Math.max(ans, xor);
            }
        }
        return ans;
    }

    class Node {
        Node[] children;

        Node() {
            children = new Node[2];
        }
    }
}
