package binarysearch.search;

public class SmallerLetterGreaterThanTarget {

    public char nextGreatestLetter(char[] letters, char target) {

        int l = 0, r = letters.length;

        while (l < r) {
            int m = (l + r) >> 1;

            if (letters[m] <= target) l = m + 1;
            else r = m;
        }

        return (l == letters.length ? letters[0] : letters[l]);
    }
}
