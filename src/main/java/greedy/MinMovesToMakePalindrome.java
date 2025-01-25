package greedy;

public class MinMovesToMakePalindrome {

    // https://leetcode.com/problems/minimum-number-of-moves-to-make-palindrome/
    public int minMovesToMakePalindrome(String s) {
        char[] c = s.toCharArray();
        int i = 0, j = s.length() - 1;
        int res = 0;

        while (i < j) {
            if (c[i] == c[j]) {
                i++;
                j--;
            } else {
                int k = j;
                while (k >= i && c[i] != c[k]) {
                    k--;
                }
                if (i == k) {
                    res++;
                    swap(i,i+1,c);
                } else {
                    while (k < j) {
                        swap(k,k+1,c);
                        k++;
                        res++;
                    }
                    i++;
                    j--;
                }
            }
        }
        return res;
    }
    public void swap(int i, int j, char[] c) {
        char tmp = c[i];
        c[i] = c[j];
        c[j] = tmp;
    }
}
