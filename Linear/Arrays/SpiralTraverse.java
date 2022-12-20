import java.util.*;

public class SpiralTraverse {

    public static void main(String[] args) {
        int[][] array = { {1, 2, 3},
                          {12, 13, 4},
                          {11, 14, 5},
                          {10, 15, 6},
                          {9, 8, 7} };
        System.out.println(spiralFillUsingLoop(array));
        var result = new ArrayList<Integer>();
        spiralFillUsingRecursion(array, 0, array.length - 1, 0, array[0].length - 1, result);
        System.out.println(result);
    }
    public static List<Integer> spiralFillUsingLoop(int[][] array) {
        // O(n) time | O(n) space;
        if(array.length == 0) return new ArrayList<>();

        var result = new ArrayList<Integer>();
        var startRow = 0;
        var endRow = array.length - 1;
        var startCol = 0;
        var endCol = array[0].length - 1;

        while(startRow <= endRow && startCol <= endCol) {
            for(int col = startCol; col <= endCol; col++)
                result.add(array[startRow][col]);
            for(int row = startRow; row <= endRow; row++)
                result.add(array[row][endCol]);
            for(int col = endCol - 1; col >= startCol; col--) {
                if(startRow == endRow) break;
                result.add(array[endRow][col]);
            }
            for(int row = endRow - 1; row > startRow; row--) {
                if(startCol == endCol) break;
                result.add(array[row][endCol]);
            }

            startRow++;
            endRow--;
            startCol++;
            endCol--;
        }

        return result;
    }
    public static void spiralFillUsingRecursion(
            int[][] array,
            int startRow,
            int endRow,
            int startCol,
            int endCol,
            ArrayList<Integer> result) {
        // O(n) time | O(n) space;
        if(startRow > endRow || startCol > endCol) return;

        for(int col = startCol; col <= endCol; col++)
            result.add(array[startRow][col]);
        for(int row = startRow + 1; row <= endRow; row++)
                result.add(array[row][endCol]);
        for(int col = endCol - 1; col >= startCol; col--) {
            if(startRow == endRow) break;
            result.add(array[endRow][col]);
        }
        for(int row = endRow - 1; row > startRow; row--) {
            if(startCol == endCol) break;
            result.add(array[row][startCol]);
        }
        spiralFillUsingRecursion(array, startRow + 1, endRow -1, startCol + 1, endCol - 1, result);
    }
}
