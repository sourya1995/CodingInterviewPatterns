package Greedy;

public class JumpGame2 {

    public int jump(int[] nums) {
        int targetNumIndex = nums.length - 1;
        int count = 0;

        while (targetNumIndex > 0) {
            int maxIndex = -1;
            for (int i = 0; i < targetNumIndex; i++) {
                if (i + nums[i] >= targetNumIndex) {
                    maxIndex = i;
                    break;
                }
            }
            if (maxIndex == -1) {
                return -1;
            }
            targetNumIndex = maxIndex;
            count++;
        }

        return count;
    }
}
