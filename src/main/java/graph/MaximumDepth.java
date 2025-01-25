/**
 * Problem Description
 *
 * Given a Tree of A nodes having A-1 edges. Each node is numbered from 1 to A where 1 is the root of the tree.
 *
 * You are given Q queries. In each query, you will be given two integers L and X. Find the value of such node which lies at level L mod (MaxDepth + 1) and has value greater than or equal to X.
 *
 * Answer to the query is the smallest possible value or -1, if all the values at the required level are smaller than X.
 *
 * NOTE:
 *
 * Level and Depth of the root is considered as 0.
 * It is guaranteed that each edge will be connecting exactly two different nodes of the tree.
 * Please read the input format for more clarification.
 *
 *
 * Problem Constraints
 *
 * 2 <= A, Q(size of array E and F) <= 105
 *
 * 1 <= B[i], C[i] <= A
 *
 * 1 <= D[i], E[i], F[i] <= 106
 *
 *
 *
 * Input Format
 *
 * The first argument is an integer A denoting the number of nodes.
 *
 * The second and third arguments are the integer arrays B and C where for each i (0 <= i < A-1), B[i] and C[i] are the nodes connected by an edge.
 *
 * The fourth argument is an integer array D, where D[i] denotes the value of the (i+1)th node
 *
 * The fifth and sixth arguments are the integer arrays E and F where for each i (0 <= i < Q), E[i] denotes L and F[i] denotes X for ith query.
 *
 *
 *
 * Output Format
 *
 * Return an array of integers where the ith element denotes the answer to ith query.
 *
 *
 *
 * Example Input
 *
 * Input 1:
 *
 *  A = 5
 *  B = [1, 4, 3, 1]
 *  C = [5, 2, 4, 4]
 *  D = [7, 38, 27, 37, 1]
 *  E = [1, 1, 2]
 *  F = [32, 18, 26]
 * Input 2:
 *
 *  A = 3
 *  B = [1, 2]
 *  C = [3, 1]
 *  D = [7, 15, 27]
 *  E = [1, 10, 1]
 *  F = [29, 6, 26]
 *
 *
 * Example Output
 *
 * Output 1:
 *
 *  [37, 37, 27]
 * Output 2:
 *
 *  [-1, 7, 27]
 *
 *
 * Example Explanation
 *
 * Explanation 1:
 *
 *       1[7]
 *      /    \
 *    5[1]  4[37]
 *         /    \
 *        2[38]  3[27]
 *
 *  Query 1:
 *     L = 1, X = 32
 *     Nodes for level 1 are 5, 4
 *     Value of Node 5 = 1 < 32
 *     Value of Node 4 = 37 >= 32
 *     Ans = 37
 * Explanation 2:
 *
 *       1[7]
 *      /    \
 *    2[15]  3[27]
 *
 *  Query 1:
 *     L = 1, X = 6
 *     Nodes for level 1 are 2, 3 having value 15 and 27 respectively.
 *     Answer = -1 (Since no node is greater or equal to 29).
 *  Query 1:
 *     L = 10 % 2 = 0, X = 6
 *     Nodes for level 0 is 1 having value 7.
 *     Answer = 7.
 */
package graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class MaximumDepth {
    static int maxN = 100009; // max number of nodes
    static int n; // number of nodes
    static int maxDepth; // max depth of tree
    static int[] val = new int[maxN]; // value of nodes in tree
    static ArrayList<ArrayList<Integer>> adjList;
    static ArrayList<ArrayList<Integer>> levelList;
    public static void graph() { // initialize graph
        adjList = new ArrayList<>(); // adjacency list
        levelList = new ArrayList<>(); // level list of nodes
        for(int i = 0; i < maxN; i++) {
            adjList.add(new ArrayList<>());
            levelList.add(new ArrayList<>());
        }
    }
    public static void main(String[] args) {
        int A = 5;
        int[] B = {1, 4, 3, 1};
        int[] C = {5, 2, 4, 4};
        int[] D = {7, 38, 27, 37, 1};
        int[] E = {1, 1, 2};
        int[] F = {32, 18, 26};
        int[] res = solve(A, B, C, D, E, F);
        System.out.println(Arrays.toString(res));
    }
    public static int[] solve(int A, int[] B, int[] C, int[] D, int[] E, int[] F) {
        //TODO: pretty hard problem
        graph(); // create graph
        n = A;
        for (int i = 0; i < n; ++i) { // store values of nodes
            val[i+1] = D[i];
        }
        for(int i = 0; i < A - 1; i++) { // create adjacency list
            adjList.get(B[i]).add(C[i]);
            adjList.get(C[i]).add(B[i]);
        }
        maxDepth = 0;
        dfs(1, 1, 0); // dfs to find max depth of tree and level of each node

        for (int i = 0; i < maxN; ++i) { // sort nodes at each level
            Collections.sort(levelList.get(i));
        }
        int[] res = new int[E.length]; // answer queries
        for (int i = 0; i < E.length; ++i) { // binary search to find answer
            int level = E[i] % (maxDepth + 1); // level of node
            int idx = Collections.binarySearch(levelList.get(level), F[i]);
            if (idx < 0) { // if not found
                idx = -idx - 1; // find index of next greater element
            }
            if (idx == levelList.get(level).size()) { // if no greater element
                res[i] = -1; // answer is -1
            } else {
                res[i] = levelList.get(level).get(idx); // else answer is next greater element
            }
        }
        return res; // return answer
    }
    public static void dfs(int node, int parent, int depth) {
        maxDepth = Math.max(maxDepth, depth); // find max depth
        levelList.get(depth).add(val[node]); // store value of node at its level
        for(int child : adjList.get(node)) { // dfs on children
            if(child != parent) { // if not parent
                dfs(child, node, depth + 1); // dfs on child
            }
        }
    }
}
