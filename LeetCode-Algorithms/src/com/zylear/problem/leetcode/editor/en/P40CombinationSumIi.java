package com.zylear.problem.leetcode.editor.en;

//Given a collection of candidate numbers (candidates) and a target number (targ
//et), find all unique combinations in candidates where the candidate numbers sum 
//to target. 
//
// Each number in candidates may only be used once in the combination. 
//
// Note: The solution set must not contain duplicate combinations. 
//
// 
// Example 1: 
//
// 
//Input: candidates = [10,1,2,7,6,1,5], target = 8
//Output: 
//[
//[1,1,6],
//[1,2,5],
//[1,7],
//[2,6]
//]
// 
//
// Example 2: 
//
// 
//Input: candidates = [2,5,2,1,2], target = 5
//Output: 
//[
//[1,2,2],
//[5]
//]
// 
//
// 
// Constraints: 
//
// 
// 1 <= candidates.length <= 100 
// 1 <= candidates[i] <= 50 
// 1 <= target <= 30 
// 
// Related Topics Array Backtracking 
// 👍 2323 👎 80


import java.util.*;

public class P40CombinationSumIi {
    public static void main(String[] args) {
        // Solution solution = new P40CombinationSumIi().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {


        List<List<Integer>> result = new LinkedList<>();
        Stack<Integer> record = new Stack<>();

        public List<List<Integer>> combinationSum2(int[] candidates, int target) {

            Arrays.sort(candidates);
            backtrack(0, 0, candidates, target);

            return result;
        }

        private void backtrack(int indexOfAttempts, int sum, int[] candidates, int target) {
            if (sum > target) {
                return;
            }
            if (sum == target) {
                List<Integer> list = new ArrayList<>(record);
                result.add(list);
                return;
            }

            for (int i = indexOfAttempts; i < candidates.length; i++) {
                //同一个元素不重复使用，防止出现重复的结果，因为如果元素重复的话，
                //i 和 i+1回溯得到的结果的是一样的，主要是去重
                //对于本次（不能跨次） 尝试集处理来说  只要后面有一个跟前一个重复的  就跳过
                if (i > indexOfAttempts && candidates[i] == candidates[i - 1]) {
                    continue;
                }
                record.push(candidates[i]);
                backtrack(i + 1, sum + candidates[i], candidates, target);
                record.pop();
            }

        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}
