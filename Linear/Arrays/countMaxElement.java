public class countMaxElement {
    public static void main(String[] args) {
        int[] array = {-1, 2, 3, -1, 0, 10, 12, 10, 40};
        System.out.println(solve(array));
    }
    public static int solve(int[] array) {
        int maxElement = Integer.MIN_VALUE;
        int maxElementCount = 0;

        // Find Max
        for (var num: array) {
            maxElement = Math.max(num, maxElement);
        }

        //Find count of max elements
        for (var num: array) {
            if (num == maxElement) maxElementCount++;
        }
        return array.length - maxElementCount;
    }
}
