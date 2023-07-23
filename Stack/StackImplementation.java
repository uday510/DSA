package Stack;

import java.util.ArrayList;
import java.util.List;

public class StackImplementation {
    private List<Integer> data;

    public StackImplementation() {
        data = new ArrayList<Integer>();
    }

    public void push(int x) {
        data.add(x);
    }
    public boolean isEmpty() {
        return data.isEmpty();
    }
    public int top() {
        return data.get(data.size() - 1);
    }
    public boolean pop() {
        if (isEmpty()) {
            return false;
        }
        data.remove(data.size() - 1);
        return true;
    }

    public static void main(String[] args) {
        StackImplementation s = new StackImplementation();
        s.push(5);
        s.push(3);
        System.out.println(s.top());
        s.pop();
        System.out.println(s.top());
        s.pop();
        System.out.println(s.isEmpty());
    }
}
