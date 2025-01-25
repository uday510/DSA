package linkedlist;

/**
 * Problem Description
 * Given heads of two linked lists A and B, check if they are identical i.e. each of their corresponding nodes should contain the same data. The two given linked lists may or may not be of the same length.
 *
 *
 * Problem Constraints
 * 1 <= size of linked lists <= 105
 *
 * 1 <= value of each node <= 109
 *
 *
 *
 * Input Format
 * You are given the head of two linked lists A and B.
 *
 *
 * Output Format
 * Return 1 if both the linked lists are identical and 0 otherwise
 *
 *
 * Example Input
 * Input 1:
 * A = 1 -> 2 -> 3
 * B = 1 -> 2 -> 3
 * Input 2:
 * A = 4 -> 3 -> 2 -> 1
 * B = 4 -> 2 -> 3 -> 1
 *
 *
 * Example Output
 * Output 1:
 * 1
 * Output 2:
 * 0
 *
 *
 * Example Explanation
 * For Input 1:
 * Both the linked lists are identical
 * For Input 2:
 * The value in the second node of both the linked lists
 * are different.
 */

public class CompareLinkedList {

    public static void main(String[] args) {

        ListNode head1 = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));

        ListNode head2 = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));

        System.out.println(solve(head1, head2));
    }

    public static int solve(ListNode head1, ListNode head2) {
            ListNode temp1 = head1;
            ListNode temp2 = head2;

            while (temp1 != temp2) {
                if (temp1.val != temp2.val) return 0;
                temp1 = temp1.next;
                temp2 = temp2.next;
            }
            return 0;
    }
}
