package WhatToTrack;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class FindAllAnagrams {
    class Solution {
        public List<Integer> findAnagrams(String s, String p) {
            List<Integer> ans = new ArrayList<Integer>();
            if (p.length() > s.length())
                return ans;

            HashMap<Character, Integer> hashA = new HashMap<>();
            HashMap<Character, Integer> hashB = new HashMap<>();

            for (int i = 0; i < p.length(); i++) {
                if (!hashB.containsKey(p.charAt(i)))
                    hashB.put(p.charAt(i), 1);
                else
                    hashB.put(p.charAt(i), hashB.get(p.charAt(i)) + 1);
            }

            int windowEnd = 0;
            while (windowEnd < s.length()) {
                if (!hashA.containsKey(s.charAt(windowEnd)))
                    hashA.put(s.charAt(windowEnd), 1);
                else
                    hashA.put(s.charAt(windowEnd), hashA.get(s.charAt(windowEnd)) + 1);
                int windowStart = windowEnd - p.length();
                if (windowEnd >= p.length())
                    if (hashA.get(s.charAt(windowStart)) == 1)
                        hashA.remove(s.charAt(windowStart));
                    else if (!hashA.containsKey(s.charAt(windowStart)))
                        hashA.put(s.charAt(windowStart), 1);
                    else
                        hashA.put(s.charAt(windowStart), hashA.get(s.charAt(windowStart)) - 1);
                windowEnd++;

                if (hashA.equals(hashB)) {
                    ans.add(windowEnd - p.length());
                }
            }
            return ans;
        }
    }
}
