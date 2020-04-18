package Arrays;

/*Given an array nums of n integers where n > 1,  return an array output such that output[i] is equal to the product of all the elements of nums except nums[i].

Example:

Input:  [1,2,3,4]
Output: [24,12,8,6]
Constraint: It's guaranteed that the product of the elements of any prefix or suffix of the array (including the whole array) fits in a 32 bit integer.

Note: Please solve it without division and in O(n).

Follow up:
Could you solve it with constant space complexity? (The output array does not count as extra space for the purpose of space complexity analysis.)*/

public class NSProductOfArrayExceptSelf {
    /**NS**/
	// O(N) - Time Complexity
	// O(N) - Space Complexity
	//                 0,1,2,3,4 - index 
	// [1,2,3,4,5] - [ 1,2,6,24, ] - a[]
	//
	//                0,1,  2, 3, 4 - index
	// [1,2,3,4,5] - [120,60,20,5,1] - b[]
	//
	// [120,60,40,30,24] - a[i]*b[i+1] - 0<=i<=len-1            
    public static int[] productExceptSelfConstantSpace(int[] nums) {
        int[] op = new int[nums.length];
        int temp = 1;
        for(int i = nums.length - 1; i >= 1; i--){
        		op[i-1] = temp*nums[i];
        		temp = op[i-1];
    		}
        temp = 1;
        op[nums.length - 1] = temp;
        for(int i = 0; i < nums.length - 1; i++){
            temp = temp*nums[i];
            op[i+1] = temp*op[i+1];
        }
        return op;
    }

    /** VM
     *  Time complexity is O(N)
     *  Space complexity is O(N)
     *  Idea is to build products which are to the left and right of current index
     *  Finally multiple the left and right products for each index
     * **/
    public static int[] productExceptSelfWithLeftAndRight(int[] nums) {
        if(nums == null)
            return null;
        int[] res = new int[nums.length];
        if(nums.length == 0)
            return res;
        int[] lProd = new int[nums.length];
        int[] rProd = new int[nums.length];
        lProd[0] = 1;
        // building the left products for each index
        for(int i = 1; i < nums.length; i++){
            lProd[i] = lProd[i-1] * nums[i-1];
        }
        rProd[nums.length - 1] = 1;
        // building the right products for each index
        for(int i = nums.length - 2; i >= 0 ; i--){
            rProd[i] = rProd[i+1] * nums[i+1];
        }
        // build the array with left and right products for each index
        for(int i = 0 ; i < nums.length; i++){
            res[i] = lProd[i] * rProd[i];
        }

        return res;
    }

    public static void main(String[] args){
        int[] res = productExceptSelfConstantSpace(new int[]{1,2,3,4,5});
        //int[] res = productExceptSelfWithLeftAndRight(new int[]{1,2,3,4});

        for(int i : res){
            System.out.println(i);
        }

    }
}
