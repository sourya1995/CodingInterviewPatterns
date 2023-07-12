package WhatToTrack;

import java.util.HashMap;
import java.util.Map;

public class ValidAnagram {
    class Solution {
        public boolean isAnagram(String s, String t) {
            if (s.length() != t.length()) {
                return false;
            }

            Map<Character, Integer> table = new HashMap<>();
            for (char c : s.toCharArray()) {
                if (table.containsKey(c)) {
                    table.put(c, table.get(c) + 1);
                } else {
                    table.put(c, 1);
                }
            }

            for (char c : t.toCharArray()) {
                if (table.containsKey(c)) {
                    table.put(c, table.get(c) - 1);
                } else {
                    return false;
                }
            }

            for (int count : table.values()) {
                if (count != 0) {
                    return false;
                }
            }

            return true;
        }
    }
}
