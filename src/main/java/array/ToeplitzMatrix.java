package array;

public class ToeplitzMatrix {
    public static void main(String[] args) {
        int[][] matrix = {
            {1, 2, 3, 4},
            {5, 1, 2, 3},
            {6, 5, 1, 2}
        };
        System.out.println(isToeplitzMatrix(matrix));
    }
    public static boolean isToeplitzMatrix(int[][] matrix) {

//       int i = 0;
//
//       while (i < matrix[0].length){
//
//           int row = matrix.length - 1;
//           int col = i;
//
//           int prev = matrix[row][col];
//
//           while (row >= 0 && col >= 0){
//
//               if (matrix[row][col] != prev){
//                   return false;
//               }
//
//               row--;
//               col--;
//           }
//           ++i;
//       }
        for (int i = 0; i < matrix.length; ++i) {
            for (int j = 0; j < matrix[0].length; ++j) {
                if (i > 0 && j > 0 && matrix[i-1][j-1] != matrix[i][j]) {
                    return false;
                }
            }
        }
       return true;
    }
}
