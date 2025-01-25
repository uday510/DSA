/**
 * You are given an array A of N elements. Sort the given array in increasing order of
 * number of distinct factors of each element, i.e., element having the least number of
 * factors should be the first to be displayed and the number having highest number of factors
 * should be the last one. If 2 elements have same number of factors, then number with less value
 * should come first.
 *
 * Note: You cannot use any extra space
 *
 *
 * Problem Constraints
 * 1 <= N <= 104
 * 1 <= A[i] <= 104
 *
 *
 * Input Format
 * First argument A is an array of integers.
 *
 *
 * Output Format
 * Return an array of integers.
 *
 *
 * Example Input
 * Input 1:
 * A = [6, 8, 9]
 * Input 2:
 * A = [2, 4, 7]
 *
 *
 * Example Output
 * Output 1:
 * [9, 6, 8]
 * Output 2:
 * [2, 7, 4]
 *
 *
 * Example Explanation
 * For Input 1:
 * The number 9 has 3 factors, 6 has 4 factors and 8 has 4 factors.
 * For Input 2:
 * The number 2 has 2 factors, 7 has 2 factors and 4 has 3 factors.
 */

package sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

public class ComparatorFunction {
    public static void main(String[] args) {
        ArrayList<Integer> array = new ArrayList<>(
                Arrays.asList(6, 8, 9));
        ArrayList<Integer> res = solve(array);
        System.out.println(res);
    }

    public static ArrayList<Integer> solve(ArrayList<Integer> array) {
        array.sort((o1, o2) -> {
            Integer count1 = getFactors(o1);
            Integer count2 = getFactors(o2);
            if (Objects.equals(count1, count2)) return o1 - o2;
            return count1 - count2;
        });
        return array;
    }

    public static Integer getFactors(Integer n) {
        int numOfFactors = 0;

        for (int i = 1; i * i <= n; ) {
            if (n % i == 0) {
                if (i != n / i) numOfFactors += 2;
                else numOfFactors += 1;
            }
            i++;
        }
        return numOfFactors;
    }
}
