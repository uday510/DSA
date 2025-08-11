package binarysearch.tricky;

public class HIndex2 {

    public int hIndex(int[] citations) {
        int l = 0, r = citations.length;
        int n = citations.length;

        while (l < r) {
            int m = (l + r ) >> 1;

            int h = n - m;
            if (citations[m] < h) l = m + 1;
            else r = m;
        }

        return n - l;
    }

}
