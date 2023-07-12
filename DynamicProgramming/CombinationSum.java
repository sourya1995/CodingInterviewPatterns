package DynamicProgramming;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum {
    class Solution {
        public List<List<Integer>> combinationSum(int[] candidates, int target) {
            List<List<List<Integer>>> dp = new ArrayList<>(target + 1);
            dp.add(new ArrayList<>());
            dp.get(0).add(new ArrayList<>());

            for (int i = 1; i <= target; i++) {
                dp.add(new ArrayList<>());
                for (int j = 0; j < candidates.length; j++) {
                    if (candidates[j] <= i) {
                        for (List<Integer> prev : dp.get(i - candidates[j])) {
                            List<Integer> temp = new ArrayList<>(prev);
                            temp.add(candidates[j]);
                            temp.sort(null);

                            if (!dp.get(i).contains(temp)) {
                                dp.get(i).add(temp);
                            }
                        }
                    }
                }
            }

            return dp.get(target);
        }
    }
}
