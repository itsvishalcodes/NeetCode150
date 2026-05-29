/*
 * @lc app=leetcode id=121 lang=java
 *
 * [121] Best Time to Buy and Sell Stock
 */

// @lc code=start
class Solution {
    public int maxProfit(int[] prices) {
        int profit = 0, buyPrice = prices[0];
        
        for(int i=1; i<prices.length; i++) {
            if (buyPrice >= prices[i]) {
                buyPrice = prices[i];
            }
            else {
                profit = Math.max(profit, prices[i] - buyPrice);
            }
        }

        return profit;
    }
}
// @lc code=end

