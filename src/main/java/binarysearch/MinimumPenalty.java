/*
You are given the customer visit log of a shop represented by a 0-indexed string customers consisting only of characters 'N' and 'Y':

if the ith character is 'Y', it means that customers come at the ith hour
whereas 'N' indicates that no customers come at the ith hour.
If the shop closes at the jth hour (0 <= j <= n), the penalty is calculated as follows:

For every hour when the shop is open and no customers come, the penalty increases by 1.
For every hour when the shop is closed and customers come, the penalty increases by 1.
Return the earliest hour at which the shop must be closed to incur a minimum penalty.

Note that if a shop closes at the jth hour, it means the shop is closed at the hour j.



Example 1:

Input: customers = "YYNY"
Output: 2
Explanation:
- Closing the shop at the 0th hour incurs in 1+1+0+1 = 3 penalty.
- Closing the shop at the 1st hour incurs in 0+1+0+1 = 2 penalty.
- Closing the shop at the 2nd hour incurs in 0+0+0+1 = 1 penalty.
- Closing the shop at the 3rd hour incurs in 0+0+1+1 = 2 penalty.
- Closing the shop at the 4th hour incurs in 0+0+1+0 = 1 penalty.
Closing the shop at 2nd or 4th hour gives a minimum penalty. Since 2 is earlier, the optimal closing time is 2.
Example 2:

Input: customers = "NNNNN"
Output: 0
Explanation: It is best to close the shop at the 0th hour as no customers arrive.
Example 3:

Input: customers = "YYYY"
Output: 4
Explanation: It is best to close the shop at the 4th hour as customers arrive at each hour.


Constraints:

1 <= customers.length <= 105
customers consists only of characters 'Y' and 'N'.
 */
package binarysearch;

public class MinimumPenalty {
    public static void main(String[] args) {
        String customers = "YYNY";

        System.out.println(bestClosingTime(customers));

    }

    public static int bestClosingTime(String customers) {
        int minPenalty = Integer.MAX_VALUE;
        int bestHour = 0;

//        for (int hour = 0; hour <= customers.length(); ++hour) {
//
//            int currPenalty = getPenalty(customers, hour);
//
//            if (minPenalty > currPenalty) {
//                bestHour = hour;
//                minPenalty = currPenalty;
//            }
//        }
        int i = 0, j = customers.length() - 1;

        while (i <= j) {

            int hour = (i + j) / 2;

            int currPenalty = getPenalty(customers, hour);

            if (minPenalty > currPenalty) {
                bestHour = hour;
                minPenalty = currPenalty;
                j = hour - 1;
            } else {
                i = hour + 1;
            }
        }
        return bestHour;

    }
    public static int getPenalty(String customers, int hour) {
        int penalty = 0;

        for (int i = 0; i < customers.length(); ++i) {
            boolean customerCame = customers.charAt(i) == 'Y';
            boolean shopClosed = i >= hour;

            if (customerCame && shopClosed) {
                penalty++;
            } else if (!customerCame && !shopClosed) {
                penalty++;
            }
        }
        return penalty;
    }
}
