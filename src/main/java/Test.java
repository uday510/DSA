import java.util.*;


public class Test {

}

/**
 *
 * Given a string paragraph and a string array of the banned words banned, return the most frequent word that is not banned.
 * It is guaranteed there is at least one word that is not banned, and that the answer is unique.
 *
 * The words in paragraph are case-insensitive and the answer should be returned in lowercase.
 *
 *
 *
 * Example 1:
 *
 * Input: paragraph = "Bob hit a ball, the hit BALL flew far after it was hit.", banned = ["hit"]
 * Output: "ball"
 * Explanation:
 * "hit" occurs 3 times, but it is a banned word.
 * "ball" occurs twice (and no other word does), so it is the most frequent non-banned word in the paragraph.
 * Note that words in the paragraph are not case sensitive,
 * that punctuation is ignored (even if adjacent to words, such as "ball,"),
 * and that "hit" isn't the answer even though it occurs more because it is banned.
 * Example 2:
 *
 * Input: paragraph = "a.", banned = []
 * Output: "a"
 *
 *
 * Constraints:
 *
 * 1 <= paragraph.length <= 1000
 * paragraph consists of English letters, space ' ', or one of the symbols: "!?',;.".
 * 0 <= banned.length <= 100
 * 1 <= banned[i].length <= 10
 * banned[i] consists of only lowercase English letters.
 *
 */


/**
 *
 *
 *
 *You are asked to cut off all the trees in a forest for a golf event. The forest is represented as an m x n matrix. In this matrix:
 *
 * 0 means the cell cannot be walked through.
 * 1 represents an empty cell that can be walked through.
 * A number greater than 1 represents a tree in a cell that can be walked through, and this number is the tree's height.
 * In one step, you can walk in any of the four directions: north, east, south, and west. If you are standing in a cell with a tree, you can choose whether to cut it off.
 *
 * You must cut off the trees in order from shortest to tallest. When you cut off a tree, the value at its cell becomes 1 (an empty cell).
 *
 * Starting from the point (0, 0), return the minimum steps you need to walk to cut off all the trees. If you cannot cut off all the trees, return -1.
 *
 * Note: The input is generated such that no two trees have the same height, and there is at least one tree needs to be cut off.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: forest = [[1,2,3],[0,0,4],[7,6,5]]
 * Output: 6
 * Explanation: Following the path above allows you to cut off the trees from shortest to tallest in 6 steps.
 * Example 2:
 *
 *
 * Input: forest = [[1,2,3],[0,0,0],[7,6,5]]
 * Output: -1
 * Explanation: The trees in the bottom row cannot be accessed as the middle row is blocked.
 * Example 3:
 *
 * Input: forest = [[2,3,4],[0,0,5],[8,7,6]]
 * Output: 6
 * Explanation: You can follow the same path as Example 1 to cut off all the trees.
 * Note that you can cut off the first tree at (0, 0) before making any steps.
 *
 *
 * Constraints:
 *
 * m == forest.length
 * n == forest[i].length
 * 1 <= m, n <= 50
 * 0 <= forest[i][j] <= 109
 * Heights of all trees are distinct.
 *
 *
 *https://leetcode.com/problems/cut-off-trees-for-golf-event/
 */