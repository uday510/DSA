package ScalerContest.Contest2;

public class ConstructBinaryTree {
    public static void main(String[] args) {
        int a = 3, b = 2;

        int ans = solve(a, b);
        System.out.println(ans);
    }
    public static int solve(int a, int b) {
        // O(c - b) time | O(1) space
        int c = a + b;
        int ans = 0;

        for (int i = c - 1; i >= b; i--) {
            ans |= 1 << i;
        }
        return ans;
    }
}
