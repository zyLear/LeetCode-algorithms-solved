package com.zylear.problem.leetcode.editor.en;

//Given an array of non-negative integers, you are initially positioned at the f
//irst index of the array. 
//
// Each element in the array represents your maximum jump length at that positio
//n. 
//
// Determine if you are able to reach the last index. 
//
// 
// Example 1: 
//
// 
//Input: nums = [2,3,1,1,4]
//Output: true
//Explanation: Jump 1 step from index 0 to 1, then 3 steps to the last index.
// 
//
// Example 2: 
//
// 
//Input: nums = [3,2,1,0,4]
//Output: false
//Explanation: You will always arrive at index 3 no matter what. Its maximum jum
//p length is 0, which makes it impossible to reach the last index.
// 
//
// 
// Constraints: 
//
// 
// 1 <= nums.length <= 3 * 10^4 
// 0 <= nums[i][j] <= 10^5 
// 
// Related Topics Array Greedy 
// 👍 5300 👎 374


public class P55JumpGame {
    public static void main(String[] args) {
        Solution solution = new P55JumpGame().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public boolean canJump(int[] nums) {
            int lastPosition = nums.length - 1;

            for (int i = nums.length - 2; i >= 0; i--) {
                if (i + nums[i] >= lastPosition) {
                    lastPosition = i;
                }
            }

            return lastPosition == 0;
        }


        //dynamic programming solution
        public boolean canJump1(int[] nums) {
            boolean[] dp = new boolean[nums.length];
            dp[nums.length - 1] = true;
            for (int i = nums.length - 2; i >= 0; i--) {

                int num = nums[i];
                boolean result = false;

                for (int j = i + 1; j <= i + num; j++) {
                    if (dp[j]) {
                        result = true;
                        break;
                    }
                }
                dp[i] = result;
            }

            return dp[0];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}