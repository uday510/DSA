package string;

public class IntegerToEnglishWords {
       int[] nums = {1_000_000_000, 1_000_000, 1000, 100,
                    90, 80, 70, 60, 50, 40,
                    30, 20, 19, 18, 17, 16,
                    15, 14, 13, 12, 11, 10,
                    9, 8, 7, 6, 5, 4, 3, 2, 1};
       String[] words = {"Billion" ,"Million", "Thousand", "Hundred","Ninety", "Eighty"
                        , "Seventy", "Sixty", "Fifty", "Forty", "Thirty", "Twenty"
                        , "Nineteen", "Eighteen", "Seventeen", "Sixteen", "Fifteen"
                        , "Fourteen", "Thirteen", "Twelve", "Eleven", "Ten", "Nine",
                        "Eight", "Seven", "Six", "Five", "Four", "Three", "Two", "One"};

    public String numberToWords(int currNum) {
            if (currNum == 0) return "";
            StringBuilder sb = new StringBuilder();
            int i = 0;

            while (currNum > 0) {
                if (nums[i] <= currNum) {
                    if (currNum < 100) {
                        currNum -= nums[i];
                        sb.append(words[i]).append(" ");
                    } else {
                        int quotient = currNum / nums[i];
                        sb.append(numberToWords(quotient)).append(" ").append(nums[i]).append(" ");
                        currNum %= nums[i];
                    }
                }
                ++i;
            }
            return sb.toString();
    }
}
