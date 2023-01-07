import java.util.*;
public class FourNumberSum {
    public static void main(String[] args) {
        int[] array = {7, 6, 4, -1, 1, 2};
        int targetSum = 16;
        List<Integer[]> result = solve(array, targetSum);
        for (var pair: result) {
            System.out.println(Arrays.toString(pair));
        }
    }
    public static List<Integer[]> solve(int[] array, int targetSum) {
        // Average: O(n^2) time | O(n^2) space
        // Worst: O(n^3) time | O(n^2) space
        Map<Integer, List<Integer[]>> allPairSums = new HashMap<>();
        List<Integer[]> quardruplets = new ArrayList<>();
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = i + 1; j < array.length; j++) {
                int currentSum = array[i] + array[j];
                int difference = targetSum - currentSum;
                if (allPairSums.containsKey(difference)) {
                    for (Integer[] pair: allPairSums.get(difference)) {
                        Integer[] newQuadruplet = {pair[0], pair[1], array[i], array[j]};
                        quardruplets.add(newQuadruplet);
                    }
                }
            }
            for (int k = 0; k < i; k++) {
                int currentSum = array[i] + array[k];
                Integer[] pair = {array[k], array[i]};
                if(!allPairSums.containsKey(currentSum)) {
                    List<Integer[]> pairGroup = new ArrayList<>();
                    pairGroup.add(pair);
                    allPairSums.put(currentSum, pairGroup);
                } else {
                    allPairSums.get(currentSum).add(pair);
                }
            }
        }
        return quardruplets;
    }
}
