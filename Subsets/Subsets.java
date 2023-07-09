package Subsets;

import java.util.ArrayList;
import java.util.List;

public class Subsets {
    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> setsList = new ArrayList<>();

        // Find number of subsets by taking the power of the length of the input array
        int subsetsCount = (int) Math.pow(2, nums.length);

        for (int i = 0; i < subsetsCount; i++) {
            List<Integer> subset = new ArrayList<>();
            for (int j = 0; j < nums.length; j++) {
                if ((i & (1 << j)) != 0) {
                    subset.add(nums[j]);
                }
            }
            setsList.add(subset);
        }

        return setsList;
    }
}
