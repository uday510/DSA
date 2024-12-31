package scripting;

import java.io.BufferedReader;
import java.io.FileReader;

/**
 * Given a file containing some sample text, write a script command to change all occurrences of the word “Amazon” with “It” in the file.
 */
public class Occurances {

    public static void main(String[] args) {
       String file = "/Users/uday/Desktop/Projects/DSA/scripting/file.txt";
       String pattern = "Amazon";
       int count = 0;

       try (BufferedReader br = new BufferedReader(new FileReader(file))) {
           String line;

           while ((line = br.readLine()) != null) {
               String[] words = line.toLowerCase().split(" ");
               for (String word : words) {
                   if (word.equalsIgnoreCase(pattern)) {
                       count++;
                   }
               }
           }

           System.out.println("Total occurrences of the word " + pattern + " in the file: " + count);
       } catch (Exception exception) {
           System.out.println("Error: " + exception.getMessage());
       }
    }
}
