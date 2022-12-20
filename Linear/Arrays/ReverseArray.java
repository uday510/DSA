public class ReverseArray {
    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5};

        reverseArray(array);

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
}