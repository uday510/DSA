package dynamicprogramming;

public class MaximalSquare {

    public static void main(String[] args) {
        char[][] matrix = {{'1','0','1','0','0'},{'1','0','1','1','1'},{'1','1','1','1','1'},{'1','0','0','1','0'}};

        int result = maximalSquare(matrix);
        System.out.println(result);
    }
    public static int maximalSquare(char[][] matrix) {
        int maximumSquare = 1;
        int rows = matrix.length;
        int cols = matrix[0].length;

        for (int row = 0; row < rows; ++row) {
            for (int col = 0; col < cols; ++col) {
                int currentSquareLength = 0;
                boolean flag = true;

                while (currentSquareLength + row < rows && currentSquareLength + col < cols && flag) {
                    for (int currCol = col; currCol <= currentSquareLength + col; ++currCol) {
                        if (matrix[row + currentSquareLength][currCol] == '0') {
                            flag = false;
                            break;
                        }
                    }
                    for (int currRow = row; currRow <= currentSquareLength + row; ++currRow) {
                        if (matrix[currRow][col + currentSquareLength] == '0') {
                            flag = false;
                            break;
                        }
                    }

                    if (flag) {
                        currentSquareLength++;
                    }
                }
                maximumSquare = Math.max(maximumSquare, currentSquareLength);
            }
        }

        return maximumSquare * maximumSquare;
    }
}
