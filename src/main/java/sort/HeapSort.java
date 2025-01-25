package sort;

import java.util.Arrays;

public class HeapSort {
    public static void main(String[] args) {

//        List<Integer> array = new ArrayList<>
//                (List.of(48, 12, 24, 7, 8, -5, 24, 391, 24, 56, 2, 6, 8, 41));

      int[] array = {48, 12, 24, 7, 8, -5, 24, 391, 24, 56, 2, 6, 8, 41};

      int[] ans = solve(array);

      System.out.println(Arrays.toString(ans));
    }
    public static int[] solve(int[] array) {
        // Best : O(NLog(N)) time | O(1) space
        // Average : O(NLog(N)) time | O(1) space
        // Worst : O(NLog(N)) time | O(1) space
       buildMaxHeap(array);
       for (int endIdx = array.length - 1; endIdx > 0; --endIdx) {
           swap(0, endIdx, array);
           siftDown(0, endIdx - 1, array);
       }
        return array;
    }
    public static void buildMaxHeap(int[] array) {
        int firstParentIdx = (array.length - 2) / 2;
        for (int currentIdx = firstParentIdx; currentIdx > -1; --currentIdx) {
            siftDown(currentIdx, array.length - 1, array);
        }
    }
    public static void siftDown(int currentIdx, int endIdx, int[] heap) {
        int childOneIdx = currentIdx * 2 + 1;
        while (childOneIdx <= endIdx) {
            int childTwoIdx = currentIdx * 2 + 2 <= endIdx ? currentIdx * 2 + 2 : -1;
            int idxToSwap;
            if (childTwoIdx != -1 && heap[childTwoIdx] > heap[childOneIdx]) {
                idxToSwap = childTwoIdx;
            } else {
                idxToSwap = childOneIdx;
            }
            if (heap[idxToSwap] > heap[currentIdx]) {
                swap(idxToSwap, currentIdx, heap);
                currentIdx = idxToSwap;
                childOneIdx = currentIdx * 2 + 1;
            } else {
                return;
            }
        }
    }
    public static void swap(int i, int j, int[] array) {
        int temp = array[j];
        array[j] = array[i];
        array[i] = temp;
    }
}
