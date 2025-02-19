/**
 * You are given a string s, and an array of pairs of indices in the string pairs where pairs[i] = [a, b] indicates 2 indices(0-indexed) of the string.
 * You can swap the characters at any pair of indices in the given pairs any number of times.
 * Return the lexicographically smallest string that s can be changed to after using the swaps.
 * Example 1:
 * Input: s = "dcab", pairs = [[0,3],[1,2]]
 * Output: "bacd"
 * Explaination:
 * Swap s[0] and s[3], s = "bcad"
 * Swap s[1] and s[2], s = "bacd"
 * Example 2:
 * Input: s = "dcab", pairs = [[0,3],[1,2],[0,2]]
 * Output: "abcd"
 * Explaination:
 * Swap s[0] and s[3], s = "bcad"
 * Swap s[0] and s[2], s = "acbd"
 * Swap s[1] and s[2], s = "abcd"
 * Example 3:
 * Input: s = "cba", pairs = [[0,1],[1,2]]
 * Output: "abc"
 * Explaination:
 * Swap s[0] and s[1], s = "bca"
 * Swap s[1] and s[2], s = "bac"
 * Swap s[0] and s[1], s = "abc"
 * Constraints:
 * 1 <= s.length <= 10^5
 * 0 <= pairs.length <= 10^5
 * 0 <= pairs[i][0], pairs[i][1] < s.length
 * s only contains lower case English letters.
 *
 */
package graph;
import java.util.*;
public class SmallestStringWithSwaps {
    public static void main(String[] args) {
        String s = "dcab";
        var pairs = List.of(List.of(0, 3), List.of(1, 2), List.of(0, 2));
        System.out.println(smallestStringWithSwaps(s, pairs));
    }
    public static String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
        int len = s.length();
        DSU dsu = new DSU(len);

        for (var pair : pairs) {
            dsu.union(pair.get(0), pair.get(1));
        }

        var components = new HashMap<Integer, List<Integer>>();
        for (int vertex = 0; vertex < len; ++vertex) {
            int root = dsu.find(vertex);
            components.computeIfAbsent(root, k -> new ArrayList<>()).add(vertex);
        }
        System.out.println(components);

        char[] result = new char[len];
        for (var component : components.values()) {
            var chars = new ArrayList<Character>();
            for (int idx : component) {
                chars.add(s.charAt(idx));
            }
            Collections.sort(chars);
            for (int idx = 0; idx < component.size(); ++idx) {
                result[component.get(idx)] = chars.get(idx);
            }
        }

        return new String(result);
    }
    static class DSU {
        int[] rank;
        int[] root;

        DSU(int n) {
            rank = new int[n];
            root = new int[n];

            for (int idx = 0; idx < n; ++idx) {
                rank[idx] = 1;
                root[idx] = idx;
            }
        }

        void union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);

            if (rootX == rootY) {
                return;
            }

            if (rank[rootX] > rank[rootY]) {
                root[rootY] = rootX;
            } else if (rank[rootY] > rank[rootY]) {
                rank[rootX] = rootY;
            } else {
                root[rootY] = rootX;
                rank[rootX]++;
            }
        }

        int find(int x) {
            if (x == root[x]) {
                return x;
            }
            return root[x] = find(root[x]);
        }
    }

}
