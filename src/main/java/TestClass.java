import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

class TestClass {
    public static void main(String args[] ) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            int n = Integer.parseInt(br.readLine());

            long[] arr = new long[n];
            StringTokenizer st = new StringTokenizer(br.readLine());

            for (int i = 0; i < n; i++) {
                arr[i] = Long.parseLong(st.nextToken());
            }

            long res = 0;
            System.out.println(res);
        }
    }

    static long largestRectangle(long[] h) {
        int n = h.length;
        long maxArea = 0;
        Deque<Integer> st = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {

            while (!st.isEmpty() && h[i] < h[st.peek()]) {
                long height = h[st.pop()];
                int r = i, l = st.isEmpty() ? -1: st.peek();

                long w = r - l - 1;
                maxArea = Math.max(maxArea, w * height);
            }

            st.push(i);
        }

        while (!st.isEmpty()) {
            long height = h[st.pop()];
            int r = n, l = st.isEmpty() ? -1: st.peek();

            long w = r - l - 1;
            maxArea = Math.max(maxArea, w * height);
        }

        return maxArea;
    }
}
