package dynamicprogramming;

public class UniqueBinarySearchTrees {
    public static void main(String[] args) {
        int n = 3;
        System.out.println(numTrees(n));
    }
    public static int numTrees(int n) {
        // O(n^2) time and O(n) space
        /*
        numTree[4] = numTree[0] * numTree[3] +
                     numTree[1] * numTree[2] +
                     numTree[2] * numTree[1] +
                     numTree[3] * numTree[0]
         */

        int[] numTree = new int[n + 1];
        numTree[0] = 1; // 0 node
        numTree[1] = 1; // 1 node

        for (int nodes = 2; nodes <= n; ++nodes) {
            int curr = 0;
            for (int root = 1; root <= nodes; ++root) {
                int leftNodes = root - 1;
                int rightNodes = nodes - root;
                curr += numTree[leftNodes] * numTree[rightNodes];
            }
            numTree[nodes] = curr;
        }
        return numTree[n];
    }
}
