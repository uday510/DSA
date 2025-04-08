package stack;

import java.util.ArrayDeque;
import java.util.Deque;

class Stack<T> {

    Deque<T> stack;

    Stack() {
        stack = new ArrayDeque<>();
    }

    void push(T t) {
        stack.push(t);
    }

    T pop() {
        return stack.isEmpty() ? null: stack.pop();
    }
}
public class DinnerPlateStacks {

    public static void main(String[] args) {

        Stack<Integer> st = new Stack<>();
        st.push(10);
        st.push(11);
        System.out.println(st.pop());
    }
}
