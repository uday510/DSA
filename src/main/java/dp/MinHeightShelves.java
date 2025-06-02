package dp;

public class MinHeightShelves {
    static int[][] dp;
    public static void main(String[] args) {
        int[][] books = {{1,1},{2,3},{2,3},{1,1},{1,1},{1,1},{1,2}};
        int shelf_width = 4;
        System.out.println(minHeightShelves(books, shelf_width));
    }
    public static int minHeightShelves(int[][] books, int shelfWidth) {
        /*
        Brute Force:

        1. For each book, we have two choices:
            a. Either we can put it on the current shelf
            b. Or we can put it on the next shelf
        2. If we put it on the current shelf, then we need to check if the width of the book is less than the remaining width of the shelf.
        3. If the width of the book is less than the remaining width of the shelf, then we can put it on the current shelf.
        4. If the width of the book is greater than the remaining width of the shelf, then we need to put it on the next shelf.
        5. If we put it on the next shelf, then we need to check if the height of the current shelf is less than the height of the next shelf.
        6. If the height of the current shelf is less than the height of the next shelf, then we can put it on the current shelf.
        7. If the height of the current shelf is greater than the height of the next shelf, then we need to put it on the next shelf.
        8. We need to repeat the above steps for each book.
         */

        dp = new int[books.length][shelfWidth + 1];
        return dfs(books, shelfWidth, 0);
    }
    public static int dfs(int[][] books, int shelfWidth, int i) {

        if (i == books.length) {
            return 0;
        }


        if (dp[i][shelfWidth] != 0) {
            return dp[i][shelfWidth];
        }

        int width = 0;
        int height = 0;
        int minHeight = Integer.MAX_VALUE;

        for (int j = i; j < books.length; j++) {
            width += books[j][0];
            if (width > shelfWidth) {
                break;
            }
            height = Math.max(height, books[j][1]);
            minHeight = Math.min(minHeight, height + dfs(books, shelfWidth, j + 1));
        }

        return dp[i][shelfWidth] = minHeight;
    }

}
