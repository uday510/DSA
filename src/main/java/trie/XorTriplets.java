package trie;

public class XorTriplets {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3};

        int ans = solve(arr);
        System.out.println(ans);
    }
    public static int solve(int[] arr) {
        int res = 0;

        // O(N^2) time | O(N) space
        int n = arr.length + 1,  prefix[] = new int[n];
        for (int i = 1; i < n; ++i) {
            prefix[i] = arr[i-1] ^ prefix[i-1];
        }
        for (int i = 0; i < n; ++i) {
            for (int j = i+1; j < n; ++j) {
                if (prefix[i] == prefix[j]) {
                    res += j - i - 1;
                }
            }
        }
        return res;

        // O(N^4) time | O(1) space
        // int n = arr.length;
//        int ans = 0;
//        for (int i = 0; i < n; i++) {
//            for (int j = i+1; j < n; j++) {
//                for (int k = j; k < n; k++) {
//                    int xor1 = 0, xor2 = 0;
//
//                    for (int x = i; x <= j-1; x++) {
//                        xor1 ^= arr[x];
//                    }
//                    for (int x = j; x <= k; x++) {
//                        xor2 ^= arr[x];
//                    }
//                    if (xor1 == xor2) ans++;
//                }
//            }
//        }
//        return ans;
    }
}
