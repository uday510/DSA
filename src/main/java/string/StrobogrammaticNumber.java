/*
Given a string num which represents an integer, return true if num is a strobogrammatic number.

A strobogrammatic number is a number that looks the same when rotated 180 degrees (looked at upside down).


Example 1:

Input: num = "69"
Output: true
Example 2:

Input: num = "88"
Output: true
Example 3:

Input: num = "962"
Output: false


Constraints:

1 <= num.length <= 50
num consists of only digits.
num does not contain any leading zeros except for zero itself.
 */
package string;

public class StrobogrammaticNumber {
    public static void main(String[] args) {
        String num = "69";
        System.out.println(isStrobogrammatic(num));
    }
    public static boolean isStrobogrammatic(String num) {
        StringBuilder sb = new StringBuilder();

        for (int i = num.length() - 1; i > -1; --i) {
            char c = num.charAt(i);
            if (c == '1' || c == '0' || c == '8') {
                sb.append(c);
            } else if (c == '6') {
                sb.append('9');
            } else if (c == '9') {
                sb.append('6');
            } else {
                return false;
            }
        }

        String str = sb.toString();
        return num.equals(str);
    }
}
