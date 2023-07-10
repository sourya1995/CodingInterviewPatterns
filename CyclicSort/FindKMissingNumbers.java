package CyclicSort;

import java.util.ArrayList;
import java.util.List;

public class FindKMissingNumbers {
    public static List<Integer> findKMissingNumbers(int[] numbers, int k) {
        int i = 0;
        while (i < numbers.length) {
            if(numbers[i] > 0 && numbers[i] <= numbers.length && numbers[numbers[i] - 1] != numbers[i]) {
                swap(numbers, i, numbers[i] - 1);
            } else {
                i++;
            }
        }

        List<Integer> missingNumbers = new ArrayList<>();
        int count = 0;
        i = 0;
        while(count < k){
            if(numbers[i] != i + 1){
                missingNumbers.add(i+1);
                count++;
            }
            i++;
        }

        return missingNumbers;
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
