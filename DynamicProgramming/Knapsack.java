package DynamicProgramming;

public class Knapsack {
    public static int findKnapSackProfit(int capacity, int[] weights, int[] values){
        int n = weights.length;
        int[] dp = new int[capacity + 1];
        for(int i = 0; i <= capacity; i++){
            dp[i] = 0;
        }

        for(int i = 0; i < n; i++){
            for(int j = capacity; j >= weights[i]; j--){
                dp[j] = Math.max(values[i] + dp[j - weights[i]], dp[j]);
            }
        }

        return dp[capacity];

    }
}
