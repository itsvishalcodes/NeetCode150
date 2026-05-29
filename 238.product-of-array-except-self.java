/*
 * @lc app=leetcode id=238 lang=java
 *
 * [238] Product of Array Except Self
 */

// @lc code=start
class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] res = new int[nums.length];

        int[] preSum = new int[nums.length];
        preSum[0] = nums[0];
        int[] postSum = new int[nums.length];
        postSum[nums.length-1] = nums[nums.length-1];

        for (int i=1; i<nums.length; i++) {
            preSum[i] = preSum[i-1] * nums[i];
        }

        for (int i=nums.length-2; i>=0; i--) {
            postSum[i] = postSum[i+1] * nums[i];
        }

        for (int i=0; i<nums.length; i++) {
            int preIdx = i-1, postIdx = i+1;
            int preMult = 1, postMult = 1;

            if (preIdx >= 0) {
                preMult = preSum[preIdx];
            }
            if (postIdx < postSum.length) {
                postMult = postSum[postIdx];
            }

            res[i] = preMult * postMult;
        }

        return res;
    }
}
// @lc code=end

