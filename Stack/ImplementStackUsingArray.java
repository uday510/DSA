package Stack;

public class ImplementStackUsingArray {
    static int topOfStack = -1;
    static int[] stack = new int[4];


    public static void main(String[] args) {

    }
    public static void push(int x) {
        int n = stack.length;
        if (topOfStack + 1 == n) {
            System.out.println("Stack is over flow");
        } else {
            stack[++topOfStack] = x;
        }
    }
    public static int pop() {
        if (topOfStack == -1) {
            System.out.println("Stack is under flow");
            return -1;
        } else {
            return stack[topOfStack--];
        }
    }
    public static int getTopOfStack() {
        if (topOfStack == -1) {
            System.out.println("Stack is under flow");
            return -1;
        }
        return stack[topOfStack];
    }

    public static boolean isEmpty() {
        return topOfStack == -1;
    }
}
