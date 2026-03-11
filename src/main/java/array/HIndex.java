package array;

public class HIndex {

    public int hIndex(int[] C) {

        int n = C.length;
        int[] cnts = new int[n + 1];

        for (int c : C) {
            int cur = Math.min(c, n);
            cnts[cur]++;
        }

        int papers = 0;
        for (int i = n; i > -1; i--) {
            papers += cnts[i];

            if (papers >= i) {
                return i;
            }
        }

        return -1;
    }

}
