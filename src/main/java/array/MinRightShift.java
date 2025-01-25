package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MinRightShift {


    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.addAll(Arrays.asList(1, 1));

        System.out.println(minimumRightShifts(list));

    }

    public static int minimumRightShifts(List<Integer> nums) {
        int n = nums.size();

        int i = 0;
        int j = n - 1;

        if (n % 2 != 0) {
            return 1;
        }

        while (i < j && nums.get(i) < nums.get(j)) {
            i++;
            j--;
        }

       return i >= j ? 0 : n;

    }
}
