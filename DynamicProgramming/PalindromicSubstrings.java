import java.util.Arrays;

public class PalindromicSubstrings {
    public static int MinCutsHelper(String s, int[][] palindromeTable, int[] dp) {
        int n = s.length();
        for (int i = 0; i < n; i++) {
            palindromeTable[i][i] = 1;
        }

        for (int i = n - 1; i > -1; i--) {
            for (int j = i + 1; j < n; j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    if ((j - i == 1) || (palindromeTable[i + 1][j - 1]) == 1) {
                        palindromeTable[i][j] = 1;
                    }
                }
            }
        }

        for (int i = n - 1; i > -1; i--) {
            if (palindromeTable[i][n - 1] == 1)
                dp[i] = 0;

            else {
                for (int j = n - 2; j > i - 1; j--) {
                    if (palindromeTable[i][j] == 1)
                        dp[i] = Math.min(dp[i], 1 + dp[j + 1]);
                }
            }
        }

        return dp[0];
    }

    public static int minCuts(String s) {
        int n = s.length();
        int[][] palindromeTable = new int[n][n];
        for (int k = 0; k < n; k++) {
            Arrays.fill(palindromeTable[k], 0);
        }

        int[] dp = new int[n];

        for (int k = 0; k < n; k++) {
            dp[k] = Integer.MAX_VALUE;
        }

        return MinCutsHelper(s, palindromeTable, dp);
    }
}
