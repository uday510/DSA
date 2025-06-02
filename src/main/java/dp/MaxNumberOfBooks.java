/*
You are given a 0-indexed integer array books of length n where books[i] denotes the number of books on the ith shelf of a bookshelf.

You are going to take books from a contiguous section of the bookshelf spanning from l to r where 0 <= l <= r < n. For each index i in the range l <= i < r, you must take strictly fewer books from shelf i than shelf i + 1.

Return the maximum number of books you can take from the bookshelf.



Example 1:

Input: books = [8,5,2,7,9]
Output: 19
Explanation:
- Take 1 book from shelf 1.
- Take 2 books from shelf 2.
- Take 7 books from shelf 3.
- Take 9 books from shelf 4.
You have taken 19 books, so return 19.
It can be proven that 19 is the maximum number of books you can take.
Example 2:

Input: books = [7,0,3,4,5]
Output: 12
Explanation:
- Take 3 books from shelf 2.
- Take 4 books from shelf 3.
- Take 5 books from shelf 4.
You have taken 12 books so return 12.
It can be proven that 12 is the maximum number of books you can take.
Example 3:

Input: books = [8,2,3,7,3,4,0,1,4,3]
Output: 13
Explanation:
- Take 1 book from shelf 0.
- Take 2 books from shelf 1.
- Take 3 books from shelf 2.
- Take 7 books from shelf 3.
You have taken 13 books so return 13.
It can be proven that 13 is the maximum number of books you can take.


Constraints:

1 <= books.length <= 105
0 <= books[i] <= 105

https://leetcode.com/problems/maximum-number-of-books-you-can-take/description
 */
package dp;

import java.util.Stack;

public class MaxNumberOfBooks {
    public static void main(String[] args) {

    }
    public static long maximumBooks(int[] books) {
        int N = books.length;
        long[] maxEndingAt = new long[N]; // dp

        long res;
        maxEndingAt[0] = books[0];
        res = books[0];

        Stack<Integer> stack = new Stack<>();
        stack.push(0);

        for (int i = 1; i < N; ++i) {
            while (!stack.isEmpty()) {
                int j = stack.pop();
                if (books[j] < books[j] - i + j) {
                    break;
                }
            }

            int j =  stack.isEmpty() ? -1 : stack.peek();
            long maxEndingAtI = (j >= 0 ? maxEndingAt[j] : 0) +
                    triangularNumber(books[i]) - triangularNumber(books[i] - i + j);

            res = Math.max(res, maxEndingAtI);
            maxEndingAt[i] = maxEndingAtI;
            stack.push(i);
        }
        return res;




        //TODO: TLE
//        long res = 0;
//        long N = books.length;
//
//        for (int i = 0; i < N; ++i) {
//            int prevTaken = books[i];
//            int currMax = prevTaken;
//
//            for (int j = i - 1; j > -1; --j) {
//                int currTaken = Math.min(books[j], prevTaken-1);
//                if (currTaken < 1) break;
//
//                currMax += currTaken;
//                prevTaken = currTaken;
//            }
//            res = Math.max(res, currMax);
//        }
//        return res;
    }
    private static long triangularNumber(int n) {
        if (n <= 0) return 0;
        return n * (n + 1L) / 2;
    }
}
