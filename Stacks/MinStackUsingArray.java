/**
 * Problem Description
 *
 * Design a stack that supports push, pop, top, and retrieve the minimum element in constant time.
 * push(x) -- Push element x onto stack.
 * pop() -- Removes the element on top of the stack.
 * top() -- Get the top element.
 * getMin() -- Retrieve the minimum element in the stack.
 * NOTE:
 * All the operations have to be constant time operations.
 * getMin() should return -1 if the stack is empty.
 * pop() should return nothing if the stack is empty.
 * top() should return -1 if the stack is empty.
 * Problem Constraints
 *
 * 1 <= Number of Function calls <= 107
 * Input Format
 *
 * Functions will be called by the checker code automatically.
 * Output Format
 *
 * Each function should return the values as defined by the problem statement.
 * Example Input
 *
 * Input 1:
 * push(1)
 * push(2)
 * push(-2)
 * getMin()
 * pop()
 * getMin()
 * top()
 * Input 2:
 * getMin()
 * pop()
 * top()
 * Example Output
 *
 * Output 1:
 *  -2 1 2
 * Output 2:
 *  -1 -1
 * Example Explanation
 *
 * Explanation 1:
 * Let the initial stack be : []
 * 1) push(1) : [1]
 * 2) push(2) : [1, 2]
 * 3) push(-2) : [1, 2, -2]
 * 4) getMin() : Returns -2 as the minimum element in the stack is -2.
 * 5) pop() : Return -2 as -2 is the topmost element in the stack.
 * 6) getMin() : Returns 1 as the minimum element in stack is 1.
 * 7) top() : Return 2 as 2 is the topmost element in the stack.
 * Explanation 2:
 * Let the initial stack be : []
 * 1) getMin() : Returns -1 as the stack is empty.
 * 2) pop() :  Returns nothing as the stack is empty.
 * 3) top() : Returns -1 as the stack is empty.
 */
package Stacks;

public class MinStackUsingArray {
    static int topOfStack = -1;

    static int[] stack = new int[1000];
    static int[] minStack = new int[1000];
    static int topOfMinStack = -1;

    public static void main(String[] args) {
        // DAY : 59

        push(1);
        push(2);
        push(-2);
        System.out.println(getMin());
        pop();
        System.out.println(getMin());
        System.out.println(top());
    }
    public static void push(int x) {
        int n = stack.length;

        if (topOfMinStack == -1 || minStack[topOfMinStack] > x) {
            minStack[++topOfMinStack] = x ;
        }

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
            int val = stack[topOfStack--];
            if (val == minStack[topOfMinStack]) {
                topOfMinStack--;
            }
            return val;
        }
    }

    public static int top() {
        if (topOfStack == -1) {
            System.out.println("Stack is under flow");
            return -1;
        }
        return stack[topOfStack];
    }

    public static int getMin() {
        if (topOfMinStack == -1) {
            System.out.println("Stack is under flow");
            return -1;
        }
        return minStack[topOfMinStack];
    }

    public static boolean isEmpty() {
        return topOfStack == -1;
    }

}
