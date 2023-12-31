package DynamicProgramming;

public class MinDeletionsToMakeSequenceSorted {
    public static int minDeletions(int[] nums){
        int size = nums.length;
        int[][] dp = new int[size+1][size+1];

        for(int curr = size - 1; curr > -1; curr--){
            for(int prev = curr - 1; prev > -2; prev--){
                int length = dp[curr + 1][prev+1];

                if(prev < 0 || nums[prev] < nums[curr]){
                    length = Math.max(length, 1+ dp[curr + 1][curr+1]);

                }

                dp[curr][prev+1] = length;
            }
        }

        int minDel = size - dp[0][0];
        return minDel;
    }
}
