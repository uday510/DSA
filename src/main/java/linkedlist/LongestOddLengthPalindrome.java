package linkedlist;

public class LongestOddLengthPalindrome {

    public static void main(String[] args) {
        ListNode tail = new ListNode(2, null);
        ListNode node8 = new ListNode(2, tail);
        ListNode node7 = new ListNode(3, node8);
        ListNode node6 = new ListNode(1, node7);
        ListNode node5 = new ListNode(2, node6);
        ListNode node4 = new ListNode(2, node5);
        ListNode node3 = new ListNode(1, node4);
        ListNode node2 = new ListNode(2, node3);
        ListNode node1 = new ListNode(1, node2);
        ListNode head = new ListNode(2, node1);

        int ans = solve(head);
        System.out.println(ans);
    }
    public static int solve(ListNode head) {
        // O(N^2) time | O(1) space
        ListNode currNode = head;
        ListNode prevNode = null;
        int maxLength = 1;
        int currLength = 1;

        while(currNode != null) {
            ListNode nextNode = currNode.next;
            currLength = matchingCount(prevNode, nextNode);
            maxLength = Integer.max(currLength * 2 + 1, maxLength);
            currNode.next = prevNode;
            currLength = matchingCount(currNode, nextNode);
            maxLength = Integer.max(currLength * 2, maxLength);
            prevNode = currNode;
            currNode = nextNode;
        }
        return maxLength;
    }
    public static int matchingCount(ListNode prevNode, ListNode nextNode) {
        int count = 0;

        while (prevNode != null && nextNode != null) {
            if (prevNode.val != nextNode.val) { break; }
            count += 1;
            prevNode = prevNode.next;
            nextNode = nextNode.next;
        }
        return count;
    }
}
