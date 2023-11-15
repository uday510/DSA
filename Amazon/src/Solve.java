public class Solve {

    public static void main(String[] args) {
        String[] str = {"aa", "bab", "cde", "aba", "ab"};

        System.out.println(solve(str));

    }

    public static boolean solve(String[] A) {
        int N = A.length;
        int left = 0;
        int right = N-1;

        while (left < right) {
            
        }


        /*
        Move the rightmost character of arr[i]
        to the leftmost position in arr[i + 1].
        For instance, "abc" and "def" will become "ab" and "cdef".
        This operation can be applied only once to any pair of consecutive elements.

        Move the leftmost character of arr[i + 1]
        to the rightmost position in arr[i]
        For instance, "abc" and "def" will become "abcd" and "ef".
        Again, this operation can be applied only once to any pair of
        consecutive elements.

        Do nothing to the pair of consecutive elements.
        Is it possible to obtain a palindromic array from arr by performing
        these operations?
         */

        return true;
    }
}
