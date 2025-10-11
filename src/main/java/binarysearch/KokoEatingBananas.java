/**
 * Koko loves to eat bananas. There are n piles of bananas, the ith pile has piles[i] bananas. The guards have gone and will come back in h hours.
 *
 * Koko can decide her bananas-per-hour eating speed of k. Each hour, she chooses some pile of bananas and eats k bananas from that pile. If the pile has less than k bananas, she eats all of them instead and will not eat any more bananas during this hour.
 *
 * Koko likes to eat slowly but still wants to finish eating all the bananas before the guards return.
 *
 * Return the minimum integer k such that she can eat all the bananas within h hours.
 *
 *
 *
 * Example 1:
 *
 * Input: piles = [3,6,7,11], h = 8
 * Output: 4
 * Example 2:
 *
 * Input: piles = [30,11,23,4,20], h = 5
 * Output: 30
 * Example 3:
 *
 * Input: piles = [30,11,23,4,20], h = 6
 * Output: 23
 *
 *
 * Constraints:
 *
 * 1 <= piles.length <= 104
 * piles.length <= h <= 109
 * 1 <= piles[i] <= 109
 */
package binarysearch;

import java.util.Arrays;

public class KokoEatingBananas {
    public static void main(String[] args) {
        int[] piles = {30,11,23,4,20};

        int ans = solve(piles, 6);
        System.out.println(ans);
    }
    public static int solve(int[] piles, int h) {

       int res;
       res = minEatingSpeed(piles, h); // binary search
       return res;
    }

    public static int minEatingSpeed(int[] piles, int h) {
        int left = 1;
        int right = Arrays.stream(piles).max().getAsInt();

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (timeToEat(piles, mid) <= h) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
    public static int timeToEat(int[] piles, int speed) {
        int time = 0;
        for (int pile : piles) {
            time += (int) Math.ceil((double) pile / speed);
        }
        return time;
    }

//    public static int minEatingSpeed(int[] piles, int h) {
//        // initialize the left and right boundaries
//        int left = 1,
//            right = Arrays.stream(piles).max().getAsInt(),
//                res = (int) 1e9;
//
//        while (right > left) {
//            // Get the middle index between left and right boundary indexes.
//            // hourSpent stands for the total hour koko spends.
//            int middle = left + (right - left)/ 2;
//            int hourSpent = 0;
//
//            // iterate over the piles and calculate hourSpent
//            // We increase the hourSpent by ceil(pile/middle)
//
//            for (int pile : piles) {
//                hourSpent += (int) Math.ceil((double) pile / middle);
//            }
//
//            // Check if middle is workable speed, and cut the search by half.
//            if (hourSpent <= h) {
//                res = middle;
//                right = middle-1;
//            } else {
//                left = middle + 1;
//            }
//        }
//        //Once the left and right boundaries coincide, we find the target value,
//        // that is, the minimum workable eating speed.
//        return res;
//    }
//    public static int bruteForce(int[] piles, int h) {
//        // Start at an eating speed of 1.
//        int speed = 1;
//
//        while (true) {
//            // hourSpent stands for the total hour koko spends with
//            // the given eating speed.
//            int hourSpent = 0;
//
//            // Iterate over the piles and calculate hourSpent
//            // We increase the hourSpent by ceil(pile / speed)
//            for (int pile : piles) {
//                hourSpent += Math.ceil((double) pile / speed);
//                if (hourSpent > h) {
//                    break;
//                }
//            }
//
//            // Check if Koko can finish all the piles within h hours,
//            // If so, return speed. Otherwise, let speed increment by
//            // 1 and repeat the previous iteration.
//            if (hourSpent <= h) {
//                return speed;
//            } else {
//                speed += 1;
//            }
//        }
//    }
}
