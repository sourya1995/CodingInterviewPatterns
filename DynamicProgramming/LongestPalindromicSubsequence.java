public class LongestPalindromicSubsequence {
    class Solution {
        public int longestPalindromeSubseq(String s) {
            int[][] lookupTable = new int[s.length()][s.length()];
            for (int i = 0; i < s.length(); i++) {
                lookupTable[i][i] = 1;
            }

            for (int startIndex = s.length(); startIndex >= 0; startIndex--)
                for (int endIndex = startIndex + 1; endIndex < s.length(); endIndex++)
                    if (s.charAt(startIndex) == s.charAt(endIndex)) {
                        lookupTable[startIndex][endIndex] = 2 + lookupTable[startIndex + 1][endIndex - 1];
                    }

                    else {
                        lookupTable[startIndex][endIndex] = Math.max(lookupTable[startIndex + 1][endIndex],
                                lookupTable[startIndex][endIndex - 1]);
                    }

            return lookupTable[0][s.length() - 1];
        }
    }
}
