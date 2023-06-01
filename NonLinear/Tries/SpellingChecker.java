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
package NonLinear.Tries;

import java.util.Arrays;

public class SpellingChecker {
    static TrieNode root; // create root for trie.
    static Trie trie;
    public static void main(String[] args) {
        String[] s1 = {"hat", "cat", "rat"};
        String[] s2 = {"cat", "ball"};

        int[] ans = solve(s1, s2);
        System.out.println(Arrays.toString(ans));
    }
    public static int[] solve(String[] s1, String[] s2) {
        root = new TrieNode('$');
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
}
