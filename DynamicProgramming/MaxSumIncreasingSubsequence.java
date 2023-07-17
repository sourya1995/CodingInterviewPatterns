package DynamicProgramming;

public class MaxSumIncreasingSubsequence {
    public static int msLength(int[] nums){
        int size = nums.length;
        int[][] dp = new int[size+1][size+1];

        for(int curr = size - 1; curr >= -1; curr--){
            for(int prev = curr - 1; prev >= -2; prev--){
                int length = dp[curr + 1][prev + 1];
                if(prev < 0 || nums[prev] < nums[curr]){
                    length = Math.max(length, nums[curr] + dp[curr + 1][curr + 1]);
                }
                dp[curr][prev + 1] = length;
            }
        }
        return dp[0][0];
    }
}
