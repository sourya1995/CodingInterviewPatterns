package Subsets;

import java.util.HashMap;
import java.util.Map;

public class KSubsetSum {

    public int subarraySum(int[] nums, int k) {

        int count = 0;
        int sum = 0;
        Map<Integer, Integer> sumCountMap = new HashMap<>();
        sumCountMap.put(0, 1);

        for (int num : nums) {
            sum += num;
            if (sumCountMap.containsKey(sum - k)) {
                count += sumCountMap.get(sum - k);
            }
            sumCountMap.put(sum, sumCountMap.getOrDefault(sum, 0) + 1);
        }

        return count;
    }

}
