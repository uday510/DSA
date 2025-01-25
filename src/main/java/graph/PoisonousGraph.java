/**
 * Problem Description
 * You are given an undirected unweighted graph consisting of A vertices and M edges given in a form of 2D Matrix B of size M x 2 where (B[i][0], B][i][1]) denotes two nodes connected by an edge.
 *
 * You have to write a number on each vertex of the graph. Each number should be 1, 2 or 3. The graph becomes Poisonous if for each edge the sum of numbers on vertices connected by this edge is odd.
 *
 * Calculate the number of possible ways to write numbers 1, 2 or 3 on vertices so the graph becomes poisonous.
 * Since this number may be large, return it modulo 998244353.
 *
 * NOTE:
 *
 * Note that you have to write exactly one number on each vertex.
 * The graph does not have any self-loops or multiple edges.
 * Nodes are labelled from 1 to A.
 *
 *
 * Problem Constraints
 * 1 <= A <= 3*105
 *
 * 0 <= M <= 3*105
 *
 * 1 <= B[i][0], B[i][1] <= A
 *
 * B[i][0] != B[i][1]
 *
 *
 *
 * Input Format
 * First argument is an integer A denoting the number of nodes.
 *
 * Second argument is an 2D Matrix B of size M x 2 denoting the M edges.
 *
 *
 *
 * Output Format
 * Return one integer denoting the number of possible ways to write numbers 1, 2 or 3 on the vertices of given graph so it becomes Poisonous .
 * Since answer may be large, print it modulo 998244353.
 *
 *
 *
 * Example Input
 * Input 1:
 *
 *  A = 2
 *  B = [  [1, 2]
 *      ]
 * Input 2:
 *
 *  A = 4
 *  B = [  [1, 2]
 *         [1, 3]
 *         [1, 4]
 *         [2, 3]
 *         [2, 4]
 *         [3, 4]
 *     ]
 *
 *
 * Example Output
 * Output 1:
 *
 *  4
 * Output 2:
 *
 *  0
 *
 *
 * Example Explanation
 * Explanation 1:
 *
 *  There are 4 ways to make the graph poisonous. i.e, writing number on node 1 and 2 as,
 *     [1, 2] , [3, 2], [2, 1] or [2, 3] repsectively.
 * Explanation 2:
 *
 *  There is no way to make the graph poisonous.
 */
package graph;


import java.util.ArrayList;

public class PoisonousGraph {

    public static void main(String[] args) {
       int A = 2;
         int[][] B = {{1, 2}};

        System.out.println(solve(A, B));
    }
    public static int solve(int A, int[][] B) {

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for(int i = 0; i <= A; i++){
            adj.add(new ArrayList<>());
        }

        for (int[] ints : B) {
            adj.get(ints[0]).add(ints[1]);
            adj.get(ints[1]).add(ints[0]);
        }

        int[] color = new int[A + 1]; // color of each node
        int[] visited = new int[A + 1]; // visited array

        // 0 -> not visited, 1 -> visited

        // check for all connected components

        long ans = 1;

        for(int i = 1; i <= A; i++) {
            if(visited[i] == 0){ // if node is not visited
                int[] count = new int[2]; // count of 0 and 1
                if(!dfs(i, adj, color, visited, count)){
                    return 0;
                }
                ans = (ans * (pow(2, count[0]) + pow(2, count[1]))) % 998244353;
            }
        }
        return (int) ans;
    }
    public static boolean dfs(int node, ArrayList<ArrayList<Integer>> adj, int[] color, int[] visited, int[] count){
        visited[node] = 1;

        count[color[node]]++;

        for(int it : adj.get(node)){
            if(visited[it] == 0){ // if adjacent node is not visited
                color[it] = 1 - color[node]; // color of adjacent node will be opposite to current node
                if(!dfs(it, adj, color, visited, count)){ // if any of the adjacent node returns false, return false
                    return false;
                }
            }
            else if(color[it] == color[node]){ // if adjacent node is already visited and has same color as current node, return false
                return false;
            }
        }
        return true;
    }

    public static long pow(long a, long b){
        long res = 1;
        while(b > 0){ // binary exponentiation
            if((b & 1) != 0){ // if b is odd
                res = (res * a) % 998244353; // multiply res with a
            }
            a = (a * a) % 998244353; // square a
            b = b >> 1; // divide b by 2
        }
        return res;
    }
}
