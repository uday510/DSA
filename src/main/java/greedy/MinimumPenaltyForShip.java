package greedy;

public class MinimumPenaltyForShip {
    public static void main(String[] args) {
        String customers = "YYNY";

        System.out.println(bestClosingTime(customers));

    }
    public static int bestClosingTime (String customers) {
        int totalPenalty = getPenaltyCount(customers);
        int minPenalty = totalPenalty;
        int res = 0;
        int late = 0;
        int n = customers.length();

        for (int hour = 1; hour <= n; ++hour) {
            char c = customers.charAt(hour - 1);

            totalPenalty -= (c == 'Y') ? 1 : 0;
            late += (c == 'N') ? 1 : 0;

            int currPenalty = totalPenalty + late;

            if (currPenalty < minPenalty) {
                minPenalty = currPenalty;
                res = hour;
            }
        }

        return res;
    }
    public static int getPenaltyCount (String  customers) {

        int count = 0;

        for (int i = 0; i < customers.length(); ++i) {

            char c = customers.charAt(i);

            if (c == 'Y') {
                ++count;
            }
        }
        return count;
    }
}
