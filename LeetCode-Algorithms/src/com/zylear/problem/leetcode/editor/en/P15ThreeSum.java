package com.zylear.problem.leetcode.editor.en;

//Given an array nums of n integers, are there elements a, b, c in nums such tha
//t a + b + c = 0? Find all unique triplets in the array which gives the sum of ze
//ro. 
//
// Notice that the solution set must not contain duplicate triplets. 
//
// 
// Example 1: 
// Input: nums = [-1,0,1,2,-1,-4]
//Output: [[-1,-1,2],[-1,0,1]]
// Example 2: 
// Input: nums = []
//Output: []
// Example 3: 
// Input: nums = [0]
//Output: []
// 
// 
// Constraints: 
//
// 
// 0 <= nums.length <= 3000 
// -105 <= nums[i] <= 105 
// 
// Related Topics Array Two Pointers 
// 👍 8830 👎 942


import java.util.*;

public class P15ThreeSum {
    public static void main(String[] args) {
        Solution solution = new P15ThreeSum().new Solution();
        int[] nums = new int[]{-4, -1, -1, 0, 1, 2};
        solution.threeSum(nums);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {


        private List<List<Integer>> result = new LinkedList<>();
        private Stack<Integer> record = new Stack<>();


        public List<List<Integer>> threeSum(int[] nums) {
            //时间复杂度  O(n^(k-1))  比暴力搜索/回溯 少一次放  O(n^(k))
            Arrays.sort(nums);
            kSum(nums, 0, nums.length - 1, 3, 0);

            return result;
        }

        private void kSum(int[] nums, int lower, int upper, int n, int target) {
            if (n == 2) {

                while (lower < upper) {
                    if (nums[lower] + nums[upper] == target) {
                        ArrayList<Integer> integers = new ArrayList<>(record);
                        integers.add(nums[lower]);
                        integers.add(nums[upper]);
                        result.add(integers);
                        //同一组内 找到新的起点
                        int temp = nums[lower];
                        do {
                            lower++;
                        } while (lower < upper && nums[lower] == temp);

                    } else if (nums[lower] + nums[upper] > target) {
                        upper--;
                    } else {
                        lower++;
                    }
                }

            } else if (n > 2) {
                for (int i = lower; i < upper - 1; i++) {
                    if (i > lower && nums[i] == nums[i - 1]) {
                        continue;
                    }
                    record.push(nums[i]);
                    kSum(nums, i + 1, upper, n - 1, target - nums[i]);
                    record.pop();
                }
            }
        }


        public List<List<Integer>> threeSum1(int[] nums) {
            //brute force first
            //time limit exceeded
            List<List<Integer>> result = new LinkedList<>();

            Arrays.sort(nums);
            Set<String> set = new HashSet<>();
            for (int i = 0; i < nums.length; i++) {
                for (int j = i + 1; j < nums.length; j++) {
                    for (int k = j + 1; k < nums.length; k++) {
                        if (nums[i] + nums[j] + nums[k] == 0) {
                            List<Integer> integers = Arrays.asList(nums[i], nums[j], nums[k]);
                            StringBuilder stringBuilder = new StringBuilder();
                            for (Integer integer : integers) {
                                stringBuilder.append(integer);
                            }
                            if (!set.contains(stringBuilder.toString())) {
                                result.add(integers);
                                set.add(stringBuilder.toString());
                            }
                        }
                    }
                }
            }
            return result;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)


}