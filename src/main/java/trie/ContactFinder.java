/**
 * Problem Description
 *
 * We want to make a custom contacts finder applications as part of our college project. The application must perform two types of operations:
 *
 * Type 1: Add name B[i] ,denoted by 0 in vector A where B[i] is a string in vector B denoting a contact name. This must store B[i] as a new contact in the application.
 *
 * Type 2: Find partial for B[i] ,denoted by 1 in vector A where B[i] is a string in vector B denoting a partial name to search the application for. It must count the number of contacts starting with B[i].
 *
 * You have been given sequential add and find operations. You need to perform each operation in order.
 *
 * And return as an array of integers, answers for each query of type 2(denoted by 1 in A) .
 *
 *
 *
 * Problem Constraints
 *
 * 1 <= |A| <= 10000
 *
 * 1 <= |length of strings in B| <= 10
 *
 *
 *
 * Input Format
 *
 * First argument is the vector A, which denotes the type of query.
 *
 * Second argument is the vector B, which denotes the string for corresponding query.
 *
 *
 *
 * Output Format
 *
 * Return an array of integers, denoting answers for each query of type 1.
 *
 *
 *
 * Example Input
 *
 * Input 1:
 *
 * A = [0, 0, 1, 1]
 * B = ["hack", "hacker", "hac", "hak"]
 * Input 2:
 *
 * A = [0, 1]
 * B = ["abcde", "abc"]
 *
 *
 * Example Output
 *
 * Output 1:
 *
 *
 * [2, 0]
 * Output 2:
 *
 * [1]
 *
 *
 * Example Explanation
 *
 * Explanation 1:
 *
 *
 * We perform the following sequence of operations:
 * Add a contact named "hack".
 * Add a contact named "hacker".
 * Find the number of contact names beginning with "hac". There are currently two contact names in the application and both of them start with "hac", so we have 2.
 * Find the number of contact names beginning with "hak". There are currently two contact names in the application but neither of them start with "hak", so we get0.
 * Explanation 2:
 *
 *
 * Add "abcde"
 * Find words with prefix "abc". We have answer as 1.
 */
package trie;

import java.util.ArrayList;
import java.util.Arrays;

public class ContactFinder {
    static Node root;
    static Trie trie;
    public static void main(String[] args) {
        String[] str = {"hack", "hacker", "hac", "hak"};
        int[] a = {0, 0, 1, 1};

        int[] ans = solve(a, str);
        System.out.println(Arrays.toString(ans));
    }
    public static int[] solve(int[] A, String[] B) {
        root = new Node('$');
        trie = new Trie();
        ArrayList<Integer> ans = new ArrayList<>();

        for (int i = 0; i < B.length; i++) {
            String currStr = B[i];
            if (A[i] == 0) {
                trie.insert(root, currStr);
            } else {
                ans.add(trie.getFreq(root, currStr));
            }
        }
        return ans.stream().mapToInt(i -> i).toArray();

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
                // go to next char index and increase freq.
                currNode = currNode.children[idx];
                currNode.freq++;
            }
            // mark eow = true
            currNode.eow = true;
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
}
