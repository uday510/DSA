package Linear.Arrays;

import java.util.HashMap;

public class LastOccurance {
    public static void main(String[] args) {
        int[] array = {2, 4, 5, 6, -1, 2, 5, 4, 3, 7, 3, 2};
        int ans = solve(array);
        System.out.println(ans);
    }
    public static int solve(int[] nums) {
        // O(N) time | O(N) space
        int ans = Integer.MAX_VALUE;

        HashMap<Integer, Integer> hashMap = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (!hashMap.containsKey(num)) {
                hashMap.put(num, i);
            } else {
                int lastOccurence = hashMap.get(num);
                ans = Math.min(ans, i - lastOccurence);
                hashMap.put(num, i);
            }
        }
        System.out.println(hashMap);
        return ans;
    }
}
