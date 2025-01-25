/*
You are given a connected tree of N nodes numbered from 0 to N-1 rooted at the 0th node, where p[i] is the parent of the ith node and p[0] = -1 as the 0th node is the root.

Calculate the numbers of pairs of nodes (a,b) 0 < a < N, a < b < N such that LCA(a,b) = x , for each x where 0 < x < N.

The LCA or lowest common ancestor between two nodes a and b is defined as the lowest node in tree that has both a and b as descendants (where we allow a node to be a descendant of itself).

Example 1:

Input:
N = 3
p[] = [-1, 0, 0]
Output: [4, 1 , 1]
Explanation: The structure of tree is :
   0
  / \
 1   2
For LCA = 0, we have 4 pairs (0,0), (0,1),
(0,2), (1,2)
For LCA = 1, we have only 1 pair (1,1)
For LCA = 2, we have only 1 pair (2,2)
Example 2:

Input:
N = 5
p[] = [-1, 0, 0, 1, 1]
Output: [8, 4, 1, 1, 1]
Explanation: The structure of tree is :
      0
     / \
    1   2
   / \
  3   4
For LCA = 0, we have 8 pairs (0,0), (0,1),
(0,2),(0,3),(0,4),(1,2),(2,3),(2,4)
For LCA = 1 , we have 4 pairs (1,1), (1,3),
(1,4),(3,4)
FOR LCA = 2, we have only 1 pair (2,2),
FOR LCA = 3, we have only 1 pair (3,3)
For LCA = 4, we have only 1 pair (4,4)

Your Task:
Your task is to complete the function calcPairs() which takes the integer N  and a list p[ ] of size N as input parameters and returns  a list of N elements a0, a1, .. aN-1 where ai is the the number of unordered pairs for which lca(a,b) = i , where 0 < a < N , a < b < N



Constraints:
1 ≤ N ≤ 105
0 < p[i] < N where 0< i < N
p[0]=-1


 */
package greedy;

import java.util.ArrayList;

public class Exam {
    public static void main(String[] args) {
        int N = 5;
        ArrayList<Integer> p = new ArrayList<>();



    }

    public static ArrayList<Long> calcPairs(int N, ArrayList<Integer> p) {
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 1; i < N; i++) {
            graph.get(p.get(i)).add(i);
        }

        ArrayList<Long> freq = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            freq.add(0L);
        }

        dfs(0, graph, freq);

        ArrayList<Long> result = new ArrayList<>();
        for (int i = 1; i < N; i++) {
            result.add(freq.get(i) / 2);
        }

        return result;
    }

    private static void dfs(int node, ArrayList<ArrayList<Integer>> graph, ArrayList<Long> freq) {
        ArrayList<Integer> descendants = new ArrayList<>();
        for (int i = 0; i < graph.size(); i++) {
            descendants.add(0);
        }

        for (int child : graph.get(node)) {
            dfs(child, graph, freq);

            for (int i = 0; i < graph.size(); i++) {
                if (i == node) {
                    continue;
                }

                descendants.set(i, descendants.get(i) + descendants.get(child) + (node == i ? 1 : 0));
            }

        }

        for (int i = 0; i < graph.size(); i++) {
            if (i == node) {
                continue;
            }
            freq.set(descendants.get(i), freq.get(descendants.get(i)) + 1);
        }

        descendants.set(node, 1);
    }
}
