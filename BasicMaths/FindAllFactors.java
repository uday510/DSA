public class FindAllFactors {
/**
 * Scaler Class 04:01:2023
 * */
    public static void main(String[] args) {
        int n = 24;
        System.out.println(solve(n));
    }
    public static int solve(int n) {
        int numOfFactors = 0;

        for(int i = 1; i * i <=n;) {
            if( n % i == 0) {
                if( i != n / i) numOfFactors += 1;
                else numOfFactors += 2;
            }
            i++;
        }
        return numOfFactors;
    }
}
