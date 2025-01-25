/*
You have n computers. You are given the integer n and a 0-indexed integer array batteries where the ith battery can run a computer for batteries[i] minutes. You are interested in running all n computers simultaneously using the given batteries.

Initially, you can insert at most one battery into each computer. After that and at any integer time moment, you can remove a battery from a computer and insert another battery any number of times. The inserted battery can be a totally new battery or a battery from another computer. You may assume that the removing and inserting processes take no time.

Note that the batteries cannot be recharged.

Return the maximum number of minutes you can run all the n computers simultaneously.

Input: n = 2, batteries = [3,3,3]
Output: 4
Explanation:
Initially, insert battery 0 into the first computer and battery 1 into the second computer.
After two minutes, remove battery 1 from the second computer and insert battery 2 instead. Note that battery 1 can still run for one minute.
At the end of the third minute, battery 0 is drained, and you need to remove it from the first computer and insert battery 1 instead.
By the end of the fourth minute, battery 1 is also drained, and the first computer is no longer running.
We can run the two computers simultaneously for at most 4 minutes, so we return 4.

Input: n = 2, batteries = [1,1,1,1]
Output: 2
Explanation:
Initially, insert battery 0 into the first computer and battery 2 into the second computer.
After one minute, battery 0 and battery 2 are drained so you need to remove them and insert battery 1 into the first computer and battery 3 into the second computer.
After another minute, battery 1 and battery 3 are also drained so the first and second computers are no longer running.
We can run the two computers simultaneously for at most 2 minutes, so we return 2.


Constraints:

1 <= n <= batteries.length <= 105
1 <= batteries[i] <= 109

 */
package binarysearch;

public class MaximumRunningTimeOfNComputers {
    public static void main(String[] args) {
        int n = 2;
        int[] batteries = {3, 3, 3};
        System.out.println(maxTime(n, batteries));
    }
    public static long maxTime(int n, int[] batteries) {
        long left = 0, right = 0; // left and right boundary

        for (int battery : batteries) { // find the maximum battery life
            right += battery;
        }

        for (; right > left; ) { // binary search
            long mid = left + (right - left + 1) / 2; // mid is the maximum running time

            if (canRunAll(n, batteries, mid)) { // if we can run all n computers for mid minutes
                left = mid;  // then we can run all n computers for mid + 1 minutes
            } else {
                right = mid - 1; // then we can run all n computers for mid - 1 minutes
            }
        }
        return left; // return left boundary as the answer since we want to maximize the running time
    }
     public static boolean canRunAll(int n, int[] batteries, long time) {
        long count = 0; // count how many batteries can run for time minutes

        for (int battery : batteries) { // count how many batteries can run for time minutes
            count += Math.min(battery, time); // if battery > time, then it can only run for time minutes
        }
        return count >= time * n; // if count >= time * n, then we can run all n computers for time minutes
     }
}
