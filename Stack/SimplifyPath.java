package Stack;

import java.util.Stack;

public class SimplifyPath {
    public static void main(String[] args) {
        String path = "/a//b////c/d//././/..";
        System.out.println(simplifyPath(path));
    }
    private static String simplifyPath(String path) {
        var dirs = path.split("/");
        var stack = new Stack<String>();

        for (var dir : dirs) {
           handleDir(dir, stack);
        }

        return "/" + String.join("/", stack);
    }
    private static void handleDir(String dir, Stack<String> st) {
        if (dir.equals("..")) {
            if (!st.isEmpty()) {
                st.pop();
            }
        } else if (!dir.equals(".") && !dir.isEmpty()) {
            st.push(dir);
        }
    }
}
