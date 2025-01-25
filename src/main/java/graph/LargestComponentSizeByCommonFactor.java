/*
You are given an integer array of unique positive integers nums. Consider the following graph:

There are nums.length nodes, labeled nums[0] to nums[nums.length - 1],
There is an undirected edge between nums[i] and nums[j] if nums[i] and nums[j] share a common factor greater than 1.
Return the size of the largest connected component in the graph.

Input: nums = [4,6,15,35]
Output: 4

Input: nums = [20,50,9,63]
Output: 2

Input: nums = [2,3,6,7,4,12,21,39]
Output: 8


Constraints:

1 <= nums.length <= 2 * 104
1 <= nums[i] <= 105
All the values of nums are unique.
 */
package graph;

public class LargestComponentSizeByCommonFactor {
    public static void main(String[] args) {
        int[] nums = {2, 3, 6, 7, 4, 12, 21, 39};
        System.out.println(largestComponentSize(nums));
    }
    public static int largestComponentSize(int[] nums) {
        /*
        use union find to find the largest component size

        1. find the max number in the array
        2. find all the prime numbers from 2 to max number
        3. for each number in the array, find all the prime factors

        4. for each number in the array, union the number with all its prime factors

        5. find the largest component size
         */

        int max = 0;
        for (int num : nums) {
            max = Math.max(max, num);
        }

        UnionFind uf = new UnionFind(max + 1);

        for (int num : nums) {
            for (int factor = 2; factor <= Math.sqrt(num); factor++) {
                if (num % factor == 0) { // if the number is divisible by the factor then it is a prime factor
                    // not understand why we need to union the number with its prime factors
                    uf.union(num, factor); // union the number with its prime factors
                    uf.union(num, num / factor); // union the number with its prime factors
                }
            }
        }

        int[] count = new int[max + 1]; // count the number of nodes in the same component


        int res = 0;

        for (int num : nums) {
            int root = uf.find(num); // find the root of the number in the union find
            count[root]++; // count the number of nodes in the same component
            res = Math.max(res, count[root]); // update the largest component size
        }
        return res; // return the largest component size

    }
    static class UnionFind {
        int[] parent;
        int[] size;

        public UnionFind(int n) {
            parent = new int[n];
            size = new int[n];

            for (int i = 0; i < n; i++) {
                parent[i] = i;
                size[i] = 1;
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

            if (rootX != rootY) {
                if (size[rootX] > size[rootY]) {
                    parent[rootY] = rootX;
                } else if (size[rootY] > size[rootX]) {
                    parent[rootX] = rootY;
                } else {
                    parent[rootY] = rootX;
                    size[rootX] += size[rootY];
                }
            }
        }
    }
}
