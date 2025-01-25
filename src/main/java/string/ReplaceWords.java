package string;
import java.util.List;

public class ReplaceWords {
    public static void main(String[] args) {
        String str = "the cattle was rattled by the battery";
        List<String> dictionary = List.of("catt", "cat", "bat", "rat");
        ReplaceWords replaceWords = new ReplaceWords();

        System.out.println(replaceWords.replaceWords(dictionary, str));
    }

    public String replaceWords(List<String> dictionary, String sentence) {
        String[] words = sentence.split(" ");
        StringBuilder sb = new StringBuilder();

        for (String word : words) {
            boolean flag = false;
            String appendedString = word;
            for (String root : dictionary) {
                if (word.startsWith(root)) {
                    appendedString = root;
                    flag = true;
                }
            }
            sb.append(flag ? appendedString : word).append(" ");
        }
        return sb.toString().trim();
    }
}
