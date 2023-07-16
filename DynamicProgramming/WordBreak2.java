package DynamicProgramming;

import java.util.ArrayList;
import java.util.List;

public class WordBreak2 {
    class Solution {
        public List<String> wordBreak(String s, List<String> wordDict) {
            ArrayList<ArrayList<String>> dpSolutions = new ArrayList<ArrayList<String>>();
            for (int i = 0; i <= s.length(); i++) {
                dpSolutions.add(new ArrayList<String>());
            }

            dpSolutions.get(0).add("");

            for (int i = 1; i <= s.length(); i++) {
                for (int j = 0; j < i; j++) {
                    String prefix = s.substring(j, i);
                    if (wordDict.contains(prefix)) {
                        for (String substring : dpSolutions.get(j)) {
                            dpSolutions.get(i).add((substring + " " + prefix).trim());
                        }
                    }
                }
            }

            return dpSolutions.get(s.length());
        }
    }
}
