package com.zylear.problem.leetcode.editor.en;

//Given a collection of integers that might contain duplicates, nums, return all
// possible subsets (the power set). 
//
// Note: The solution set must not contain duplicate subsets. 
//
// Example: 
//
// 
//Input: [1,2,2]
//Output:
//[
//  [2],
//  [1],
//  [1,2,2],
//  [2,2],
//  [1,2],
//  []
//]
// 
// Related Topics Array Backtracking 
// 👍 2109 👎 92


import java.util.*;
import java.util.concurrent.locks.ReentrantLock;
import java.util.stream.Collectors;

public class P90SubsetsIi {
    public static void main(String[] args) {
        // Solution solution = new P90SubsetsIi().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        Stack<Integer> record = new Stack<>();
        List<List<Integer>> result = new LinkedList<>();

        public List<List<Integer>> subsetsWithDup(int[] nums) {
            Arrays.sort(nums);
            backtrack(0, nums);

            return result;
        }

        private void backtrack(int indexOfAttempts, int[] nums) {

            ArrayList<Integer> integers = new ArrayList<>(record);
            result.add(integers);

            for (int i = indexOfAttempts; i < nums.length; i++) {

                if (i > indexOfAttempts && nums[i] == nums[i - 1]) {
                    continue;
                }

                int num = nums[i];

                record.push(num);
                backtrack(i + 1, nums);
                record.pop();
            }
        }


    }
    //leetcode submit region end(Prohibit modification and deletion)

}
