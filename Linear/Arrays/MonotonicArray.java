public class MonotonicArray {
    public static void main(String[] args) {
        int[] array = {-1, -5, -10, -1100, -1100, -1101, -1102, -9001};

        System.out.println(solve(array));
    }
    public static boolean solve(int[] array) {
        // O(n) time | O(1) space
        boolean isNonDecreasing = true;
        boolean isNonIncreasing = true;
        for(int i = 1; i < array.length; i++) {
            if(array[i] < array[i - 1]) isNonDecreasing = false;
            if(array[i] > array[i - 1]) isNonIncreasing = false;
        }
        return isNonDecreasing || isNonIncreasing;
    }
}
