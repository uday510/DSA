package scripting;

import java.io.BufferedReader;
import java.io.FileReader;

public class Test {
    public static void main(String[] args) {
        String filePath = "/Users/uday/Desktop/Projects/DSA/scripting/file.txt";
        String pattern = "Amazon";
        int cnt = 0;
        String line;

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {

            while ( (line = br.readLine()) != null) {
                String[] curr = line.toLowerCase().split(" ");

                for (String str : curr) {
                    if (pattern.equalsIgnoreCase(str)) {
                        ++cnt;
                    }
                }
            }

            System.out.println(cnt);
        } catch (Exception exception) {
            System.out.println(exception);
        }
    }
}
