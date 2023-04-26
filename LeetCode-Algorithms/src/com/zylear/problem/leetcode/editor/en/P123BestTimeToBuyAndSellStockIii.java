package com.zylear.problem.leetcode.editor.en;

//You are given an array prices where prices[i] is the price of a given stock 
//on the iᵗʰ day. 
//
// Find the maximum profit you can achieve. You may complete at most two 
//transactions. 
//
// Note: You may not engage in multiple transactions simultaneously (i.e., you 
//must sell the stock before you buy again). 
//
// 
// Example 1: 
//
// 
//Input: prices = [3,3,5,0,0,3,1,4]
//Output: 6
//Explanation: Buy on day 4 (price = 0) and sell on day 6 (price = 3), profit = 
//3-0 = 3.
//Then buy on day 7 (price = 1) and sell on day 8 (price = 4), profit = 4-1 = 3.
// 
//
// Example 2: 
//
// 
//Input: prices = [1,2,3,4,5]
//Output: 4
//Explanation: Buy on day 1 (price = 1) and sell on day 5 (price = 5), profit = 
//5-1 = 4.
//Note that you cannot buy on day 1, buy on day 2 and sell them later, as you 
//are engaging multiple transactions at the same time. You must sell before buying 
//again.
// 
//
// Example 3: 
//
// 
//Input: prices = [7,6,4,3,1]
//Output: 0
//Explanation: In this case, no transaction is done, i.e. max profit = 0.
// 
//
// 
// Constraints: 
//
// 
// 1 <= prices.length <= 10⁵ 
// 0 <= prices[i] <= 10⁵ 
// 
//
// Related Topics Array Dynamic Programming 👍 7043 👎 140


import java.util.Arrays;
import java.util.Map;

public class P123BestTimeToBuyAndSellStockIii {
    public static void main(String[] args) {
        Solution solution = new P123BestTimeToBuyAndSellStockIii().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxProfit(int[] prices) {

            int[][] dp = new int[prices.length][5];

            //dp[i][0]表示在第i天时没有买过股票手上的最大收益
            //dp[i][1]表示在第i天时买过一次股票还没有卖出手上的最大收益
            //dp[i][2]表示在第i天时买过一次也卖出过一次股票手上的最大收益
            //dp[i][3]表示在第i天时买过两次只卖出过一次股票手上的最大收益
            //dp[i][4]表示在第i天时买过两次同时也买出过两次股票手上的最大收益

            dp[0][0] = 0;
            dp[0][1] = -prices[0];
            dp[0][2] = -10000;
            dp[0][3] = -10000;
            dp[0][4] = -10000;

            for (int i = 1; i < prices.length; i++) {
                dp[i][0] = dp[i - 1][0];
                //前一天已经买入 || 今天买入  求最大值
                dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
                //前一天已经卖出 || 今天卖出  求最大值
                dp[i][2] = Math.max(dp[i - 1][2], dp[i - 1][1] + prices[i]);
                //前一天已经第二次买入 || 今天第二次买入 求最大值
                dp[i][3] = Math.max(dp[i - 1][3], dp[i - 1][2] - prices[i]);
                //前一天已经第二次卖出 || 今天第二次卖出  求最大值
                dp[i][4] = Math.max(dp[i - 1][4], dp[i - 1][3] + prices[i]);
            }

            //都不操作 || 第一次卖出 || 第二次卖出  求最大值
            return Math.max(dp[prices.length - 1][2], Math.max(dp[prices.length - 1][0], dp[prices.length - 1][4]));
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}