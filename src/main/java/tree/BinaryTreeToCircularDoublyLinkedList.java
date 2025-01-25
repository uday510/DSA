package tree;

public class BinaryTreeToCircularDoublyLinkedList {
    static Node head;
    static Node tail = null;
    public static void main(String[] args) {

        Node root = new Node(20);
        root.left = new Node(8);
        root.right = new Node(22);

        Node ans = solve(root);
        System.out.println(ans.left);
    }
    public static Node solve(Node root) {

        head = new Node();

        helper(root);

        return head;
    }
    public static Node helper(Node root) {
        if (root == null) return null;

        helper(root.left);
        if (tail == null) {
            head = root;
            head.left = null;
            tail = head;
        } else {
            tail.right = root;
            tail = tail.right;
        }
        tail.val = root.val;
        helper(root.right);
        return head;
    }
}

class Node {
    int val;
    Node left;
    Node right;
    Node (int val) {
        this.val = val;
        left = right = null;
    }
    Node () {
        left = right = null;
    }
}
