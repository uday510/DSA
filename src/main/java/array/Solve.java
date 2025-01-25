package array;

import java.util.*;

public class Solve {
    public static void main(String[] args) {
        int[] arr1 = {1, 2, 3, 4, 5, 6, 6};
        int[] arr2 = {1, 2, 3, 4, 7, 7};

        solve(arr1, arr2);
    }


    public static void solve(int[] arr1, int[] arr2) {

       Arrays.sort(arr1);
       Arrays.sort(arr2);
        int i = 0;
        int j = 0;
        int N = arr1.length;
        int M = arr2.length;
        List<Integer> res = new ArrayList<>();

        while (i < N && j < M) {
            if (arr1[i] != arr2[j]) {
                // not common elements
                res.add(arr1[i]);
                res.add(arr2[j]);
            }
            i++;
            j++;
        }
        while (i < N) {
            res.add(arr1[i++]);
        }
        while (j < M) {
            res.add(arr1[j++]);
        }
        res.forEach(System.out::println);
    }
}
