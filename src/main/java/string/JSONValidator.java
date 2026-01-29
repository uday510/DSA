package string;

public class JSONValidator {

    private static boolean isValidJSON(String s) {

    }

    static void main() {

        String[] testCases = {
                " { \"name\": \"John\", \"age\": 30, \"car\": null } ",
                " { name: \"John\" } ",
                "[1, 2, 3]",
                "{\"key\": \"value\",}"
        };

        for (String t : testCases) {
            System.out.println(STR."\{t} --> \{isValidJSON(t)}");
        }

    }

}
