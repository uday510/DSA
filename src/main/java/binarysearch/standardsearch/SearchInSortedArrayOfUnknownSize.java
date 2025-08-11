package binarysearch.standardsearch;

public class SearchInSortedArrayOfUnknownSize {

    // https://leetcode.com/problems/search-in-a-sorted-array-of-unknown-size/description/?envType=study-plan-v2&envId=binary-search
//    public int search(ArrayReader reader, int target) {
//        if (reader.get(0) == target) return 0;
//
//        int l = 0, r = 1;
//
//        while (reader.get(r) < target) {
//            l = r;
//            r <<= 1;
//        }
//
//        while (l < r) {
//            int m = (l + r) >> 1;
//            int curr = reader.get(m);
//            if (curr == target) return m;
//            if (curr < target) l = m + 1;
//            else r = m;
//        }
//
//        return reader.get(l) == target ? l : -1;
//    }

}
