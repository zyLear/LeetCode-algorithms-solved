package com.zylear.problem.leetcode.editor.en;

//Given an array nums of distinct integers, return all the possible permutations
//. You can return the answer in any order. 
//
// 
// Example 1: 
// Input: nums = [1,2,3]
//Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
// Example 2: 
// Input: nums = [0,1]
//Output: [[0,1],[1,0]]
// Example 3: 
// Input: nums = [1]
//Output: [[1]]
// 
// 
// Constraints: 
//
// 
// 1 <= nums.length <= 6 
// -10 <= nums[i] <= 10 
// All the integers of nums are unique. 
// 
// Related Topics Backtracking 
// 👍 5061 👎 121


import java.util.*;

public class P46Permutations {
    public static void main(String[] args) {
        // Solution solution = new P46Permutations().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        List<List<Integer>> result = new LinkedList<>();
        Stack<Integer> record = new Stack<>();
        Set<Integer> set = new HashSet<>();
        public List<List<Integer>> permute(int[] nums) {
            for (int num : nums) {
                set.add(num);
            }
            backtrack(nums);

            return result;
        }

        private void backtrack(int[] nums) {
            if (set.isEmpty()) {
                result.add(new ArrayList<>(record));
                return;
            }
            List<Integer> temp = new ArrayList<>(set);
            for (Integer integer : temp) {
                record.push(integer);
                set.remove(integer);

                backtrack( nums);
                set.add(integer);
                record.pop();
            }

        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}
