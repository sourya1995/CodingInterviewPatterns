public class MinimumDeletionsForLPS {
    public static int minimumDeletions(String s) {
        return s.length() - longestPalindromicSubsequence(s);
    }

    public static int longestPalindromicSubsequence(String s) {
        int[][] lookupTable = new int[s.length()][s.length()];
        for (int i = 0; i < s.length(); i++)
            lookupTable[i][i] = 1;

        for (int start = s.length(); start >= 0; start--) {
            for (int end = start + 1; end < s.length(); end++) {
                if (s.charAt(start) == s.charAt(end))
                    lookupTable[start][end] = 2 + lookupTable[start + 1][end - 1];
                else
                    lookupTable[start][end] = Math.max(lookupTable[start][end - 1], lookupTable[start + 1][end]);
            }
        }

        return lookupTable[0][s.length() - 1];
    }
}
