/*
You are given a read only array of n integers from 1 to n.

Each integer appears exactly once except A which appears twice and B which is missing.

Return A and B.

Note: Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?

Note that in your output A should precede B.

Example:

Input:[3 1 2 5 3]

Output:[3, 4]

A = 3, B = 4
 */
package Array;

public class dummy {
    public static void main(String[] args) {

        int[] array = {3, 1, 2, 5, 3};

        int[] result = repeatedNumber(array);

        System.out.println(result[0] + " " + result[1]);
    }
    public static int[] repeatedNumber(int[] array) {

        int[] result = new int[2]; // result[0] = repeated number, result[1] = missing number

        for (int i = 0; i < array.length; ++i) {

            if (array[Math.abs(array[i]) - 1] < 0) { // if the number is already negative, it means it is repeated
                result[0] = Math.abs(array[i]); // so we store it in result[0]
            } else {
                array[Math.abs(array[i]) - 1] = -array[Math.abs(array[i]) - 1]; // else we make it negative
            }
        }

        for (int i = 0; i < array.length; ++i) { // now we check which number is positive, that is the missing number
            if (array[i] > 0) { // we store it in result[1]
                result[1] = i + 1; // we add 1 because the array starts from 1
            }
        }
        return result;

    }
}
