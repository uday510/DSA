package sort;

import java.util.Arrays;
import java.util.Collections;

public class dummy {
    public static void main(String[] args) {
        String[] arr = {"adarsh80", "harsh95", "shivam95"};

//        ArrayList<String>
         solve(arr);
//        System.out.println(Arrays.toString(res));
//        Arrays.sort(arr, Collections.reverseOrder());
//        System.out.println(Arrays.toString(arr));

//        String a = "123";
//
//        long res = solve(a);
//        System.out.println(res);

//        int[] arr = {2, 3, 1};
//        int b = 2;
//        System.out.println(solve(arr, b));

    }
//    public static String[] solve(String[] array) {
//        Collections.sort(new Comparator<String>() {
//            @Override
//            public int compare(String o1, String o2) {
//                Integer count1 = getCount(o1);
//                Integer count2 = getCount(o2);
//                if (count1 == count2)
//                return count1 - count2;
//                return count1.compareTo(count2);
//                if (count1 == count2) o1.
//                return o1;
//            }
//        });
//        return array;
//    }
//    public static Integer getCount(String str) {
//        int res = 0;
//        if(str.charAt(str.length() - 3) - '0'  < 10) {
//            res += str.charAt(str.length() - 3) - '0';
//        }
//        if(str.charAt(str.length() - 2) - '0'  < 10) {
//            res += str.charAt(str.length() - 2) - '0';
//        }
//        res += str.charAt(str.length() - 1) - '0';
//        return res;
//    }
//}

//    public static long solve(String str) {
//        long res = 0;
//
//        ArrayList<Long> list = new ArrayList<>();
//        for (int i = 0; i < str.length(); i++) {
//            list.add(str.charAt(i) - (long)'0');
//        }
//        System.out.println("LIST: " + list);
//
//        for (int i = 0; i < list.size(); i++) {
//            long n = list.get(i);
//            if (n >= 0 && n < 10) {
//                int k = i;
//                String s = "";
//                while (k < list.size() && list.get(k) < 10 && list.get(k) >= 0) {
//                    s += list.get(k);
//                    k++;
//                }
//                res += Integer.parseInt(s);
//                i = k - 1;
//            }
//        }
//        return res;

    // [1, 3, 7, 5, 2, 3, 1]
//    public static long solve(int[] arr, int b) {
//        int res = 0;
//        int i = 0;
//        for ( i = 0; i < arr.length; i++) {
//            {
//                int num = arr[i] % b;
//                if (num == 0) {
//                    res++;
//                    break;
//                }
//            }
//        }
//        for (int j = i; j < arr.length; j++) {
//            int num = arr[j];
//            if (num % b == 0) {
//                int sum = num;
//                int k = j;
//                while ((k < arr.length )) {
//                    k++;
//                    sum += arr[k];
//                    if (sum % b == 0) break;
//                }
//                System.out.println("SUM::" + sum);
//                res+=1;
//            }
//        }

//        int[] pf = new int[arr.length];
//        pf[0] = arr[0];
//        for (int i = 1; i < arr.length; i++) {
//            pf[i] = arr[i] + pf[i - 1];
//        }
//
//        for (int i = 0; i < arr.length; i++) {
//            for (int j = i; j < arr.length; j++) {
//                int sum = 0;
//                if (i == 0) {
//                     sum = pf[i];
//                } else {
//                    sum = pf[j] - pf[i - 1];
//                }
//                if (sum % b == 0) res++;
//            }
//        }
//        return res;

//    }
    public static void solve(String[] strings) {

        /**
         *  Collections.sort(new Comparator<String>() {
         * //            @Override
         * //            public int compare(String o1, String o2) {
         * //                Integer count1 = getCount(o1);
         * //                Integer count2 = getCount(o2);
         * //                if (count1 == count2)
         * //                return count1 - count2;
         * //                return count1.compareTo(count2);
         * //                if (count1 == count2) o1.
         * //                return o1;
         * //            }
         * //        });
         * //        return array;
         */

        Arrays.sort(strings, Collections.reverseOrder());

        System.out.println(Arrays.toString(strings));

    }

}
