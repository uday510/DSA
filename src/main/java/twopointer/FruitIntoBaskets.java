/*
You are visiting a farm that has a single row of fruit trees arranged from left to right. The trees are represented by an integer array fruits where fruits[i] is the type of fruit the ith tree produces.

You want to collect as much fruit as possible. However, the owner has some strict rules that you must follow:

You only have two baskets, and each basket can only hold a single type of fruit. There is no limit on the amount of fruit each basket can hold.
Starting from any tree of your choice, you must pick exactly one fruit from every tree (including the start tree) while moving to the right. The picked fruits must fit in one of your baskets.
Once you reach a tree with fruit that cannot fit in your baskets, you must stop.
Given the integer array fruits, return the maximum number of fruits you can pick.



Example 1:

Input: fruits = [1,2,1]
Output: 3
Explanation: We can pick from all 3 trees.
Example 2:

Input: fruits = [0,1,2,2]
Output: 3
Explanation: We can pick from trees [1,2,2].
If we had started at the first tree, we would only pick from trees [0,1].
Example 3:

Input: fruits = [1,2,3,2,2]
Output: 4
Explanation: We can pick from trees [2,3,2,2].
If we had started at the first tree, we would only pick from trees [1,2].


Constraints:

1 <= fruits.length <= 105
0 <= fruits[i] < fruits.length
 */
package twopointer;

import java.util.HashMap;
import java.util.Map;

public class FruitIntoBaskets {
    public static void main(String[] args) {
        int[] fruits = {1,2,3,2,2};
        System.out.println(totalFruit(fruits));
    }
    public static int totalFruit(int[] fruits) {



        // -- SLIDING WINDOW --
        // O(N) time | O(N) space
        // 1. We will use a sliding window to keep track of the fruits we have picked
        // 2. We will use a hashmap to keep track of the fruits we have picked
        // 3. We will use a left and right pointer to keep track of the window
        // 4. We will use a maxPicked variable to keep track of the max fruits we have picked
        // 5. We will use a while loop to iterate through the fruits array

        int left = 0, maxPicked = 0;
        Map<Integer, Integer> basket = new HashMap<>();

        for (int right = 0; right < fruits.length; ++right) {
            basket.put(fruits[right], basket.getOrDefault(fruits[right], 0) + 1);

            // If the basket size is greater than 2, we need to remove the left most fruit
            // and increment the left pointer
            // We will keep doing this until the basket size is 2

            while (basket.size() > 2) {
                basket.put(fruits[left], basket.get(fruits[left]) - 1);
                basket.remove(fruits[left], 0);
                ++left;
            }

            // We will update the maxPicked variable with the max of the current maxPicked
            // and the difference between the right and left pointer
            maxPicked = Math.max(maxPicked, right - left + 1);
        }
        return maxPicked;

        // O(N^2) time | O(N) space
//        for (int left = 0; left < fruits.length; ++left) {
//
//            Set<Integer> basket = new HashSet<>();
//            int right = left;
//
//            while (right < fruits.length) {
//
//                int fruit = fruits[right];
//
//                if (!basket.contains(fruit) && basket.size() == 2) {
//                    break;
//                }
//
//                basket.add(fruit);
//                ++right;
//            }
//            maxPicked = Math.max(maxPicked, right - left);
//        }
//  return maxPicked;
        // -- BRUTE FORCE --
        // O(N^3) time| O(N) space
//        for (int left = 0; left < fruits.length; ++left) {
//            for (int right = 0; right < fruits.length; ++right) {
//                Set<Integer> basket = new HashSet<>();
//
//                for (int i = left; i <= right; ++i) {
//                    basket.add(fruits[i]);
//                }
//
//                if (basket.size() <= 2) {
//                    maxPicked = Math.max(maxPicked, right - left + 1);
//                }
//            }
//        }
//  return maxPicked;
    }
}
