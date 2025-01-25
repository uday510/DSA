/**
 * Problem Description
 * Given two integer arrays A and B of size N each which represent values and weights associated with N items respectively.
 *
 * Also given an integer C which represents knapsack capacity.
 *
 * Find out the maximum total value that we can fit in the knapsack. If the maximum total value is ans, then return ⌊ans × 100⌋ , i.e., floor of (ans × 100).
 *
 * NOTE:
 *
 * You can break an item for maximizing the total value of the knapsack
 *
 *
 * Problem Constraints
 * 1 <= N <= 105
 *
 * 1 <= A[i], B[i] <= 103
 *
 * 1 <= C <= 103
 *
 *
 *
 * Input Format
 * First argument is an integer array A of size N denoting the values on N items.
 *
 * Second argument is an integer array B of size N denoting the weights on N items.
 *
 * Third argument is an integer C denoting the knapsack capacity.
 *
 *
 *
 * Output Format
 * Return a single integer denoting the maximum total value of A such that sum of the weights of this subset is smaller than or equal to C.
 *
 *
 *
 * Example Input
 * Input 1:
 *
 *  A = [60, 100, 120]
 *  B = [10, 20, 30]
 *  C = 50
 * Input 2:
 *
 *  A = [10, 20, 30, 40]
 *  B = [12, 13, 15, 19]
 *  C = 10
 *
 *
 * Example Output
 * Output 1:
 *
 *  24000
 * Output 2:
 *
 *  2105
 *
 *
 * Example Explanation
 * Explanation 1:
 *
 * Taking the full items with weight 10 and 20 and 2/3 of the item with weight 30 will give us
 * the maximum value i.e 60 + 100 + 80 = 240. So we return 24000.
 * Explanation 2:
 *
 * Taking 10/19 the fourth item gives us the maximum value i.e. 21.0526. So we return 2105.
 */
package greedy;

import java.util.Arrays;

public class FractionalKnapsack {
    public static void main(String[] args) {
        int[] A = {10, 20, 30, 40};
        int[] B = {12, 13, 15, 19};
        int c = 10;
        int res = solve(A, B, c);
        System.out.println(res);
    }
    public static int solve(int[] A, int[] B, int capacity) {
        int n = A.length;

        Items[] items = new Items[n];

        for (int i = 0; i < n; ++i) {
            items[i] = new Items(A[i], B[i], i);
        }

        Arrays.sort(items, (o1, o2) -> {
           if (o1.cost >= o2.cost) return -1;
           return 1;
        });

        double res = 0d;
        for (int i = 0; i < n; ++i) {
            int currWeight = items[i].weight;
            int value = items[i].value;
            if (currWeight <= capacity) {
                res += value*1.0;
                capacity -= currWeight;
            } else {
                double fraction = ((double)value / (double)currWeight)*capacity;
                res += fraction;
                break;
            }
        }
        res *= 1000;
        return (int) (res/10);
    }
    static class Items {
        double cost;
        int value, weight, index;
        Items(int value, int weight, int index) {
            this.value = value;
            this.weight = weight;
            this.index = index;
            this.cost = (double) value / weight;
        }
    }
}
