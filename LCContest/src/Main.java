import java.util.*;

public class Main {
    public static void main(String[] args) {
//        System.out.println("Hello world!");
        int[] nums = {1, 2, 3, 1, 2, 3, 1, 2};
        int k = 2;
        System.out.println(maxSubarrayLength(nums, k));
    }
    public int[] findIntersectionValues(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();

        for (int num : nums1) {
            set.add(num);
        }
       Set<Integer> res = new HashSet<>();
        for (int num : nums2) {
            if (set.contains(num)) {
                res.add(num);
            }
        }
        int[] arr = new int[res.size()];
        int i = 0;
        for (int val : res) {
            arr[i++] = val;
        }
        return arr;
    }

    public int removeAlmostEqualCharacters(String word) {
        int cnt = 0;

        for (int i = 1; i < word.length();) {
            char prev = word.charAt(i-1);
            char curr = word.charAt(i);
            if (curr - prev <= 1) {
                ++i;
            }
            ++i;
        }
        return cnt;
    }

    public static int maxSubarrayLength(int[] nums, int k) {
        Map<Integer, Integer> freq = new HashMap<>();

        int start = 0;
        int end = 0;
        int longest = 1;
        int N = nums.length;

        for (; end < N; ++end) {
            int num = nums[end];
            freq.put(num, freq.getOrDefault(num, 0)+1);

            while (freq.get(nums[end]) > k) {
                freq.put(nums[start], freq.get(nums[start]) - 1);
                if (freq.get(nums[start]) == 0) {
                    freq.remove(nums[start]);
                }
                start++;
            }
            longest = Math.max(end-start+1, longest);
        }


        return longest;
    }
}