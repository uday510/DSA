package Strings;

public class dummy {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 1};
        int b = 3;

        int ans = solve(arr, b);
        System.out.println(ans);

    }
    public static int solve(int[] array, int b) {
        int ans = 0;
        int len = array.length;
        int[] prefixSum  = new int[len];
        prefixSum[0] = array[0];

        for (int i = 1; i < len; i++) prefixSum[i] = prefixSum[i - 1] + array[i];

        for(int i = 0; i < len; i++) {
            for (int j = i; j < len; j++) {
                int currentSubArraySum = prefixSum[j];
                if (i > 0) currentSubArraySum -= prefixSum[i - 1];

                if (currentSubArraySum == b) ans++;
            }
        }
        return ans;
    }
}
