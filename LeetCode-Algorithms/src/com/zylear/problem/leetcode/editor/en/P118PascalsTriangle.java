package com.zylear.problem.leetcode.editor.en;

//Given a non-negative integer numRows, generate the first numRows of Pascal's t
//riangle. 
//
// 
//In Pascal's triangle, each number is the sum of the two numbers directly above
// it. 
//
// Example: 
//
// 
//Input: 5
//Output:
//[
//     [1],
//    [1,1],
//   [1,2,1],
//  [1,3,3,1],
// [1,4,6,4,1]
//]
// 
// Related Topics Array 
// 👍 1963 👎 122


import java.util.ArrayList;
import java.util.List;

public class P118PascalsTriangle {
    public static void main(String[] args) {
        Solution solution = new P118PascalsTriangle().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> generate(int numRows) {

            List<List<Integer>> result = new ArrayList<>();

            int count = 0;
            while (count < numRows) {
                List<Integer> list = new ArrayList<>();

                if (count == 0) {
                    list.add(1);
                } else {
                    List<Integer> integers = result.get(count - 1);
                    list.add(1);
                    for (int i = 1; i < integers.size(); i++) {
                        list.add(integers.get(i - 1) + integers.get(i));
                    }
                    list.add(1);
                }
                result.add(list);
                count++;
            }
            return result;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}