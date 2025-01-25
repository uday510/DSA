package string;

import java.util.HashMap;

public class WordPattern {
    public static void main(String[] args) {
        String pattern = "abba";
        String str = "dog cat cat dog";
        System.out.println(wordPattern(pattern, str));
    }
    private static boolean wordPattern(String pattern, String s) {
        var map = new HashMap<Character, String>();
        var words = s.split(" ");
        if (pattern.length() != words.length) return false;

        for (int i = 0; i < pattern.length(); i++) {
            char c = pattern.charAt(i);
           if (!map.containsKey(c)) {
               if (map.containsValue(words[i])) return false;
               map.put(c, words[i]);
           } else {
               if (!map.get(c).equals(words[i])) return false;
           }
        }
        return true;
    }
}
