package array;

import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSequence {

    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();

        for (int num : nums) set.add(num);

        int longest = 0;

        for (int num : set) {
            if (set.contains(num - 1)) continue;

            int curr = 1;
            while (set.contains(num + 1)) {
                curr++;
                num++;
            }

            longest = Math.max(longest, curr);
        }

        return longest;
    }

}
