public class Main {
    public static void main(String[] args) {

        Thread thread = new Thread(() -> {
            System.out.println("Thread is Running...");
        });

        thread.start();
    }
}