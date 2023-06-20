package Stacks;

import java.util.LinkedList;
import java.util.Queue;

public class StackUsingQueue {
    public static void main(String[] args) {

    }
    class MyStack {
        private Queue<Integer> q1;
        private Queue<Integer> q2;
        private int top;
        public MyStack() {
            q1 = new LinkedList<>();
            q2 = new LinkedList<>();
        }

        public void push(int x) {
            // O(1) time | O(1) space
            q1.add(x);
            top = x;
        }

        public int pop() {
            // O(N) time | O(1) space
            while (q1.size() > 1) {
                top = q1.remove();
                q2.add(top);
            }
            int val = q1.remove();
            Queue<Integer> temp = q1;
            q1 = q2;
            q2 = temp;

            return val;
        }

        public int top() {
            return top;
        }

        public boolean empty() {
            return q1.isEmpty();
        }
    }
}
