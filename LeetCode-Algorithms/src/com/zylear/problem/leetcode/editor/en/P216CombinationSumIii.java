package com.zylear.problem.leetcode.editor.en;

//Find all valid combinations of k numbers that sum up to n such that the follow
//ing conditions are true: 
//
// 
// Only numbers 1 through 9 are used. 
// Each number is used at most once. 
// 
//
// Return a list of all possible valid combinations. The list must not contain t
//he same combination twice, and the combinations may be returned in any order. 
//
// 
// Example 1: 
//
// 
//Input: k = 3, n = 7
//Output: [[1,2,4]]
//Explanation:
//1 + 2 + 4 = 7
//There are no other valid combinations. 
//
// Example 2: 
//
// 
//Input: k = 3, n = 9
//Output: [[1,2,6],[1,3,5],[2,3,4]]
//Explanation:
//1 + 2 + 6 = 9
//1 + 3 + 5 = 9
//2 + 3 + 4 = 9
//There are no other valid combinations.
// 
//
// Example 3: 
//
// 
//Input: k = 4, n = 1
//Output: []
//Explanation: There are no valid combinations. [1,2,1] is not valid because 1 i
//s used twice.
// 
//
// Example 4: 
//
// 
//Input: k = 3, n = 2
//Output: []
//Explanation: There are no valid combinations.
// 
//
// Example 5: 
//
// 
//Input: k = 9, n = 45
//Output: [[1,2,3,4,5,6,7,8,9]]
//Explanation:
//1 + 2 + 3 + 4 + 5 + 6 + 7 + 8 + 9 = 45
//​​​​​​​There are no other valid combinations.
// 
//
// 
// Constraints: 
//
// 
// 2 <= k <= 9 
// 1 <= n <= 60 
// 
// Related Topics Array Backtracking 
// 👍 1574 👎 61


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class P216CombinationSumIii {
    public static void main(String[] args) {
        // Solution solution = new P216CombinationSumIii().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        List<List<Integer>> result = new LinkedList<>();
        Stack<Integer> record = new Stack<>();

        public List<List<Integer>> combinationSum3(int k, int n) {

            backtracking(1, 0, k, n);
            return result;
        }

        private void backtracking(int indexOfAttempts, int sum, int k, int n) {

            if (record.size() == k) {
                if (sum == n) {
                    result.add(new ArrayList<>(record));
                    return;
                }else {
                    return;
                }
            }else {
                if (sum >= n) {
                    return;
                }
            }

            for (int i = indexOfAttempts; i <= 9; i++) {
                record.push(i);
                backtracking(i + 1, sum + i, k, n);
                record.pop();
            }

        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}
