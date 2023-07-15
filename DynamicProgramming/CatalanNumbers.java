package DynamicProgramming;

public class CatalanNumbers {
    public static long catalan(int n){
        long[] dp = new long[n+1];
        dp[0] = 1;
        for(int i = 1; i < n+1; i++){
            dp[i] = 0;
            for(int j = 0; j < i; j++)
                dp[i] += (dp[j] * dp[i-j-1]);
            
        }
        return dp[n];
    }
}
