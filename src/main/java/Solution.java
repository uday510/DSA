public class Solution {


}

/**
 *
 *
 * position = [1, 2, 3, 4, 7], m = 3
 *
 *
 *
 * l = 1, r = 7
 *
 * m = (1+7)/2 = 4 -> not possible
 *
 * l = 1, r = 4
 * m = (1+4)/2 = 2 -> possible -> maximize it
 *
 * l = 3, r = 4
 * m = (3+4)/2 = 3 -> possible -> maximize it
 *
 * l = 4, r = 4
 * m = (4+4)/2 = 4 -> not possible -> l == r => return (l-1)
 *
 *
 * m = 3
 * balls = 1+1+1
 * pos = 7
 *
 *
 */
