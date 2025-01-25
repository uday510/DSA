package dynamicprogramming;

public class TwosKeyBoard {
    public static void main(String[] args) {
        System.out.println(minSteps(3));
    }
    public static int minSteps(int n) {

        return dfs(1, 0, n);
    }
    public static int dfs(int curr, int clip, int n) {
        if (curr > n) return n + 1;
        if (curr == n) return 0;

       int pasteOnly = n + 1;
        if (clip != 0) {
            pasteOnly = 1 + dfs(curr + clip, clip, n);
        }

        int copyPaste = 2 + dfs(curr + curr, curr, n);
        return Math.min(pasteOnly, copyPaste);
    }
}
