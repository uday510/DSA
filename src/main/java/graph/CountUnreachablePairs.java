/*
You are given an integer n. There is an undirected graph with n nodes, numbered from 0 to n - 1. You are given a 2D integer array edges where edges[i] = [ai, bi] denotes that there exists an undirected edge connecting nodes ai and bi.

Return the number of pairs of different nodes that are unreachable from each other.



Example 1:


Input: n = 3, edges = [[0,1],[0,2],[1,2]]
Output: 0
Explanation: There are no pairs of nodes that are unreachable from each other. Therefore, we return 0.
Example 2:


Input: n = 7, edges = [[0,2],[0,5],[2,4],[1,6],[5,4]]
Output: 14
Explanation: There are 14 pairs of nodes that are unreachable from each other:
[[0,1],[0,3],[0,6],[1,2],[1,3],[1,4],[1,5],[2,3],[2,6],[3,4],[3,5],[3,6],[4,6],[5,6]].
Therefore, we return 14.


Constraints:

1 <= n <= 105
0 <= edges.length <= 2 * 105
edges[i].length == 2
0 <= ai, bi < n
ai != bi
There are no repeated edges.

Input: n = 7, edges = [[0,2],[0,5],[2,4],[1,6],[5,4]]
Output: 14
Explanation: There are 14 pairs of nodes that are unreachable from each other:
[[0,1],[0,3],[0,6],[1,2],[1,3],[1,4],[1,5],[2,3],[2,6],[3,4],[3,5],[3,6],[4,6],[5,6]].
Therefore, we return 14.
 */
package graph;

import java.util.HashMap;
import java.util.Map;

public class CountUnreachablePairs {
    public static void main(String[] args) {
        int n = 7;
        int[][] edges = {{0,2},{0,5},{2,4},{1,6},{5,4}};

        System.out.println(countUnreachablePairs(n, edges));
    }
    public static long countUnreachablePairs(int n, int[][] edges) {
        long count = 0;

        UnionFind dsu = new UnionFind(n);

        for(int[] edge : edges){
            dsu.union(edge[0], edge[1]);
        }

        // TIME LIMIT EXCEEDED
//        for(int i = 0; i < n; i++){
//            for(int j = i+1; j < n; j++){
//                if(!dsu.isConnected(i, j)){
//                    count++;
//                }
//            }
//        }

        Map<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i < n; i++){
            int root = dsu.find(i);
            map.put(root, map.getOrDefault(root, 0) + 1); // root, count of nodes
        }

        long remainingNodes = n;

        for (int countOfNodes : map.values()) {
            remainingNodes -= countOfNodes; // remaining nodes
            count += countOfNodes * remainingNodes;
        }

        return count;
    }
   static class UnionFind {
        int[] parent;
        int[] rank;

        public UnionFind(int n) {
            parent = new int[n];
            rank = new int[n];

            for (int i = 0; i < n; i++) {
                parent[i] = i;
                rank[i] = 1;
            }
        }

        public int find(int x) {
            if (parent[x] == x) {
                return x;
            }

            return parent[x] = find(parent[x]);
        }

        public void union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);

            if (rootX == rootY) {
                return;
            }

            if (rank[rootX] > rank[rootY]) {
                parent[rootY] = rootX;
            } else if (rank[rootY] > rank[rootX]) {
                parent[rootX] = rootY;
            } else {
                parent[rootY] = rootX;
                rank[rootX]++;
            }
        }

    }
}
