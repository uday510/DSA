package array;

public class TwoSum {

    public static String twoSum(int[] array, int target) {
        java.util.Arrays.sort(array);
        int i = 0, j = array.length -1;

        while (i < j) {
            int curr = array[i] + array[j];

            if (curr == target) {
                return array[i] + "," + array[j];
            } else if (curr < target) {
                i++;
            } else {
                j--;
            }
        }
        return "";
    }
}
