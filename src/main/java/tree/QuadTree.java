package tree;

public class QuadTree {
    public static void main(String[] args) {

    }
    public static QuadNode construct(int[][] grid) {
        return construct(grid, 0, 0, grid.length);
    }
    private static QuadNode construct(int[][] grid, int x, int y, int len) {
        if (len == 1) {
            return new QuadNode(grid[x][y] == 1, true, null, null, null, null);
        }
        QuadNode topLeft = construct(grid, x, y, len / 2);
        QuadNode topRight = construct(grid, x, y + len / 2, len / 2);
        QuadNode bottomLeft = construct(grid, x + len / 2, y, len / 2);
        QuadNode bottomRight = construct(grid, x + len / 2, y + len / 2, len / 2);
        if (topLeft.isLeaf && topRight.isLeaf && bottomLeft.isLeaf && bottomRight.isLeaf && topLeft.val == topRight.val && topRight.val == bottomLeft.val && bottomLeft.val == bottomRight.val) {
            return new QuadNode(topLeft.val, true, null, null, null, null);
        }
        return new QuadNode(true, false, topLeft, topRight, bottomLeft, bottomRight);
    }
}