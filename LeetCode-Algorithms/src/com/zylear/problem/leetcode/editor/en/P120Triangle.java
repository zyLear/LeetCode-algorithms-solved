package com.zylear.problem.leetcode.editor.en;

//Given a triangle array, return the minimum path sum from top to bottom. 
//
// For each step, you may move to an adjacent number of the row below. More 
//formally, if you are on index i on the current row, you may move to either index i 
//or index i + 1 on the next row. 
//
// 
// Example 1: 
//
// 
//Input: triangle = [[2],[3,4],[6,5,7],[4,1,8,3]]
//Output: 11
//Explanation: The triangle looks like:
//   2
//  3 4
// 6 5 7
//4 1 8 3
//The minimum path sum from top to bottom is 2 + 3 + 5 + 1 = 11 (underlined 
//above).
// 
//
// Example 2: 
//
// 
//Input: triangle = [[-10]]
//Output: -10
// 
//
// 
// Constraints: 
//
// 
// 1 <= triangle.length <= 200 
// triangle[0].length == 1 
// triangle[i].length == triangle[i - 1].length + 1 
// -10⁴ <= triangle[i][j] <= 10⁴ 
// 
//
// 
//Follow up: Could you do this using only 
//O(n) extra space, where 
//n is the total number of rows in the triangle?
//
// Related Topics Array Dynamic Programming 👍 8242 👎 486


import java.util.List;

public class P120Triangle {
    public static void main(String[] args) {
        Solution solution = new P120Triangle().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {


        public int minimumTotal(List<List<Integer>> triangle) {
            if (triangle == null || triangle.size() == 0) {
                return 0;
            }
            int width = triangle.get(triangle.size() - 1).size();
            int[] dp = new int[width];

            for (int i = triangle.size() - 1; i >= 0; i--) {
                List<Integer> integers = triangle.get(i);
                for (int j = 0; j < integers.size(); j++) {
                    int temp = integers.get(j);
                    if (i < triangle.size() - 1) {
                        dp[j] = temp + Math.min(dp[j], dp[j + 1]);
                    } else {
                        dp[j] = temp;
                    }
                }
            }
            return dp[0];
        }

        public int minimumTotal3(List<List<Integer>> triangle) {
            if (triangle == null || triangle.size() == 0) {
                return 0;
            }

            for (int i = triangle.size() - 2; i >= 0; i--) {
                List<Integer> integers = triangle.get(i);
                List<Integer> nextList = triangle.get(i + 1);
                for (int j = 0; j < integers.size(); j++) {
                    integers.set(j, integers.get(j) + Math.min(nextList.get(j), nextList.get(j + 1)));
                }
            }
            return triangle.get(0).get(0);
        }


        public int minimumTotal1(List<List<Integer>> triangle) {
            if (triangle == null || triangle.size() == 0) {
                return 0;
            }
            int high = triangle.size();
            int width = triangle.get(triangle.size() - 1).size();
            int[][] dp = new int[high][width];

            for (int i = triangle.size() - 1; i >= 0; i--) {
                List<Integer> integers = triangle.get(i);
                for (int j = 0; j < integers.size(); j++) {
                    dp[i][j] = integers.get(j);
                    if (i < triangle.size() - 1) {
                        dp[i][j] += Math.min(dp[i + 1][j], dp[i + 1][j + 1]);
                    }
                }
            }
            return dp[0][0];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}