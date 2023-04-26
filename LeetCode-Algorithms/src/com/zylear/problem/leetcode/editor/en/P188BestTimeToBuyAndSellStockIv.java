package com.zylear.problem.leetcode.editor.en;

//You are given an integer array prices where prices[i] is the price of a given 
//stock on the iᵗʰ day, and an integer k. 
//
// Find the maximum profit you can achieve. You may complete at most k 
//transactions: i.e. you may buy at most k times and sell at most k times. 
//
// Note: You may not engage in multiple transactions simultaneously (i.e., you 
//must sell the stock before you buy again). 
//
// 
// Example 1: 
//
// 
//Input: k = 2, prices = [2,4,1]
//Output: 2
//Explanation: Buy on day 1 (price = 2) and sell on day 2 (price = 4), profit = 
//4-2 = 2.
// 
//
// Example 2: 
//
// 
//Input: k = 2, prices = [3,2,6,5,0,3]
//Output: 7
//Explanation: Buy on day 2 (price = 2) and sell on day 3 (price = 6), profit = 
//6-2 = 4. Then buy on day 5 (price = 0) and sell on day 6 (price = 3), profit = 3
//-0 = 3.
// 
//
// 
// Constraints: 
//
// 
// 1 <= k <= 100 
// 1 <= prices.length <= 1000 
// 0 <= prices[i] <= 1000 
// 
//
// Related Topics Array Dynamic Programming 👍 6326 👎 197


import java.util.Arrays;

public class P188BestTimeToBuyAndSellStockIv {
    public static void main(String[] args) {
        Solution solution = new P188BestTimeToBuyAndSellStockIv().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxProfit(int k, int[] prices) {

            int[][] dp = new int[prices.length][1 + k * 2];

            //dp[i][0]表示在第i天时没有买过股票手上的最大收益
            //dp[i][1]表示在第i天时买过k次股票还没有卖出手上的最大收益
            //dp[i][2]表示在第i天时买过k次也卖出过k次股票手上的最大收益

            Arrays.fill(dp[0], -100000);
            dp[0][0] = 0;
            dp[0][1] = -prices[0];

            for (int i = 1; i < prices.length; i++) {
                dp[i][0] = dp[i - 1][0];
                for (int j = 0; j < k; j++) {
                    int statusBuy = j * 2 + 1;
                    int statusSell = j * 2 + 2;
                    //前一天已经买入 || 今天买入  求最大值
                    dp[i][statusBuy] = Math.max(dp[i - 1][statusBuy], dp[i - 1][statusBuy - 1] - prices[i]);
                    //前一天已经卖出 || 今天卖出  求最大值
                    dp[i][statusSell] = Math.max(dp[i - 1][statusSell], dp[i - 1][statusSell - 1] + prices[i]);
                }
            }

            int max = dp[prices.length - 1][0];
            for (int i = 0; i < k; i++) {
                int statusSell = i * 2 + 2;
                max = Math.max(max, dp[prices.length - 1][statusSell]);
            }
            return max;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}