package DynamicProgramming;

import java.util.Arrays;

public class MinDeletesAndRemovals {
    public static int findMaxMatchingSubseq(String str1, String str2) {
        int m = str1.length();
        int n = str2.length();

        int[][] lookupTable = new int[m + 1][n + 1];
        for (int i = 0; i < m + 1; i++)
            Arrays.fill(lookupTable[i], -1);

        for (int j = 0; j < n + 1; j++) {
            lookupTable[0][j] = 0;
        }

        for (int i = 0; i < m + 1; i++) {
            lookupTable[i][0] = 0;
        }

        for (int i = 0; i < m + 1; i++) {
            for (int j = 0; j < n + 1; j++) {
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    lookupTable[i][j] = lookupTable[i - 1][j - 1] + 1;
                } else {
                    lookupTable[i][j] = Math.max(lookupTable[i][j - 1], lookupTable[i - 1][j]);
                }
            }
        }
        return lookupTable[m][n];
    }
}

public static int[] minDelIns(String str1, String str2) {
    int n = findMaxMatchingSubseq(str1, str2);
    int deletions = str1.length() - n;
    int insertions = str2.length() - n;
    return new int[]{deletions, insertions};
}
