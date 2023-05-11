package Linear.Stacks;

public class ImplementStackUsingLinkedList {

    static ListNode head = new ListNode();
    static ListNode topOfStack = head;
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    public static void main(String[] args) {

    }
    public static void push(ListNode node) {
        if (head == null) {
            head = node;
        } else {
            node.next = topOfStack;
        }
        topOfStack = node;
    }
    public static int pop() {
        if (topOfStack == null) {
            System.out.println("Stack is under flow");
            return -1;
        } else {
            int val = topOfStack.val;
            topOfStack = topOfStack.next;
            return val;
        }
    }
}
