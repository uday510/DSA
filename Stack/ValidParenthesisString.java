package Stack;

public class ValidParenthesisString {
    public static void main(String[] args) {
        String s = "(*))";
        System.out.println(checkValidString(s));
    }
    public static boolean checkValidString(String s) {

        int low = 0;
        int high = 0;

        for(char c : s.toCharArray()){
            if(c == '('){
                low++;
                high++;
            }else if(c == ')'){
                low--;
                high--;
            }else{
                low--;
                high++;
            }
            if(high < 0) return false;
            low = Math.max(low, 0);
        }
        return low == 0;
    }

}
