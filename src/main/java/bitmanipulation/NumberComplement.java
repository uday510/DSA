package bitmanipulation;

public class NumberComplement {
    public static void main(String[] args) {
        int num = 5;
        System.out.println(findComplement(num));
    }
    public static int findComplement(int num) {
        int mask = 1;
        while (mask < num) {
            mask = (mask << 1) | 1;
        }
        return num ^ mask;
    }
}
