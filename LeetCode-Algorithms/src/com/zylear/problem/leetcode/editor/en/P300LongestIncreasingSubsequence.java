package com.zylear.problem.leetcode.editor.en;

//Given an integer array nums, return the length of the longest strictly increas
//ing subsequence. 
//
// A subsequence is a sequence that can be derived from an array by deleting som
//e or no elements without changing the order of the remaining elements. For examp
//le, [3,6,2,7] is a subsequence of the array [0,3,1,6,2,2,7]. 
//
// 
// Example 1: 
//
// 
//Input: nums = [10,9,2,5,3,7,101,18]
//Output: 4
//Explanation: The longest increasing subsequence is [2,3,7,101], therefore the 
//length is 4.
// 
//
// Example 2: 
//
// 
//Input: nums = [0,1,0,3,2,3]
//Output: 4
// 
//
// Example 3: 
//
// 
//Input: nums = [7,7,7,7,7,7,7]
//Output: 1
// 
//
// 
// Constraints: 
//
// 
// 1 <= nums.length <= 2500 
// -104 <= nums[i] <= 104 
// 
//
// 
// Follow up: 
//
// 
// Could you come up with the O(n2) solution? 
// Could you improve it to O(n log(n)) time complexity? 
// 
// Related Topics Binary Search Dynamic Programming 
// 👍 6250 👎 143


import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class P300LongestIncreasingSubsequence {
    public static void main(String[] args) {
        // Solution solution = new P300LongestIncreasingSubsequence().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public int lengthOfLIS(int[] nums) {
            if (nums.length == 0) {
                return 0;
            }
            //dp[n]=以n结尾的解
            int[] dp = new int[nums.length];
            dp[0] = 1;
            int max = 1;
            for (int i = 1; i < dp.length; i++) {
                int prevMax = 0;
                for (int j = 0; j < i; j++) {
                    if (nums[i] > nums[j]) {
                        prevMax = Math.max(prevMax, dp[j]);
                    }
                }
                dp[i] = prevMax + 1;
                max = Math.max(max, dp[i]);
            }
            return max;
        }


        int[][] map;

        public int lengthOfLIS5(int[] nums) {
            map = new int[nums.length + 1][nums.length];
            for (int[] l : map) {
                Arrays.fill(l, -1);
            }
            return recursive2(nums, -1, 0);
        }

        private int recursive2(int[] nums, int prevIndex, int index) {
            if (index == nums.length) {
                return 0;
            }
            int temp = map[prevIndex + 1][index];
            if (temp >= 0) {
                return temp;
            }

            int max = 0;
            if (prevIndex < 0 || nums[index] > nums[prevIndex]) {
                max = Math.max(max, 1 + recursive2(nums, index, index + 1));
            }
            max = Math.max(max, recursive2(nums, prevIndex, index + 1));

            map[prevIndex + 1][index] = max;

            return max;
        }


        public int lengthOfLIS2(int[] nums) {
            return recursive(nums, Integer.MIN_VALUE, 0);
        }

        private int recursive(int[] nums, int prev, int index) {
            if (index == nums.length) {
                return 0;
            }
            int max = 0;
            if (nums[index] > prev) {
                max = Math.max(max, 1 + recursive(nums, nums[index], index + 1));
            }
            max = Math.max(max, recursive(nums, prev, index + 1));

            return max;
        }

        //lime exceeded
        public int lengthOfLIS1(int[] nums) {
            return dfs(nums, Integer.MIN_VALUE, 0);
        }

        private int dfs(int[] nums, int prev, int indexOfAttempts) {
            if (indexOfAttempts == nums.length) {
                return 0;
            }
            int max = 0;
            for (int i = indexOfAttempts; i < nums.length; i++) {
                if (nums[i] > prev) {
                    max = Math.max(max, 1 + dfs(nums, nums[i], i + 1));
                } else {
                    max = Math.max(max, dfs(nums, prev, i + 1));
                }

            }

            return max;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}
