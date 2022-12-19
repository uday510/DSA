import java.util.Arrays;

public class NonConstructibleChange {
    public static void main(String[] args) {
        int[] coins = {5, 7, 1, 1, 2, 3, 22};
        System.out.println(solve(coins));
    }
    public static int solve(int[] coins) {

        Arrays.sort(coins);
        int currentChangeCreated = 0;

        for(int coin: coins) {
            if(coin > currentChangeCreated + 1) return currentChangeCreated + 1;
            currentChangeCreated += coin;
        }
        return currentChangeCreated + 1;
    }

}
