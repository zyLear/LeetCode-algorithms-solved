package com.zylear.problem.leetcode.editor.en;

//Suppose an array sorted in ascending order is rotated at some pivot unknown to
// you beforehand. 
//
// (i.e., [0,1,2,4,5,6,7] might become [4,5,6,7,0,1,2]). 
//
// Find the minimum element. 
//
// The array may contain duplicates. 
//
// Example 1: 
//
// 
//Input: [1,3,5]
//Output: 1 
//
// Example 2: 
//
// 
//Input: [2,2,2,0,1]
//Output: 0 
//
// Note: 
//
// 
// This is a follow up problem to Find Minimum in Rotated Sorted Array. 
// Would allow duplicates affect the run-time complexity? How and why? 
// 
// Related Topics Array Binary Search 
// 👍 1354 👎 262


public class P154FindMinimumInRotatedSortedArrayIi{
    public static void main(String[] args) {
        // Solution solution = new P154FindMinimumInRotatedSortedArrayIi().new Solution();
        // TO TEST
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int findMin(int[] nums) {
            int lower = 0;
            int upper = nums.length - 1;

            while (lower < upper) {
                if (lower + 1 == upper) {
                    return Math.min(nums[lower], nums[upper]);
                }

                int mid = lower + (upper - lower) / 2;
                if (nums[lower] == nums[mid]) {
                    lower++;
                    continue;
                }


                //以用单调性 + 头尾判断
                if (nums[lower] <= nums[mid] ) {
                    if (nums[upper] > nums[lower]) {
                        return nums[lower];
                    }else {
                        lower = mid;
                    }
                } else {
                    upper = mid;
                }
            }

            return nums[lower];
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}
