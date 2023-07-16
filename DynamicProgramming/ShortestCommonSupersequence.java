package DynamicProgramming;

public class ShortestCommonSupersequence {
    public static int shortestCommonSupersequence(String str1, String str2) {
        int s1 = str1.length();
        int s2 = str2.length();

        int[][] lookupTable = new int[s1+1][];
        for (int i = 0; i < s1 + 1; i++) {
            lookupTable[i] = new int[s2 + 1];
            for (int j = 0; j < s2 + 1; j++) {
                lookupTable[i][j] = 0;
            }
        }

        for (int i = 0; i <= s1; i++) {
            lookupTable[i][0] = i;
        }

        for (int j = 0; j <= s2; j++) {
            lookupTable[0][j] = j;
        }

        for(int i1 = 1; i1 <= s1; i1++){
            for(int i2 = 1; i2 <= s2; i2++){
                if(str1.charAt(i1 - 1) == str2.charAt(i2 - 1)){
                    lookupTable[i1][i2] = 1 + lookupTable[i1 - 1][i2 - 1];
                } else{
                    lookupTable[i1][i2] = 1 + Math.min(lookupTable[i1 - 1][i2], lookupTable[i1][i2 - 1]);
                }
            }
        }

        return lookupTable[s1][s2];
    }
}
