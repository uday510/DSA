/**
 * Write a function that takes an integer and returns the number of 1 bits it has.
 *
 *
 * Problem Constraints
 * 1 <= A <= 109
 *
 *
 * Input Format
 * First and only argument contains integer A
 *
 *
 * Output Format
 * Return an integer as the answer
 *
 *
 * Example Input
 * Input 1:
 * 11
 * Input 2:
 * 6
 *
 *
 * Example Output
 * Output 1:
 * 3
 * Output 2:
 * 2
 *
 *
 * Example Explanation
 * Explaination 1:
 * 11 is represented as 1011 in binary.
 * Explaination 2:
 * 6 is represented as 110 in binary.
 */

package bitmanipulation;

public class NumberOf1Bits {
    public static void main(String[] args) {
        int num = 11;
        int ans = hammingWeight(num);
        System.out.println(ans);
    }
    public static int hammingWeight(int n) {
        int bits = 0;
        int mask = 1;

        for (int i = 0; i < 32; ++i) {
            if ( (n & mask) != 0) {
                bits++;
            }
            mask <<= 1;
        }
        return bits;
    }
}
