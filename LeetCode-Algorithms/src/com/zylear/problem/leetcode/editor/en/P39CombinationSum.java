package com.zylear.problem.leetcode.editor.en;

//Given an array of distinct integers candidates and a target integer target, re
//turn a list of all unique combinations of candidates where the chosen numbers su
//m to target. You may return the combinations in any order. 
//
// The same number may be chosen from candidates an unlimited number of times. T
//wo combinations are unique if the frequency of at least one of the chosen number
//s is different. 
//
// It is guaranteed that the number of unique combinations that sum up to target
// is less than 150 combinations for the given input. 
//
// 
// Example 1: 
//
// 
//Input: candidates = [2,3,6,7], target = 7
//Output: [[2,2,3],[7]]
//Explanation:
//2 and 3 are candidates, and 2 + 2 + 3 = 7. Note that 2 can be used multiple ti
//mes.
//7 is a candidate, and 7 = 7.
//These are the only two combinations.
// 
//
// Example 2: 
//
// 
//Input: candidates = [2,3,5], target = 8
//Output: [[2,2,2,2],[2,3,3],[3,5]]
// 
//
// Example 3: 
//
// 
//Input: candidates = [2], target = 1
//Output: []
// 
//
// Example 4: 
//
// 
//Input: candidates = [1], target = 1
//Output: [[1]]
// 
//
// Example 5: 
//
// 
//Input: candidates = [1], target = 2
//Output: [[1,1]]
// 
//
// 
// Constraints: 
//
// 
// 1 <= candidates.length <= 30 
// 1 <= candidates[i] <= 200 
// All elements of candidates are distinct. 
// 1 <= target <= 500 
// 
// Related Topics Array Backtracking 
// 👍 5088 👎 141


import java.util.*;

public class P39CombinationSum {
    public static void main(String[] args) {
        // Solution solution = new P39CombinationSum().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        List<List<Integer>> result = new LinkedList<>();
        Stack<Integer> record = new Stack<>();

        public List<List<Integer>> combinationSum(int[] candidates, int target) {

            Arrays.sort(candidates);
            backtrack(0, 0, candidates, target);

            return result;
        }

        private void backtrack(int indexOfAttempts, int sum, int[] candidates, int target) {
            if (sum > target) {
                return;
            }
            for (int i = indexOfAttempts; i < candidates.length; i++) {
                if (sum + candidates[i] == target) {
                    List<Integer> list = new ArrayList<>(record);
                    list.add(candidates[i]);
                    result.add(list);
                }else if(sum + candidates[i] < target){
                    record.push(candidates[i]);
                    backtrack(i, sum + candidates[i], candidates, target);
                    record.pop();
                }
            }

        }


    }
    //leetcode submit region end(Prohibit modification and deletion)

}
