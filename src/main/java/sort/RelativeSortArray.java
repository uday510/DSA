package sort;

import java.util.Arrays;

public class RelativeSortArray {
    public static void main(String[] args) {
        int[] arr1 = {2,3,1,3,2,4,6,7,9,2,19};
        int[] arr2 = {2,1,4,3,9,6};
        int[] result = relativeSortArray(arr1, arr2);
        for (int i : result) {
            System.out.print(i + " ");
        }
    }
    public static int[] relativeSortArray(int[] arr1, int[] arr2) {
        int[] count = new int[1001];

        for (int i : arr1) {
            count[i]++;
        }

        int index = 0;

        for (int i : arr2) {
            while (count[i] > 0) {
                arr1[index++] = i;
                count[i]--;
            }
        }

        for (int i = 0; i < count.length; i++) {
            while (count[i] > 0) {
                arr1[index++] = i;
                count[i]--;
            }
        }
        return arr1;
    }
}
