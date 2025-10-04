/**
 * Problem Description
 * Given a singly linked list A and an integer B, reverse the nodes of the list B at a time and return the modified linked list.
 *
 *
 *
 * Problem Constraints
 * 1 <= |A| <= 103
 *
 * B always divides A
 *
 *
 *
 * Input Format
 * The first argument of input contains a pointer to the head of the linked list.
 *
 * The second arugment of input contains the integer, B.
 *
 *
 *
 * Output Format
 * Return a pointer to the head of the modified linked list.
 */
package linkedlist;

public class ReverseKGroup {
    public static void main(String[] args) {

        ListNode tail = new ListNode(8, null);
        ListNode node7 = new ListNode(7, tail);
        ListNode node6 = new ListNode(6, node7);
        ListNode node5 = new ListNode(5, node6);
        ListNode node4 = new ListNode(4, node5);
        ListNode node3 = new ListNode(3, node4);
        ListNode node2 = new ListNode(2, node3);
        ListNode head = new ListNode(1, node2);

        ListNode linkedList = solve(head, 3);

        while (linkedList != null) {
            System.out.print(linkedList.val + " ");
            linkedList = linkedList.next;
        }
    }
    public static ListNode solve (ListNode head, int k) {
        // O(N) time | O(1) space
            if (head == null || k == 1) return head;

            ListNode dummyNode = new ListNode(0, head);

            ListNode currentNode = dummyNode, nextNode, previousNode = dummyNode;
            int counter = 0;
            // 1.calculate the linked list length
            while (currentNode.next != null) {
                currentNode = currentNode.next;
                counter++;
            }

            while (counter >= k) {
                currentNode = previousNode.next;
                nextNode = currentNode.next;

                // reverse in k groups
                for (int i = 1; i < k; i++) {
                    currentNode.next = nextNode.next;
                    nextNode.next = previousNode.next;
                    previousNode.next = nextNode;
                    nextNode = currentNode.next;
                }
                previousNode = currentNode;
                counter -= k;
            }
            return dummyNode.next;
    }

//    public ListNode reverseKGroup(ListNode head, int k) {
//            return dfs(head, k);
//    }
    private ListNode dfs(ListNode node, int k) {
        if (node == null) return null;

        ListNode current = node;
        for (int i = 0; i < k; i++) {
            if (current == null) return node;
            current = current.next;
        }

        ListNode prev = null;
        ListNode curr = node;

        for (int i = 0; i < k; ++i) {
            ListNode next = curr.next;

            curr.next = prev;
            prev = curr;

            curr = next;
        }

        node.next = dfs(curr, k);

        return prev;
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode newHead = null, tail = null, cur = head;

        while (cur != null) {
            ListNode ptr = cur;
            int cnt = 0;
            while (cnt < k && ptr != null) {
                ptr = ptr.next;
                cnt++;
            }

            if (cnt == k) {
                ListNode reversedHead = reverse(cur, k);
                if (newHead == null) newHead = reversedHead;
                if (tail != null) tail.next = reversedHead;
                tail = cur;
                cur = ptr;
            } else {
                if (tail != null) tail.next = cur;
                break;
            }
        }

        return newHead == null ? head : newHead;
    }

    private ListNode reverse(ListNode node, int k) {
        ListNode cur = node, prev = null;

        while (k > 0) {
            ListNode next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;

            k--;
        }

        return prev;
    }
}
