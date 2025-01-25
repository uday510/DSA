
/**
 * Problem Description
 * Given a list of N words, find the shortest unique prefix to represent each word in the list.
 *
 * NOTE: Assume that no word is the prefix of another. In other words, the representation is always possible
 *
 *
 *
 * Problem Constraints
 * 1 <= Sum of length of all words <= 106
 *
 *
 *
 * Input Format
 * First and only argument is a string array of size N.
 *
 *
 *
 * Output Format
 * Return a string array B where B[i] denotes the shortest unique prefix to represent the ith word.
 *
 *
 *
 * Example Input
 * Input 1:
 *
 *  A = ["zebra", "dog", "duck", "dove"]
 * Input 2:
 *
 * A = ["apple", "ball", "cat"]
 *
 *
 * Example Output
 * Output 1:
 *
 *  ["z", "dog", "du", "dov"]
 * Output 2:
 *
 *  ["a", "b", "c"]
 *
 *
 * Example Explanation
 * Explanation 1:
 *
 *  Shortest unique prefix of each word is:
 *  For word "zebra", we can only use "z" as "z" is not any prefix of any other word given.
 *  For word "dog", we have to use "dog" as "d" and "do" are prefixes of "dov".
 *  For word "du", we have to use "du" as "d" is prefix of "dov" and "dog".
 *  For word "dov", we have to use "dov" as "d" and do" are prefixes of "dog".
 *
 * Explanation 2:
 *
 *  "a", "b" and c" are not prefixes of any other word. So, we can use of first letter of each to represent.
 */
package trie;

import java.util.Arrays;

public class ShortestUniquePrefix {
    static Node root; // create root for trie.
    static Trie trie;

    public static void main(String[] args) {
//        String[] strings = {"zebra", "dog", "duck", "dove"};
        String[] strings = {"apple", "ball", "cat"};

        String[] ans = solve(strings);
        System.out.printf(Arrays.toString(ans));
    }

    public static String[] solve(String[] strings) {

        /**
         * 1. create trie for given strings.
         *
         */
        root = new Node('$');
        trie = new Trie();
        String[] ans = new String[strings.length];

        for (int i = 0; i < strings.length; i++) {
            String currStr = strings[i];
            trie.insert(root, currStr);
        }

        for (int i = 0; i < strings.length; i++) {  // ["zebra", "dog", "duck", "dove"]
            Node currNode = root;
            String currString = strings[i];

            for (int j = 0; j < currString.length(); j++) { // z , e , b, r , a
                if (currNode.children[currString.charAt(j) - 'a'].freq == 1) { // zebra
                    ans[i] = currString.substring(0, j + 1);
                    break;
                } else {
                    currNode = currNode.children[currString.charAt(j) - 'a'];
                }
            }
            if (ans[i] == null) {
                ans[i] = currString;
            }
        }
        return ans;
    }
    static class Node {
        char data;
        Node[] children;
        boolean eow; // marker for end-of-word
        int freq;
        Node() {
            children = new Node[26];
            eow = false;
            freq = 0;
        }
        Node(char data) {
            this.data = data;
            children = new Node[26];
            eow = false;
            freq = 0;
        }
    }
    static class Trie {
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
            if (currNode.eow == true) return true;
            return false;
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
}
