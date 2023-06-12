package com.zylear.problem.leetcode.editor.en;

//Given an array of non-negative integers nums, you are initially positioned at 
//the first index of the array. 
//
// Each element in the array represents your maximum jump length at that positio
//n. 
//
// Your goal is to reach the last index in the minimum number of jumps. 
//
// You can assume that you can always reach the last index. 
//
// 
// Example 1: 
//
// 
//Input: nums = [2,3,1,1,4]
//Output: 2
//Explanation: The minimum number of jumps to reach the last index is 2. Jump 1 
//step from index 0 to 1, then 3 steps to the last index.
// 
//
// Example 2: 
//
// 
//Input: nums = [2,3,0,1,4]
//Output: 2
// 
//
// 
// Constraints: 
//
// 
// 1 <= nums.length <= 3 * 104 
// 0 <= nums[i] <= 105 
// 
// Related Topics Array Greedy 
// 👍 3358 👎 161


public class P45JumpGameIi {
    public static void main(String[] args) {
        // Solution solution = new P45JumpGameIi().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public int jump(int[] nums) {

            int jmp = 0;
            int lastPosition = nums.length - 1;

            while (true) {
                //从前往后遍历 很重要 可以找到第一个到达的点
                for (int i = 0; i < lastPosition; i++) {
                    //第一个到达目标的点 把目标转移成i
                    if (i + nums[i] >= lastPosition) {
                        lastPosition = i;
                        jmp++;
                        break;
                    }
                }
                if (lastPosition == 0) {
                    return jmp;
                }
            }
        }


        //[2,3,1,1,4]
        //dp 超时
        public int jump1(int[] nums) {
            int[] dp = new int[nums.length];
            dp[0] = 0;

            for (int i = 1; i < dp.length; i++) {
                int min = Integer.MAX_VALUE;
                for (int j = 0; j < i; j++) {
                    if (dp[j] != Integer.MAX_VALUE && j + nums[j] >= i) {
                        min = Math.min(dp[j] + 1, min);
                    }
                }
                dp[i] = min;
            }
            return dp[nums.length - 1];
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}
