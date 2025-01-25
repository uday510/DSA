/**
 * You are given a string s, and an array of pairs of indices in the string pairs where pairs[i] = [a, b] indicates 2 indices(0-indexed) of the string.
 *
 * You can swap the characters at any pair of indices in the given pairs any number of times.
 *
 * Return the lexicographically smallest string that s can be changed to after using the swaps.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "dcab", pairs = [[0,3],[1,2]]
 * Output: "bacd"
 * Explaination:
 * Swap s[0] and s[3], s = "bcad"
 * Swap s[1] and s[2], s = "bacd"
 * Example 2:
 *
 * Input: s = "dcab", pairs = [[0,3],[1,2],[0,2]]
 * Output: "abcd"
 * Explaination:
 * Swap s[0] and s[3], s = "bcad"
 * Swap s[0] and s[2], s = "acbd"
 * Swap s[1] and s[2], s = "abcd"
 * Example 3:
 *
 * Input: s = "cba", pairs = [[0,1],[1,2]]
 * Output: "abc"
 * Explaination:
 * Swap s[0] and s[1], s = "bca"
 * Swap s[1] and s[2], s = "bac"
 * Swap s[0] and s[1], s = "abc"
 *
 *
 * Constraints:
 *
 * 1 <= s.length <= 10^5
 * 0 <= pairs.length <= 10^5
 * 0 <= pairs[i][0], pairs[i][1] < s.length
 * s only contains lower case English letters.
 */
package graph;

import java.util.*;

public class SmallestStringWithSwaps {
    public static void main(String[] args) {
        String s = "dcab";
        List<List<Integer>> pairs = List.of(List.of(0, 3), List.of(1, 2), List.of(0, 2));
        System.out.println(smallestStringWithSwaps(s, pairs));
    }
    public static String smallestStringWithSwaps(String s, List<List<Integer>> edges) {
        // (O((E+V)⋅α(V)+VlogV) time and O(V) space)
        UnionFind uf = new UnionFind(s.length());

        // iterate over the edges
        for (List<Integer> edge : edges) {
            int source = edge.get(0);
            int destination = edge.get(1);

            //Perform the union of end points
            uf.union(source, destination);
        }
        Map<Integer, List<Integer>> rootToComponent = new HashMap<>();
        // Group the vertices that are in the same component
        for (int vertex = 0; vertex < s.length(); ++vertex) {
            int root = uf.find(vertex);
            //Add the vertices corresponding to the component root
            rootToComponent.putIfAbsent(root, new ArrayList<>());
            rootToComponent.get(root).add(vertex);
        }
        // String to store the answer
        char[] smallestString = new char[s.length()];
        // Iterate over each component
        for (List<Integer> indices : rootToComponent.values()) {
            //Sort the characters in the component
            List<Character> sortedCharacters = new ArrayList<>();
            for (int index : indices) {
                sortedCharacters.add(s.charAt(index));
            }
            Collections.sort(sortedCharacters);

            // Store the sorted characters in the smallestString
            for (int index = 0; index < indices.size(); ++index) {
                smallestString[indices.get(index)] = sortedCharacters.get(index);
                System.out.println(smallestString[indices.get(index)]);
            }
        }
        return new String(smallestString);

    }
    static class UnionFind {
        private int[] root;
        private int[] rank;

        public UnionFind(int size) {
            root = new int[size];
            rank = new int[size];
            for (int i = 0; i < size; ++i) {
                root[i] = i;
                rank[i] = 1;
            }
        }
        public int find(int x) {
            if (root[x] == x) return x;
            return root[x] = find(root[x]);
        }
        public void union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);
            if (rootX != rootY) {
                if (rank[rootX] > rank[rootY]) {
                    root[rootY] = rootX;
                } else if (rank[rootX] < rank[rootY]) {
                    root[rootX] = rootY;
                } else {
                    root[rootY] = rootX;
                    rank[rootX] += rank[rootY];
                }
            }
        }
    }
}
