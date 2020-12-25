package com.zylear.problem.leetcode.editor.en;

//Given an integer array nums, return all possible subsets (the power set). 
//
// The solution set must not contain duplicate subsets. 
//
// 
// Example 1: 
//
// 
//Input: nums = [1,2,3]
//Output: [[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
// 
//
// Example 2: 
//
// 
//Input: nums = [0]
//Output: [[],[0]]
// 
//
// 
// Constraints: 
//
// 
// 1 <= nums.length <= 10 
// -10 <= nums[i] <= 10 
// 
// Related Topics Array Backtracking Bit Manipulation 
// 👍 4913 👎 103


import java.util.*;

public class P78Subsets {
    public static void main(String[] args) {
        // Solution solution = new P78Subsets().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> subsets(int[] nums) {
            List<List<Integer>> result = new LinkedList<>();
            int n = 0;
            result.add(Collections.emptyList());

            while (n < nums.length) {
                List<List<Integer>> temp = new LinkedList<>();
                for (List<Integer> integers : result) {
                    List<Integer> list = new ArrayList<>(integers);
                    list.add(nums[n]);
                    temp.add(list);
                }
                result.addAll(temp);
                n++;
            }

            return result;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
