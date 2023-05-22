/**
 * Problem Description
 * Given an array of integers A.
 *
 * The value of an array is computed as the difference between the maximum element in the array and the minimum element in the array A.
 *
 * Calculate and return the sum of values of all possible subarrays of A modulo 109+7.
 *
 *
 *
 * Problem Constraints
 * 1 <= |A| <= 100000
 *
 * 1 <= A[i] <= 1000000
 *
 *
 *
 * Input Format
 * The first and only argument given is the integer array A.
 *
 *
 *
 * Output Format
 * Return the sum of values of all possible subarrays of A modulo 109+7.
 *
 *
 *
 * Example Input
 * Input 1:
 *
 *  A = [1]
 * Input 2:
 *
 *  A = [4, 7, 3, 8]
 *
 *
 * Example Output
 * Output 1:
 *
 *  0
 * Output 2:
 *
 *  26
 *
 *
 * Example Explanation
 * Explanation 1:
 *
 * Only 1 subarray exists. Its value is 0.
 * Explanation 2:
 *
 * value ( [4] ) = 4 - 4 = 0
 * value ( [7] ) = 7 - 7 = 0
 * value ( [3] ) = 3 - 3 = 0
 * value ( [8] ) = 8 - 8 = 0
 * value ( [4, 7] ) = 7 - 4 = 3
 * value ( [7, 3] ) = 7 - 3 = 4
 * value ( [3, 8] ) = 8 - 3 = 5
 * value ( [4, 7, 3] ) = 7 - 3 = 4
 * value ( [7, 3, 8] ) = 8 - 3 = 5
 * value ( [4, 7, 3, 8] ) = 8 - 3 = 5
 * sum of values % 10^9+7 = 26
 */
package Linear.Stacks;

import java.util.Arrays;
import java.util.Stack;

public class MaxAndMin {
    public static int mod = (int) 1e9 + 7;
    public static void main(String[] args) {
        int[] array = {4, 7, 3, 8};

        int ans = solve(array);
        System.out.println(ans);
    }
    public static int solve(int[] array) {
        // Solution having some logic error
            int NSEL[] = getNSEL(array);
            int NSER[] = getNSER(array);
            int NLEL[] = getNLEL(array);
            int NLER[] = getNLER(array);

            long sum = 0;
            for(int i = 0;i<array.length;i++) {
                long max = 1L*( NLER[i] - i + 1 ) * ( i - NLEL[i] + 1);
                long min = 1L*( NSER[i] -i + 1) *(i - NSEL[i] + 1);
                long s = (long) (max - min) * (long) array[i];
                sum =  (sum %mod +  s%mod)%mod;
            }
            return (int)((sum + mod)%mod);
    }
    public static int[] getNSEL(int arr[]) {
        int n = arr.length;
        int res[] = new int[n];
        Stack<Integer> st = new Stack<>();

        for(int i= 0;i<n;i++) {
            while(!st.isEmpty() && arr[st.peek()] >= arr[i]) {
                st.pop();
            }
            if(st.isEmpty()) {
                res[i] = 0;
            } else {
                res[i] = st.peek() + 1;
            }
            st.push(i);
        }
        return res;
    }

    public static int[] getNSER(int arr[]) {
        int n = arr.length;
        int res[] = new int[n];
        Stack<Integer> st = new Stack<>();

        for(int i= n-1;i>=0;i--) {
            while(!st.isEmpty() && arr[st.peek()] >= arr[i]) {
                st.pop();
            }
            if(st.isEmpty()) {
                res[i] = n-1;
            } else {
                res[i] = st.peek() - 1;
            }
            st.push(i);
        }
        return res;
    }

    public static int[] getNLEL(int arr[]) {
        int n = arr.length;
        int res[] = new int[n];
        Stack<Integer> st = new Stack<>();

        for(int i= 0;i<n;i++) {
            while(!st.isEmpty() && arr[st.peek()] <= arr[i]) {
                st.pop();
            }
            if(st.isEmpty()) {
                res[i] = 0;
            } else {
                res[i] = st.peek() + 1;
            }
            st.push(i);
        }
        return res;
    }

    public static int[] getNLER(int arr[]) {
        int n = arr.length;
        int res[] = new int[n];
        Stack<Integer> st = new Stack<>();

        for(int i= n-1;i>=0;i--) {
            while(!st.isEmpty() && arr[st.peek()] <= arr[i]) {
                st.pop();
            }
            if(st.isEmpty()) {
                res[i] = n-1;
            } else {
                res[i] = st.peek() - 1;
            }
            st.push(i);
        }
        return res;
    }


}
