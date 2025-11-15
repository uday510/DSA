package stack;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.Set;

public class MinimumRemoveToMakeValidParentheses {

    public String minRemoveToMakeValid_(String s) {
        Set<Integer> invalid = new HashSet<>();
        Deque<Integer> st = new ArrayDeque<>();
        int n = s.length();

        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);

            if (ch == '(') {
                st.push(i);
            } else {
                if (ch == ')') {
                    if (st.isEmpty()) {
                        invalid.add(i);
                    } else {
                        st.pop();
                    }
                }
            }
        }

        while (!st.isEmpty()) invalid.add(st.pop());

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n; i++) {
            if (!invalid.contains(i)) {
                sb.append(s.charAt(i));
            }
        }

        return sb.toString();
    }

}
