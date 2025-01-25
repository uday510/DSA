package slidingwindow;

import java.util.Arrays;
import java.util.OptionalInt;

// https://leetcode.com/problems/count-subarrays-where-max-element-appears-at-least-k-times/
public class CountSubarrays {
    public static void main(String[] args) {
        int[] arr = {1, 2, 1, 2, 3};
        int k = 2;
        System.out.println(countSubarrays(arr, k));
    }
    public static long countSubarrays(int[] arr, int k) {
        int len = arr.length;
        int left = 0, right = 0;
        long totalSubarrays = 0;

        int maxElement = Arrays.stream(arr).max().getAsInt();
        int maxElementsInWindow = 0;

        for (; right < len; ++right) {

            if (arr[right] == maxElement)
                maxElementsInWindow++;

            while (maxElementsInWindow >= k) {
                if (arr[left] == maxElement) {
                    totalSubarrays += right - left + 1;
                    maxElementsInWindow--;
                }
                left++;
            }
        }
        return totalSubarrays;
    }
}
