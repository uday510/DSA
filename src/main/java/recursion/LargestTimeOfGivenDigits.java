package recursion;

public class LargestTimeOfGivenDigits {

    int[] arr;
    int n;
    int mins;
    public String largestTimeFromDigits(int[] arr) {
        this.arr = arr;
        mins = -1;
        n = arr.length;

        dfs(0);

        if (mins == -1) return "";

        return String.format("%02d:%02d", mins / 60, mins % 60);
    }

    private void dfs(int i) {
        if (i >= n) {
            buildTime();
            return;
        }

        for (int j = i; j < n; j++) {
            swap(i, j);
            dfs(i + 1);
            swap(i, j);
        }
    }

    private void swap(int i, int j) {
        int tmp = arr[j];
        arr[j] = arr[i];
        arr[i] = tmp;
    }

    private void buildTime() {
        int h = arr[0] * 10 + arr[1];
        int m = arr[2] * 10 + arr[3];

        if (h < 24 && m < 60) {
            mins = Math.max(mins, h * 60 + m);
        }
    }

}
