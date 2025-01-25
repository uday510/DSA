/**
 * Problem Description
 *
 * Given two arrays of strings A of size N and B of size M.
 *
 * Return a binary string C where C[i] = '1' if B[i] can be found in dictionary A using exactly one modification in B[i], Else C[i] = '0'.
 *
 * NOTE: modification is defined as converting a character into another character.
 *
 *
 *
 * Problem Constraints
 *
 * 1 <= N <= 30000
 *
 * 1 <= M <= 2500
 *
 * 1 <= length of any string either in A or B <= 20
 *
 * strings contains only lowercase alphabets
 *
 *
 *
 * Input Format
 *
 * First argument is the string arrray A.
 *
 * Second argument is the string array B.
 *
 *
 *
 * Output Format
 *
 * Return a binary string C where C[i] = '1' if B[i] can be found in dictionary A using one modification in B[i], Else C[i] = '0'.
 *
 *
 *
 * Example Input
 *
 * Input 1:
 *
 *  A = [data, circle, cricket]
 *  B = [date, circel, crikket, data, circl]
 * Input 2:
 *
 *  A = [hello, world]
 *  B = [hella, pello, pella]
 *
 *
 * Example Output
 *
 * Output 1:
 *
 *  "10100"
 * Output 2:
 *
 *  "110"
 *
 *
 * Example Explanation
 *
 * Explanation 1:
 *
 *  1. date = dat*(can be found in A)
 *  2. circel =(cannot be found in A using exactly one modification)
 *  3. crikket = cri*ket(can be found in A)
 *  4. data = (cannot be found in A using exactly one modification)
 *  5. circl = (cannot be found in A using exactly one modification)
 * Explanation 2:
 *
 *  Only pella cannot be found in A using only one modification.
 */
package trie;

public class ModifiedSearch {
    public static void main(String[] args) {

    }
    public static String solve(String[] A, String[] B) {

        Node root = new Node();

        for (int i = 0; i < A.length; ++i) {
            insert(root, A[i]);
        }
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < B.length; ++i) {
            if (query(root, 0, B[i], false, false)) {
                res.append('1');
            } else {
                res.append('0');
            }
        }
        return res.toString();
    }
    public static boolean query(Node currNode, int index, String data, boolean modified, boolean eow) {
        boolean res = false;
        int n = data.length();
        if (index == n) {
            return modified && eow;
        }
        int c = data.charAt(index) - 97;
        if (!modified) {
            for (int i = 0; i < 26; ++i) {
                if (currNode.children[i] == null) {
                    continue;
                }
                if (i == c) {
                    res = res || query(currNode.children[i], index + 1, data, modified, currNode.children[i].eow);
                } else {
                    res = res || query(currNode.children[i], index + 1, data, !modified, currNode.children[i].eow);
                }
            }
        } else {
            if (currNode.children[c] != null) {
                res = query(currNode.children[c], index + 1, data, modified, currNode.children[c].eow);
            }
        }
        return res;
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
