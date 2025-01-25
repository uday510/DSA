/**
 * Problem Description
 * Given an array, A of integers of size N. Find the subarray AL, AL+1, AL+2, ... AR with 1<=L<=R<=N, which has maximum XOR value.
 *
 * NOTE: If there are multiple subarrays with the same maximum value, return the subarray with minimum length. If the length is the same, return the subarray with the minimum starting index.
 *
 *
 *
 * Problem Constraints
 * 1 <= N <= 100000
 * 0 <= A[i] <= 109
 *
 *
 *
 * Input Format
 * First and only argument is an integer array A.
 *
 *
 *
 * Output Format
 * Return an integer array B of size 2. B[0] is the starting index(1-based) of the subarray and B[1] is the ending index(1-based) of the subarray.
 *
 *
 *
 * Example Input
 * Input 1:
 *
 *  A = [1, 4, 3]
 * Input 2:
 *
 *  A = [8]
 *
 *
 * Example Output
 * Output 1:
 *
 *  [2, 3]
 * Output 2:
 *
 *  [1, 1]
 *
 *
 * Example Explanation
 * Explanation 1:
 *
 *  There are 6 possible subarrays of A:
 *  subarray            XOR value
 *  [1]                     1
 *  [4]                     4
 *  [3]                     3
 *  [1, 4]                  5 (1^4)
 *  [4, 3]                  7 (4^3)
 *  [1, 4, 3]               6 (1^4^3)
 *
 *  [4, 3] subarray has maximum XOR value. So, return [2, 3].
 * Explanation 2:
 *
 *  There is only one element in the array. So, the maximum XOR value is equal to 8 and the only possible subarray is [1, 1].
 */
package array;

import java.util.Arrays;

public class MaximumXORSubarray {
    public static void main(String[] args) {
        int[] arr = {28,31,13,22,17,22};

        int[] ans = solve(arr);
        System.out.println(Arrays.toString(ans));
    }
    public static int[] solve(int[] A) {
        TrieNode root = new TrieNode();
        int maxNum = A[0];
        for(int num : A) maxNum = Math.max(maxNum, num);
        int L = Integer.toBinaryString(maxNum).length();

        int[] pf = new int[A.length + 1];
        pf[0] = 0;

        for (int i = 0; i < A.length; i++) {
            pf[i+1] = pf[i] ^ A[i];
        }

        for (int i = 0; i < pf.length; i++) {
            int num = pf[i];
            TrieNode currNode = root;
            for (int j = L-1; j > -1; j--) {
                if ((num & 1 << j) == 0) {
                    if (currNode.children[0] == null) {
                        currNode.children[0] = new TrieNode();
                    }
                    currNode = currNode.children[0];
                } else {
                    if (currNode.children[1] == null) {
                        currNode.children[1] = new TrieNode();
                    }
                    currNode = currNode.children[1];
                }
            }
            if(currNode.end == -1) {
                currNode.end = i;
            }
        }

        int max = 0, start = -1, end = -1;
        for (int i = 0; i < pf.length; i++) {
            int num = pf[i];

            int xor = 0;
            TrieNode currNode = root;

            for (int j = L-1; j > -1; j--) {
                if ((num & (1 << j)) == 0) {
                    if (currNode.children[1] != null) {
                        // set jth bit in xor value
                        xor = (xor | (1 << j));
                        currNode = currNode.children[1];
                    } else {
                        currNode = currNode.children[0];
                    }
                } else {
                    if (currNode.children[0] != null) {
                        // set jth bit in xor value
                        xor = (xor | (1 << j));
                        currNode = currNode.children[0];
                    } else {
                        currNode = currNode.children[1];
                    }
                }
            }
            if (xor > max) {
                max = xor;
                start = i + 1;
                end = currNode.end;
            } else if(xor == max && currNode.end > i) {
                int prev = end - start + 1;
                int curr = currNode.end - i;
                if(curr < prev) {
                    start = i + 1;
                    end = currNode.end;
                }
            }
        }
        return new int[]{start, end};
    }
}
class TrieNode {
    TrieNode[] children;
    int end = -1;
    TrieNode() { this.children = new TrieNode[2]; }
}
