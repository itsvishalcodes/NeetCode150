/*
 * @lc app=leetcode id=11 lang=java
 *
 * [11] Container With Most Water
 */

// @lc code=start

/* 
NOTE TO SELF

The proof of why the solution works is important to understand. Following is its summary:

Consider we start with i = 0 and j = height.size() - 1. That is, i points to the first column and j points to the last column.
Now suppose that h(i)>h(j) (we are not loosing generality by this assumption)
We calculate the water capacity for the i, j. It will be h(j)*(j-i).
Now see that if we fix j at height.size() - 1 and vary i, we cannot get a greater water capacity. Why?
capacity = min of both heights * width between them. Since capacity is the product of these two terms, we will look at each term individually.
First about the width. It is easy to see that for all other i's (i = 1, 2,... ,height.size()-2) we will have a lesser width.
Second, the height will be the minimum of the column at i and at j, i.e. min(h(i),h(j)). But this value will be always less than h(j)
So both factors in the calculation of the capacity will be smaller and hence we can skip considering all the cases where i = 1, 2, 3, ..., height.size()-2 and j = height.size()-1
Which basically means that we can simply move j to j-1.
*/
class Solution {
    public int maxArea(int[] height) {
        int maxArea = 0;
        int leftPtr = 0, rightPtr = height.length -1;
        
        // The reason we greedily move the pointer
        // is because the width will decrease, so it's
        // better to move the small one instead of moving
        // the larger one, reason being, since it's small,
        // and the width decreases, the next pair would never
        // be larger than the currently calculated product.
        while(leftPtr < rightPtr) {
            maxArea = Math.max(
                maxArea, 
                (rightPtr - leftPtr)*Math.min(
                    height[leftPtr], height[rightPtr]
            ));
            if(height[leftPtr] <= height[rightPtr]) leftPtr++;
            else rightPtr--;
        }

        return maxArea;
    }
}
// @lc code=end

