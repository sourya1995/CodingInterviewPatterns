package CyclicSort;

public class FindTheCorruptPair {
    public static void swap(int[] arr, int first, int second) {
        int temp = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;
    }

    public static int[] findCorruptPair(int[] nums){
        int duplicated = 0;
        int missing = 0;
        int[] pair = {0, 0};
        int i = 0;
        while(i < nums.length){
            int correct = nums[i] - 1;
            if(nums[i] != nums[correct]){
                swap(nums,i, correct)
            } else{
                i = i + 1;
            }
        }

        for (int j=0; j < nums.length; j++){
            if(nums[j] != nums[j+1]){
                duplicated = nums[j];
                missing = j+1;
            }
        }
        pair[0] = missing;
        pair[1] = duplicated;

        return pair;
    }
}
