package biweekly.contest138;

public class GenerateKey {
    public static void main(String[] args) {
        int num1 = 282;
        int num2 = 718;
        int num3 = 1028;

        System.out.println(generateKey(num1, num2, num3));
    }
    public static int generateKey(int num1, int num2, int num3) {
        int key = 0;
        int[] keyArr = new int[4];

        for (int i = 0; i < 4; ++i) {
            int min = Math.min(num1 % 10, Math.min(num2 % 10, num3 % 10));
            keyArr[i] = min;
            num1 /= 10;
            num2 /= 10;
            num3 /= 10;
        }
        for (int i = 3; i > -1; --i) {
            key = key * 10 + keyArr[i];
        }
        return key;
    }
}
