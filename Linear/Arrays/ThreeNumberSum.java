import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeNumberSum {
    public static void main(String[] args){
        int[] array = {12, 3, 1, 2, -6, 5, -8, 6};
        int targetSum = 0;
        List<Integer[]> triplets = solve(array, targetSum);
        for(var triplet: triplets) System.out.println(Arrays.toString(triplet));
    }
    public static List<Integer[]> solve(int[] array, int targetSum) {
        Arrays.sort(array);
        List<Integer[]> triplets = new ArrayList<>();

        for(int i = 0; i < array.length - 2; i++) {
            int left = i + 1;
            int right = array.length - 1;
            while(left < right) {
                int currentSum = array[i] + array[left] + array[right];
                if(currentSum == targetSum) {
                    Integer[] newTriplet = {array[i], array[left], array[right]};
                    triplets.add(newTriplet);
                    left++;
                    right--;
                } else if(currentSum < targetSum) left++;
                  else right--;
            }
        }
        return triplets;
    }
}