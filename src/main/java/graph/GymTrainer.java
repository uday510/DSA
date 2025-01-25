/**
 * Problem Description
 *
 * You are the trainer of a gym and there are A people who come to your gym.
 *
 * Some of them are friends because they walk together, and some of them are friends because they talk together.
 * But people become possessive about each other, so a person cannot walk with one friend and talk with another. Although he can walk with two or more people or talk with two or more people.
 *
 * You being the trainer, decided to suggest each one of the 2 possible diets. But friends, being friends will always have the same diet as all the other friends are having.
 *
 * Find and return the number of ways you can suggest each of them a diet.
 *
 * As the number of ways can be huge, return the answer modulo 109+7.
 *
 * NOTE: If there is any person who walks with one person and talks with the another person, then you may return 0.
 *
 *
 *
 * Problem Constraints
 *
 * 1 <= A, N, M <= 105
 *
 * 1 <= B[i][0], B[i][1], C[i][0], C[i][1] <= A
 *
 *
 *
 * Input Format
 *
 * The first argument contains an integer A, representing the number of people.
 * The second argument contains a 2-D integer array B of size N x 2, where B[i][0] and B[i][1] are friends because they walk together.
 * The third argument contains a 2-D integer array C of size M x 2, where C[i][0] and C[i][1] are friends because they talk together.
 *
 *
 *
 * Output Format
 *
 * Return an integer representing the number of ways to suggest one of the two diets to the people.
 *
 *
 *
 * Example Input
 *
 * Input 1:
 *
 *  A = 4
 *  B = [
 *        [1, 2]
 *      ]
 *  C = [
 *        [3, 4]
 *      ]
 * Input 2:
 *
 *  A = 3
 *  B = [
 *        [1, 2]
 *      ]
 *  C = [
 *        [1, 3]
 *      ]
 *
 *
 * Example Output
 *
 * Output 1:
 *
 *  4
 * Output 2:
 *
 *  0
 *
 *
 * Example Explanation
 *
 * Explanation 1:
 *
 *  There are four ways to suggest the diet:
 *  Diet-1 to (1, 2) and Diet-2 to (3, 4).
 *  Diet-1 to (1, 2) and Diet-1 to (3, 4).
 *  Diet-2 to (1, 2) and Diet-1 to (3, 4).
 *  Diet-2 to (1, 2) and Diet-2 to (3, 4).
 */
package graph;

import java.util.HashSet;
import java.util.Set;

public class GymTrainer {
    public static void main(String[] args) {
        int A = 4;
        int[][] B = {{1, 2}};
        int[][] C = {{3, 4}};
        System.out.println(solve(A, B, C));
    }
    public static int solve(int A, int[][] B, int[][] C) {
        UnionFind dsu = new UnionFind(A);
        Set<Integer> set = new HashSet<>();
        Set<Integer> set1 = new HashSet<>();

        for (int[] b : B) {
            dsu.union(b[0], b[1]);
            set1.add(b[0]);
            set1.add(b[1]);
        }

        for (int[] c : C) {
            dsu.union(c[0], c[1]);
            if (set1.contains(c[0]) || set1.contains(c[1])) {
                return 0;
            }
        }

        for (int i = 1; i <= A; i++) {
            int parent = dsu.find(i);
            if (set.contains(parent)) continue;
            set.add(parent);
        }

        if (set.size() == 2) {
            return 0;
        }

        int MOD = (int) 1e9 + 7;
        int ans = 1;

        for (int i = 1; i <= set.size(); ++i) {
            ans = (ans * 2) % MOD;
        }

        return ans;
    }
    static class UnionFind {
        int[] parent;
        int[] rank;
        public UnionFind(int n) {
            parent = new int[n + 1];
            rank = new int[n + 1];
            for (int i = 0; i <= n; i++) {
                parent[i] = i;
                rank[i] = 1;
            }
        }

        public int find(int x) {
            if (parent[x] == x) return x;
            return parent[x] = find(parent[x]);
        }
        public void union(int x, int y) {
            int parentX = find(x);
            int parentY = find(y);
            if (parentX == parentY) return;

            if (rank[parentX] > rank[parentY]){
                parent[parentY] = parentX;
            } else if (rank[parentY] > rank[parentX]) {
                parent[parentX] = parentY;
            } else {
                parent[parentY] = parentX;
                rank[parentX]++;
            }
        }
    }
}
