package com.zylear.problem.leetcode.editor.en;

//Say you have an array for which the ith element is the price of a given stock 
//on day i. 
//
// If you were only permitted to complete at most one transaction (i.e., buy one
// and sell one share of the stock), design an algorithm to find the maximum profi
//t. 
//
// Note that you cannot sell a stock before you buy one. 
//
// Example 1: 
//
// 
//Input: [7,1,5,3,6,4]
//Output: 5
//Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 
//6-1 = 5.
//             Not 7-1 = 6, as selling price needs to be larger than buying pric
//e.
// 
//
// Example 2: 
//
// 
//Input: [7,6,4,3,1]
//Output: 0
//Explanation: In this case, no transaction is done, i.e. max profit = 0.
// 
// Related Topics Array Dynamic Programming 
// 👍 6742 👎 293


public class P121BestTimeToBuyAndSellStock {
    public static void main(String[] args) {
        Solution solution = new P121BestTimeToBuyAndSellStock().new Solution();
        int[] array = {1,2};
        System.out.println(solution.maxProfit(array));
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        //动态规划法
        public int maxProfit(int[] prices) {

            //dp[i][0] 表示在i天时不持有股票手上最大金额
            //dp[i][1] 表示在i天时持有股票手上最大金额
            int[][] dp = new int[prices.length][2];
            dp[0][0] = 0;
            dp[0][1] = -prices[0];
            //第二天开始
            for (int i = 1; i < prices.length; i++) {
                //之前已经卖出||今天卖出  求最大值
                dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
                //昨天已经买入||今天买入  求最大值
                dp[i][1] = Math.max(dp[i - 1][1], -prices[i]);
            }
            return dp[prices.length - 1][0];
        }

        public int maxProfit1(int[] prices) {
            if (prices.length == 0) {
                return 0;
            }
            int profit = 0;
//            int peak = 0;
            int valley = prices[0];
            int i = 0;

            while (i < prices.length) {

                valley = Math.min(prices[i], valley);

                profit = Math.max(prices[i] - valley, profit);
                i++;

            }
            return profit;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    //峰谷法  不错
    class Solution2 {
        public int maxProfit(int[] prices) {
            if (prices.length == 0) {
                return 0;
            }
            int profit = 0;
            int peak = 0;
            int valley = prices[0];
            int i = 0;

            while (i < prices.length - 1) {

                //双循环截断，重要！！！！  条件跟外层一样
                while (i < prices.length - 1 && prices[i] >= prices[i + 1]) {
                    i++;
                }

                valley = Math.min(prices[i], valley);

                while (i < prices.length - 1 && prices[i] <= prices[i + 1]) {
                    i++;
                }
                peak = prices[i];

                profit = Math.max(peak - valley, profit);

            }
            return profit;
        }
    }
}

