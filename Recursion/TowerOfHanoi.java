/**Problem Description
 In the classic problem of the Towers of Hanoi, you have 3 towers numbered from 1 to 3 (left to right) and A disks numbered from 1 to A (top to bottom) of different sizes which can slide onto any tower.
 The puzzle starts with disks sorted in ascending order of size from top to bottom (i.e., each disk sits on top of an even larger one).
 You have the following constraints:
 Only one disk can be moved at a time.
 A disk is slid off the top of one tower onto another tower.
 A disk cannot be placed on top of a smaller disk.
 You have to find the solution to the Tower of Hanoi problem.
 You have to return a 2D array of dimensions M x 3, where M is the minimum number of moves needed to solve the problem.
 In each row, there should be 3 integers (disk, start, end), where:

 disk - number of disk being moved
 start - number of the tower from which the disk is being moved
 stop - number of the tower to which the disk is being moved


 Problem Constraints
 1 <= A <= 18


 Input Format
 The first argument is the integer A.


 Output Format
 Return a 2D array with dimensions M x 3 as mentioned above in the description.


 Example Input
 Input 1:
 A = 2
 Input 2:

 A = 3


 Example Output
 Output 1:
 [1 1 2 ] [2 1 3 ] [1 2 3 ]
 Output 2:

 [1 1 3 ] [2 1 2 ] [1 3 2 ] [3 1 3 ] [1 2 1 ] [2 2 3 ] [1 1 3 ]


 Example Explanation
 Explanation 1:
 We shift the first disk to the middle tower.
 We shift the second disk to the last tower.
 We, finally, shift the first disk from the middle tower to the last tower.
 Explanation 2:

 We can see that this the only unique path with minimal moves to move all disks from the first to the third tower.
 *
 */
package Recursion;

import java.util.ArrayList;
import java.util.Arrays;

public class TowerOfHanoi {
    static int currIdx;
    static int[][] res;
    public static ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
    public static void main(String[] args) {
        int A = 3;
        currIdx = 0;
        int mSize = (1 << A) -1;  // size of the Array will be 2^A - 1
        res = new int[mSize][3];

//        solve(A, 1, 3, 2);
//        System.out.println(ans);
        toh(A, 1, 3, 2);
        System.out.println(Arrays.deepToString(res));
    }
    public static void solve(int n, int start, int destination, int helper) {
        if (n == 0) return;
        solve(n-1, start, helper, destination);
        ArrayList<Integer> step = new ArrayList<>();
        step.add(n);
        step.add(start);
        step.add(destination);
        ans.add(step);
        solve(n-1, helper, destination, start);
    }
    public static void toh(int n, int start, int destination, int helper) {
        if (n == 0) return;
        toh(n-1, start, helper, destination);
        res[currIdx++] = new int[]{n, start, destination};
        toh(n-1, helper, start, destination);
    }
}
