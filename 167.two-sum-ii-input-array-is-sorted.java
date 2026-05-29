/*
* @lc app=leetcode id=167 lang=java
*
* [167] Two Sum II - Input Array Is Sorted
*/

// @lc code=start
class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int ptrLeft = 0, ptrRight = numbers.length-1;

        while(ptrLeft < ptrRight) {
            int sm = numbers[ptrLeft] + numbers[ptrRight];
            if (sm == target)
                return new int[] { ptrLeft+1, ptrRight+1 };
            else if (sm < target) 
                ptrLeft++;
            else
                ptrRight--;
        }

        return new int[] { -1, -1 };
    }
}
// @lc code=end

