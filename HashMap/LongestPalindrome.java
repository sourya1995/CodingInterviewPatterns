package HashMap;

import java.util.HashMap;
import java.util.Map;

class LongestPalindrome {
    public int longestPalindrome(String s) {
        if (s == null || s.isEmpty()) {
            return 0;
        }

        Map<Character, Integer> charCount = new HashMap<>();

        for (char c : s.toCharArray()) {
            charCount.put(c, charCount.getOrDefault(c, 0) + 1);
        }

        int longestPalindromeLength = 0;
        boolean oddCountFound = false;

        for (int count : charCount.values()) {
            if (count % 2 == 0) {
                longestPalindromeLength += count;
            } else {
                longestPalindromeLength += count - 1;
                oddCountFound = true;
            }
        }

        return longestPalindromeLength + (oddCountFound ? 1 : 0);
    }
}
