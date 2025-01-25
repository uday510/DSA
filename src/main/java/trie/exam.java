package trie;

public class exam {
    public static void main(String[] args) {
        String[] str = {"acd", "bcn", "dkp"};
        String B = "cwp";
    }
    public static int solve(String[] str) {
        Node root = new Node();
        for (String s : str) {
            insert(root, s);
        }
        return 0;
    }
    public static boolean search(Node root, String data, int index) {
        Node currNode = root;

        if (index == data.length()) return true;

        char c = data.charAt(index);

        return false;
    }
    public static void insert(Node root, String data) {
        // O(L) time | O(L) space where L is length of data.
        Node currNode = root;
        for (int i = 0; i < data.length(); i++) {
            char c = data.charAt(i);
            int idx = c - 'a'; // gives index
            if (currNode.children[idx] == null) {
                // insert current char
                currNode.children[idx] = new Node();
            }
            // go to next char index and increase freq.
            currNode = currNode.children[idx];
        }
        // mark eow = true
        currNode.eow = true;
    }

    static class Node {
        Node[] children;
        boolean eow;
        Node() {
            children = new Node[26];
            eow = false;
        }
    }
}
