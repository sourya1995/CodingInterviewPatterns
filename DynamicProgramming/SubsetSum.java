package DynamicProgramming;

public class SubsetSum {
    public static boolean subsetSum(int[] arr, int total) {
        int n = arr.length;
        boolean[][] dp = new boolean[n + 1][total + 1];

        for (int i = 0; i < n + 1; i++)
            for (int j = 0; j < total + 1; j++)
                dp[i][j] = false;

        for (int k = 0; k < n; k++)
            for (int l = 0; l < total; l++) {
                if (k == 0) {
                    dp[k][l] = false;
                }
                if (l == 0) {
                    dp[k][l] = true;
                }
            }

        for (int i = 1; i < n + 1; i++)
            for (int j = 0; j < total + 1; j++) {
                if (arr[i - 1] > j) {
                    dp[i][j] = dp[i - 1][j];
                }

                else {
                    dp[i][j] = dp[i - 1][j - arr[i - 1]];
                }
            }

        return dp[n][total];
    }

}
