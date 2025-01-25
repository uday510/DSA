package string;
import java.util.Arrays;

public class SortVowels {
    public static void main(String[] args) {

    }
    public String sortVowels(String s) {
        char[] chars = getVowels(s.toCharArray());
        int idx = 0;
        Arrays.sort(chars);
        int N = s.length();
        StringBuilder t = new StringBuilder();

        for (int i = 0; i < N; ++i) {
            char c = s.charAt(i);
            if (isVowel(c)) {
                t.append(chars[idx++]);
            } else {
                t.append(c);
            }
        }
        return t.toString();
    }
    public char[] getVowels(char[] str) {
        StringBuilder s = new StringBuilder();
        for (char c: str) {
            if (isVowel(c)) {
                s.append(c);
            }
        }
        return s.toString().toCharArray();
    }
    public boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'o'|| c == 'u'|| c == 'i'
                || c == 'A' || c == 'E' || c == 'O'|| c == 'U'|| c == 'I';
    }
}
