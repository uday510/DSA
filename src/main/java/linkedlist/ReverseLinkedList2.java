package linkedlist;

/**
 * Given the head of a singly linked list and two integers left and right where left <= right, reverse the nodes of the list from position left to position right, and return the reversed list.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: head = [1,2,3,4,5], left = 2, right = 4
 * Output: [1,4,3,2,5]
 * Example 2:
 *
 * Input: head = [5], left = 1, right = 1
 * Output: [5]
 */
public class ReverseLinkedList2 {

    public static void main(String[] args) {
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));

        ListNode linkedList = solve (head, 2, 4);
        while (linkedList != null) {
            System.out.print(linkedList.val + " ");
            linkedList = linkedList.next;
        }
    }
    public static ListNode solve (ListNode head, int left, int right) {
        // O(N) time | O(1) space
        if (head == null || left == right) return head;

        ListNode dummyNode = new ListNode(0, head);

        ListNode before = dummyNode;

        for (int i = 1; i < left; i++) {
            before = before.next;
        }

        System.out.println("before: " + before.val);

        // before is at node 1
        ListNode prevNode = before;
        ListNode currNode = before.next;

        for (int i = left; i <= right; i++) {
            ListNode nextNode = currNode.next;
            currNode.next = prevNode;
            prevNode = currNode;
            currNode = nextNode;
        }

        /**
         * before.next.next is 2.next i.e 2.next should point to currNode i.e 5
         * before.next should point to last node of reversed i.e 4
         */

        System.out.println(before.val +  " " + before.next.val + " " + before.next.next.val);

        before.next.next = currNode;
        before.next = prevNode;

        return dummyNode.next;
    }

}
