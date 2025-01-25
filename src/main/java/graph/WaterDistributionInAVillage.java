/**
 * There are n houses in a village. We want to supply water for all the houses by building wells and laying pipes.
 *
 * For each house i, we can either build a well inside it directly with cost wells[i - 1] (note the -1 due to 0-indexing), or pipe in water from another well to it. The costs to lay pipes between houses are given by the array pipes where each pipes[j] = [house1j, house2j, costj] represents the cost to connect house1j and house2j together using a pipe. Connections are bidirectional, and there could be multiple valid connections between the same two houses with different costs.
 *
 * Return the minimum total cost to supply water to all houses.
 *
 * Input: n = 3, wells = [1,2,2], pipes = [[1,2,1],[2,3,1]]
 * Output: 3
 * Explanation: The image shows the costs of connecting houses using pipes.
 * The best strategy is to build a well in the first house with cost 1 and
 * connect the other houses to it with cost 2 so the total cost is 3.
 *
 *
 * Example 2:
 *
 * Input: n = 2, wells = [1,1], pipes = [[1,2,1],[1,2,2]]
 * Output: 2
 * Explanation: We can supply water with cost two using one of the three options:
 * Option 1:
 *   - Build a well inside house 1 with cost 1.
 *   - Build a well inside house 2 with cost 1.
 * The total cost will be 2.
 * Option 2:
 *   - Build a well inside house 1 with cost 1.
 *   - Connect house 2 with house 1 with cost 1.
 * The total cost will be 2.
 * Option 3:
 *   - Build a well inside house 2 with cost 1.
 *   - Connect house 1 with house 2 with cost 1.
 * The total cost will be 2.
 * Note that we can connect houses 1 and 2 with cost 1 or with cost 2 but we will always
 * choose the cheapest option.
 *
 *
 * Constraints:
 *
 * 2 <= n <= 104
 * wells.length == n
 * 0 <= wells[i] <= 105
 * 1 <= pipes.length <= 104
 * pipes[j].length == 3
 * 1 <= house1j, house2j <= n
 * 0 <= costj <= 105
 * house1j != house2j
 *
 * https://leetcode.com/problems/optimize-water-distribution-in-a-village/description/
 */
package graph;

import java.util.ArrayList;
import java.util.List;

public class WaterDistributionInAVillage {
    public static void main(String[] args) {
        int n = 3;
        int[] wells = {1, 2, 2};
        int[][] pipes = {{1, 2, 1}, {2, 3, 1}};
        System.out.println(minCostToSupplyWater(n, wells, pipes));
    }
    public static int minCostToSupplyWater(int n, int[] wells, int[][] pipes) {
        // O((N+M)log(N+M)) time complexity where N is the number of houses and M is the number of pipes
        /**
         * First, we build a list of edges, which takes O(N+M) time.
         *
         * We then sort the list of edges, which takes O((N+M)log(N+M)) time.
         *
         * At the end, we iterate through the sorted edges. For each iteration,
         * we invoke a Union-Find operation. Hence, the time complexity for iteration is O((N+M)log(N))
         *
         * To sum up, the overall time complexity of the algorithm is O((N+M)log(N+M))
         * which is dominated by the sorting step.
         *
         * Space Complexity: O(N+M) for the list of edges.
         */
        List<int[]> orderedEdges = new ArrayList<>(n + 1 + pipes.length);

        // add the virtual vertex (index with 0) along with the new edges
        for (int i = 0; i < wells.length; ++i) {
            orderedEdges.add(new int[]{0, i + 1, wells[i]});
        }

        // add the existing edges
        for (int i = 0; i < pipes.length; ++i) {
            int[] edges = pipes[i];
            orderedEdges.add(edges);
        }

        // sort the edges based on their cost
        orderedEdges.sort((a, b) -> a[2] - b[2]);

        // iterate through the ordered edges
        UnionFind uf = new UnionFind(n);
        int totalCost = 0;
        for (int[] edge : orderedEdges) {
            int house1 = edge[0];
            int house2 = edge[1];
            int cost = edge[2];
            if (uf.union(house1, house2)) {
                totalCost += cost;
            }
        }
        return totalCost;
    }
    static class UnionFind {
        /**
         * Implementation of UnionFind without load balancing
         */
        private int[] group;
        private int[] rank;

        public UnionFind(int size) {
            // Container to hold group id for each member
            // Note: The index of member starts from 1,
            // thus we need to allocate size + 1 space
            group = new int[size + 1];
            rank = new int[size + 1];
            for (int i = 0; i < size + 1; ++i) {
                group[i] = i;
                rank[i] = 1;
            }
        }
        /**
         * return the group id that the person belongs to
         */
        public int find(int person) {
            if (person == group[person]) {
                return person;
            }
            return group[person] = find(group[person]);
        }

        /**
         * Join the groups together
         * return true if two groups are joined together
         * return false if two groups are already in the same group
         */
        public boolean union(int person1, int person2) {
            int group1 = find(person1);
            int group2 = find(person2);
            if (group1 == group2) {
                return false;
            }

            // attach the group with lower rank to the one with higher rank
            if (rank[group1] > rank[group1]) {
                group[group2] = group1;
            } else if (rank[group2] > rank[group2]) {
                group[group1] = group2;
            } else {
                group[group2] = group1;
                rank[group1] += 1;
            }
            return true;
        }
    }
}
