package ModifiedBinarySearch;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomPickWithWeight {
    private List<Integer> runningSums;
    private int totalSum;
    public RandomPickWithWeight(int[] w) {
        runningSums = new ArrayList<>();
        int runningSum = 0;
        for (int weights: w){
            runningSum += weights;
            runningSums.add(runningSum);
        } 
        totalSum = runningSum;
    }
    
    public int pickIndex() {
        Random random = new Random();
        int target = random.nextInt(totalSum) + 1;
        int low = 0;
        int high = runningSums.size();

        while(low < high){
            int mid =  low + (high - low)/2;
            if(target > runningSums.get(mid)){
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }
}
