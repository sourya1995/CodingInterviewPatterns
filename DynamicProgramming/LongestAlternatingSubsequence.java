import java.util.Arrays;

public class LongestAlternatingSubsequence {
    public static int LAS(int[] nums) {
        int n = nums.length;
        if (n == 0)
            return 0;

        int[][] dp = new int[2][n];
        for (int[] row : dp) {
            Arrays.fill(row, 1);
        }

        for (int current = 1; current < n; current++) {
            int previous = current - 1;
            if (nums[current] > nums[previous]) {
                dp[0][current] = 1 + dp[1][previous];
                dp[1][current] = dp[1][previous];

            }

            else if (nums[current] < nums[previous]) {
                dp[1][current] = dp[1][previous];
                dp[0][current] = dp[0][previous];
            }
        }

        return Math.max(dp[1][n - 1], dp[0][n - 1]);
    }
}
