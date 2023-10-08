import java.util.concurrent.*;

public class Client {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Value value = new Value();

        ExecutorService executorService = Executors.newCachedThreadPool();
//
//        Callable<Void> adder = () -> {
//            for (int i = 1; i <= 500; ++i) {
//                this.value.val += i;
//            }
//            return null;
//        };
//        Callable<Void> subtractor = () -> {
//            for (int i = 500; i >= 1; --i) {
//                this.value.val += i;
//            }
//            return null;
//        };
    }

    static class Value {
        int val;
        Value(int val) {
            this.val = val;
        }
        Value () {
            this.val = 0;
        }
    }
}
