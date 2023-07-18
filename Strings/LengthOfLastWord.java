package Strings;

public class LengthOfLastWord {
    class Solution {
        public int lengthOfLastWord(String s) {
            s = s.trim(); // Remove leading and trailing whitespace
            if (s.isEmpty()) { // Check if string is empty
                return 0;
            }

            String[] words = s.split(" "); // Split string into words
            if (words.length == 0) { // Check if words array is empty
                return 0;
            }

            String lastWord = words[words.length - 1]; // Retrieve the last word
            return lastWord.length(); // Return length of the last word
        }

    }

}
