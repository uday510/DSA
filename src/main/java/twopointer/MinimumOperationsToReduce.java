package twopointer;
import java.util.*;

public class MinimumOperationsToReduce {

    public int minOperations(int[] nums, int x) {


        int n = nums.length;
        int totalSum = Arrays.stream(nums).sum();
        int currSum = 0;
        int maxLength = Integer.MIN_VALUE;
        int targetSum = totalSum - x;

        Deque<Integer> queue = new ArrayDeque<>();
        for (int num : nums) {
            currSum += num;
            queue.add(num);

            while (currSum > targetSum && !queue.isEmpty()) {
                int removedNum = queue.poll();
                currSum -= removedNum;
            }

            if (currSum == targetSum) {
                maxLength = Math.max(maxLength, queue.size());
            }
        }
        return (maxLength == Integer.MIN_VALUE) ? -1 : n - maxLength;
    }
}
