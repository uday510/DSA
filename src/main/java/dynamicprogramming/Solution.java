package dynamicprogramming;

import java.util.ArrayList;
import java.util.List;

/**
 * Given two arrays,
 * choose exactly same k indices in such a way that the sum of those k elements in
 * arr1 and arr2 over these indices is maximum
 * arr1 = [1, 4, 2, 3, 5]
 * arr2 = [6, 8, 7, 9, 10]
 * k = 2
 * ans-5
 *
 * min(sum(max indices ele of arr1 ),sum(max indices ele of arr2 ))
 * for k==1 -->  min(5,10) , so ans -5
 *
 */

public class Solution {
    public static void main(String[] args) {
        List<Integer> arr1 = new ArrayList<>(List.of(1, 4, 2, 3, 5));
        List<Integer> arr2 = new ArrayList<>(List.of(6, 8, 7, 9, 10));
        int k = 2;
        maxSum(arr1, arr2, k);
//        System.out.println(maxSum(arr1, arr2, k));
    }





    private static int getSum (int[] arr1, int[] arr2, int k) {


        int n = arr1.length;


        for (int i = 0; i < n; ++i) {


            int sum1 = 0;
            int sum2 = 0;
            for (int j = 0; j < k; ++j) {

            }
        }








        return -1;
    }
    private static int maxSum(List<Integer> arr1, List<Integer> arr2, int k) {
        int n = arr1.size();
        int res = 0;


        List<Pair> list1 = new ArrayList<>();
        List<Pair> list2 = new ArrayList<>();

        for (int i = 0; i < n; ++i) {
            list1.add(new Pair(i, arr1.get(i)));
            list2.add(new Pair(i, arr2.get(i)));
        }

        list1.sort((o1, o2) -> Integer.compare(o2.value, o1.value));
        list2.sort((o1, o2) -> Integer.compare(o2.value, o1.value));


        for (Pair p : list1) {
            System.out.print(p.index + "," + p.value + " ");
        }

        System.out.println();
        for (Pair p : list2) {
            System.out.print(p.index + "," + p.value + " ");
        }
        System.out.println();

        /**
         *
         *         0  1  2  3  4
         * arr1 = {4, 2, 3, 6}
         * arr2 = {1, 1, 4, 8}
         *
         *
         *  6 +  4   -> min (10, 9) -> 9
         *  8 +  1
         */




        /**
         * or k==1 -->  min(5,10) , so ans -5
         * arr1 = ((4,5),(1,4),(3,3),(2,2),(0,1)
         * arr2 = ((4,10),(3,9),(1,8),(2,7),(0,6))
         * k=2
         */

        return res;
    }
    static class Pair {
        int index;
        int value;

        Pair(int index, int value) {
            this.index = index;
            this.value = value;
        }
    }
}
