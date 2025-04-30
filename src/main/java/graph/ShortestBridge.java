package graph;

import java.util.ArrayDeque;
import java.util.Queue;

public class ShortestBridge {

    int[][] dirs = {{0,1},{1,0},{-1,0},{0,-1}};
    Queue<int[]> queue;
    int n;
    boolean[][] visited;
    int[][] grid;
    
    public int shortestBridge(int[][] grid) {
        n = grid.length;
        visited = new boolean[n][n];
        queue = new ArrayDeque<>();
        this.grid = grid;

        boolean found = false;
        for (int i = 0; i < n && !found; ++i) {
            for (int j = 0; j < n && !found; ++j) {
                if (grid[i][j] == 1) {
                    dfs(i, j);
                    found = true;
                }
            }
        }

        while (!queue.isEmpty()) {
            int[] curr = queue.poll();

            for (int[] dir : dirs) {
                int i = curr[0] + dir[0];
                int j = curr[1] + dir[1];
                int d = curr[2];

                if (isInvalid(i, j)) continue;

                if (grid[i][j] == 1) return d;

                visited[i][j] = true;
                queue.offer(new int[]{i, j, d + 1});
            }
        }

        return -1;
    }
    
    private void dfs(int i, int j) {
        if (isInvalid(i, j) || grid[i][j] == 0) return;

        queue.offer(new int[]{i, j, 0});
        visited[i][j] = true;
        for (int[] dir : dirs) {
            int nextI = dir[0] + i;
            int nextJ = dir[1] + j;

            dfs(nextI, nextJ);
        }
    }
    
    private boolean isInvalid(int i, int j) {
        return i < 0 || i >= n || j < 0 || j >= n || visited[i][j];
    }
}



//Given string num representing a non-negative integer num, and an integer k,
//return the smallest possible integer after removing k digits from num.
//
//
//num = "1432219", k = 3
//output: "1219"
//
//
//len = 7
//
//
//"1432219"
//
//"1119"
//
//requiredLen = 4
//
//ans =
//
//smallest =
//
//4
//
//[1,2,1,9]
//
//"4324312", k = 4
//
//"4324312", k = n - 2, ans = 1
//
//
//num = "1432219", k = 3
//output: "1219"
//
//[1, ],
//
//
//assume we have array as input, stock price of particular, 2 transactions
//
//
//array of stocks: [1, 2, 3, 4, 2, 1] --> ans : 3
//
//                 [1, 3, 1, 2, 5, 2, 4, 8] --> ans : 10
//
//                minBuyingPrice: 1
//                maxSellingPrice: 5
//                currProfit = maxSellingPrice - minBuyingPrice
//
//                maxProfit : 4
//
//
//// O(N) time | O(1) space
//// N is the length of input array
//
//
//[3, 2, 1], ans : 0
//
//int[] arr = {1, 2, 3, 4, 2, 1};
//
//int len = arr.length;
//
//if (len < 1) return 0;
//
//int minBuyingPrice = arr[0], maxSellingPrice = arr[0], maxProfit = 0;
//
//for (int idx = 1; idx < len; ++idx) {
//    minBuyingPrice = Math.min(minBuyingPrice, arr[idx]);
//    maxSellingPrice = Math.max(maxSellingPrice, arr[idx]);
//    maxProfit = Math.max(maxProfit, maxSellingPrice - minBuyingPrice);
//}
//
//
//return maxProfit;
//
//
//
//
//
//
//
//                 Q1.
//N children are standing in a line. Each child is assigned a rating value.
//You are giving candies to these children subjected to the following requirements:
//1. Each child must have at least one candy.
//2. Children with a higher rating get more candies than their neighbours.
//What is the minimum number of candies you must give?
//
//sum : 1 +
//
//prevVal: 3
//
//ratings-arr : [0, 1, 3, 3, 4, 1, 2] : 12
//              [1, 2, 3, 1, 2, 1, 2]
//
//
//Input : 1, 5, 2, 1
//
//        1, 3, 2, 1  :7
//
//
//Time: O(N)  | space: O(N)
//
//
//Q2.
//
//Given a linked list of integers which are sorted considering their absolute values. You need to sort the linked list.
//
//Input: 1 -2 5 -7 9 -10
//
//Answer: -10 -7 -2 1 5 9
//
//positiveList : 1 -> 5
//
//negativeList: -7 -> -2
//
//public void main() {
//}
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
