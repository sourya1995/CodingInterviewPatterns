package ModifiedBinarySearch;

public class SearchInRotatedSortedArray {
     static int searchRecursive(int[] nums, int start, int end, int target) {
		if (start > end)
			return -1;

		// Finding mid using floor division
		int mid = start + (end - start) / 2;

		if (nums[mid] == target)
			return mid;

		// start to mid is sorted
		if (nums[start] <= nums[mid])
			if (nums[start] <= target && target < nums[mid])
				return searchRecursive(nums, start, mid - 1, target);
			else
				return searchRecursive(nums, mid + 1, end, target);
		// mid to end is sorted
		else if (nums[mid] < target && target <= nums[end])
			return searchRecursive(nums, mid + 1, end, target);
		else
			return searchRecursive(nums, start, mid - 1, target);
	}

	static int search(int[] nums, int target) {
		return searchRecursive(nums, 0, nums.length - 1, target);
	}
}
