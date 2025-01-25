package linkedlist;

/**
 * Problem Description
 * You are given A which is the head of a linked list. Also given is the value B and position C. Complete the function that should insert a new node with the said value at the given position.
 *
 * Notes:
 *
 * In case the position is more than length of linked list, simply insert the new node at the tail only.
 * In case the pos is 0 or less, simply insert the new node at head only.
 * Follow 0-based indexing for the node numbering.
 *
 *
 * Problem Constraints
 * 1 <= size of linked list <= 105
 *
 * 1 <= value of nodes <= 109
 *
 * 1 <= B <= 109
 *
 * 0 <= C <= 105
 *
 *
 *
 * Input Format
 * The first argument A is the head of a linked list.
 *
 * The second argument B is an integer which denotes the value of the new node
 *
 * The third argument C is an integer which denotes the position of the new node
 *
 *
 *
 * Output Format
 * Return the head of the linked list
 *
 *
 * Example Input
 * Input 1:
 * A = 1 -> 2
 * B = 3
 * C = 0
 * Input 2:
 * A = 1 -> 2
 * B = 3
 * C = 1
 *
 *
 * Example Output
 * Output 1:
 * 3 -> 1 -> 2
 * Output 2:
 * 1 -> 3 -> 2
 */

public class InsertInLinkedList {


    public static void main(String[] args) {

        ListNode head = new ListNode(10);
        ListNode node1 = new ListNode(20);
        ListNode node2 = new ListNode(30);
        ListNode node3 = new ListNode(40);
        ListNode node4 = new ListNode(50);
        ListNode node5 = new ListNode(60);
        ListNode node6 = new ListNode(70);
        ListNode node7 = new ListNode(80);

        head.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = node7;

        solve(head, 9, 90);
    }
    public static ListNode solve(ListNode node, int position, int x) {
        ListNode newNode = new ListNode(x);
        ListNode temp = node;

        if (position == 0) {
            newNode.next = temp;
            return newNode;
        }

        int i = 0, k = position;
        while (i != k - 1 && temp.next != null) {
            temp = temp.next;
            i++;
        }

        newNode.next = temp.next;
        temp.next = newNode;

        return node;
    }
}
