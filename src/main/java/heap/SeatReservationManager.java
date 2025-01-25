package heap;

import java.util.HashSet;
import java.util.Set;

public class SeatReservationManager {

    public static void main(String[] args) {

    }
    static class SeatManager {
        Set<Pair> bookings = new HashSet<>();
        int reservedCount = 0;
        public SeatManager(int n) {
            for (int i = 1; i <= n; ++i) {
                Pair p = new Pair(i);
                bookings.add(p);
            }
        }


        public void unreserve(int seatNumber) {

        }

        static class Pair {
            int num;
            boolean flag;
            Pair(int num) {
                this.num = num;
                flag = false;
            }
        }
    }
}
