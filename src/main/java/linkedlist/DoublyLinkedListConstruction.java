/**
 *

 Write a DoublyLinkedList class that has a head and a tail, both of which point to either a linked list Node or None / null. The class should support:

 Setting the head and tail of the linked list.
 Inserting nodes before and after other nodes as well as at given positions (the position of the head node is 1).
 Removing given nodes and removing nodes with given values.
 Linear.Searching for nodes with given values.

 Note that the setHead, setTail, insertBefore, insertAfter, insertAtPosition, and remove
 methods all take in actual Nodes as input parameters—not integers (except for insertAtPosition,
 which also takes in an integer representing the position);
 this means that you don't need to create any new Nodes in these methods. The input nodes can be
 either stand-alone nodes or nodes that are already in the linked list. If they're nodes that are
 already in the linked list, the methods will effectively be moving the nodes within the linked list.
 You won't be told if the input nodes are already in the linked list, so your code will have to defensively handle this scenario.

 If you're doing this problem in an untyped language like Python or JavaScript,
 you may want to look at the various function signatures in a typed language
 like Java or TypeScript to get a better idea of what each input parameter is.

 Each Node has an integer value as well as a prev node and a next node, both of which can point to either another node or None / null.
 Sample Usage

 // Assume the following linked list has already been created:
 1 <-> 2 <-> 3 <-> 4 <-> 5
 // Assume that we also have the following stand-alone nodes:
 3, 3, 6
 setHead(4): 4 <-> 1 <-> 2 <-> 3 <-> 5 // set the existing node with value 4 as the head
 setTail(6): 4 <-> 1 <-> 2 <-> 3 <-> 5 <-> 6 // set the stand-alone node with value 6 as the tail
 insertBefore(6, 3): 4 <-> 1 <-> 2 <-> 5 <-> 3 <-> 6 // move the existing node with value 3 before the existing node with value 6
 insertAfter(6, 3): 4 <-> 1 <-> 2 <-> 5 <-> 3 <-> 6 <-> 3 // insert a stand-alone node with value 3 after the existing node with value 6
 insertAtPosition(1, 3): 3 <-> 4 <-> 1 <-> 2 <-> 5 <-> 3 <-> 6 <-> 3 // insert a stand-alone node with value 3 in position 1
 removeNodesWithValue(3): 4 <-> 1 <-> 2 <-> 5 <-> 6 // remove all nodes with value 3
 remove(2): 4 <-> 1 <-> 5 <-> 6 // remove the existing node with value 2
 containsNodeWithValue(5): true


 */
package linkedlist;

public class DoublyLinkedListConstruction {
    public Node head;
    public Node tail;
    public static class Node {
        public int value;
        public Node prev;
        public Node next;

        public Node(int value) {
            this.value = value;
        }
    }
    public static void main(String[] args) {

    }
    public void setHead(Node node) {
        if (head == null) {
            head = node;
            tail = node;
            return;
        }
        insertBefore(head, node);
    }

    // O(1) time | O(1) space
    public void setTail(Node node) {
        if (tail == null) {
            setHead(node);
            return;
        }
        insertAfter(tail, node);
    }

    // O(1) time | O(1) space
    public void insertBefore(Node node, Node nodeToInsert) {
        if (nodeToInsert == head && nodeToInsert == tail) return;
        remove(nodeToInsert);
        nodeToInsert.prev = node.prev;
        nodeToInsert.next = node;
        if (node.prev == null) {
            head = nodeToInsert;
        } else {
            node.prev.next = nodeToInsert;
        }
        node.prev = nodeToInsert;
    }

    // O(1) time | O(1) space
    public void insertAfter(Node node, Node nodeToInsert) {
        if (nodeToInsert == head && nodeToInsert == tail) return;
        remove(nodeToInsert);
        nodeToInsert.prev = node;
        nodeToInsert.next = node.next;
        if (node.next == null) {
            tail = nodeToInsert;
        } else {
            node.next.prev = nodeToInsert;
        }
        node.next = nodeToInsert;
    }

    // O(p) time | O(1) space
    public void insertAtPosition(int position, Node nodeToInsert) {
        if (position == 1) {
            setHead(nodeToInsert);
            return;
        }
        Node node = head;
        int currentPosition = 1;
        while (node != null && currentPosition++ != position) node = node.next;
        if (node != null) {
            insertBefore(node, nodeToInsert);
        } else {
            setTail(nodeToInsert);
        }
    }

    // O(n) time | O(1) space
    public void removeNodesWithValue(int value) {
        Node node = head;
        while (node != null) {
            Node nodeToRemove = node;
            node = node.next;
            if (nodeToRemove.value == value) remove(nodeToRemove);
        }
    }

    // O(1) time | O(1) space
    public void remove(Node node) {
        if (node == head) head = head.next;
        if (node == tail) tail = tail.prev;
        removeNodeBindings(node);
    }

    // O(n) time | O(1) space
    public boolean containsNodeWithValue(int value) {
        Node node = head;
        while (node != null && node.value != value) {
            node = node.next;
        }
        return node != null;
    }

    // O(1) time | O(1) space
    public void removeNodeBindings(Node node) {
        if (node.prev != null) node.prev.next = node.next;
        if (node.next != null) node.next.prev = node.prev;
        node.prev = null;
        node.next = null;
    }

}
