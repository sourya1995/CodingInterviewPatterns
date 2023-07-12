package WhatToTrack;

import java.util.HashMap;

public class FirstuniquecharacterInString {
    class Solution {
        public int firstUniqChar(String s) {
            HashMap<Character, Integer> wordCount = new HashMap<Character, Integer>();
            for (int i = 0; i < s.length(); i++) {
                char ch = s.charAt(i);
                if (wordCount.containsKey(ch)) {
                    wordCount.put(ch, wordCount.get(ch) + 1);
                } else {
                    wordCount.put(ch, 1);
                }
            }

            for (int i = 0; i < s.length(); i++) {
                char ch = s.charAt(i);
                if (wordCount.get(ch) == 1) {
                    return i;
                }
            }

            return -1;
        }
    }
}
