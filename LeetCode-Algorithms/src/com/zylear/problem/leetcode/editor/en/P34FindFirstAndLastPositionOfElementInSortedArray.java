package com.zylear.problem.leetcode.editor.en;

//Given an array of integers nums sorted in ascending order, find the starting a
//nd ending position of a given target value. 
//
// If target is not found in the array, return [-1, -1]. 
//
// Follow up: Could you write an algorithm with O(log n) runtime complexity? 
//
// 
// Example 1: 
// Input: nums = [5,7,7,8,8,10], target = 8
//Output: [3,4]
// Example 2: 
// Input: nums = [5,7,7,8,8,10], target = 6
//Output: [-1,-1]
// Example 3: 
// Input: nums = [], target = 0
//Output: [-1,-1]
// 
// 
// Constraints: 
//
// 
// 0 <= nums.length <= 105 
// -109 <= nums[i] <= 109 
// nums is a non-decreasing array. 
// -109 <= target <= 109 
// 
// Related Topics Array Binary Search 
// 👍 4541 👎 179


public class P34FindFirstAndLastPositionOfElementInSortedArray {
    public static void main(String[] args) {
        // Solution solution = new P34FindFirstAndLastPositionOfElementInSortedArray().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] searchRange(int[] nums, int target) {
            int[] result = {-1, -1};

            int left = findIndex(nums, target, true);
            if (left == -1) {
                return result;
            }
            int right = findIndex(nums, target, false);
            result[0] = left;
            result[1] = right;
            return result;
        }

        public int findIndex(int[] nums, int target, boolean left) {
            int lower = 0;
            int upper = nums.length - 1;
            while (lower <= upper) {
                int mid = lower + (upper - lower) / 2;
                if (nums[mid] == target) {
                    if (left) {
                        if (mid - 1 < 0 || nums[mid - 1] != target) {
                            return mid;
                        } else {
                            upper = upper - 1;
                        }
                    } else {
                        if (mid + 1 >= nums.length || nums[mid + 1] != target) {
                            return mid;
                        } else {
                            lower = mid + 1;
                        }
                    }


                } else if (nums[mid] > target) {
                    upper = mid - 1;
                } else {
                    lower = mid + 1;
                }
            }

            return -1;

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
