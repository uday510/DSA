package string;

public class RomanToInteger {
    String[] romans = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X",
            "IX", "V", "IV", "I"};
    int[] integers = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};

    public String intToRoman(int num) {

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < integers.length && num > 0; ++i) {

            while (integers[i] <= num) {
                sb.append(romans[i]);
                num -= integers[i];
            }
        }
        return sb.toString();
    }
}
