/**
 * Problem Description
 *
 * Implement a stack which will support following types of operations:
 *
 * Type 1: "1 x" : Push x into the stack.
 * Type 2: "2 0" : Pop the top element from the stack and return it.
 * Type 3: "3 0" : Return the middle element of the stack.
 * Type 4: "4 0" : Delete the middle element from the stack.
 * You have to perform Q operations given in a form of 2-D array A of size Q x 2 where A[i][0] and A[i][1] denotes the operation parameters as explained above.
 *
 * NOTE:
 *
 * You have to output only for operations of type-2 and type-3.
 * If the stack is empty return -1 for operations of type-2 and type-3.
 * If the stack size is even then the second middle element will be considered as middle element for the operations to perform.
 * Try to implement each operation in O(1) time complexity.
 *
 *
 * Problem Constraints
 *
 * 1 <= Q <= 105
 *
 * 1 <= x <= 103
 *
 *
 *
 * Input Format
 *
 * First and only argument A is and 2-D array of size Q x 2 denoting the operations.
 *
 *
 *
 * Output Format
 *
 * Return a 1-D array consisting the output of operations of type-2 and type-3. The order must be same as in input.
 *
 *
 *
 * Example Input
 *
 * Input 1:
 *
 *  A = [
 *         [1, 3]
 *         [3, 0]
 *         [4, 0]
 *         [2 ,0]
 *         [1, 5]
 *         [1, 9]
 *         [3, 0]
 *      ]
 * Input 2:
 *
 *  A = [
 *         [1, 1]
 *         [1, 2]
 *         [1, 3]
 *         [3, 0]
 *         [4, 0]
 *         [3, 0]
 *         [4, 0]
 *      ]
 *
 *
 * Example Output
 *
 * Output 1:
 *
 *  [3, -1, 9]
 * Output 2:
 *
 *  [2, 3]
 *
 *
 * Example Explanation
 *
 * Explanation 1:
 *
 *  Initial stack S = [ ]
 *  Operation 1: "1 3" : Push 3 into stack so stack becomes S = [3]
 *  Operation 2: "3 0" : Middle element of stack is 3 so adding 3 to output array.
 *  Operation 3: "4 0" : Deleting the middle element i.e 3 so stack becomes S = [ ]
 *  Operation 4: "2 0" : Popping element from the stack but the stack is empty so adding -1 to the output array.
 *  Operation 5: "1 5" : Push 5 into stack so stack becomes S = [5]
 *  Operation 6: "1 9" : Push 9 into stack so stack becomes S = [5, 9] where 9 is the top element of the stack.
 *  Operation 7: "3 0" : As stack size is even so 9 will be consider as middle element and we will add 9 to output array. Stack S remains same.
 * Explanation 2:
 *
 *  Initial stack S = [ ]
 *  Operation 1: "1 1" : Push 1 into stack so stack becomes S = [1]
 *  Operation 2: "1 2" : Push 2 into stack so stack becomes S = [1, 2]
 *  Operation 3: "1 3" : Push 3 into stack so stack becomes S = [1, 2, 3]
 *  Operation 4: "3 0" : Middle element of stack is 2 so adding 2 to output array. Stack S remains same [1, 2, 3].
 *  Operation 5: "4 0" : Deleting the middle element i.e 2 so stack becomes S = [1, 3]
 *  Operation 6: "3 0" : Middle element of stack is 3 so adding 3 to output array. Stack S remains same [1, 3].
 *  Operation 6: "4 0" : Deleting the middle element i.e 3 so stack becomes S = [1]
 */
package Stacks;

import java.util.ArrayList;
import java.util.Arrays;
public class MiddleElementFromStack {
    static int count = 0;
    static DoublyLinkedList doublyLinkedList;
    public static void main(String[] args) {
        int[][] arr = { {1, 3}, {3, 0},
                        {4, 0}, {2, 0},
                        {1, 5}, {1, 9},
                        {3, 0}};

        int[] ans = solve(arr);
        System.out.println(Arrays.toString(ans));
    }
    public static int[] solve (int[][] arr) {
        count = 0;
        ArrayList<Integer> ans = new ArrayList<>();
        doublyLinkedList = new DoublyLinkedList();

        for (int[] a : arr) {
            int operation = a[0];

            switch (operation) {
                case 1:
                    push(a[1]);
                    break;
                case 2:
                    ans.add(pop());
                    break;
                case 3:
                    ans.add(getMiddle());
                    break;
                case 4:
                    deleteMiddle();
                    break;
            }
        }
        return ans.stream().mapToInt(i -> i).toArray();
    }
    public static void push(int val) {

        Node newNode = new Node(val);
        newNode.next = doublyLinkedList.head;
        count += 1;

        /**
         * change the mid-pointer in two cases
         * 1. linked list is empty
         * 2. Number of nodes in linked list is odd
         */
        if (count == 1) {
            doublyLinkedList.middle = newNode;
        } else {
            doublyLinkedList.head.prev = newNode;
            // update mid if count is even
            if ( (count & 1) == 0)  {
                doublyLinkedList.middle = doublyLinkedList.middle.prev;
            }
        }

        doublyLinkedList.head = newNode;

    }

    public static int pop() {
        if (count == 0) {
            return -1;
        }

        Node head = doublyLinkedList.head;
        int val = head.value;

        doublyLinkedList.head = head.next;

        if (doublyLinkedList.head != null) {
            doublyLinkedList.head.prev = null;
        }
        count -= 1;

        // update the mid-pointer when
        // have the odd number of elements in the stack

        if ( (count & 1) != 0) {
            doublyLinkedList.middle = doublyLinkedList.middle.next;
        }
        return val;
    }

    public static int getMiddle() {
        if (count == 0) {
            return -1;
        }
        return doublyLinkedList.middle.value;
    }

    public static void deleteMiddle() {

        if (count == 0) return;
        else if (count == 1) {
            count = 0;
            doublyLinkedList.head = null;
            doublyLinkedList.middle = null;
        } else if (count == 2) {
            count = 1;
            Node head = doublyLinkedList.head;
            doublyLinkedList.head = head.next;
            doublyLinkedList.head.prev = null;
            doublyLinkedList.middle = doublyLinkedList.head;
        } else {
            Node midNext = doublyLinkedList.middle.next;
            Node midPrev = doublyLinkedList.middle.prev;
            doublyLinkedList.middle.prev.next = doublyLinkedList.middle.next;
            doublyLinkedList.middle.next.prev = doublyLinkedList.middle.prev;

            count -= 1;

            // if odd
            if ( (count & 1) != 0) doublyLinkedList.middle = midNext;
            else doublyLinkedList.middle = midPrev;
        }
    }
}

class DoublyLinkedList {
    Node head = null;
    Node middle = null;

}
class Node {
    int value;
    Node prev = null;
    Node next = null;

    public Node(int value) {
        this.value = value;
    }
}
