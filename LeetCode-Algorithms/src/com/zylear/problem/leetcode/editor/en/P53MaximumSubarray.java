package com.zylear.problem.leetcode.editor.en;

//Given an integer array nums, find the contiguous subarray (containing at least
// one number) which has the largest sum and return its sum.
//
// Follow up: If you have figured out the O(n) solution, try coding another solu
//tion using the divide and conquer approach, which is more subtle. 
//
// 
// Example 1: 
//
// 
//Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
//Output: 6
//Explanation: [4,-1,2,1] has the largest sum = 6.
// 
//
// Example 2: 
//
// 
//Input: nums = [1]
//Output: 1
// 
//
// Example 3: 
//
// 
//Input: nums = [0]
//Output: 0
// 
//
// Example 4: 
//
// 
//Input: nums = [-1]
//Output: -1
// 
//
// Example 5: 
//
// 
//Input: nums = [-2147483647]
//Output: -2147483647
// 
//
// 
// Constraints: 
//
// 
// 1 <= nums.length <= 2 * 104 
// -231 <= nums[i] <= 231 - 1 
// 
// Related Topics Array Divide and Conquer Dynamic Programming 
// 👍 9712 👎 472


public class P53MaximumSubarray {
    public static void main(String[] args) {
//        Solution solution = new Solution();
        // TO TEST
    }

    //暴力法
    //分治法
    //动态规划



    /*

    如果把 状态 dp[i] 定为 0-i 的最大子序列和，最后只要返回 dp[n-1] 即可，但 决策 无法确定，不能根据dp[i-1] 得到 dp[i] , 因为 dp[i-1] 保存的最大子序列和可能不和dp[i-1]连续 ，如 [−2,1,−3,4,−1,2,1,−5,4] ,dp[0]=-2,dp[1]=1,dp[2]=1,dp[3] 不能等于5，因为dp[2] 没有记录序列是否是连续的。

定义状态：dp[i] 表示包含 a[i] 的最大连续子串长度，不一定从nums[0] 开始
起始装填：dp[0]=nums[0]
终止状态：dp[nums.length-1]
转移函数 : dp[i]=max( dp[i−1]+a[i] , a[i] )

    */
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxSubArray(int[] nums) {

            //以i结尾最大子序列和，不一定从nums[0]开始
            int[] dp = new int[nums.length];

            dp[0] = nums[0];
            int max = nums[0];

            for (int i = 0; i < nums.length - 1; i++) {
                if (dp[i] < 0) {
                    dp[i + 1] = nums[i + 1];
                }else {
                    dp[i + 1] = dp[i] + nums[i + 1];
                }

                max = Math.max(max, dp[i + 1]);
            }
            return max;


        }
    }
    //leetcode submit region end(Prohibit modification and deletion)


    //暴力解法时间超时
    class Solution2 {
        public int maxSubArray(int[] nums) {

            int max = nums[0];
            for (int i = 0; i < nums.length; i++) {
                for (int j = i; j < nums.length; j++) {
                    int total = calculateSum(i, j, nums);
                    if (total > max) {
                        max = total;
                    }
                }
            }
            return max;
        }

        public int calculateSum(int i, int j, int[] nums) {
            int count = 0;
            for (int index = i; index <= j; index++) {
                count += nums[index];
            }
            return count;
        }
    }

}

