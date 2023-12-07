package Recursion;

/*
 Problem:

Given a numerical dollar amount (USD), provide the English phrase that describes the amount.

You may assume the input is between $0 and $999.99

ex. convertCurrency(“$138.17”) = “one hundred thirty eight dollars and seventeen cents”

ex. convertCurrency(“$241.00”) = “two hundred fourty one dollars”
 */

public class CurrencyConverter {
    private static final int[] nums = { 12, 11, 10, 9, 8, 7, 6, 5, 4, 3, 2, 1, 0};
    private static final String[] words = { "twelve", "eleven", "ten", "nine",
            "eight", "seven", "six", "five", "four", "three", "two", "one", "zero"};

    public static String convertCurrency(String numStr) {
        String[] amount = numStr.substring(1).split("\\.");
        int num = Integer.parseInt(amount[0]);

        if (num == 0) {
            return words[words.length - 1] + " dollars";
        }

        StringBuilder sb = new StringBuilder();
        int i = 0;

        while (num > 0) {
            if (nums[i] <= num) {
                if (num < 100) {
                    sb.append(words[i]).append(" ");
                    num -= nums[i];
                } else {
                    int quotient = num / nums[i];
                    sb.append(convertCurrency("$" + quotient)).append(" ").append(words[i]).append(" ");
                    num %= nums[i];
                }
            }
            i++;
        }

        String res = sb.toString().trim();
        boolean hasCents = amount.length > 1 && Integer.parseInt(amount[1]) > 0;

        if (hasCents) {
            res += " and ";
            int cents = Integer.parseInt(amount[1]);

            if (cents < 10) {
                res += words[cents] + " cent";
            } else {
                res += convertCurrency("$" + cents) + " cents";
            }
        } else {
            res += " dollars";
        }

        return res;
    }

    public static void main(String[] args) {
//        System.out.println(convertCurrency("$4"));
        System.out.println(convertCurrency("$12.01"));
//        System.out.println(convertCurrency("$320"));
    }

    /*
     System.out.println(new TestCase("$4", "four dollars").validate());
        System.out.println(new TestCase("$0", "zero dollars").validate());
        System.out.println(new TestCase("$1", "one dollar").validate());
        System.out.println(new TestCase("$12.01", "twelve dollars and one cent").validate());
        System.out.println(new TestCase("$30", "thirty dollars").validate());
        System.out.println(new TestCase("$71", "seventy one dollars").validate());
        System.out.println(new TestCase("$56", "fifty six dollars").validate());
        System.out.println(new TestCase("$90.00", "ninety dollars").validate());
        System.out.println(new TestCase("$100", "one hundred dollars").validate());
        System.out.println(new TestCase("$217.84", "two hundred seventeen dollars and eighty four cents").validate());
        System.out.println(new TestCase("$320", "three hundred twenty dollars").validate());
        System.out.println(new TestCase("$350.21", "three hundred fifty dollars and twenty one cents").validate());
        System.out.println(new TestCase("$701.82", "seven hundred one dollars and eighty two cents").validate());
     */

}

