package Linear.Queues;

public class QueueUsingArray {
    static int[] queue = new int[1000];
    static int n = queue.length;
    static int front = -1;
    static int rear = -1;
    public static void main(String[] args) {

        enque(1);
        enque(2);
        enque(3);
        enque(4);

        System.out.println(deque());
    }
    public static void enque(int val) {
        if (rear + 1 == n) {
            System.out.print("Queue is over flow");
        } else {
            if (rear == -1) {
                front = rear = 0;
            } else {
                rear = rear + 1;
            }
            queue[rear] = val; // insert value
        }
    }
    public static int deque() {
        if (front == -1) {
            System.out.println("Queue is underflow");
        } else {
            int val = queue[front];
            if (front == rear) {
                front = rear = -1;
            } else {
                front = front + 1;
                return val;
            }
        }
        return -1;
    }
}
