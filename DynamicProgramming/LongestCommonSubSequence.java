package DynamicProgramming;

import java.util.Arrays;

public class LongestCommonSubSequence {
    class Solution {

        public int longestCommonSubsequenceHelper(String text1, String text2, int i, int j, int[][] dp) {
            if (i == text1.length() || j == text2.length())
                return 0;

            else if (dp[i][j] == -1) {
                if (text1.charAt(i) == text2.charAt(j)) {
                    dp[i][j] = 1 + longestCommonSubsequenceHelper(text1, text2, i + 1, j + 1, dp);
                } else {
                    dp[i][j] = Math.max(longestCommonSubsequenceHelper(text1, text2, i + 1, j, dp),
                            longestCommonSubsequenceHelper(text1, text2, i, j + 1, dp));
                }
            }
            return dp[i][j];
        }

        public int longestCommonSubsequence(String text1, String text2) {
            int n = text1.length();
            int m = text2.length();
            int[][] dp = new int[n][m];
            for (int[] row : dp) {
                Arrays.fill(row, -1);
            }

            return longestCommonSubsequenceHelper(text1, text2, 0, 0, dp);
        }
    }
}
