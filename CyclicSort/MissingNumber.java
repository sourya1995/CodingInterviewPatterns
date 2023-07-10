package CyclicSort;

public class MissingNumber {
    public int missingNumber(int[] nums) {
        int actualSum = 0;
        for(Integer x: nums){
            actualSum += x;
        }
        int n = nums.length;
        int sumOfN = (n * (n + 1)) / 2;
        return sumOfN - actualSum;
    }
}
