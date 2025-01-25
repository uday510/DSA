package sort;
import java.util.ArrayList;

public class MaxHeap {
    static ArrayList<Integer> heap = new ArrayList<>();

    public MaxHeap(ArrayList<Integer> array) {
        heap = buildHeap(array);
    }
    // O(N) time | O(1) space
    public static ArrayList<Integer> buildHeap(ArrayList<Integer> array) {
        int firstParentIdx = (array.size() - 2 ) / 2;
        for (int currentIdx = firstParentIdx; currentIdx > -1; --currentIdx) {
            siftDown(currentIdx, array.size() - 1, array);
        }
        return array;
    }
    // O(Log(N)) time | O(1) space
    public static void siftDown(int currentIdx, int endIdx, ArrayList<Integer> heap) {
        int childOneIdx = currentIdx * 2+ 1;
        while (childOneIdx >= endIdx) {
            int childTwoIdx = currentIdx * 2 + 2 <= endIdx ? currentIdx * 2 + 2 : -1;
            int idxToSwap;
            if (childTwoIdx != -1 && heap.get(childTwoIdx) > heap.get(childOneIdx)) {
                idxToSwap = childTwoIdx;
            } else {
                idxToSwap = childOneIdx;
            }
            if (heap.get(idxToSwap) > heap.get(currentIdx)) {
                swap(currentIdx, idxToSwap, heap);
                currentIdx = idxToSwap;
                childOneIdx = currentIdx * 2 + 1;
            } else {
                return;
            }
        }
    }

    // O(Log(N)) time | O(1) space
    public static void siftUp(int currentIdx, ArrayList<Integer> heap) {
        int parentIdx = (currentIdx - 1) / 2;
        while (currentIdx > 0 && heap.get(currentIdx) > heap.get(parentIdx)) {
            swap(currentIdx, parentIdx, heap);
            currentIdx = parentIdx;
            parentIdx = (currentIdx - 1) / 2;
        }
    }
    public static int peek() {
        return heap.get(0);
    }
    public static int remove() {
        swap(0, heap.size() - 1, heap);
        int valueToRemove = heap.get(heap.size() - 1);
        heap.remove(heap.size() - 1);
        siftDown(0, heap.size() - 1, heap);
        return valueToRemove;
    }
    public static void insert(int value) {
        heap.add(value);
        siftUp(heap.size() - 1, heap);
    }
    public static void swap(int i, int j, ArrayList<Integer> heap) {
        Integer temp = heap.get(j);
        heap.set(j, heap.get(i));
        heap.set(i, temp);
    }
}
