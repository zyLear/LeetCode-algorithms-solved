package com.zylear.problem.leetcode.editor.en;

//You are given an integer array nums sorted in ascending order (not necessarily
// distinct values), and an integer target. 
//
// Suppose that nums is rotated at some pivot unknown to you beforehand (i.e., [
//0,1,2,4,4,4,5,6,6,7] might become [4,5,6,6,7,0,1,2,4,4]). 
//
// If target is found in the array return its index, otherwise, return -1. 
//
// 
// Example 1: 
// Input: nums = [2,5,6,0,0,1,2], target = 0
//Output: true
// Example 2: 
// Input: nums = [2,5,6,0,0,1,2], target = 3
//Output: false
// 
// 
// Constraints: 
//
// 
// 1 <= nums.length <= 5000 
// -104 <= nums[i] <= 104 
// nums is guaranteed to be rotated at some pivot. 
// -104 <= target <= 104 
// 
//
// 
//Follow up: This problem is the same as Search in Rotated Sorted Array, where n
//ums may contain duplicates. Would this affect the run-time complexity? How and w
//hy? Related Topics Array Binary Search 
// 👍 1857 👎 536


public class P81SearchInRotatedSortedArrayIi {
    public static void main(String[] args) {
        Solution solution = new P81SearchInRotatedSortedArrayIi().new Solution();
        int[] ints = new int[]{1, 3, 5};
        System.out.println(solution.search(ints, 1));
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean search(int[] nums, int target) {

            int lower = 0;
            int upper = nums.length - 1;
            while (lower <= upper) {


                int mid = lower + (upper - lower) / 2;
                if (nums[mid] == target) {
                    return true;
                } else {
                    if (nums[mid] == nums[lower] && nums[mid] == nums[upper]) {
                        lower++;
                        continue;
                    }

                    if (nums[mid] > target) {

                        if (nums[lower] <= nums[mid] && nums[lower] > target) {
                            lower = mid + 1;
                        } else {
                            upper = mid - 1;
                        }
                    } else {
                        if (nums[upper] >= nums[mid] && nums[upper] < target) {
                            upper = mid - 1;
                        } else {
                            lower = mid + 1;
                        }
                    }
                }
            }
            return false;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}
