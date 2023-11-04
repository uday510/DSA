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
package DynamicProgramming;

public class MaxNumberOfBooks {
    public static void main(String[] args) {

    }
    public static long maximumBooks(int[] books) {

        // PASSED ONLY 42 TEST CASES
//        int N = books.length;
//        if (N == 1) return books[0];
//        long MAX = 0L;
//
//        long[] dp = new long[N];
//        if (books[1] > books[0]) {
//            dp[0] = (long) books[1] - 1;
//        }
//
//        for (int i = 1; i < N; ++i) {
//            int prevSelf = books[i-1];
//            int currSelf = books[i];
//
//            if (currSelf > prevSelf) {
//                dp[i] = dp[i - 1] + currSelf;
//            } else if (currSelf < prevSelf) {
//                dp[i] = currSelf + currSelf-1;
//            }
//            MAX = Math.max(dp[i], MAX);
//        }
//        return MAX;
        return 0L;
    }
}
