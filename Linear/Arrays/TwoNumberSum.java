import java.util.*;

public class TwoNumberSum {
    public static void main(String[] args) {
        int[] array = {3, 5, -4, 8, 11, 1, -1, 6};
        int targetSum = 10;
    }
    public static int[] twoNumberSumOptimal(int[] array, int targetSum) {
// O(nlog(n)) time | O(1) space
        Arrays.sort(array);
        int left = 0;
        int right = array.length - 1;
        while(left < right) {
            int firstNum = array[left];
            int secondNum = array[right];
            int currentSum = firstNum + secondNum;
            if(currentSum == targetSum) return new int[] {firstNum, secondNum};
            else if(currentSum < targetSum) left += 1;
            else right -= 1;
        } return new int[0];
    }
    public static int[] twoNumberSumUsingSet(int[] array, int targetSum) {
// O(n) time | O(n) space
        Set<Integer> nums = new HashSet<>();
        for(int num: array) {
            int potentialMatch = targetSum - num;
            if(nums.contains(potentialMatch)) return new int[] {num, potentialMatch};
            nums.add(num);
        } return new int[0];
    }
    public static int[] twoNumberSumBruteForce(int[] array, int targetSum) {
// O(n^2) time | O(1) space
        for(int i = 0; i < array.length - 1; i++) {
            int firstNum = array[i];
            for(int j = i + 1; j < array.length; j++) {
                int secondNum = array[j];
                if(firstNum + secondNum == targetSum)
                    return new int[] {firstNum, secondNum};
            }
        } return new int[0];
    }
}
