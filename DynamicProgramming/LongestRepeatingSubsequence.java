package DynamicProgramming;

import java.util.Arrays;

public class LongestRepeatingSubsequence {
    static int findLRS(String str){
        int size = str.length();
        int lookupTable[][] = new int[size+1][size+1];
        for(int[] arr:lookupTable) {
            Arrays.fill(arr, 0);
        }

        for(int i = 1; i < size + 1; i++){
            for(int k = 1; k < size + 1; k++){
                if((str.charAt(i - 1) == str.charAt(k - 1)) && (i != k)){
                    lookupTable[i][k] = lookupTable[i-1][k-1] + 1;
                }

                else {
                    lookupTable[i][k] = Math.max(lookupTable[i-1][k], lookupTable[i][k-1]);
                }
            }
        }

        return lookupTable[size][size];
    }
}
