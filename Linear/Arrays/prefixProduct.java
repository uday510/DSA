import java.util.ArrayList;
import java.util.Arrays;

/**
 * Given an array of integers A, find and return the product array of the same size where the ith element of the product array will be equal to the product of all the elements divided by the ith element of the array.
 *
 * Note: It is always possible to form the product array with integer (32 bit) values. Solve it without using the division operator.
 *
 *
 * Input Format
 *
 * The only argument given is the integer array A.
 * Output Format
 *
 * Return the product array.
 * Constraints
 *
 * 2 <= length of the array <= 1000
 * 1 <= A[i] <= 10
 * For Example
 *
 * Input 1:
 *     A = [1, 2, 3, 4, 5]
 * Output 1:
 *     [120, 60, 40, 30, 24]
 *
 * Input 2:
 *     A = [5, 1, 10, 1]
 * Output 2:
 *     [10, 50, 5, 50]
 */
public class prefixProduct {

    public static void main(String[] args) {
        ArrayList<Integer> array = new ArrayList<>(
                Arrays.asList(1, 2, 3, 4, 5));
        System.out.println(solve(array));
    }
    public static ArrayList<Integer> solve(ArrayList<Integer> array) {

        ArrayList<Integer> result = new ArrayList<>();
        int totalArrayProduct = 1;
        for(int i = 0; i < array.size(); i++) {
            totalArrayProduct *= array.get(i);
        }

        for (int i = 0 ; i < array.size(); i++) {
            int currentProduct = totalArrayProduct / array.get(i);
            result.add(currentProduct);
        }

        return result;
    }
}
