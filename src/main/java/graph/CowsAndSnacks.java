/**
 * Problem Description
 *
 * The legendary Farmer John is throwing a huge party, and animals from all over the world are hanging out at his house. His guests are hungry, so he instructs his cow Bessie to bring out the snacks! Moo!
 *
 * There are A snacks flavors, numbered with integers 1,2,…,A. Bessie has A snacks, one snack of each flavor. There are M guests and every guest has exactly two favorite flavors. The procedure for eating snacks will go as follows:
 *
 * First, Bessie will line up the guests in some way.
 * Each guest in their turn will eat all remaining snacks of their favorite flavor. In case no favorite flavors are present when a guest goes up, they become very sad.
 * Help Bessie to minimize the number of sad guests by lining the guests in an optimal way.
 *
 *
 *
 * Problem Constraints
 *
 * 2 <= A <= 100000
 * 1 <= M <= 100000
 * 1 <= B[i][0] , B[i][1] <= A
 * B[i][0] != B[i][1]
 *
 *
 *
 * Input Format
 *
 * First argument of input contains a single integer A.
 * Second argument of input contains a M x 2 integer matrix B denoting favorite flavors of each guest.
 *
 *
 *
 * Output Format
 *
 * Return a single integer denoting the ,minimum possible number of sad guests.
 *
 *
 *
 * Example Input
 *
 * Input 1:
 *
 *  A = 5
 *  B = [
 *        [1, 2],
 *        [4, 3],
 *        [1, 4],
 *        [3, 4]
 *      ]
 * Input 2:
 *
 *  A = 6
 *  B = [
 *        [2, 3],
 *        [2, 1],
 *        [3, 4],
 *        [6, 5],
 *        [4, 5]
 *      ]
 *
 *
 * Example Output
 *
 * Output 1:
 *
 *  1
 * Output 2:
 *
 *  0
 *
 *
 * Example Explanation
 *
 * Explanation 1:
 *
 *  Bessie can order the guests like this: (3, 1, 2, 4). Guest 3 goes first and eats snacks 1 and 4.
 *  Then the guest 1 goes and eats the snack 2 only, because the snack 1 has already been eaten.
 *  Similarly, the guest 2 goes up and eats the snack 3 only. All the snacks are gone, so the guest 4 will be sad.
 * Explanation 2:
 *
 *  Bessie can order the guests like this: (1, 2, 3, 5, 4). So no-one will be sad.
 */
package graph;

public class CowsAndSnacks {
    public static void main(String[] args) {
        int A = 6;
        int[][] B = {{2, 3}, {2, 1}, {3, 4}, {6, 5}, {4, 5}};
        System.out.println(solve(A, B));
    }
    public static int solve(int A, int[][] B) {

        UnionFind dsu = new UnionFind(A + 1);

        int count = 0;
        for (int[] ints : B) {
            if (dsu.find(ints[0]) == dsu.find(ints[1])) {
                count++;
            } else {
                dsu.union(ints[0], ints[1]);
            }
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
            int parentX = find(x);
            int parentY = find(y);

            if (parentX == parentY) {
                return;
            }
            if (rank[parentX] > rank[parentY]) {
                parent[parentY] = parentX;
            } else if (rank[parentY] > rank[parentX]) {
                parent[parentX] = parentY;
            } else {
                parent[parentX] = parentY;
                rank[parentY]++;
            }
        }
    }
}
