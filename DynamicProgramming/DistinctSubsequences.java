package DynamicProgramming;

import java.util.Arrays;

public class DistinctSubsequences {

    public int numDistinct(String s, String t) {
        int m = s.length();
        int n = t.length();

        int[][] lookupTable = new int[m + 1][n + 1];
        for (int[] row : lookupTable) {
            Arrays.fill(row, 0);
        }

        for (int i = 0; i < n + 1; i++) {
            lookupTable[m][i] = 0;
        }

        for (int i = 0; i < m + 1; i++) {
            lookupTable[i][n] = 1;
        }

        for (int i1 = m - 1; i1 > -1; i1--) {
            for (int i2 = n - 1; i2 > -1; i2--) {
                if (s.charAt(i1) == t.charAt(i2)) {
                    lookupTable[i1][i2] += lookupTable[i1 + 1][i2 + 1] + lookupTable[i1 + 1][i2];
                } else {
                    lookupTable[i1][i2] = lookupTable[i1 + 1][i2];
                }
            }
        }

        return lookupTable[0][0];
    }
}
