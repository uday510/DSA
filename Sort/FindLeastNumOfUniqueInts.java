package Sort;

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
        for (int i = 1; i < freq.length; i++) {
            // If k is greater than or equal to i * freq[i],
            // then we can remove all the elements with frequency i
            if (k >= i * freq[i]) {
                k -= i * freq[i];
                count -= freq[i];
            } else {
                // If k is less than i * freq[i], then we can remove only k / i elements
                // and further we can't remove any more elements
                count -= k / i;
                break;
            }
        }
        return count;
    }
}
