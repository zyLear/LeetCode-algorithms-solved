package com.zylear.problem.leetcode.editor.en;

//Given an integer array nums, find a contiguous non-empty subarray within the a
//rray that has the largest product, and return the product. 
//
// It is guaranteed that the answer will fit in a 32-bit integer. 
//
// A subarray is a contiguous subsequence of the array. 
//
// 
// Example 1: 
//
// 
//Input: nums = [2,3,-2,4]
//Output: 6
//Explanation: [2,3] has the largest product 6.
// 
//
// Example 2: 
//
// 
//Input: nums = [-2,0,-1]
//Output: 0
//Explanation: The result cannot be 2, because [-2,-1] is not a subarray.
// 
//
// 
// Constraints: 
//
// 
// 1 <= nums.length <= 2 * 104 
// -10 <= nums[i] <= 10 
// 
// Related Topics Array Dynamic Programming 
// 👍 6459 👎 210


public class P152MaximumProductSubarray {
    public static void main(String[] args) {
        // Solution solution = new P152MaximumProductSubarray().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxProduct(int[] nums) {

            int prevMin = nums[0];
            int prevMax = nums[0];
            int max = prevMax;
            for (int i = 1; i < nums.length; i++) {
                int currentMax = Math.max(nums[i], Math.max(nums[i] * prevMin, nums[i] * prevMax));
                int currentMin = Math.min(nums[i], Math.min(nums[i] * prevMin, nums[i] * prevMax));
                prevMax = currentMax;
                prevMin = currentMin;
                max = Math.max(currentMax, max);
            }

            return max;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}
