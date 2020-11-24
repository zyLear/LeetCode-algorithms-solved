package com.zylear.problem.leetcode.editor.en;

//Say you have an array prices for which the ith element is the price of a given
// stock on day i. 
//
// Design an algorithm to find the maximum profit. You may complete as many tran
//sactions as you like (i.e., buy one and sell one share of the stock multiple tim
//es). 
//
// Note: You may not engage in multiple transactions at the same time (i.e., you
// must sell the stock before you buy again). 
//
// Example 1: 
//
// 
//Input: [7,1,5,3,6,4]
//Output: 7
//Explanation: Buy on day 2 (price = 1) and sell on day 3 (price = 5), profit = 
//5-1 = 4.
//             Then buy on day 4 (price = 3) and sell on day 5 (price = 6), prof
//it = 6-3 = 3.
// 
//
// Example 2: 
//
// 
//Input: [1,2,3,4,5]
//Output: 4
//Explanation: Buy on day 1 (price = 1) and sell on day 5 (price = 5), profit = 
//5-1 = 4.
//             Note that you cannot buy on day 1, buy on day 2 and sell them lat
//er, as you are
//             engaging multiple transactions at the same time. You must sell be
//fore buying again.
// 
//
// Example 3: 
//
// 
//Input: [7,6,4,3,1]
//Output: 0
//Explanation: In this case, no transaction is done, i.e. max profit = 0. 
//
// 
// Constraints: 
//
// 
// 1 <= prices.length <= 3 * 10 ^ 4 
// 0 <= prices[i] <= 10 ^ 4 
// 
// Related Topics Array Greedy 
// 👍 3271 👎 1864


public class P122BestTimeToBuyAndSellStockIi {
    public static void main(String[] args) {
        int[] array = {1, 2};
        Solution solution = new P122BestTimeToBuyAndSellStockIi().new Solution();
        System.out.println(solution.maxProfit(array));
    }


    //leetcode submit region begin(Prohibit modification and deletion)


    class Solution {
        public int maxProfit(int[] prices) {
            int profit = 0;
            for (int i = 0; i < prices.length - 1; i++) {
                if (prices[i + 1] > prices[i]) {
                    profit += prices[i + 1] - prices[i];
                }
            }
            return profit;
        }
    }


    //leetcode submit region end(Prohibit modification and deletion)


    //第二种方法  峰谷法   善用双层while  例外的while都加同样的基本判断条件，在里层while附加额外条件
    class Solution2 {
        public int maxProfit(int[] prices) {
            int profit = 0;
            int peak = 0;
            int valley = 0;
            int i = 0;
            while (i < prices.length - 1) {

                //双循环截断，重要！！！！  条件跟外层一样
                while (i < prices.length - 1 && prices[i] >= prices[i + 1]) {
                    i++;
                }
                valley = i;

                while (i < prices.length - 1 && prices[i] <= prices[i + 1]) {
                    i++;
                }
                peak = i;

                profit += prices[peak] - prices[valley];

            }
            return profit;

//            int i = 0;
//            int valley = prices[0];
//            int peak = prices[0];
//            int maxprofit = 0;
//            while (i < prices.length - 1) {
//                while (i < prices.length - 1 && prices[i] >= prices[i + 1])
//                    i++;
//                valley = prices[i];
//                while (i < prices.length - 1 && prices[i] <= prices[i + 1])
//                    i++;
//                peak = prices[i];
//                maxprofit += peak - valley;
//            }
//            return maxprofit;
        }
    }


}
