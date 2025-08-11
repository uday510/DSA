package binarysearch.standardsearch;

public class FirstBadVersion {

    public int firstBadVersion(int n) {
        int l = 1;
        int r = n;

        while (l < r) {
            int m = (l + r) >>> 1;
//            if (!isBadVersion(m)) l = m + 1;
//            else r = m;
        }

        return l;
    }

}
