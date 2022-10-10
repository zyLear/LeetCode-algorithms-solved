package com.zylear.problem.leetcode.editor.en;

//Given an array nums of n integers and an integer target, are there elements a,
// b, c, and d in nums such that a + b + c + d = target? Find all unique quadruple
//ts in the array which gives the sum of target. 
//
// Notice that the solution set must not contain duplicate quadruplets. 
//
// 
// Example 1: 
// Input: nums = [1,0,-1,0,-2,2], target = 0
//Output: [[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]
// Example 2: 
// Input: nums = [], target = 0
//Output: []
// 
// 
// Constraints: 
//
// 
// 0 <= nums.length <= 200 
// -109 <= nums[i] <= 109 
// -109 <= target <= 109 
// 
// Related Topics Array Hash Table Two Pointers 
// 👍 2776 👎 384


import java.util.*;

public class P18FourSum {
    public static void main(String[] args) {
        // Solution solution = new P18FourSum().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public List<List<Integer>> fourSum(int[] nums, int target) {
            //配合 twoSum双指针解法
            Arrays.sort(nums);
            kSum(nums, 0, 4, target);
            return result;
        }


        private void kSum(int[] nums, int left, int n, long target) {
            if (n == 2) {
                int right = nums.length - 1;
                while (left < right) {
                    if (nums[left] + nums[right] == target) {
                        ArrayList<Integer> integers = new ArrayList<>(record);
                        integers.add(nums[left]);
                        integers.add(nums[right]);
                        result.add(integers);
                        //同一组内 找到新的起点
                        int temp = nums[left];
                        do {
                            left++;
                        } while (left < right && nums[left] == temp);

                    } else if (nums[left] + nums[right] > target) {
                        right--;
                    } else {
                        left++;
                    }
                }

            } else if (n > 2) {
                for (int i = left; i < nums.length - 2; i++) {
                    if (i > left && nums[i] == nums[i - 1]) {
                        continue;
                    }
                    record.push(nums[i]);
                    kSum(nums, i + 1, n - 1, target - nums[i]);
                    record.pop();
                }
            }
        }


        private List<List<Integer>> result = new LinkedList<>();
        private Stack<Integer> record = new Stack<>();
        private Integer currentSum = 0;

        //回溯法  时间超时
        public List<List<Integer>> fourSum1(int[] nums, int target) {
            Arrays.sort(nums);
            backtracking(0, 0, nums, target);

            return result;
        }

        private void backtracking(int indexOfAttempts, int depth, int[] nums, int target) {

//            if (currentSum > target ) {
//                return;
//            }
            if (record.size() == 4) {
                if (target == currentSum) {
                    result.add(new ArrayList<>(record));
                }
                return;
            }

            for (int i = indexOfAttempts; i < nums.length; i++) {
                if (i > indexOfAttempts && nums[i] == nums[i - 1]) {
                    continue;
                }

                currentSum += nums[i];
                record.push(nums[i]);
                backtracking(i + 1, depth + 1, nums, target);

                currentSum -= nums[i];
                record.pop();
            }

        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}
