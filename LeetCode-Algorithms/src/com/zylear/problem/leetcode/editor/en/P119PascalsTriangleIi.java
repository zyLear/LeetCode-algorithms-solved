package com.zylear.problem.leetcode.editor.en;

//Given an integer rowIndex, return the rowIndexth row of the Pascal's triangle.
// 
//
// Notice that the row index starts from 0. 
//
// 
//In Pascal's triangle, each number is the sum of the two numbers directly above
// it. 
//
// Follow up: 
//
// Could you optimize your algorithm to use only O(k) extra space? 
//
// 
// Example 1: 
// Input: rowIndex = 3
//Output: [1,3,3,1]
// Example 2: 
// Input: rowIndex = 0
//Output: [1]
// Example 3: 
// Input: rowIndex = 1
//Output: [1,1]
// 
// 
// Constraints: 
//
// 
// 0 <= rowIndex <= 40 
// 
// Related Topics Array 
// 👍 1141 👎 212


import java.util.ArrayList;
import java.util.List;

public class P119PascalsTriangleIi {
    public static void main(String[] args) {
        Solution solution = new P119PascalsTriangleIi().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<Integer> getRow(int rowIndex) {
            List<List<Integer>> result = new ArrayList<>();

            int count = 0;

            while (count < rowIndex + 1) {
                List<Integer> list = new ArrayList<>();
                list.add(1);
                if (count != 0) {
                    List<Integer> integers = result.get(count - 1);
                    for (int i = 1; i < integers.size(); i++) {
                        list.add(integers.get(i - 1) + integers.get(i));
                    }
                    list.add(1);
                }
                if (count == rowIndex) {
                    return list;
                }
                result.add(list);

                count++;
            }
            return result.get(rowIndex);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}