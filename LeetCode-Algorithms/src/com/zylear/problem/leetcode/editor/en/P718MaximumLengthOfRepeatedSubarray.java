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
        public int findLength(int[] nums1, int[] nums2) {

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