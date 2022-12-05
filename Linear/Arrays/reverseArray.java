class Program {
    // O(n) time | O(1) space
  public static void reverseArray(int[] array) {
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