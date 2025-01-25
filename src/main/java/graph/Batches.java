/**
 * Problem Description
 *
 * A students applied for admission in IB Academy. An array of integers B is given representing the strengths of A people i.e. B[i] represents the strength of ith student.
 *
 * Among the A students some of them knew each other. A matrix C of size M x 2 is given which represents relations where ith relations depicts that C[i][0] and C[i][1] knew each other.
 *
 * All students who know each other are placed in one batch.
 *
 * Strength of a batch is equal to sum of the strength of all the students in it.
 *
 * Now the number of batches are formed are very much, it is impossible for IB to handle them. So IB set criteria for selection: All those batches having strength at least D are selected.
 *
 * Find the number of batches selected.
 *
 * NOTE: If student x and student y know each other, student y and z know each other then student x and student z will also know each other.
 *
 *
 *
 * Problem Constraints
 *
 * 1 <= A <= 105
 *
 * 1 <= M <= 2*105
 *
 * 1 <= B[i] <= 104
 *
 * 1 <= C[i][0], C[i][1] <= A
 *
 * 1 <= D <= 109
 *
 *
 *
 * Input Format
 *
 * The first argument given is an integer A.
 * The second argument given is an integer array B.
 * The third argument given is a matrix C.
 * The fourth argument given is an integer D.
 *
 *
 *
 * Output Format
 *
 * Return the number of batches selected in IB.
 *
 *
 *
 * Example Input
 *
 * Input 1:
 *
 *  A = 7
 *  B = [1, 6, 7, 2, 9, 4, 5]
 *  C = [  [1, 2]
 *         [2, 3]
 *        `[5, 6]
 *         [5, 7]  ]
 *  D = 12
 * Input 2:
 *
 *  A = 5
 *  B = [1, 2, 3, 4, 5]
 *  C = [  [1, 5]
 *         [2, 3]  ]
 *  D = 6
 *
 *
 * Example Output
 *
 * Output 1:
 *
 *  2
 * Output 2:
 *
 *  1
 *
 *
 * Example Explanation
 *
 * Explanation 1:
 *
 *  Initial Batches :
 *     Batch 1 = {1, 2, 3} Batch Strength = 1 + 6 + 7 = 14
 *     Batch 2 = {4} Batch Strength = 2
 *     Batch 3 = {5, 6, 7} Batch Strength = 9 + 4 + 5 = 18
 *     Selected Batches are Batch 1 and Batch 2.
 * Explanation 2:
 *
 *  Initial Batches :
 *     Batch 1 = {1, 5} Batch Strength = 1 + 5  = 6
 *     Batch 2 = {2, 3} Batch Strength = 5
 *     Batch 3 = {4} Batch Strength = 4
 *     Selected Batch is only Batch 1.
 */
package graph;

import java.util.HashSet;
import java.util.Set;

public class Batches {
    public static void main(String[] args) {
        int A = 7;
        int[] B = {1, 6, 7, 2, 9, 4, 5};
        int[][] C = {{1, 2}, {2, 3}, {5, 6}, {5, 7}};
        int D = 12;
        System.out.println(solve(A, B, C, D));
    }

    /**

     A = 7
     B = [1, 6, 7, 2, 9, 4, 5]
     C = [  [1, 6]
     [6, 7]
     `[9, 4]
     [9, 5]  ]
     D = 12

     Initial Batches :
     Batch 1 = {1, 2, 3} Batch Strength = 1 + 6 + 7 = 14
     Batch 2 = {4} Batch Strength = 2
     Batch 3 = {5, 6, 7} Batch Strength = 9 + 4 + 5 = 18
     Selected Batches are Batch 1 and Batch 2.


     **/
    public static int solve(int A, int[] B, int[][] C, int D) {
       UnionFind dsu = new UnionFind(A, B); // create a union find object

         for (int[] edge : C) { // union all the edges
              dsu.union(edge[0] - 1, edge[1] - 1);
         }
        Set<Integer> set = new HashSet<>(); // create a set to store the unique parents

        for (int i = 0; i < A; ++i) { // add all the parents to the set
            set.add(dsu.find(i));
        }
        int ans = 0;
        for (int i : set) { // count the number of parents with strength >= D
            if (dsu.getStrength(i) >= D) { // if strength of parent is >= D then increment the ans
                ans++;
            }
        }
        return ans; // return the ans
    }
    static class UnionFind { // union find class
        int[] parent;
        int[] rank;
        int[] strength;
        public UnionFind(int x, int[] B) {
            parent = new int[x];
            rank = new int[x];
            strength = new int[x];
            for (int i = 0; i < x; i++) {
                parent[i] = i;
                strength[i] = B[i];
                rank[i] = 1;
            }
        }
        public int find(int x) {
            if (parent[x] == x) {
                return x;
            }
            return parent[x] = find(parent[x]);
        }
        public int getStrength(int x) {
            return strength[find(x)];
        }
        public void union(int x, int y) {
            int xParent = find(x);
            int yParent = find(y);
            if (xParent == yParent) {  // if both the parents are same then return
                return; // no need to union
            }
            if (rank[xParent] < rank[yParent]) {
                parent[xParent] = yParent; // make the parent of xParent as yParent
                strength[yParent] += strength[xParent];
            } else if (rank[xParent] > rank[yParent]) {
                parent[yParent] = xParent; // make the parent of yParent as xParent
                strength[xParent] += strength[yParent]; // add the strength of the parent
            } else {
                parent[yParent] = xParent;
                strength[xParent] += strength[yParent]; // add the strength of the parent
                rank[xParent]++; // increment the rank of the parent
            }
        }
    }
}
