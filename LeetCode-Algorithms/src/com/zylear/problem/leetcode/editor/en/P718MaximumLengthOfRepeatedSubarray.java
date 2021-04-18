package com.zylear.problem.leetcode.editor.en;

//Given two integer arrays nums1 and nums2, return the maximum length of a subar
//ray that appears in both arrays. 
//
// 
// Example 1: 
//
// 
//Input: nums1 = [1,2,3,2,1], nums2 = [3,2,1,4,7]
//Output: 3
//Explanation: The repeated subarray with maximum length is [3,2,1].
// 
//
// Example 2: 
//
// 
//Input: nums1 = [0,0,0,0,0], nums2 = [0,0,0,0,0]
//Output: 5
// 
//
// 
// Constraints: 
//
// 
// 1 <= nums1.length, nums2.length <= 1000 
// 0 <= nums1[i], nums2[i] <= 100 
// 
// Related Topics Array Hash Table Binary Search Dynamic Programming 
// 👍 1971 👎 54


public class P718MaximumLengthOfRepeatedSubarray {
    public static void main(String[] args) {
        Solution solution = new P718MaximumLengthOfRepeatedSubarray().new Solution();
    }

    // 1  2  3
    // 2  3  4

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        //动态规划
        public int findLength(int[] nums1, int[] nums2) {

            //dp[i][j] 以nums1[i] nums[j] 结尾的最长公共字串
            // if(nums1[i]==nums2[j]) dp[i][j]=dp[i-1][j-1]+1
            int[][] dp = new int[nums1.length + 1][nums2.length + 1];

            int max = 0;
            for (int i = 1; i <= nums1.length; i++) {
                for (int j = 1; j <= nums2.length; j++) {
                    if (nums1[i - 1] == nums2[j - 1]) {
                        dp[i][j] = dp[i - 1][j - 1] + 1;
                        max = Math.max(max, dp[i][j]);
                    }
                }
            }

            return max;
        }


        public int findLength2(int[] nums1, int[] nums2) {

            //暴力法
            int max = 0;
            for (int i = 0; i < nums1.length; i++) {
                for (int j = 0; j < nums2.length; j++) {

                    int count = 0;
                    for (int r = i, t = j; r < nums1.length && t < nums2.length; r++, t++) {
                        if (nums1[r] == nums2[t]) {
                            count++;
                        } else {
                            break;
                        }
                    }
                    max = Math.max(count, max);

                }
            }
            return max;
        }

        public int findLength3(int[] nums1, int[] nums2) {
            //一数组固定 一数组平行移动比较法
            //   ===nums2===|==nums1==
            //
            int max = 0;
            for (int i = -nums2.length; i < nums1.length; i++) {
                int count = 0;
                for (int r = i, t = 0; r < nums1.length && t < nums2.length; r++, t++) {
                    if (r < 0) {
                        continue;
                    }
                    if (nums1[r] == nums2[t]) {
                        count++;
                    } else {
                        max = Math.max(count, max);
                        count = 0;
                    }
                }

                max = Math.max(count, max);
            }
            return max;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)


}