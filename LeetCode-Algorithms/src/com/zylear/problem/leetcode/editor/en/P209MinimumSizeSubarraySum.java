package com.zylear.problem.leetcode.editor.en;

//Given an array of n positive integers and a positive integer s, find the minim
//al length of a contiguous subarray of which the sum ≥ s. If there isn't one, ret
//urn 0 instead. 
//
// Example: 
//
// 
//Input: s = 7, nums = [2,3,1,2,4,3]
//Output: 2
//Explanation: the subarray [4,3] has the minimal length under the problem const
//raint. 
//
// Follow up: 
//
// If you have figured out the O(n) solution, try coding another solution of whi
//ch the time complexity is O(n log n). 
// Related Topics Array Two Pointers Binary Search 
// 👍 3106 👎 129


public class P209MinimumSizeSubarraySum {
    public static void main(String[] args) {
        // Solution solution = new P209MinimumSizeSubarraySum().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        //two pointer解法都是很考验思维
        public int minSubArrayLen(int s, int[] nums) {

            int sum = 0;
            int lower = 0;
            int result = Integer.MAX_VALUE;
            for (int upper = 0; upper < nums.length; upper++) {
                sum += nums[upper];

                while (sum >= s) {
                    result = Math.min(upper - lower + 1, result);
                    sum -= nums[lower];
                    lower++;
                }
            }

            return result == Integer.MAX_VALUE ? 0 : result;
        }


        //two pointer解法都是很考验思维
        public int minSubArrayLen1(int s, int[] nums) {

            int sum = 0;
            int lower = 0;
            int result = Integer.MAX_VALUE;
            for (int upper = 0; upper < nums.length; upper++) {
                sum += nums[upper];

                while (sum >= s) {
                    result = Math.min(upper - lower + 1, result);
                    sum -= nums[lower];
                    lower++;
                }
            }

            return result == Integer.MAX_VALUE ? 0 : result;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}
