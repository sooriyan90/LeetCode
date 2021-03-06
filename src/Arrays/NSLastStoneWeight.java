/*We have a collection of stones, each stone has a positive integer weight.

Each turn, we choose the two heaviest stones and smash them together.  Suppose the stones have weights x and y with x <= y.  The result of this smash is:

If x == y, both stones are totally destroyed;
If x != y, the stone of weight x is totally destroyed, and the stone of weight y has new weight y-x.
At the end, there is at most 1 stone left.  Return the weight of this stone (or 0 if there are no stones left.)

Example 1:

Input: [2,7,4,1,8,1]
Output: 1
Explanation: 
We combine 7 and 8 to get 1 so the array converts to [2,4,1,1,1] then,
we combine 2 and 4 to get 2 so the array converts to [2,1,1,1] then,
we combine 2 and 1 to get 1 so the array converts to [1,1,1] then,
we combine 1 and 1 to get 0 so the array converts to [1] then that's the value of last stone.

Note:

1 <= stones.length <= 30
1 <= stones[i] <= 1000*/

package Arrays;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Arrays;

public class NSLastStoneWeight {

    /**SOLUTION 1
     * ** Time Complexity - O(n log n)
     * @param stones
     * @return
     */
	public static int lastStoneWeight(int[] stones) {
		//constructor with comparator parameter needs the initial size to be specified
        PriorityQueue<Integer> pq = new PriorityQueue<>(stones.length, Collections.reverseOrder());
        for(int i = 0; i < stones.length; i++){
            pq.add(stones[i]);
        }
        
        //Insert takes O(log n)
        //delete takes O(log n)
        while(pq.size() >= 2){
            int stone1 = pq.poll();
            int stone2 = pq.poll();
            int diff = stone1 - stone2;
            if(diff > 0){
                pq.add(diff);
            }
        }
        
        return (pq.size() == 1)?pq.poll():0;
    }

    /** SOLUTION 2
     * Time Complexity - O(n^2 log n )
     * **/
    public static int lastStoneWeightWithSorting(int[] stones) {
        int n = stones.length - 1;
        for(int i = n; i > 0; i--){
            Arrays.sort(stones);
            stones[n-1] = stones[n] - stones[n-1];
            n = n-1;
        }

        return stones[0];
    }

    public static void main(String[] args){
        System.out.println((lastStoneWeight(new int[]{1,2,7,2,6,8})));
    }
//	public LastStoneWeight() {
//		// TODO Auto-generated constructor stub
//	}

}
