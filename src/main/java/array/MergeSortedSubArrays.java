package array;

import java.util.Arrays;

public class MergeSortedSubArrays {

    public static void main(String[] args) {
        int[] arr1 = {1, 3, 5, 7};
        int[] arr2 = {2, 4, 6, 8};

       int[] res =  merge(arr1, arr2);

       System.out.println("Merged Array: " + Arrays.toString(res));
    }

    public static int[] merge(int[] arr1, int[] arr2) {
        int n = arr1.length;
        int m = arr2.length;
        int[] res = new int[n + m];

        int i = 0, j = 0, k = 0;

        while (i < n && j < m) {
            if (arr1[i] < arr2[j]) {
                res[k++] = arr1[i++];
            } else {
                res[k++] = arr2[j++];
            }
        }

        addRemNums(i, k, arr1, res);
        addRemNums(j, k, arr2, res);

        return res;
    }

    private static void addRemNums(int i, int k, int[] src, int[] dest) {
        while (i < src.length) dest[k++] = src[i++];
    }

}
