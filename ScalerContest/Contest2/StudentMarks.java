package ScalerContest.Contest2;

import java.util.Arrays;

public class StudentMarks {
    public static void main(String[] args) {
        String[] students = {"harsh95", "shivam95", "adarsh80"};

        String[] ans = solve(students);
        System.out.println(Arrays.toString(ans));
    }
    public static String[] solve(String[] students) {
        //O(N^2 * M) time | O(1) space
        for (int i = 1; i < students.length; i++) {
            for (int j = 0; j < students.length - 1; j++) {
                if (isSmaller(students[j], students[j+1])) {
                    swap(j, j+1, students);
                }
            }
        }
        return students;
    }
public static  boolean isSmaller(String str1, String str2) {
    int i=0, a=0;
    while (i < str1.length() && str1.charAt(i) >= 'a' && str1.charAt(i) <= 'z') i++;
    while (i < str1.length()) {
        int digit = str1.charAt(i) - '0';
        a = a * 10 + digit;
        i++;
    }
    int j=0, b=0;
    while (j < str2.length() && str2.charAt(j) >= 'a' && str2.charAt(j) <= 'z') j++;
    while (j < str2.length()) {
        int digit = str2.charAt(j) - '0';
        b = b * 10 + digit;
        j++;
    }
    return a < b;

}
    public static void swap(int i, int j, String[] arr) {
        String temp = arr[j];
        arr[j] = arr[i];
        arr[i] = temp;
    }
}
