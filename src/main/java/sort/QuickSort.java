package sort;

import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
        int[] arr = { 10, 7, 8, 9, 1, 5 };
        int n = arr.length;
        quickSort(arr, 0, n - 1);
        System.out.println(Arrays.toString(arr));
    }

    public static void quickSort(int[] arr, int low, int high) {
        if (high <= low)
            return;

        int pivot = partition(arr, low, high);

        quickSort(arr, low, pivot - 1);
        quickSort(arr, pivot + 1, high);
    }

    public static int partition(int[] arr, int low, int high) {
        int idx = low;
        int pivot = arr[low];

        for (int i = low + 1; i <= high; ++i) {
            if (arr[i] >= pivot) {
                continue;
            }

            ++idx;
            swap(arr, idx, i);
        }
        swap(arr, low, idx);
        return idx;
    }
    public static void swap(int[] arr, int i, int j) {
       int tmp = arr[i];
       arr[i] = arr[j];
       arr[j] = tmp;
    }
}



