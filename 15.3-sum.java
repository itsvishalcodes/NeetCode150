
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/*
 * @lc app=leetcode id=15 lang=java
 *
 * [15] 3Sum
 */

// @lc code=start
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        HashSet<List<Integer>> unique = new HashSet<>();
        Arrays.sort(nums);
        
        int leftPtr = 0, rightPtr = nums.length - 1;

        while (leftPtr < nums.length) {
            while (rightPtr > leftPtr+1) {
                int ElemIdx = Arrays.binarySearch(nums, leftPtr+1, rightPtr, -1*(nums[leftPtr]+nums[rightPtr]));
                
                if(ElemIdx >= 0) {
                    ArrayList<Integer> triplets = new ArrayList<>();
                    triplets.add(nums[leftPtr]);
                    triplets.add(nums[ElemIdx]);
                    triplets.add(nums[rightPtr]);

                    if(!unique.contains(triplets)) {
                        res.add(triplets);
                        unique.add(triplets);
                    }
                }

                rightPtr--;
            }
            leftPtr++;
            rightPtr = nums.length-1;
        }

        return res;
    }
}
// @lc code=end

