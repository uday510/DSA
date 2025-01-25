package string;

import java.util.*;

public class TimeTakenToCrossTheDoor {
    public static void main(String[] args) {

        int[] arrival = {0, 0, 0};
        int[] state = {1, 0, 1};

    }
    public static int[] timeTaken(int[] arrival, int[] state) {
        int N = arrival.length;
        Queue<Integer> entryQueue = new LinkedList<>();
        Queue<Integer> exitQueue = new LinkedList<>();

        // 0 denotes nothing happened, 1 denotes entry, -1 denotes exit
        int prevOperation = 0;
        int currPerson = 0;
        int flag = 0;
        int[] res = new int[N];

        for (int time = 0; flag < N; ++time) {

            // insert into queue
            while (currPerson < N && arrival[currPerson] == time) {

                if (state[currPerson] == 0) {
                    entryQueue.add(currPerson);
                } else {
                    exitQueue.add(currPerson);
                }
                ++currPerson;
            }

            // check for conditions

            // Default
            if (prevOperation == 0) {
                if (!exitQueue.isEmpty()) {
                    res[exitQueue.peek()] = time;
                    exitQueue.poll();
                    prevOperation = -1;
                    flag++;
                } else if (!entryQueue.isEmpty()) {
                    res[entryQueue.peek()] = time;
                    entryQueue.poll();
                    prevOperation = 1;
                    flag++;
                }
//                else {
//                    // keep it default
////                    prevOperation = 0;
//                }
            } else if (prevOperation == 1) {
                if (!entryQueue.isEmpty()) {
                    res[entryQueue.peek()] = time;
                    entryQueue.poll();
                    prevOperation = 1;
                    flag++;
                } else if (!exitQueue.isEmpty()) {
                    res[exitQueue.peek()] = time;
                    exitQueue.poll();
                    prevOperation = -1;
                    flag++;
                }
//                else {
//                    // keep it default
////                    prevOperation = 0;
//                }
            } else {
                  if (!exitQueue.isEmpty()) {
                    res[exitQueue.peek()] = time;
                    exitQueue.poll();
                    prevOperation = 1;
                    flag++;
                } else if (!entryQueue.isEmpty()) {
                      res[entryQueue.peek()] = time;
                      entryQueue.poll();
                      prevOperation = 1;
                      flag++;
                }
                else {
                    prevOperation = 0;
                }
            }
        }
        return res;
    }
}

/*
 If two or more persons want to use the door at the same time, they follow the following rules:

1. If the door was not used in the previous second, then the person who wants to exit goes first.

2. If the door was used in the previous second for entering, the person who wants to enter goes first.

3. If the door was used in the previous second for exiting, the person who wants to exit goes first.

4. If multiple persons want to go in the same direction, the person with the smallest index goes first.
 */
