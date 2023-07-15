import java.util.Arrays;

public class TargetSum {

    public int findTargetSumWays(int[] nums, int target) {
        int total = 0;
        for (int num : nums) {
            total += num;
        }

        if (total < Math.abs(target))
            return 0;

        int[][] dp = new int[nums.length][2 * total + 1];
        for (int[] row : dp)
            Arrays.fill(row, 0);
        dp[0][total + nums[0]] = 1;
        dp[0][total - nums[0]] += 1;

        for (int i = 1; i < nums.length; ++i) // for every number
            for (int t = -total; t < total + 1; ++t) // for every possible total
                if (dp[i - 1][total + t] > 0) {
                    dp[i][total + t + nums[i]] += dp[i - 1][total + t];
                    dp[i][total + t - nums[i]] += dp[i - 1][total + t];
                }

        return dp[nums.length - 1][target + total];
    }
}
