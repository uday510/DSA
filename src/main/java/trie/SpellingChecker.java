
/**
 * Problem Description
 * Given an array of words A (dictionary) and another array B (which contain some words).
 *
 * You have to return the binary array (of length |B|) as the answer where 1 denotes that the word is present in the dictionary and 0 denotes it is not present.
 *
 * Formally, for each word in B, you need to return 1 if it is present in Dictionary and 0 if not.
 *
 * Such problems can be seen in real life when we work on any online editor (like Google Documnet), if the word is not valid it is underlined by a red line.
 *
 * NOTE: Try to do this in O(n) time complexity.
 * Problem Constraints
 * 1 <= |A| <= 1000
 *
 * 1 <= sum of all strings in A <= 50000
 *
 * 1 <= |B| <= 1000
 *
 *
 *
 * Input Format
 * First argument is array of strings A.
 *
 * First argument is array of strings B.
 *
 *
 *
 * Output Format
 * Return the binary array of integers according to the given format.
 *
 *
 *
 * Example Input
 * Input 1:
 *
 * A = [ "hat", "cat", "rat" ]
 * B = [ "cat", "ball" ]
 * Input 2:
 *
 * A = [ "tape", "bcci" ]
 * B = [ "table", "cci" ]
 *
 *
 * Example Output
 * Output 1:
 *
 * [1, 0]
 * Output 2:
 *
 * [0, 0]
 *
 Example Explanation
 Explanation 1:

 Only "cat" is present in the dictionary.
 Explanation 2:

 None of the words are present in the dictionary.
 */
package trie;

import java.util.Arrays;

public class SpellingChecker {
    static Node root; // create root for trie.
    static Trie trie;
    public static void main(String[] args) {
        String[] s1 = {"hat", "cat", "rat"};
        String[] s2 = {"cat", "ball"};

        int[] ans = solve(s1, s2);
        System.out.println(Arrays.toString(ans));
    }
    public static int[] solve(String[] s1, String[] s2) {
        root = new Node('$');
        trie = new Trie();
        int[] ans = new int[s2.length];

        for (int i = 0; i < s1.length; i++) {
            String currStr = s1[i];
            trie.insert(root, currStr);
        }

        for (int i = 0; i < s2.length; i++) {
            if (trie.search(root, s2[i])) ans[i] = 1;
            else ans[i] = 0;
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
            return currNode.eow;
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
                if (count > 1 || currNode.eow) {
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
