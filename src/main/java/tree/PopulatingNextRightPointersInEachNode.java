package tree;

import java.util.ArrayDeque;
import java.util.Queue;

public class PopulatingNextRightPointersInEachNode {
// Definition for a Node.
    static class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    };

    public static void main(String[] args) {
        Node root = new Node(0);

        solveUsingQueue(root);
    }
    public static Node solve(Node root) {
        // O(N) time | O(1) space
        Node dummyNode = new Node(0);
        Node tempNode = dummyNode;
        Node currNode = root;

        while (currNode != null) {
            if (currNode.left != null) {
                tempNode.next = currNode.left;
                tempNode = tempNode.next;
            }
            if (currNode.right != null) {
                tempNode.next = currNode.right;
                tempNode = tempNode.next;
            }
            currNode = currNode.next;
            if (currNode == null) {
                currNode = dummyNode.next; // first node in next level
                dummyNode.next = null;
                tempNode = dummyNode;
            }
        }
        return root;
    }
    public static Node solveUsingQueue(Node root) {
        // O(N) time | O(N) space
        Queue<Node> queue = new ArrayDeque<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Node currNode = queue.peek();
                queue.poll();

              if (i < size - 1) currNode.next = queue.poll();

              if (currNode.left != null) queue.add(currNode.left);
              if (currNode.right != null) queue.add(currNode.right);
            }
        }
        return root;
    }
}
