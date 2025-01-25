package array;

public class Test {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4};
        System.out.println(arr);
        solve(arr);
        System.out.println(arr[0]);
    }
    public static void solve(int[] arr) {
        System.out.println(arr);
        arr[0] = 5;
    }
}
