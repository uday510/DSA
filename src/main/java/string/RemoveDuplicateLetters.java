package string;

import java.util.HashSet;
import java.util.Set;

public class RemoveDuplicateLetters {

    public static String removeDuplicateLetters(String s) {
        Set<Character> set = new HashSet<>();

        StringBuilder sb = new StringBuilder();

        for (char c : s.toCharArray()) {
            set.add(c);
        }

        return "";
    }
}
