package ScalerContest1;

public class HighestProduct {
    public static void main(String[] args) {
        int[] arr = {-65, 41, 15, -11, 69, 23, -63
        -4, 49, -99, -61, 17, -61};
        int[] arr1 = {-10000000, 1, 2, 4, 3};
        int[] arr2 = {1, -1, 0};
        int ans = solve(arr2);
        System.out.println(ans);
    }
    public static int solve (int[] arr) {
        if (arr.length == 3) return arr[0] * arr[1] * arr[2];
        int firstMax = arr[0];
        int secondMax = arr[0];
        int thirdMax = arr[0];
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            int currentNum = arr[i];
            if (currentNum > firstMax) {
                thirdMax = secondMax;
                secondMax = firstMax;
                firstMax = currentNum;
            } else if (currentNum > secondMax)  {
                thirdMax = secondMax;
                secondMax = currentNum;
            } else if (currentNum > thirdMax) {
                thirdMax = currentNum;
            }
        }
        System.out.println(thirdMax + "," + secondMax + "," + firstMax);
        return firstMax * secondMax * thirdMax;
    }
}
