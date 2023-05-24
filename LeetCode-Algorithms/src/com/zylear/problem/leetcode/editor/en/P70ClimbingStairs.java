package com.zylear.problem.leetcode.editor.en;

//You are climbing a staircase. It takes n steps to reach the top. 
//
// Each time you can either climb 1 or 2 steps. In how many distinct ways can yo
//u climb to the top?
//
// 
// Example 1: 
//
// 
//Input: n = 2
//Output: 2
//Explanation: There are two ways to climb to the top.
//1. 1 step + 1 step
//2. 2 steps
// 
//
// Example 2: 
//
// 
//Input: n = 3
//Output: 3
//Explanation: There are three ways to climb to the top.
//1. 1 step + 1 step + 1 step
//2. 1 step + 2 steps
//3. 2 steps + 1 step
// 
//
// 
// Constraints: 
//
// 
// 1 <= n <= 45 
// 
// Related Topics Dynamic Programming 
// 👍 5348 👎 171


public class P70ClimbingStairs {
    public static void main(String[] args) {
        Solution solution = new P70ClimbingStairs().new Solution();
        solution.climbStairs(3);
        // TO TEST

    }

    //leetcode submit region begin(Prohibit modification and deletion)

    class Solution {
        public int climbStairs(int n) {
            if (n == 1) {
                return 1;
            }
            if (n == 2) {
                return 2;
            }
            int[] dp = new int[n + 1];
            dp[1] = 1;
            dp[2] = 2;


            for (int i = 3; i <= n; i++) {
                dp[i] = dp[i - 1] + dp[i - 2];
            }
            return dp[n];

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    class Solution2 {
        public int climbStairs(int n) {
            if (n == 1) {
                return 1;
            }
            if (n == 2) {
                return 2;
            }
            int subTwoStepCount = 1;
            int subOneStepCount = 2;

            int temp;
            for (int i = 2; i < n; i++) {

                temp = subOneStepCount + subTwoStepCount;
                subTwoStepCount = subOneStepCount;
                subOneStepCount = temp;
            }
            return subOneStepCount;
        }
    }
}

