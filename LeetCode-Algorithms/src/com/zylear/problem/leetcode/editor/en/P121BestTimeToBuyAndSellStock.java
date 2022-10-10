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
        public int maxProfit1(int[] prices) {

            return 0;
        }

        public int maxProfit(int[] prices) {
            if (prices.length == 0) {
                return 0;
            }
            int profit = 0;
            int peak = 0;
            int valley = prices[0];
            int i = 0;

            while (i < prices.length) {

                //双循环截断，重要！！！！  条件跟外层一样
//                while (i < prices.length - 1 && prices[i] >= prices[i + 1]) {
//                    i++;
//                }

                valley = Math.min(prices[i], valley);

//                while (i < prices.length - 1 && prices[i] <= prices[i + 1]) {
//                    i++;
//                }
                peak = prices[i];

                profit = Math.max(peak - valley, profit);
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

