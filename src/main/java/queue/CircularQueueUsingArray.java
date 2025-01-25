package queue;

public class CircularQueueUsingArray {
    static int[] queue = new int[1000];
    static int capacity = queue.length;
    static int currSize = capacity;
    static int front = -1;
    static int rear = -1;
    public static void main(String[] args) {

    }
    public static void enque(int val) {
        if (currSize == capacity) {
            System.out.println("Queue is over flow");
        } else {
            rear = (rear + 1) % capacity;
            queue[rear] = val;
            currSize++;
        }
    }
    public static void deque() {
        if (currSize == 0) {
            System.out.println("Queue is under flow");
        } else {
            front = (front + 1) % capacity;
            currSize--;
        }
    }
    public static int front() {
        if (currSize == 0) {
            System.out.println("Queue is under flow");
            return -1;
        }
        return queue[front + 1] % capacity;
    }
    public static int size() {
        return currSize;
    }
    public static boolean isEmpty() {
        return currSize == 0;
    }
}
