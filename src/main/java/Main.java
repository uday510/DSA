import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // System.out.println("Hello LeetCoder");

        dfs(0, new int[] {1, -5, 2, -8, 3}, new ArrayList<>() );
    }

    private static void dfs(int i, int[] arr, List<Integer> cur) {

        if (i >= arr.length) {
            System.out.println(cur);
            return;
        }

        for (int j = i; j < arr.length; j++) {
            cur.add(arr[j]);
            dfs(j + 1, arr, cur);
            cur.removeLast();
        }

//        dfs(i + 1, arr, cur);

    }
}