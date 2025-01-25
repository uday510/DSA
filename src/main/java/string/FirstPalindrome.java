package string;

import java.util.Arrays;
import java.util.Iterator;

import static java.util.Arrays.stream;

public class FirstPalindrome {
    public static void main(String[] args) {
        String[] words = {"madam", "hello", "world", "level", "radar", "racecar"};

        System.out.println("First Palindrome: " + firstPalindrome(words));
    }
    public static String firstPalindrome(String[] words) {

        for (String word : words) {
            if (stream(words).anyMatch(FirstPalindrome::palindrome))
                return word;
        }
        return "";
    }
    public static boolean palindrome(String s) {
        int i = 0;
        int j = s.length()-1;

        while (i < j && s.charAt(i) == s.charAt(j)) {
            i++;
            j--;
        }

        return i >= j;
    }

}
