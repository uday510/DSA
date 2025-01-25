package array;

public class AverageWaitingTime {
    public static void main(String[] args) {
        int[][] customers = {{1, 2}, {2, 5}, {4, 3}};
        System.out.println(averageWaitingTime(customers));
    }
    public static double averageWaitingTime(int[][] customers) {
        int waitTime = 0;
        int currentTime = 0;

        for (int[] customer : customers) {
            int arrivalTime = customer[0];
            int cookTime = customer[1];

            if (currentTime < arrivalTime) {
                currentTime = arrivalTime;
            }

            currentTime += cookTime;
            waitTime += currentTime - arrivalTime;
        }

        return (double) waitTime / customers.length;
    }
}
