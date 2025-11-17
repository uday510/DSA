package sort;

public class Mergesort {

    private void mergesort(int l, int r, int[] nums) {
        if (l >= r) return;

        int m = (l + r) >>> 1;

        mergesort(l, m, nums);
        mergesort(m + 1, r, nums);
        merge(l, m, m + 1, r, nums);
    }

    private void merge(int ls, int le, int rs, int re, int[] nums) {
        int[] left = new int[le - ls + 1];
        int[] right = new int[re - rs + 1];

        for (int i = 0; i < left.length; i++) left[i] = nums[i + ls];

        for (int i = 0; i < right.length; i++) right[i] = nums[i + rs];

        int i = 0, j = 0, k = ls;

        while (i < left.length && j < right.length) {
            if (left[i] < right[j]) nums[k] = left[i++];
            else nums[k] = right[j++];
            k++;
        }

        while (i < left.length) nums[k++] = left[i++];
        while (j < right.length) nums[k++] = right[j++];
    }
}
