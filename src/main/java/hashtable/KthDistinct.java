package hashtable;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class KthDistinct {
    public static void main(String[] args) {
        String[] arr = {"a", "b", "c", "a", "b", "c", "d"};
        int k = 2;
        System.out.println(kthDistinct(arr, k));
    }
    public static String kthDistinct(String[] arr, int k) {
        Set<String> set = new HashSet<>(Arrays.asList(arr));

        int count = 0;


        for (String s : arr) {
            if (!set.contains(s)) {
                continue;
            }
            count++;
            if (count == k) {
                return s;
            }
            set.remove(s);
        }

        return "";
    }

}
