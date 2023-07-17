import java.util.Arrays;

public class LongestPalindromicSubstring {
    public static int findLpsLength(String s){
        int[][] dp = new int[s.length()][s.length()];
        for(int[] row: dp){
            Arrays.fill(row, 0);
        }

        for(int start = s.length()-2; start >= 0; start--)
            for(int end = start+ 1; end < s.length(); end++)
                if(s.charAt(start) == s.charAt(end)){
                    int subStringLength = end - start + 1;

                    if(subStringLength == 2 || subStringLength - 2 == dp[start +1][end - 1])
                        dp[start][end] = subStringLength;
                    else 
                        dp[start][end] = Math.max(dp[start + 1][end], dp[start][end - 1]);
                }

                else
                    dp[start][end] = Math.max(dp[start+1][end], dp[start][end-1]);
            
          return dp[0][s.length() - 1];
        }

    }

