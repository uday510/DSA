/*
You are given an m x n binary matrix mat of 1's (representing soldiers) and 0's (representing civilians). The soldiers are positioned in front of the civilians. That is, all the 1's will appear to the left of all the 0's in each row.

A row i is weaker than a row j if one of the following is true:

The number of soldiers in row i is less than the number of soldiers in row j.
Both rows have the same number of soldiers and i < j.
Return the indices of the k weakest rows in the matrix ordered from weakest to strongest.



Example 1:

Input: mat =
[[1,1,0,0,0],
 [1,1,1,1,0],
 [1,0,0,0,0],
 [1,1,0,0,0],
 [1,1,1,1,1]],
k = 3
Output: [2,0,3]
Explanation:
The number of soldiers in each row is:
- Row 0: 2
- Row 1: 4
- Row 2: 1
- Row 3: 2
- Row 4: 5
The rows ordered from weakest to strongest are [2,0,3,1,4].
Example 2:

Input: mat =
[[1,0,0,0],
 [1,1,1,1],
 [1,0,0,0],
 [1,0,0,0]],
k = 2
Output: [0,2]
Explanation:
The number of soldiers in each row is:
- Row 0: 1
- Row 1: 4
- Row 2: 1
- Row 3: 1
The rows ordered from weakest to strongest are [0,2,3,1].


Constraints:

m == mat.length
n == mat[i].length
2 <= n, m <= 100
1 <= k <= m
matrix[i][j] is either 0 or 1.
 */
package heap;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class KWeakestRows {
    public static void main(String[] args) {
        int[][] mat = { {1, 1, 0, 0, 0},
                {1, 1, 1, 1, 0},
                {1, 0, 0, 0, 0},
                {1, 1, 0, 0, 0},
                {1, 1, 1, 1, 1} };

        int k = 3;

        KWeakestRows kWeakestRows = new KWeakestRows();

        int[] res = kWeakestRows.kWeakestRows(mat, k);
        System.out.println(Arrays.toString(res));
    }

    public int[] kWeakestRows(int[][] mat, int k) {
        int n = mat.length;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
            if (a[1] != b[1]) {
                return a[1] - b[1]; // Compare by the number of 1s in ascending order
            } else {
                return a[0] - b[0]; // If the number of 1s is equal, compare by row index in ascending order
            }
        });

        for (int i = 0; i < n; ++i) {
            int[] row = mat[i];
            int countOnes = Arrays.stream(row).sum();

            pq.offer(new int[]{i, countOnes});

            if (pq.size() > k) {
                pq.poll();
            }
        }

        int[] res = new int[k];

        for (int i = 0; i < k && !pq.isEmpty(); ++i) {
            int[] temp = pq.poll();
            res[i] = temp[0];
        }

        return res;
    }

}
