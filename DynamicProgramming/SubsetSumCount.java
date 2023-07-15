package DynamicProgramming;

public class SubsetSumCount {
    public static long countSubsetSum(int[] nums, int targetSum){
        int numsLen = nums.length;
        long lookup[][] = new long[numsLen][targetSum + 1];
        for(long[] row  : lookup){
            Arrays.fill(row, 0);
        if(nums[0] == 0) lookup[0][0] = 2;

        else {
            lookup[0][0] = 1;
            if(nums[0] <= targetSum)
                lookup[0][nums[0]] = 1;
        }

        for(int current = 1; current < numsLen; current++){
            for(int requiredSum = 0; requiredSum <= targetSum; requiredSum++){
                long sum1 = 0;
                if(nums[current] <= requiredSum)
                    sum1 = lookup[current - 1][requiredSum - nums[current]];

                long sum2 = lookup[current - 1][requiredSum];
                lookup[current][requiredSum] = sum1 + sum2;
            }
        }
        return lookup[numsLen - 1][targetSum];
    }
}
