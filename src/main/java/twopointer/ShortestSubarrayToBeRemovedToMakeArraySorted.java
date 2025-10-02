package twopointer;

public class ShortestSubarrayToBeRemovedToMakeArraySorted {

    public int findLengthOfShortestSubarray(int[] arr) {
        int n = arr.length, r = n - 1;

        while (r > 0 && arr[r] >= arr[r - 1]) r--;

        int res = r, l = 0;

        while (l < r && (l == 0 || arr[l] >= arr[l - 1])) {

            while (r < n && arr[l] > arr[r]) r++;

            res = Math.min(res, r - l - 1);

            l++;
        }

        return res;
    }

}
