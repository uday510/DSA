/*
Given a sorted integer array arr, two integers k and x, return the k closest integers to x in the array. The result should also be sorted in ascending order.

An integer a is closer to x than an integer b if:

|a - x| < |b - x|, or
|a - x| == |b - x| and a < b


Example 1:

Input: arr = [1,2,3,4,5], k = 4, x = 3
Output: [1,2,3,4]
Example 2:

Input: arr = [1,2,3,4,5], k = 4, x = -1
Output: [1,2,3,4]


Constraints:

1 <= k <= arr.length
1 <= arr.length <= 104
arr is sorted in ascending order.
-104 <= arr[i], x <= 104

 */
package binarysearch;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class FindKClosestElements {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        int k = 4;
        int x = 3;
        System.out.println(findClosestElements(arr, k, x));
    }
    public static List<Integer> findClosestElements(int[]  arr, int k, int x) {
        List<Integer> result = new ArrayList<>();

        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> {
            if (a.diff == b.diff) {
                return a.index - b.index;
            }
            return a.diff - b.diff;
        });

        for (int i = 0; i < arr.length; i++) {
            pq.add(new Pair(arr[i], Math.abs(arr[i] - x), i));
        }

        while (k-- > 0) {
            result.add(pq.poll().key);
        }

        Collections.sort(result);

        return result;
    }
    static class Pair {
        int key;
        int index;
        int diff;

        Pair(int key, int diff, int index) {
            this.key = key;
            this.diff = diff;
            this.index = index;
        }
    }
}
