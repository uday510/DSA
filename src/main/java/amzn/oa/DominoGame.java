package amzn.oa;

public class DominoGame {
    public static int maxRemovals(int[] domino, int[] remove, int min_order) {
        return 0;
    }

    public static void main(String[] args) {
        int n = 6;
        int[] domino = {1, 4, 4, 2, 5, 3};
        int[] remove = {2, 1, 4, 0, 5, 3};
        int min_order = 3;

        System.out.println(maxRemovals(domino, remove, min_order));
    }
}