package Sorting;

/**
 * Given a sorted (in ascending order) integer array nums of n elements and a target value, write a function to search target in nums. If target exists, then return its index, otherwise return -1.


Example 1:

Input: nums = [-1,0,3,5,9,12], target = 9
Output: 4
Explanation: 9 exists in nums and its index is 4

Example 2:

Input: nums = [-1,0,3,5,9,12], target = 2
Output: -1
Explanation: 2 does not exist in nums so return -1
 

Note:

You may assume that all elements in nums are unique.
n will be in the range [1, 10000].
The value of each element in nums will be in the range [-9999, 9999].
 * 
 * @author VenkataramaSooriyaku
 *
 */

public class BinarySearch {
	public int search(int[] nums, int target) {
		return iterative_search(nums, target);
	}
	public int binarySearch(int[] nums, int target, int left, int right) {
		if (right >= left && left <= nums.length-1) { 
			int middle = left + (right-left) / 2;
			if (nums[middle] < target) {
				return binarySearch(nums, target, middle+1, right);
			} 
			if (nums[middle] > target) {
				return binarySearch(nums, target, left, middle-1);
			}
			if (nums[middle] == target) {
				return middle;
			}
		}

		return -1;
	}

	public int iterative_search (int[] nums, int target) {
		int left = 0;
		int right = nums.length - 1;
		while (left <= right) {
			int middle = left + (right - left)/2;
			if ( target == nums[middle]) {
				return middle;
			}
			else if (target < nums[middle]) {
				right = middle -1 ;
				continue;
			}
			else {
				left = middle + 1;
				continue;
			}
		}
		return -1;
	}

	public static void main(String[] args) {
		BinarySearch bs = new BinarySearch();
		// TODO Auto-generated method stub
		int nums[] = {-5};
		int target = -5;
		System.out.println(bs.search(nums, target));
		
		int nums2[] = {-1,0,3,5,9,12};
		int target2 = 9;
		System.out.println(bs.binarySearch(nums2, target2, 0, 5));
	}

}
