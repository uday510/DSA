package linkedlist;

public class NodesBetweenCriticalPoints {
    public static void main(String[] args) {

    }

    /**
     * A critical point in a linked list is defined as either a local maxima or a local minima.
     *
     * A node is a local maxima if the current node has a value strictly greater than the previous node and the next node.
     *
     * A node is a local minima if the current node has a value strictly smaller than the previous node and the next node.
     *
     * Note that a node can only be a local maxima/minima if there exists both a previous node and a next node.
     *
     * Given a linked list head, return an array of length 2 containing [minDistance, maxDistance] where minDistance is the minimum distance between any two distinct critical points and maxDistance is the maximum distance between any two distinct critical points. If there are fewer than two critical points, return [-1, -1].
     * @param head
     * @return
     */
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        int[] res = new int[]{-1, -1};
        ListNode prev = head;
        ListNode curr = head.next;
        ListNode next = head.next.next;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        int count = 0;
        while (next != null) {
            if (prev.val < curr.val && curr.val > next.val) {
                count++;
                if (count > 1) {
                    min = Math.min(min, count);
                    max = Math.max(max, count);
                }
                count = 0;
            } else if (prev.val > curr.val && curr.val < next.val) {
                count++;
                if (count > 1) {
                    min = Math.min(min, count);
                    max = Math.max(max, count);
                }
                count = 0;
            } else {
                count++;
            }
            prev = curr;
            curr = next;
            next = next.next;
        }
        if (min == Integer.MAX_VALUE) {
            return res;
        }
        res[0] = min;
        res[1] = max;
        return res;
    }
}
