package DynamicProgramming;

public class RodCutting {
    public static int rodCutting(int[] lengths, int[] prices, int n){
        int lengthsCount = lengths.length;
        int pricesCount = prices.length;

        if(n ==0 || pricesCount == 0 || pricesCount != lengthsCount){
            return 0;
        }

        int[][] dp = new int[lengthsCount][n+1];
        for(int curr = 0; curr < lengthsCount; curr++){
            for(int rodLength = 1; rodLength <= n; rodLength++){ 
                int revenue1 = 0;
                int revenue2 = 0;
                if(lengths[curr] <= rodLength) {
                    revenue1 = prices[curr] + dp[curr][rodLength - lengths[curr]];
                }

                if(curr > 0){
                    revenue2= dp[curr - 1][rodLength];
                }

                dp[curr][rodLength] = Math.max(revenue1, revenue2);
            }
        }

        return dp[lengthsCount - 1][n];
    }
}
