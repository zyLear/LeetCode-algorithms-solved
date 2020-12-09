package com.zylear.problem.leetcode.editor.en;

//You are given an integer array nums sorted in ascending order, and an integer 
//target. 
//
// Suppose that nums is rotated at some pivot unknown to you beforehand (i.e., [
//0,1,2,4,5,6,7] might become [4,5,6,7,0,1,2]). 
//
// If target is found in the array return its index, otherwise, return -1. 
//
// 
// Example 1: 
// Input: nums = [4,5,6,7,0,1,2], target = 0
//Output: 4
// Example 2: 
// Input: nums = [4,5,6,7,0,1,2], target = 3
//Output: -1
// Example 3: 
// Input: nums = [1], target = 0
//Output: -1
// 
// 
// Constraints: 
//
// 
// 1 <= nums.length <= 5000 
// -10^4 <= nums[i] <= 10^4 
// All values of nums are unique. 
// nums is guranteed to be rotated at some pivot. 
// -10^4 <= target <= 10^4 
// 
// Related Topics Array Binary Search 
// 👍 6443 👎 560


import java.util.HashMap;

public class P33SearchInRotatedSortedArray {
    public static void main(String[] args) {
        // Solution solution = new P33SearchInRotatedSortedArray().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int search(int[] nums, int target) {
            int left = 0;
            int right = nums.length - 1;
            while (left <= right) {
                int mid = left + (right - left) / 2;
                if (nums[mid] == target) {
                    return mid;
                } else if (nums[mid] > target) {
                    // the left half is monotonic, yet still does not satisfy
                    if (nums[left] <= nums[mid] && nums[left] > target) {
                        left = mid + 1;
                    } else {
                        right = mid - 1;
                    }
                } else {
                    // the right half is monotonic, yet still does not satisfy
                    if (nums[right] >= nums[mid] && nums[right] < target) {
                        right = mid - 1;
                    } else {
                        left = mid + 1;
                    }
                }
            }
            return -1;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
