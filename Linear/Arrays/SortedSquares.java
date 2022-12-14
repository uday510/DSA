import java.util.Arrays;

public class SortedSquares {
 public static void main(String[] args) {
     int[] array = {1, 2, 3, 5, 6, 8, 9};
     System.out.println(Arrays.toString(solve(array)));
 }
    public static int[] solve(int[] array) {
     // O(n) time | O(n) space
     int smallerValueIdx = 0;
     int largerValueIdx = array.length - 1;
     int[] sortedSquares = new int[array.length];

     for(int idx = array.length - 1; idx > -1;) {
         int smallerValue = array[smallerValueIdx];
         int largerValue = array[largerValueIdx];
         if(Math.abs(smallerValue) > Math.abs(largerValue)) {
             sortedSquares[idx] = smallerValue * smallerValue;
             smallerValueIdx++;
         } else {
             sortedSquares[idx] = largerValue * largerValue;
             largerValueIdx--;
         }
         idx--;
     }
        return sortedSquares;
 }
}