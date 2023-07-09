package ModifiedBinarySearch;

public class SearchInRotatedSortedArray2 {
     static boolean searchRecursive(int[] nums, int start, int end, int target) {
        if (start > end)
            return false;

        // Finding mid using floor division
        int mid = start + (end - start) / 2;

        if (nums[mid] == target)
            return true;

        // start to mid is sorted
        if (nums[start] < nums[mid]) {
            if (nums[start] <= target && target < nums[mid]) {
                return searchRecursive(nums, start, mid - 1, target);
            } else {
                return searchRecursive(nums, mid + 1, end, target);
            }
        }
        // mid to end is sorted
        else if (nums[mid] < nums[end]) {
            if (nums[mid] < target && target <= nums[end]) {
                return searchRecursive(nums, mid + 1, end, target);
            } else {
                return searchRecursive(nums, start, mid - 1, target);
            }
        }
        // Check both halves
        else {
            return searchRecursive(nums, start, mid - 1, target) || searchRecursive(nums, mid + 1, end, target);
        }
    }

    static boolean search(int[] nums, int target) {
        return searchRecursive(nums, 0, nums.length - 1, target);
    }
}
