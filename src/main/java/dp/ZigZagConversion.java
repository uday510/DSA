/*
The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)

P   A   H   N
A P L S I I G
Y   I   R
And then read line by line: "PAHNAPLSIIGYIR"

Write the code that will take a string and make this conversion given a number of rows:

string convert(string s, int numRows);


Example 1:

Input: s = "PAYPALISHIRING", numRows = 3
Output: "PAHNAPLSIIGYIR"
Example 2:

Input: s = "PAYPALISHIRING", numRows = 4
Output: "PINALSIGYAHRPI"
Explanation:
P     I    N
A   L S  I G
Y A   H R
P     I
Example 3:

Input: s = "A", numRows = 1
Output: "A"


Constraints:

1 <= s.length <= 1000
s consists of English letters (lower-case and upper-case), ',' and '.'.
1 <= numRows <= 1000
 */
package dp;

public class ZigZagConversion {
    public static void main(String[] args) {
        String s = "PAYPALISHIRING";
        int numRows = 4;
        System.out.println(convert(s, numRows));
    }
    public static String convert(String s, int numRows) {
        if(numRows == 1) return s;
        int n = s.length();

        String[][] zigzag = new String[numRows][n];
        StringBuilder sb = new StringBuilder();

        int i = 0, col = 0;

        while (i < n) {
            int row = 0;
            while (row < numRows && i < n) {
                zigzag[row][col] = String.valueOf(s.charAt(i));
                ++row;
                ++i;
            }

            col = col + 1;
            row = row - 2;
            while (row > 0 && i < n) {
                zigzag[row][col] = String.valueOf(s.charAt(i));
                --row;
                ++col;
                ++i;
            }
        }

        for (i = 0; i < numRows; i++) {
            for (int j = 0; j < n; j++) {
                if(zigzag[i][j] != null) {
                    sb.append(zigzag[i][j]);
                }
            }
        }

        return sb.toString();
    }
}
