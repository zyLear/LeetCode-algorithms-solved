package com.zylear.problem.leetcode.editor.en;

//You are a professional robber planning to rob houses along a street. Each hous
//e has a certain amount of money stashed. All houses at this place are arranged i
//n a circle. That means the first house is the neighbor of the last one. Meanwhil
//e, adjacent houses have a security system connected, and it will automatically c
//ontact the police if two adjacent houses were broken into on the same night. 
//
// Given an integer array nums representing the amount of money of each house, r
//eturn the maximum amount of money you can rob tonight without alerting the polic
//e. 
//
// 
// Example 1: 
//
// 
//Input: nums = [2,3,2]
//Output: 3
//Explanation: You cannot rob house 1 (money = 2) and then rob house 3 (money = 
//2), because they are adjacent houses.
// 
//
// Example 2: 
//
// 
//Input: nums = [1,2,3,1]
//Output: 4
//Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
//Total amount you can rob = 1 + 3 = 4.
// 
//
// Example 3: 
//
// 
//Input: nums = [0]
//Output: 0
// 
//
// 
// Constraints: 
//
// 
// 1 <= nums.length <= 100 
// 0 <= nums[i] <= 1000 
// 
// Related Topics Dynamic Programming 
// 👍 2789 👎 64


public class P213HouseRobberIi {
    public static void main(String[] args) {
        // Solution solution = new P213HouseRobberIi().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int rob(int[] nums) {

            if (nums.length == 0) {
                return 0;
            } else if (nums.length == 1) {
                return nums[0];
            } else if(nums.length==2){
                return Math.max(nums[0], nums[1]);
            }else {
                return Math.max(rob(nums, 0, nums.length - 2),
                        rob(nums, 1, nums.length - 1));
            }

        }

        private int rob(int[] nums, int left, int right) {
            int length = right - left + 1;
            //dp[n] 代表到抢到n时的解
            int[] dp = new int[length];

            dp[0] = nums[left];
            dp[1] = Math.max(nums[left], nums[left + 1]);
            for (int i = 2; i < length; i++) {
                int index = i + left;
                dp[i] = Math.max(dp[i - 2] + nums[index], dp[i - 1]);
            }


            return dp[length - 1];
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}
