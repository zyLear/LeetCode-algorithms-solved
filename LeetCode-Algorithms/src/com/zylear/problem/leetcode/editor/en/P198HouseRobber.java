package com.zylear.problem.leetcode.editor.en;

//You are a professional robber planning to rob houses along a street. Each hous
//e has a certain amount of money stashed, the only constraint stopping you from r
//obbing each of them is that adjacent houses have security system connected and i
//t will automatically contact the police if two adjacent houses were broken into 
//on the same night. 
//
// Given a list of non-negative integers representing the amount of money of eac
//h house, determine the maximum amount of money you can rob tonight without alert
//ing the police. 
//
// 
// Example 1: 
//
// 
//Input: nums = [1,2,3,1]
//Output: 4
//Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
//             Total amount you can rob = 1 + 3 = 4.
// 
//
// Example 2: 
//
// 
//Input: nums = [2,7,9,3,1]
//Output: 12
//Explanation: Rob house 1 (money = 2), rob house 3 (money = 9) and rob house 5 
//(money = 1).
//             Total amount you can rob = 2 + 9 + 1 = 12.
// 
//
// 
// Constraints: 
//
// 
// 0 <= nums.length <= 100 
// 0 <= nums[i] <= 400 
// 
// Related Topics Dynamic Programming 
// 👍 6093 👎 180


public class P198HouseRobber {
    public static void main(String[] args) {
        Solution solution = new P198HouseRobber().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        //dp[n] 表示抢劫可能以n号屋子为结尾的最大金额
        //求解就是  dp[n]
        //状态转移方程   dp[n]=max(dp[n-1],dp[n-2] + array[n])
        private int[] dp;

        public int rob(int[] nums) {
            if (nums.length == 0) {
                return 0;
            }
            dp = new int[nums.length + 1];

            dp[0] = 0;
            dp[1] = nums[0];

            for (int i = 2; i <= nums.length; i++) {
                dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i - 1]);
            }

            return dp[nums.length];
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)


}