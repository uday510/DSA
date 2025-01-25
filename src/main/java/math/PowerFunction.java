package math;

public class PowerFunction {

    public static void main(String[] args) {
        int ans = power(2, 3);
        System.out.println(ans);
    }
    public static int power(long a, long n) {
    if (n==0) return 1;
    long temp1 = power(a, n/2);
    long temp2 = (temp1*temp1);
    if (n%2 != 0) //odd
        return (int) ((a * temp2));
    return (int) ((a * temp1));
  }
    public static long pow(long a, long b){
        long res = 1;
        while(b > 0){ // binary exponentiation
            if((b & 1) != 0){ // if b is odd
                res = (res * a) % 998244353; // multiply res with a
            }
            a = (a * a) % 998244353; // square a
            b = b >> 1; // divide b by 2
        }
        return res;
    }
}
