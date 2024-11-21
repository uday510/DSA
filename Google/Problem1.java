package Google;

/**
 * Consider a bank with some intial amount of money. Consider an array which represents list of transactions which are going to come through customers. + means deposit - means withdrawl. Bank can choose from which customer they want to start serving the customers and they can refuse any number of customers. But once they start they have to serve till the time its impossible to serve the customers. Maximize the total customers bank can serve.
 *
 * Example :
 * Bank has 1 unit of money intially.
 * Customer transactions : [1, -3, 5, -2, 1]
 *
 * answer = 3
 *
 * Bank starts with customer with deposit of 5
 * 1+ 5 = 6
 * 6 - 2 = 4
 * 4 + 1 =5
 *
 * If bank starts at in index 0 can only serve 1 customer
 * 1+1 =2
 * 2-3 = -1 not possible to serve any more customers
 */
public class Problem1 {
    public static void main(String[] args) {
        int[] transactions = {1, -3, 5, -2, 1};
        System.out.println(maxCustomers(transactions, 1));
    }
    public static int maxCustomers(int[] transactions, int initialAmount) {
        int maxCustomers = 0;

        int len = transactions.length;

        for (int i = 0; i < len; ++i) {

           int currBalance = transactions[i];
           int customers = 0;

           for (int j = i + 1; j < len; ++j) {
               currBalance += transactions[j];
               if (currBalance >= 0) {
                   customers++;
               } else {
                     break;
               }
           }

           maxCustomers = Math.max(maxCustomers, customers);
        }

        return maxCustomers;
    }
}
