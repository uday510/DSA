package BasicMaths;

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
}
