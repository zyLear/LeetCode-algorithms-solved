package com.zylear.problem.leetcode.editor.en;

//Given an array nums of n integers and an integer target, find three integers i
//n nums such that the sum is closest to target. Return the sum of the three integ
//ers. You may assume that each input would have exactly one solution. 
//
// 
// Example 1: 
//
// 
//Input: nums = [-1,2,1,-4], target = 1
//Output: 2
//Explanation: The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
// 
//
// 
// Constraints: 
//
// 
// 3 <= nums.length <= 10^3 
// -10^3 <= nums[i] <= 10^3 
// -10^4 <= target <= 10^4 
// 
// Related Topics Array Two Pointers 
// 👍 2711 👎 159


public class P16ThreeSumClosest {
    public static void main(String[] args) {
        Solution solution = new P16ThreeSumClosest().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

//        private int diff
//
//        public int threeSumClosest(int[] nums, int target) {
//
//            return 0;
//
//        }



        public int threeSumClosest1(int[] nums, int target) {

            Integer sum = null;
            Integer diff = Integer.MAX_VALUE;
            for (int i = 0; i < nums.length; i++) {
                for (int j = i + 1; j < nums.length; j++) {
                    for (int k = j + 1; k < nums.length; k++) {
                        int count = nums[i] + nums[j] + nums[k];
                        if (sum == null) {
                            diff = Math.max(count, target) - Math.min(count, target);
                            sum = count;
                        }else {
                            if (Math.max(count, target) - Math.min(count, target) < diff) {
                                diff = Math.max(count, target) - Math.min(count, target);
                                sum = count;
                            }
                        }
                    }
                }
            }
            return sum;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)


}