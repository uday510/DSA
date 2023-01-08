import java.util.HashSet;

public class FirstDuplicateNumber {
    public static void main(String[] args) {
        int[] array = {2, 1, 5, 2, 3, 3, 4};

        System.out.println(solve(array));
    }
    public static int solve(int[] array) {
        // O(n) time | O(1) space
        for (int value: array) {
            int absValue = Math.abs(value);
            if(array[absValue - 1] < 0) return  absValue;
            array[absValue - 1] *= -1;
        }
        return -1;
    }
    public static int solveUsingHashSet(int[] array) {
        // O(n) time | O(n) space
        HashSet<Integer> seen = new HashSet<>();
        for (int value: array) {
            if (seen.contains(value)) return value;
            seen.add(value);
        }
        return -1;
    }
}
