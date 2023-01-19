import java.util.ArrayList;
import java.util.Arrays;

/**
 * You are given an array A of N integers.
 * Return a 2D array consisting of all the subarrays of the array
 *
 *
 * Problem Constraints
 * 1 <= N <= 100
 * 1 <= A[i] <= 105
 *
 *
 * Input Format
 * First argument A is an array of integers.
 *
 *
 * Output Format
 * Return a 2D array of integers
 *
 *
 * Example Input
 * Input 1:
 * A = [1, 2, 3]
 * Input 2:
 * A = [5, 2, 1, 4]
 *
 *
 * Example Output
 * Output 1:
 * [[1], [1, 2], [1, 2, 3], [2], [2, 3], [3]]
 * Output 2:
 * [[1 ], [1 4 ], [2 ], [2 1 ], [2 1 4 ], [4 ], [5 ], [5 2 ], [5 2 1 ], [5 2 1 4 ] ]
 *
 *
 * Example Explanation
 * For Input 1:
 * All the subarrays of the array are returned. There are a total of 6 subarrays.
 * For Input 2:
 * All the subarrays of the array are returned. There are a total of 10 subarrays.
 */

public class GenerateSubarrays {

    public static void main(String[] args) {
        ArrayList<Integer> array = new ArrayList<>(
                Arrays.asList(1, 2, 3)
        );
        ArrayList<ArrayList<Integer>> result = solve(array);
        System.out.println(result);
    }
    public static ArrayList<ArrayList<Integer>> solve(ArrayList<Integer> array) {
        ArrayList<ArrayList<Integer>>subArrays = new ArrayList<>();

        int len = array.size();
        for (int i = 0; i < len; i++) {
            for (int j = i; j < len; j++) {
                ArrayList<Integer> currentSubArray = new ArrayList<>();
                for (int k = i; k <= j; k++) {
                    Integer currentNum = array.get(k);
                    currentSubArray.add(currentNum);
                }
                subArrays.add(currentSubArray);
            }
        }
        return subArrays;
    }
}
