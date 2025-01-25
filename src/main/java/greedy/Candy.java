package greedy;

public class Candy {
    public static void main(String[] args) {
        int[] ratings = {5, 4, 3, 2, 1};

        int res = solve(ratings);
        System.out.println(res);
    }
    public static int solve(int[] ratings) {

        if (ratings.length == 0) return 0;
        int res = 1;
        int up = 0, down = 0, peak = 0;
        for (int i = 1; i < ratings.length; i++) {
            if (ratings[i - 1] < ratings[i]) {
                peak = ++up;
                down = 0;
                res += 1 + up;
            } else if (ratings[i - 1] == ratings[i]) {
                peak = up = down = 0;
                res += 1;
            } else {
                up = 0;
                ++down;
                res += down + (peak >= down ? 0: 1);
            }
        }

        return res;
        // O(N) time | O(N) space
//        int n = ratings.length;
//        int[] candies = new int[n];
//        Arrays.fill(candies, 1);
//        for (int i = 1; i < n; i++) {
//            if (ratings[i] > ratings[i-1]) {
//                candies[i] = candies[i-1] + 1;
//            }
//        }
//        int sum = candies[n - 1];
//        for (int i = candies.length - 2; i > -1; --i) {
//            if (ratings[i] > ratings[i + 1]) {
//                candies[i] = Math.max(candies[i], candies[i + 1] + 1);
//            }
//            sum += candies[i];
//        }
//        return sum;
    }
}
