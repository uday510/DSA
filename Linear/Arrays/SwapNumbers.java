import java.util.ArrayList;
import java.util.Arrays;

public class SwapNumbers {
    public static void main(String[] args) {
        ArrayList<Integer> array = new ArrayList<>(
                Arrays.asList(1, 2, 3, 4));

        solve(array, 2,3);
        for (Integer num : array) System.out.println(num);
    }
    public static void solve(ArrayList<Integer> A, int B, int C) {
        int i = B;
        int j = C;

        while (i < j) {
            swap(i, j, A);
            i++;
            j--;
        }
    }
    public static void swap(int i, int j, ArrayList<Integer> A) {
        int temp = A.get(i);
        A.set(i, A.get(j));
        A.set(j, temp);
    }
}

