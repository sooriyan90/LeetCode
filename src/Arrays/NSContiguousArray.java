package Arrays;
/*Contiguous Array
 
Given a binary array, find the maximum length of a contiguous subarray with equal number of 0 and 1.

Example 1:
Input: [0,1]
Output: 2
Explanation: [0, 1] is the longest contiguous subarray with equal number of 0 and 1.
Example 2:
Input: [0,1,0]
Output: 2
Explanation: [0, 1] (or [1, 0]) is a longest contiguous subarray with equal number of 0 and 1.
Note: The length of the given binary array will not exceed 50,000.
 */

/**
 * @author narayanan.sekhar
 */

//Note - The below solution was coded after seeing leetcode's solution
import java.util.*;

public class NSContiguousArray {

	public int findMaxLength(int[] nums) {
        int count = 0;
        int maxLength = 0;
        //Map of track points and index
        Map<Integer, Integer> countIndex = new HashMap<Integer, Integer>();
        countIndex.put(0, -1);
        for(int i = 0; i < nums.length; i++){
            //The 1's and 0's are like the highs and lows of a wave for 
            // subarrays with equal 1's and 0's. They go high and come down to a
            // point, go low and come up to the same point. The 1's and 0's
            // between the point will be same. These points repeats
            // itself throughout the array. Track those points and the index.
            // Then use them to compute the length of subarrays when the points repeat
            // itself again. 
            if(nums[i] == 0){
                count--;
            }else{
                count++;
            }
            if(countIndex.containsKey(count)){
                maxLength = Math.max(maxLength, i - countIndex.get(count));
            }else{
                countIndex.put(count, i);
            }
        }
        return maxLength;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		NSContiguousArray nSContiguousArray = new NSContiguousArray();
		int[] arr = { 0,1,1,0,1,1,1,0 };
		System.out.println(nSContiguousArray.findMaxLength(arr));
	}
}
