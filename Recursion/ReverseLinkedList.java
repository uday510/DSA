package Recursion;

public class ReverseLinkedList extends ListNode {
    ReverseLinkedList(int x) {
        super(x);
    }
    public static void main(String[] args) {
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4))));

        ListNode reversed = reverseList(head, null);
        while(reversed != null) {
            System.out.println(reversed.val);
            reversed = reversed.next;
        }
    }
    public static ListNode reverseList(ListNode curr, ListNode prev) {
       if (curr == null) { return null; }

       ListNode next = curr.next;
       curr.next = prev;
       if (next == null) { return curr; }
       return reverseList(next, curr);

    }
}
