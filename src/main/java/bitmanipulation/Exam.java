package bitmanipulation;

public class Exam {

    /// 3 -> 0000 0011
    // -> 1111 1100

    //set(1111 1100) -> 1111 1100
    // [1, 3, 3, 4, 5]


    public static void main(String[] args) {
//        0  1   2  3  4  5
//        int[] arr =  {1, 2, 3, 4, 5, 6, 7, 7, 8, 9};
//        int[] arr =  {1, 2, 3, 4, 5, 6, 7, 7, 8, 9};
          int[] arr =  {2, 3, 4, 4, 8, 9};

        System.out.println(bisectLeft(arr));
    }
    public static int find(int[] arr) {
        return bisectLeft(arr);
    }

    public static int bisectLeft(int[] arr) {
        int left = 0;
        int right = arr.length;

        while (left < right) {

            int mid = (left + right) >>> 1;

            System.out.println(mid);

            int curr = arr[mid];

            // check for left valid or not

            if (curr - 1 == mid) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return arr[left];
    }
}
