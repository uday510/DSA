package array;

import LinkedList.ListNode;

import java.util.Arrays;

public class SpiralIV {
    public static void main(String[] args) {
        ListNode head = new ListNode(3, new ListNode(2, new ListNode(0, new ListNode(-4, null))));

       int[][] res = spiralMatrix(3, 4, head);

         for (int[] arr : res) {
             System.out.println(Arrays.toString(arr));
         }
    }
    private static int[][] spiralMatrix(int m, int n, ListNode head) {
        int startRow = 0;
        int startCol = 0;
        int endRow = m-1;
        int endCol = n-1;
        ListNode currNode = head;


        int[][] res = new int[m][n];

        for (int[] arr : res) {
            Arrays.fill(arr, -1);
        }

        while (currNode != null) {

            for (int col = startCol; col <= endCol && currNode != null; ++col) {
                res[startRow][col] = currNode.val;
                currNode = currNode.next;
            }

            for (int row = startRow + 1; row <= endRow && currNode != null; ++row) {
                res[row][endCol] = currNode.val;
                currNode = currNode.next;
            }

            for (int col = endCol - 1; col >= startCol && currNode != null; --col) {
                res[endRow][col] = currNode.val;
                currNode = currNode.next;
            }

            for (int row = endRow - 1; row > startRow && currNode != null; --row) {
                res[row][startCol] = currNode.val;
                currNode = currNode.next;
            }
            ++startRow;
            --endRow;
            ++startCol;
            --endCol;
        }
        return res;
    }
}
