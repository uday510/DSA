/**
 * A phrase is a palindrome if, after converting all uppercase letters into lowercase letters and removing all non-alphanumeric characters, it reads the same forward and backward. Alphanumeric characters include letters and numbers.
 *
 * Given a string s, return true if it is a palindrome, or false otherwise.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "A man, a plan, a canal: Panama"
 * Output: true
 * Explanation: "amanaplanacanalpanama" is a palindrome.
 * Example 2:
 *
 * Input: s = "race a car"
 * Output: false
 * Explanation: "raceacar" is not a palindrome.
 * Example 3:
 *
 * Input: s = " "
 * Output: true
 * Explanation: s is an empty string "" after removing non-alphanumeric characters.
 * Since an empty string reads the same forward and backward, it is a palindrome.
 *
 *
 * Constraints:
 *
 * 1 <= s.length <= 2 * 105
 * s consists only of printable ASCII characters.
 */
package string;

public class ValidPalindrome {
    public static void main(String[] args) {
            String s = "A man, a plan, a canal: Panama";
            System.out.println(isPalindrome(s));
    }

    public static boolean isPalindrome(String s) {

        int l = 0, r = s.length() - 1;

        while (l < r) {

            while (l < r && !alphaNumeric(s.charAt(l))) {
                ++l;
            }
            while (l < r && !alphaNumeric(s.charAt(r))) {
                --r;
            }

            if (Character.toLowerCase(s.charAt(l)) != Character.toLowerCase(s.charAt(r))) {
                return false;
            }
            ++l;
            --r;
        }
        return true;

    }
    public static boolean alphaNumeric(char c) {
        return (c >= 'a' && c <= 'z') || (c >= '0' && c <= '9') || (c >= 'A' && c <= 'Z');
     }
}

//      StringBuilder sb = new StringBuilder();
//
//      for (char c : s.toCharArray()) {
//          if (Character.isLetterOrDigit(c)) {
//                sb.append(Character.toLowerCase(c));
//          }
//      }
//      String filteredString = sb.toString();
//      String reversedString = sb.reverse().toString();
//
//      return filteredString.equals(reversedString);
