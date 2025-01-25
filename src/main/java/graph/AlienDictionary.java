/**
 * There is a new alien language that uses the English alphabet. However, the order among the letters is unknown to you.
 *
 * You are given a list of strings words from the alien language's dictionary, where the strings in words are
 * sorted lexicographically
 *  by the rules of this new language.
 *
 * Return a string of the unique letters in the new alien language sorted in lexicographically increasing order by the new language's rules. If there is no solution, return "". If there are multiple solutions, return any of them.
 *
 *
 * Input: words = ["wrt","wrf","er","ett","rftt"]
 * Output: "wertf"
 *
 * Input: words = ["z","x"]
 * Output: "zx"
 *
 * Input: words = ["z","x","z"]
 * Output: ""
 * Explanation: The order is invalid, so return "".
 */
package graph;

import java.util.*;

public class AlienDictionary {
    public static void main(String[] args) {
        String[] words = {"wxqkj","whqg","cckgh","cdxg","cdxdt","cdht","ktgxt","ktgch","ktdw","ktdc","jqw","jmc","jmg"};
        System.out.println(alienOrder(words));
    }
    public static String alienOrder(String[] words) {
        // O(V+E) time and space complexity
        // Step 0: Create data structures and find all unique letters.

        // Step 0: Create data structures and find all unique letters.
        Map<Character, List<Character>> graph = new HashMap<>();
        Map<Character, Integer> indegree = new HashMap<>();

        for (String word : words) {
            for (Character c : word.toCharArray()) {
                indegree.put(c, 0);
                graph.put(c, new ArrayList<>());
            }
        }

        // Step 1: Find all edges.
        for (int i = 0; i < words.length - 1; ++i) {
            String word1 = words[i];
            String word2 = words[i+1];
            // Check that word2 is not a prefix of word1.
            if (word1.length() > word2.length() && word1.startsWith(word2)) {
                return "";
            }
            // Find the first non match and insert the corresponding relation.
            for (int j = 0; j < Math.min(word1.length(), word2.length()); ++j) {
                if (word1.charAt(j) != word2.charAt(j)) {
                    graph.get(word1.charAt(j)).add(word2.charAt(j));
                    indegree.put(word2.charAt(j), indegree.get(word2.charAt(j)) + 1);
                    break;
                }
            }
        }
        // Step 2: Breadth-first search.
        StringBuilder stringBuilder = new StringBuilder();
        Queue<Character> queue = new LinkedList<>();
        for (Character c : indegree.keySet()) {
            if (indegree.get(c).equals(0)) {
                queue.offer(c);
            }
        }

        while (!queue.isEmpty()) {
            Character c = queue.poll();
            stringBuilder.append(c);

            for (Character next : graph.get(c)) {
                indegree.put(next, indegree.get(next) - 1);
                if (indegree.get(next).equals(0)) {
                    queue.offer(next);
                }
            }
        }
        if (indegree.size() != stringBuilder.length()) {
            return "";
        }

        return stringBuilder.toString();

    }
}
