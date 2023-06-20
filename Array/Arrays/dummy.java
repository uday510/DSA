import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class dummy {

    public static void main(String[] args) {
        List<List<Integer>> array = new ArrayList<>();
        array.add(Arrays.asList(1, 3, 4, 2));
        array.add(Arrays.asList(2, 9, 6, -1));
        array.add(Arrays.asList(-3, 12, 8, 7));
        array.add(Arrays.asList(10, -2, 0, -9));

        System.out.println(array);
        solve(array);
    }

    public static void solve(List<List<Integer>> array) {

        for (int i = 0; i < array.size(); i++) {
            int start = 0;
            int end = array.get(i).size() - 1;
            int midIdx = (int) Math.floor(start - (end - start) / 2);
            System.out.println(midIdx);
            while(start < midIdx) {
                swap(start, end, array);
                start++;
                end--;
            }
            System.out.println(array.get(i));

        }
    }
    public static void swap(int rowIdx, int colIdx, List<List<Integer>> array) {
        int temp = array.get(rowIdx).get(colIdx);
        array.get(rowIdx).set(colIdx, array.get(colIdx).get(rowIdx));
        array.get(colIdx).set(rowIdx, temp);
    }
}

