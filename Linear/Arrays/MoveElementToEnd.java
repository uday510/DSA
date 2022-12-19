import java.util.Arrays;

public class MoveElementToEnd {
    public static void main(String[] args) {
        int[] array = {2, 1, 2, 2, 2, 3, 4, 2};
        int toMove = 2;
        System.out.println(Arrays.toString(solve(array, toMove)));
    }
    public static int[] solve(int[] array, int toMove) {
        int i = 0;
        int j = array.length - 1;
        while(i < j) {
            while(i < j && array[j] == toMove) j--;
            if(array[i] == toMove) swap(i, j, array);
            i++;
        }
        return array;
    }
    public static void swap(int i, int j, int[] array) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
