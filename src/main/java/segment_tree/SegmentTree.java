package segment_tree;

public class SegmentTree {

    int[] tree;
    int n;

    public SegmentTree(int[] arr) {
        n = arr.length;
        tree = new int[4 * n];
        build(arr, 0, 0, n - 1);
    }

    private void build(int[] arr, int node, int st, int en) {
        if (st == en) {
            tree[node] = arr[st];
            return;
        }

        int m = (st + en) >> 1;
        build(arr, 2 * node + 1, st, m);
        build(arr, 2 * node + 2, m + 1, en);
        tree[node] = tree[2 * node + 1] + tree[2 * node + 2];
    }

    private int query(int L, int R) {
        return query(0, 0, n - 1, L, R);
    }

    private int query(int node, int st, int en, int L, int R) {
        if (R < st || L > en) return 0;
        if (L <= st && en <= R) return tree[node];

        int m = (st + en) >> 1;
        int l = query(2 * node + 1, st, m, L, R);
        int r = query(2 * node + 2, m + 1, en, L, R);
        return l + r;
    }

    public void update(int idx, int val) {
        update(0, 0, n - 1, idx, val);
    }

    private void update(int node, int st, int en, int idx, int val) {
        if (st == en) {
            tree[node] = val;
            return;
        }

        int m = (st + en) >> 1;
        if (idx <= m) update(2 * node + 1, st, m, idx, val);
        else update(2 * node + 2, m + 1, en, idx, val);

        tree[node] = tree[2 * node + 1] + tree[2 * node + 2];
    }

    static void main() {

        int[] arr = {2, 5, 1, 4, 9, 3};
        SegmentTree st = new SegmentTree(arr);

        System.out.println(st.query(1, 4));
        st.update(2, 7);
        System.out.println(st.query(1, 4));
    }
}
