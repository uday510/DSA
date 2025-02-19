/**
 * There are n people in a social group labeled from 0 to n - 1. You are given an array logs where logs[i] = [timestampi, xi, yi] indicates that xi and yi will be friends at the time timestampi.
 *
 * Friendship is symmetric. That means if a is friends with b, then b is friends with a. Also, person a is acquainted with a person b if a is friends with b, or a is a friend of someone acquainted with b.
 *
 * Return the earliest time for which every person became acquainted with every other person. If there is no such earliest time, return -1.
 *
 *
 *
 * Example 1:
 *
 * Input: logs = [[20190101,0,1],[20190104,3,4],[20190107,2,3],[20190211,1,5],[20190224,2,4],[20190301,0,3],[20190312,1,2],[20190322,4,5]], n = 6
 * Output: 20190301
 * Explanation:
 * The first event occurs at timestamp = 20190101, and after 0 and 1 become friends, we have the following friendship groups [0,1], [2], [3], [4], [5].
 * The second event occurs at timestamp = 20190104, and after 3 and 4 become friends, we have the following friendship groups [0,1], [2], [3,4], [5].
 * The third event occurs at timestamp = 20190107, and after 2 and 3 become friends, we have the following friendship groups [0,1], [2,3,4], [5].
 * The fourth event occurs at timestamp = 20190211, and after 1 and 5 become friends, we have the following friendship groups [0,1,5], [2,3,4].
 * The fifth event occurs at timestamp = 20190224, and as 2 and 4 are already friends, nothing happens.
 * The sixth event occurs at timestamp = 20190301, and after 0 and 3 become friends, we all become friends.
 * Example 2:
 *
 * Input: logs = [[0,2,0],[1,0,1],[3,0,3],[4,1,2],[7,3,1]], n = 4
 * Output: 3
 * Explanation: At timestamp = 3, all the persons (i.e., 0, 1, 2, and 3) become friends.
 *
 *
 * Constraints:
 *
 * 2 <= n <= 100
 * 1 <= logs.length <= 104
 * logs[i].length == 3
 * 0 <= timestampi <= 109
 * 0 <= xi, yi <= n - 1
 * xi != yi
 * All the values timestampi are unique.
 * All the pairs (xi, yi) occur at most one time in the input.
 *
 * https://leetcode.com/problems/the-earliest-moment-when-everyone-become-friends/description/
 */
package graph;

import java.util.Arrays;
import java.util.Comparator;

public class EarliestMoment {

    public static void main(String[] args) {
        int[][] logs = {{20190101,0,1},{20190104,3,4},{20190107,2,3},{20190211,1,5},
                {20190224,2,4},{20190301,0,3},{20190312,1,2},{20190322,4,5}};
        int n = 6;
        System.out.println(earliest(logs, n));
    }
    public static int earliest(int[][] logs, int n) {
        // O(NlogN) time complexity | O(N) space complexity
        // In order to ensure that we find the earliest moment, we need to sort the logs
        // based on the timestamp in ascending order

        Arrays.sort(logs, Comparator.comparingInt(a -> a[0]));

        //Initially, we treat each person as a separate group
        int groupCount = n;
        UnionFind dsu = new UnionFind(n);

        for (int[] log : logs) {
            int timestamp = log[0];
            int friendX = log[1];
            int friendY = log[2];

            // We merge the groups along the way
            groupCount -= dsu.union(friendX, friendY);

            if (groupCount == 1) {
                return timestamp;
            }
        }

        // There are still more than one group left
        // i.e. there are still people who are not acquainted with each other
        return -1;
    }
    static class UnionFind {
        private int[] group;
        private int[] rank;

        public UnionFind(int size) {
            group = new int[size];
            rank = new int[size];
            for (int i = 0; i < size; ++i) {
                group[i] = i;
                rank[i] = 1;
            }
        }

        public int find(int x) {
            if (group[x] == x) {
                return x;
            }
            return group[x] = find(group[x]);
        }

        public int union(int x, int y) {
            int groupX = find(x);
            int groupY = find(y);
            boolean isMerge = false;

            // The two people share the same group
            if (groupX == groupY) {
                return 0;
            }
            // The two people are not in the same group
            // Merge the two groups
            if (rank[groupX] > rank[groupY]) {
                group[groupY] = groupX;
            } else if (rank[groupX] < rank[groupY]) {
                group[groupX] = groupY;
            } else {
                group[groupY] = groupX;
                rank[groupX]++;
            }
            return 1;
        }
    }
}
