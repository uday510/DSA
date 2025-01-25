package queue;

import java.util.Stack;

public class QueueImplementationUsingStack {

    Stack<Integer> stack1 = new Stack<>();
    Stack<Integer> stack2 = new Stack<>();
    public static void main(String[] args) {

    }

    /**
     * enque()
     * deque()
     * front()
     *
     * push()
     * pop()
     * top()
     */
    private Stack<Integer> s1;
    private Stack<Integer> s2;
    private int front;

    public void MyQueue() {
        s1 = new Stack<>();
        s2 = new Stack<>();
    }

    public void push(int x) {
        if (s1.empty()) {
            front = x;
        }
        s1.push(x);
    }

    public int pop() {
        if (s2.isEmpty()) {
            while (!s1.isEmpty()) {
                s2.push(s1.pop());
            }
        }
        return s2.pop();
    }

    public int peek() {
        if (!s2.isEmpty()) {
            return s2.peek();
        }
        return front;
    }

    public boolean empty() {
        return s1.isEmpty() && s2.isEmpty();

    }

}
