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
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {


        public List<List<Integer>> threeSum(int[] nums) {


            return null;
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