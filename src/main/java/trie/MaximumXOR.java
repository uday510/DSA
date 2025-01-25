package trie;

/**
 * Problem Description
 * Given an array of integers A, find and return the maximum result of A[i] XOR A[j], where i, j are the indexes of the array.
 *
 *
 *
 * Problem Constraints
 * 1 <= length of the array <= 100000
 * 0 <= A[i] <= 109
 *
 *
 *
 * Input Format
 * The only argument given is the integer array A.
 *
 *
 *
 * Output Format
 * Return an integer denoting the maximum result of A[i] XOR A[j].
 *
 *
 *
 * Example Input
 * Input 1:
 *
 *  A = [1, 2, 3, 4, 5]
 * Input 2:
 *
 *  A = [5, 17, 100, 11]
 *
 *
 * Example Output
 * Output 1:
 *
 *  7
 * Output 2:
 *
 *  117
 */

public class MaximumXOR {
    public static void main(String[] args) {
        int[]  array = {1, 2, 3, 4, 5};

        int ans = solve(array);
        System.out.println(ans);
    }
    public static int solve(int[] array) {
        Node root = new Node();

        Node currNode = root;
        for (int num : array) {
            currNode = root;
            for (int i = 31; i > -1; i--) {
                if ((num & 1 << i) == 0) {
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
        for (int num : array) {
            int xor = 0;
            currNode = root;

            for (int j = 31; j > -1; j--) {
                if ((num & (1 << j)) == 0) {
                    if (currNode.children[1] != null) {
                        // set jth bit in xor value
                        xor = (xor | (1 << j));
                        currNode = currNode.children[1];
                    } else {
                        currNode = currNode.children[0];
                    }
                } else {
                    if (currNode.children[0] != null) {
                        // set jth bit in xor value
                        xor = (xor | (1 << j));
                        currNode = currNode.children[0];
                    } else {
                        currNode = currNode.children[1];
                    }
                }
            }
            ans = Math.max(ans, xor);
        }
        return ans;
    }
    static class Node {
        Node[] children;
        Node() { this.children = new Node[2]; }
    }
}
