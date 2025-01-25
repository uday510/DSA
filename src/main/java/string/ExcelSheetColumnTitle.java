package string;

public class ExcelSheetColumnTitle {
    public static void main(String[] args) {
        System.out.println(convertToTitle(701));
    }

    public static String convertToTitle(int columnNumber) {

        StringBuilder sb = new StringBuilder();

        while (columnNumber > 0) {
            columnNumber -= 1;

            char c =  (char) (64 + (columnNumber % 26) + 1);

            sb.append(c);
            columnNumber = columnNumber / 26;

            System.out.println(sb + " " + columnNumber);

        }

        return sb.reverse().toString();
    }

}
