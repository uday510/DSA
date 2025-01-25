package twopointer;

import java.util.LinkedList;
import java.util.Queue;

public class CanChange {
    public static void main(String[] args) {
        String start = "_L__R__R_";
        String target = "L______RR";

        System.out.println(bfs(start, target));
    }
    public static boolean canChange(String start, String target) {

        Queue<String> queue = new LinkedList<>();

        queue.offer(start);

        while (!queue.isEmpty()) {
            String curr = queue.poll();

            if (curr.equals(target)) {
                return true;
            }

            char[] arr = curr.toCharArray();
            for (int idx = 1; idx < curr.length(); ++idx) {

                if (arr[idx] == 'L' && arr[idx - 1] == '_') {
                    swap(idx, idx - 1, arr);
                    queue.offer(new String(arr));
                    swap(idx, idx - 1, arr);

                } else if (arr[idx] == '_' && arr[idx - 1] == 'R') {

                    swap(idx, idx - 1, arr);
                    queue.offer(new String(arr));
                    swap(idx, idx - 1, arr);

                }
            }
        }

        return false;
    }

    private static boolean bfs(String start, String target) {
        Queue<Pair<Character, Integer>> startQueue = new LinkedList<>();
        Queue<Pair<Character, Integer>> targetQueue = new LinkedList<>();

        for (int idx = 0; idx < start.length(); ++idx) {
            char ch = start.charAt(idx);
            if (ch != '_') {
                startQueue.offer(new Pair<>(ch, idx));
            }
            ch = target.charAt(idx);
            if (ch != '_') {
                targetQueue.offer(new Pair<>(ch, idx));
            }
        }

        if (startQueue.size() != targetQueue.size()) {
            return false;
        }

        while (!startQueue.isEmpty() && !targetQueue.isEmpty()) {
            var st = startQueue.poll();
            var tg = targetQueue.poll();

            assert tg != null;
            if (st.ch != tg.ch || (st.ch == 'L' && st.idx < tg.idx) || (st.ch == 'R' && st.idx > tg.idx)) {
                return false;
            }
        }

        return true;
    }
    static class Pair<T1, T2> {
        T1 ch;
        T2 idx;

        Pair(T1 ch, T2 idx) {
            this.ch = ch;
            this.idx = idx;
        }
    }
    private static void swap(int i, int j, char[] arr) {
        char tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
