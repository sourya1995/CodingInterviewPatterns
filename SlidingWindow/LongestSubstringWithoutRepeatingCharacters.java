package SlidingWindow;

import java.util.Hashtable;

public class LongestSubstringWithoutRepeatingCharacters {

    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 0) {
            return 0;
        }

        int n = s.length();
        int windowStart = 0, longest = 0, windowLength = 0, i = 0;
        Hashtable<Character, Integer> lastSeenAt = new Hashtable<Character, Integer>();

        for (i = 0; i < n; i++) {
            if (!lastSeenAt.containsKey(s.charAt(i))) {
                lastSeenAt.put(s.charAt(i), i);
            } else {
                if (lastSeenAt.get(s.charAt(i)) >= windowStart) {
                    windowLength = i - windowStart;
                    if (longest < windowLength) {
                        longest = windowLength;
                    }

                    windowStart = lastSeenAt.get(s.charAt(i)) + 1;
                }

                lastSeenAt.replace(s.charAt(i), i);
            }
        }

        if (longest < i - windowStart) {
            longest = i - windowStart;
        }

        return longest;
    }
}
