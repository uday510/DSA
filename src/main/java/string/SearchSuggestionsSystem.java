package string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SearchSuggestionsSystem {

    public static void main(String[] args) {

    }
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {

        Arrays.sort(products);

        System.out.println(Arrays.toString(products));

        int l = 0, r = products.length -1;
        List<List<String>> res = new ArrayList<>();

        for (int i = 0; i < searchWord.length(); ++i) {
            char c = searchWord.charAt(i);

            while (l <= r && (products[l].length() <= i || products[l].charAt(i) != c)) {
                l++;
            }

            while (l <= r && (products[r].length() <= i || products[r].charAt(i) != c)) {
                r--;
            }

            int remain = r - l + 1;
            List<String> tmp = new ArrayList<>();

            for (int j = 0; j < Math.min(remain, 3); ++j) {
                tmp.add(products[l+j]);
            }
            res.add(tmp);
        }


        return res;
    }
}
