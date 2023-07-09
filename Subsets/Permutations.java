package Subsets;

import java.util.ArrayList;
import java.util.List;

public class Permutations {
    public static char[] swapChar(String word, int i, int j) {
        char[] swapIndex = word.toCharArray();
        char temp = swapIndex[i];
        swapIndex[i] = swapIndex[j];
        swapIndex[j] = temp;

        return swapIndex;
    }

    public static void permuteStringRec(String word, int currentIndex, List<List<Integer>> results) {
        if (currentIndex == word.length() - 1) {
            List<Integer> permutation = new ArrayList<>();
            for (char ch : word.toCharArray()) {
                permutation.add(Character.getNumericValue(ch));
            }
            results.add(permutation);
            return;
        }
        for (int index = currentIndex; index < word.length(); index++) {
            char[] swappedStr = swapChar(word, currentIndex, index);
            permuteStringRec(String.valueOf(swappedStr), currentIndex + 1, results);
        }

    }

    public static List<List<Integer>> permuteWord(String word) {
        List<List<Integer>> results = new ArrayList<>();
        permuteStringRec(word, 0, results);
        return results;
    }
}
