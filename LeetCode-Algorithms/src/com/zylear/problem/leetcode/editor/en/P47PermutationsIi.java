package com.zylear.problem.leetcode.editor.en;

//Given a collection of numbers, nums, that might contain duplicates, return all
// possible unique permutations in any order. 
//
// 
// Example 1: 
//
// 
//Input: nums = [1,1,2]
//Output:
//[[1,1,2],
// [1,2,1],
// [2,1,1]]
// 
//
// Example 2: 
//
// 
//Input: nums = [1,2,3]
//Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
// 
//
// 
// Constraints: 
//
// 
// 1 <= nums.length <= 8 
// -10 <= nums[i] <= 10 
// 
// Related Topics Backtracking 
// 👍 2598 👎 72


import java.util.*;

public class P47PermutationsIi {
    public static void main(String[] args) {
         Solution solution = new P47PermutationsIi().new Solution();
        int[] nums = new int[]{1, 1, 2};
        System.out.println(solution.permuteUnique(nums));
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        List<List<Integer>> result = new LinkedList<>();
        Stack<Integer> record = new Stack<>();
        boolean[] visited;

        public List<List<Integer>> permuteUnique(int[] nums) {
            visited = new boolean[nums.length];
            Arrays.sort(nums);
            backtrack(nums);
            return result;
        }

        private void backtrack(int[] nums) {
            if (record.size() >= nums.length) {
                result.add(new ArrayList<>(record));
                return;
            }

            for (int i = 0; i < nums.length; i++) {
                if (!visited[i]) {

                    //前一个相同的没有处理，跳过，因为是按顺序遍历的，
                    //所以处理相同后一个，前一个一定要处理过
                    //如果前一个重复元素没处理过，而先处理后面的元素，
                    //之后还是会处理到前面的元素，会产生重复
                    if (i > 0 && !visited[i - 1] && nums[i - 1] == nums[i]) {
                        continue;
                    }

                    record.push(nums[i]);
                    visited[i] = true;

                    backtrack(nums);
                    visited[i] = false;
                    record.pop();
                }
            }

        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}
