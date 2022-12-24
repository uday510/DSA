// https://practice.geeksforgeeks.org/problems/count-digits5716/1
public class CountDigits {
    public static void main(String[] args) {
        int n = 23;
        System.out.println(evenlyDivides(n));
    }
    public static int evenlyDivides(int n) {
        // O(log(N)) time | O(1) space
        int result = 0;
        int num = n; // 23
        while(num != 0) {
            int temp = num % 10;
            if(temp != 0 && (n % temp) == 0) result++;
            num /= 10;
        }
        return result;
    }
}
