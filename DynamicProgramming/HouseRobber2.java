package DynamicProgramming;

import java.util.Arrays;

public class HouseRobber2 {
    class Solution {
        public int rob(int[] nums) {
            if (nums == null || nums.length == 0) {
                return 0;
            }

            if (nums.length == 1) {
                return nums[0];
            }

            return Math.max(houseRobberHelper(Arrays.copyOfRange(nums, 0, nums.length - 1)),
                    houseRobberHelper(Arrays.copyOfRange(nums, 1, nums.length)));
        }

        private static int houseRobberHelper(int[] nums) {
            int[] lookupArray = new int[nums.length + 1];
            lookupArray[0] = 0;
            lookupArray[1] = nums[0];

            for (int i = 2; i <= nums.length; i++) {
                lookupArray[i] = Math.max(nums[i - 1] + lookupArray[i - 2], lookupArray[i - 1]);
            }

            return lookupArray[nums.length];
        }
    }
}
