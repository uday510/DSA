/*
You are given a number

You are required to form two numbers
 and
 such that:

The sum of frequency of each digit in
 and
 is equal to frequency of that digit in
.
The sum of numbers
 and
 must be minimum.
Your task is to determine the minimum possible sum of
 and
.

 */


package string;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Exam {
    public static void main(String[] args) {
        int n = 42255;
//        solve(n);


        String S = "0101";
        int K = 2;
        int N = S.length();
        solve(K, S, N);

    }
    public static void solve(int n) {
        // sort the digits in ascending order

        List<Integer> digits = new ArrayList<>();

        while (n > 0) {
            digits.add(n % 10);
            n /= 10;
        }

        Collections.sort(digits);

        int a = 0, b = 0;

        for (int i = 0; i < digits.size(); i++) {
            if (i % 2 == 0) { // why to do this? because we want to make the number as small as possible, so we put the smallest digit in the front, and the second smallest digit in the back
                a = a * 10 + digits.get(i);
            } else {
                b = b * 10 + digits.get(i);
            }
        }

        System.out.println(a + b);

    }

    public static void solve(int K, String S, int N) {


        StringBuilder sb = new StringBuilder(S);

        for (int i = 0; i < N; i++) {
            if (sb.charAt(i) == '0') {
                for (int j = i; j < i + K && j < N; j++) {
                    if (sb.charAt(j) == '0') {
                        sb.setCharAt(j, '1');
                    } else {
                        sb.setCharAt(j, '0');
                    }
                }
            }
        }

        // Check if all characters in the modified string are 'O'

        for (int i = 0; i < N; i++) {
            if (sb.charAt(i) == '1') {
                System.out.println(0);
                return;
            }
        }
        System.out.println(1);
    }

    public static void solve(int[] arr) {
        /*
        Array Challenge Have the function ArrayChallenge(arr)
        take the array of numbers stored in arr and first determine the
        largest element in the array, and then determine whether or not you
        can reach that same element within the array by moving left or right
         continuously according to whatever integer is in the current spot.
         If you can reach the same spot within the array, then your program
         should output the least amount of jumps it took.
         For example: if the input is [2, 3, 5, 6, 1] you'll start at the
          spot where 6 is and if you jump 6 spaces to the right while looping
          around the array you end up at the last element where the 1 is.
          Then from here you jump 1 space to the left and you're back where
           you started, so your program should output 2.
            If it's impossible to end up back at the largest element in the array
             your program should output -1.
              The largest element in the array will never equal the number of
              elements in the array. The largest element will be unique.
         */

        int max = Integer.MIN_VALUE;
        int maxIndex = 0;
        for (int i = 0; i < arr.length; i++) {
            if (max < arr[i]) {
                maxIndex = i;
                max = arr[i];
            }
        }

        int left = maxIndex - 1;
        int right = maxIndex + 1;
        int count = 0;
        while (left >= 0 || right < arr.length) {
            if (left >= 0 && arr[left] == max) {
                System.out.println(count);
                return;
            }
            if (right < arr.length && arr[right] == max) {
                System.out.println(count);
                return;
            }
            left--;
            right++;
            count++;
        }
    }
}
