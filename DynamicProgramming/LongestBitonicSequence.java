package DynamicProgramming;

import java.util.Arrays;

public class LongestBitonicSequence {

    class Solution {
        public int minimumMountainRemovals(int[] nums) {
            int n = nums.length;
            int[] lis_first = new int[n];
            Arrays.fill(lis_first, 1);

            int[] lis_second = new int[n];
            Arrays.fill(lis_second, 1);

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < i; j++) {
                    if (nums[i] > nums[j] && lis_first[i] < 1 + lis_first[j]) {
                        lis_first[i] = 1 + lis_first[j];
                    }
                }
            }

            for (int i = n - 1; i >= 0; i--) {
                for (int j = n - 1; j > i; j--) {
                    if (nums[i] > nums[j] && lis_second[i] < 1 + lis_second[j]) {
                        lis_second[i] = 1 + lis_second[j];
                    }
                }
            }

            int result = 0;

            for (int i = 0; i < n; i++) {
                if (lis_first[i] > 1 && lis_second[i] > 1) {
                    result = Math.max(result, lis_first[i] + lis_second[i] - 1);
                }
            }

            return n - result;
        }
    }

}
