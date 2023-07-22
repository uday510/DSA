/**
 * You are given the heads of two sorted linked lists list1 and list2.
 *
 * Merge the two lists in a one sorted list. The list should be made by splicing together the nodes of the first two lists.
 *
 * Return the head of the merged linked list.
 */
package Recursion;

public class MergeTwoSortedLists {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(1, new ListNode(2, new ListNode(4)));
        // ListNode l1 = new ListNode(1, new ListNode(2, new ListNode(4, new ListNode(5))));
        ListNode l2 = new ListNode(1, new ListNode(3, new ListNode(4)));
        // ListNode l2 = new ListNode(1, new ListNode(3, new ListNode(4, new ListNode(5))));
        ListNode result = mergeTwoLists(l1, l2);
        while (result != null) {
            System.out.print(result.val + " ");
            result = result.next;
        }
    }
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        // O(M + N) time complexity | O(M + N) space complexity - where M is the length of the first linked list and N is the length of the second linked list

        if (l1 == null) return l2;
        if (l2 == null) return l1;

        ListNode head;

        if (l1.val < l2.val) {
            head = l1;
            l1 = l1.next;
        } else {
            head = l2;
            l2 = l2.next;
        }
        head.next = mergeTwoLists(l1, l2);

        return head;
    }
}
