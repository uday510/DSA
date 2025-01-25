package trie;

public class TrieConstruction {
    class Node {
        char data;
        Node[] children;
        boolean eow; // marker for end-of-word
        int freq;

        Node (char data) {
            this.data = data;
            children = new Node[26];
            eow = false;
            freq = 0;
        }
    }
    public void insert(Node root, String data) {
        // O(L) time | O(L) space where L is length of data.
        Node currNode = root;
        for (int i = 0; i < data.length(); i++) {
            char c = data.charAt(i);
            int idx = c - 'a'; // gives index
            if (currNode.children[idx] == null) {
                // insert current char
                currNode.children[idx] = new Node(c);
            }
            // go to next char index.
            currNode = currNode.children[idx];
            currNode.freq++;
        }
        // mark eow = true
        currNode.eow = true;
    }
    public boolean search(Node root, String data) {
        // O(L) time | O(1) space where L is length of data.
        Node currNode = root;
        for (int i = 0; i < data.length(); i++) {
            char c = data.charAt(i);
            int idx = c - 'a'; // gives index
            if (currNode.children[idx] == null) {
                // insert current char
                return false;
            }
            // go to next char index.
            currNode = currNode.children[idx];
        }
        // mark eow = true
        return currNode.eow;
    }
    public int getFreq(Node root, String data) {
        // O(L) time | O(1) space where L is length of data.
        Node currNode = root;
        for (int i = 0; i < data.length(); i++) {
            char c = data.charAt(i);
            int idx = c - 'a'; // gives index
            if (currNode.children[idx] == null) {
                // insert current char
                return 0;
            }
            System.out.print(currNode.freq + " ");
            // go to next char index.
            currNode = currNode.children[idx];
        }
        // mark eow = true
        return currNode.freq;
    }
    public void delete(Node root, String word) {
        /**
         * Nodes that cannot be deleted
         *  1. Nodes which has eow is true.
         *  2. Nodes which has two children.
         *
         *  keep track of last node which cannot be deleted,
         *  and it's next children.
         */
        Node currNode = root;
        Node tempNode = null; // to keep track of last node which cannot be deleted.
        char nextCharNode = '#';
        int count = 0;

        for (int i = 0; i < word.length(); i++) {
            // O(L) time | O(1) space, where L is length of word.
            char c = word.charAt(i);
            int idx = c - 'a';

            // find no.of.nodes not null
            for (int j = 0; j < 26; j++) {
                if (currNode.children[j] != null) {
                    count += 1;
                }
            }
            if (count > 1 || currNode.eow == true) {
                tempNode = currNode;
                nextCharNode = c;
            }
            currNode = currNode.children[idx];
        }
        // mark eow false for last char of word
        currNode.eow = false;
        // check for no.of.nodes not null of last char
        if (count > 0) return;
        else tempNode.children[nextCharNode - 'a'] = null;
    }
}
