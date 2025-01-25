package linkedlist;

public class ReorderList {
    public static void main(String[] args) {
       ListNode head = new ListNode(10, new ListNode(20, new ListNode(30, new ListNode(40, new ListNode(50, new ListNode(60))))));

        ListNode ans = solve(head);

        while (ans != null) {
            System.out.print(ans.val + " ");
            ans = ans.next;
        }
    }
    public static ListNode solve(ListNode head) {
        // O(N) time | O(1) space
        if (head == null || head.next == null || head.next.next == null)
            return head;

        ListNode firstHalfHead = head;
        ListNode secondHalfHead = splitLinkedList(head);
        ListNode reverseSecondHalf = reverse(secondHalfHead);

        ListNode l1 = firstHalfHead;
        ListNode l2 = reverseSecondHalf;

        while (l1 != null && l2 != null) {
            ListNode l1Next = l1.next;
            ListNode l2Next = l2.next;

            l1.next = l2;
            l2.next = l1Next;

            l1 = l1Next;
            l2 = l2Next;
        }
        return firstHalfHead;
    }
    public static ListNode splitLinkedList(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode secondHalfHead = slow.next;
        slow.next = null;
        return secondHalfHead;

    }
    public static ListNode reverse(ListNode head) {
        ListNode prevNode = null;
        ListNode currNode = head;

        while (currNode != null) {
            ListNode nextNode = currNode.next;
            currNode.next = prevNode;
            prevNode = currNode;

            currNode = nextNode;
        }
        return prevNode;
    }
}
