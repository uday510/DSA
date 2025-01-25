package linkedlist;

public class RemoveNthNodeFromListEnd {
    public static void main(String[] args) {

        ListNode linkedList = new ListNode(10, new ListNode(20, new ListNode(30, new ListNode(40,
                new ListNode(50, new ListNode(60, new ListNode(70, new ListNode(80, new ListNode(90, new ListNode(100))))))))));

        ListNode head = solve (linkedList, 4);

        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
    }
    public static ListNode solve(ListNode head, int n) {
        ListNode first = head;
        ListNode second = head;
        int counter = 1;

        while (counter <= n && second != null) {
            second = second.next;
            counter++;
        }

        if (second == null) {
            head = head.next;
            return head;
        }

        while (second.next != null) {
            second = second.next;
            first = first.next;
        }
        first.next = first.next.next;
        return head;
    }
}
