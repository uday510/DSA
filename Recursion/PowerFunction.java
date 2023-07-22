/*
Implement pow(x, n), which calculates x raised to the power n (i.e., xn).



Example 1:

Input: x = 2.00000, n = 10
Output: 1024.00000
Example 2:

Input: x = 2.10000, n = 3
Output: 9.26100
Example 3:

Input: x = 2.00000, n = -2
Output: 0.25000
Explanation: 2-2 = 1/22 = 1/4 = 0.25


Constraints:

-100.0 < x < 100.0
-231 <= n <= 231-1
n is an integer.
Either x is not zero or n > 0.
-104 <= xn <= 104

 */
package Recursion;

public class PowerFunction {
    public static void main(String[] args) {
        System.out.println(myPow(2.00000, -2147483648));
    }
    public static double myPow(double x, long n) {
        if (n == 0) return 1;
        if (n == 1) return x;

        if (n < 0) {
            x = 1/x;
            n = -n;
        }
//
//        double temp = myPow(x, n/2);
//        if (n % 2 == 0) {
//            return temp * temp;
//        } else {
//            return temp * temp * x;
//        }

        double res = 1;

        while (n != 0) {
            if (n % 2 == 1) {
                res *= x;
                n -= 1;
            }
            x *= x;
            n = n / 2;
        }
        return res;
    }
}
