package DynamicProgramming;

public class InterleavingStrings {
    class Solution {
        public boolean isInterleave(String s1, String s2, String s3) {
            if((s1.length() + s2.length()) != s3.length()){
                return false;
            }
    
            boolean[][] lookupTable = new boolean[s1.length() + 1][s2.length() + 1];
            for(int i = 0; i < (s1.length() + 1); i++)
                for(int j = 0; j < (s2.length() + 1); j++)
                    lookupTable[i][j] = false;
    
            for(int s1Index = 0; s1Index < s1.length() + 1; s1Index++){
                for(int s2Index = 0; s2Index < s2.length() + 1; s2Index++){
                    if(s1Index == 0 && s2Index == 0){
                        lookupTable[s1Index][s2Index] = true;
                    }
    
                    else if((s1Index == 0) && (s2.charAt(s2Index - 1)) == s3.charAt(s1Index + s2Index - 1)) {
                        lookupTable[s1Index][s2Index] = lookupTable[s1Index][s2Index - 1];
                    }
    
                    else if((s2Index == 0) && (s1.charAt(s1Index - 1)) == s3.charAt(s1Index + s2Index - 1)){
                        lookupTable[s1Index][s2Index] = lookupTable[s1Index - 1][s2Index];
                    } else{
                        if((s1Index > 0) && s1.charAt(s1Index - 1) == s3.charAt(s1Index + s2Index - 1)){
                            lookupTable[s1Index][s2Index] = lookupTable[s1Index - 1][s2Index];
                        }
    
                        if((s2Index > 0) && s2.charAt(s2Index - 1) == s3.charAt(s1Index + s2Index - 1)){
                            lookupTable[s1Index][s2Index] = lookupTable[s1Index][s2Index] || lookupTable[s1Index][s2Index - 1];
                        }
                    }
                }
            }
    
            return lookupTable[s1.length()][s2.length()];
    
        }
    }
}
