package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ReverseArray {
    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5};
        List<List<Integer>> arrayList = new ArrayList<>();
        arrayList.add(Arrays.asList(1, 2, 3, 4, 5, 6));
        reverseArray(array);
        reverse(arrayList);

    }
    public static void reverseArray(int[] array) {
        // O(n) time | O(1) space
      int start = 0;
      int end = array.length - 1;
      int midIdx = (int) Math.floor(start - (end - start) / 2);
      while(start < midIdx) {
          swap(start, end, array);
          start++;
          end--;
      }
  }
    public static void swap(int i, int j, int [] array) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
  }

  public static void reverse(List<List<Integer>> array) {
      System.out.println(array);
//        int start = 0;
//        int temp = 0;
//        int end = array.size() - 1;
//        int midIdx = (int) end / 2;
//        while(start <= midIdx) {
//          temp = array.get(start);
//          array.set(start, array.get(end));
//          array.set(end, temp);
//          start++;
//          end--;
//      }
      for (int i = 0; i < array.size(); i++) {
          List<Integer> currentRow = array.get(i);
          int start = 0;
          Integer temp = 0;
          int end = array.get(i).size() - 1;
          int midIdx = (int) end / 2;
          while (start <= midIdx) {
              temp = currentRow.get(start);
              currentRow.set(start, currentRow.get(end));
              currentRow.set(end, temp);
              start++;
              end--;
          }
          System.out.println(array);
      }
  }
}
