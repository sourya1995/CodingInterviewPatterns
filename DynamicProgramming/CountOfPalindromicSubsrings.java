import java.util.Arrays;

public class CountOfPalindromicSubsrings {

    class Solution {
        public int countSubstrings(String s) {
            int n = s.length();
            boolean[][] lookupTable = new boolean[n][n];

            for (int k = 0; k < n; k++) {
                Arrays.fill(lookupTable[k], false);
            }

            int psCount = 0;
            for (int i = n - 1; i > -1; i--) {
                for (int j = i; j < n; j++) {
                    if (s.charAt(i) == s.charAt(j)) {
                        if (i + 1 >= j) {
                            lookupTable[i][j] = true;
                        } else {
                            lookupTable[i][j] = lookupTable[i + 1][j - 1];
                        }
                    }

                    if (lookupTable[i][j]) {
                        psCount += 1;
                    }
                }
            }

            return psCount;
        }
    }

}
