/*
 * @lc app=leetcode id=42 lang=java
 *
 * [42] Trapping Rain Water
 */

// @lc code=start
class Solution {
    public int trap(int[] height) {
        int res = 0;
        int[] maxLeftArr = new int[height.length];
        int[] maxRightArr = new int[height.length];

        maxLeftArr[0] = height[0];
        maxRightArr[height.length-1] = height[height.length-1];

        for(int i=1; i<height.length; i++)
            maxLeftArr[i] = Math.max(maxLeftArr[i-1], height[i]);
        for(int i=height.length-2; i>=0; i--)
            maxRightArr[i] = Math.max(maxRightArr[i+1], height[i]);

        for(int i=0; i<height.length; i++) {
            res += Math.max(0, Math.min(maxLeftArr[i], maxRightArr[i])-height[i]);
        }

        return res;
    }
}
// @lc code=end

