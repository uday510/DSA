package sort;

import java.util.*;

public class FindLeastNumOfUniqueInts {
    public static void main(String[] args) {
        int[] arr = {4,3,1,1,3,3,2};
        int k = 3;
        System.out.println(findLeastNumOfUniqueInts(arr, k));
    }
    public static int findLeastNumOfUniqueInts(int[] arr, int k) {

        // Eg. arr = [4,3,1,1,3,3,2] => map = {4:1, 3:3, 1:2, 2:1}
        Map<Integer, Integer> map = new HashMap<>();
        int n = arr.length;
        for(int i : arr) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }

        int[] freq = new int[n + 1];
        for (int i : map.values()) {
            freq[i]++;
        }

        int count = map.size();
        // count represents the number of unique elements in the array  => count = 4
        // freq[i] represents the number of elements with frequency i in the array

        for (int i = 1; i < freq.length; i++) {
            // If k is greater than or equal to i * freq[i],
            // then we can remove all the elements with frequency i

            if (k >= i * freq[i]) {
                // if k is greater than or equal to i * freq[i]
                // which means we can remove all the elements with frequency i
                // so we can remove freq[i] elements
                k -= i * freq[i];
                count -= freq[i];  // count -= 2 => current count = 2
                // why count -= freq[i]? because we are removing freq[i]
                // elements from the array and count is the number of unique elements in the array
                // so we are removing freq[i] unique elements from the array
            } else {
                // If k is less than i * freq[i], then we can remove only k / i elements
                // and further we can't remove any more elements
                // count -= k / i => count -= 1 => current count = 1
                count -= k / i;
                break;
            }
        }
        return count;
    }
}
