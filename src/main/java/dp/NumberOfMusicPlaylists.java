/*
Your music player contains n different songs. You want to listen to goal songs (not necessarily different) during your trip. To avoid boredom, you will create a playlist so that:

Every song is played at least once.
A song can only be played again only if k other songs have been played.
Given n, goal, and k, return the number of possible playlists that you can create. Since the answer can be very large, return it modulo 109 + 7.



Example 1:

Input: n = 3, goal = 3, k = 1
Output: 6
Explanation: There are 6 possible playlists: [1, 2, 3], [1, 3, 2], [2, 1, 3], [2, 3, 1], [3, 1, 2], and [3, 2, 1].
Example 2:

Input: n = 2, goal = 3, k = 0
Output: 6
Explanation: There are 6 possible playlists: [1, 1, 2], [1, 2, 1], [2, 1, 1], [2, 2, 1], [2, 1, 2], and [1, 2, 2].
Example 3:

Input: n = 2, goal = 3, k = 1
Output: 2
Explanation: There are 2 possible playlists: [1, 2, 1] and [2, 1, 2].


Constraints:

0 <= k < n <= goal <= 100

 */
package dp;

public class NumberOfMusicPlaylists {
    private static final int MOD = (int) (1e9 + 7);
    public static void main(String[] args) {
        int n = 2, goal = 3, k = 0;
        System.out.println(numMusicPlaylists(n, goal, k));
    }
    public static int numMusicPlaylists(int n, int goal, int k) {
        // dp[i][j] = number of playlists of length i that have exactly j unique songs
        // dp[i][j] = dp[i - 1][j - 1] * (n - j + 1) // if we add a new song
        // dp[i][j] += dp[i - 1][j] * (j - k) // if we add a song that we have already seen

        // O(goal * n) time | O(goal * n) space

//        Long[][] dp = new Long[goal + 1][n + 1];
//        dp[0][0] = 1L; // 0 songs in playlist, 0 songs in library , empty playlist
//
//        numMusicPlaylists(goal, n, k, n, dp);
//
//
//        return Math.toIntExact(dp[goal][n]);

       long[] dp = new long[n + 1];
       dp[0] = 1L;

       for (int i = 1; i <= goal; i++) {
           long[] next = new long[n + 1];
           for (int j = 1; j <= n; j++) {
               next[j] = dp[j - 1] * (n - j + 1) % MOD;
               if (j > k) {
                   next[j] += dp[j] * (j - k) % MOD;
               }
               next[j] %= MOD;
           }
           dp = next;
       }
         return Math.toIntExact(dp[n]);
    }
    public static int numMusicPlaylists(int i, int j, int k, int n, Long[][] dp) {
        if (i == 0 && j == 0) {
            return 1; // empty playlist
        }
        if (i == 0 || j == 0) {
            return 0; // empty library
        }

        if (dp[i][j] != null) {
            return Math.toIntExact(dp[i][j]);
        }

        // if we add a new song
        dp[i][j] = ((long) numMusicPlaylists(i - 1, j - 1, k, n, dp) * (n - j + 1)) % MOD;

        // if we add a song that we have already seen, we have j - k songs to choose from
        if (i > k) {
            dp[i][j] += ((long) numMusicPlaylists(i - 1, j, k , n, dp) * (j - k)) % MOD;
            dp[i][j] %= MOD;
        }

        return Math.toIntExact(dp[i][j]);
    }
}
