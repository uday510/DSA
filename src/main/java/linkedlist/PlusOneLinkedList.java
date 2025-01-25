/**
 * iven a non-negative integer represented as a linked list of digits, plus one to the integer.
 *
 * The digits are stored such that the most significant digit is at the head of the list.
 *
 *
 *
 * Example 1:
 *
 * Input: head = [1,2,3]
 * Output: [1,2,4]
 * Example 2:
 *
 * Input: head = [0]
 * Output: [1]
 *
 *
 * Constraints:
 *
 * The number of nodes in the linked list is in the range [1, 100].
 * 0 <= Node.val <= 9
 * The number represented by the linked list does not contain leading zeros except for the zero itself.
 */
package linkedlist;

public class PlusOneLinkedList {

    public static void main(String[] args) {
        ListNode tail = new ListNode(9, null);
        ListNode node5 = new ListNode(9, tail);
        ListNode node4 = new ListNode(9, node5);
        ListNode node3 = new ListNode(9, node4);
        ListNode node2 = new ListNode(8, node3);
        ListNode node1 = new ListNode(2, node2);
        ListNode head = new ListNode(1, node1);

        ListNode ans = solve(head);

        while (ans != null) {
            System.out.print(ans.val + " ");
            ans = ans.next;
        }
    }
    public static ListNode solve(ListNode head) {
        // O(N) time | O(1) space

        /**
         * --------------Algorithm---------
         *
         * Initialize sentinel node as ListNode(0)
         * and set it to be the new head: sentinel.next = head.
         *
         * Find the rightmost digit not equal to nine.
         *
         * Increase that digit by one.
         *
         * Set all the following nines to zero.
         *
         * Return sentinel node if it was set to 1,
         * and head sentinel.next otherwise.
         */

        // tempNode head
        ListNode tempNode = new ListNode(0);
        tempNode.next = head;
        ListNode notNine = tempNode;

        // find the rightmost not-nine digit
        while (head != null) {
            if (head.val != 9) {
                notNine = head;
            }
            head = head.next;
        }

        // increase this rightmost not-nine digit by 1
        notNine.val++;
        notNine = notNine.next;

        // set all the following nines to zeros
        while (notNine != null) {
            notNine.val = 0;
            notNine = notNine.next;
        }

        return tempNode.val != 0 ? tempNode : tempNode.next;
    }
}
