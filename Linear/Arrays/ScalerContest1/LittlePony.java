package ScalerContest1;

public class LittlePony {
    public static void main(String[] args) {
        int[] array = {2, 4, 3, 1, 5};
        int b = 3;
        int ans = solve(array, b);
        System.out.println(ans);
    }
    public static int solve(int[] A, int B) {
        int count = 0;
        boolean isPresent = false;

        for (int i = 0; i < A.length; i++) {
            int currentNum = A[i];
            if (currentNum > B )count++;
            else if (currentNum == B) {
                isPresent = true;

            }
        }
        if (!isPresent) return -1;
        return count;
    }
}
