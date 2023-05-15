package com.zylear.problem.leetcode.editor.en;

//The gray code is a binary numeral system where two successive values differ in
// only one bit. 
//
// Given a non-negative integer n representing the total number of bits in the c
//ode, print the sequence of gray code. A gray code sequence must begin with 0. 
//
// Example 1: 
//
// 
//Input: 2
//Output: [0,1,3,2]
//Explanation:
//00 - 0
//01 - 1
//11 - 3
//10 - 2
//
//For a given n, a gray code sequence may not be uniquely defined.
//For example, [0,2,3,1] is also a valid gray code sequence.
//
//00 - 0
//10 - 2
//11 - 3
//01 - 1
// 
//
// Example 2: 
//
// 
//Input: 0
//Output: [0]
//Explanation: We define the gray code sequence to begin with 0.
//             A gray code sequence of n has size = 2n, which for n = 0 the size
// is 20 = 1.
//             Therefore, for n = 0 the gray code sequence is [0].
// 
// Related Topics Backtracking 
// 👍 734 👎 1677


import com.sun.org.apache.xml.internal.utils.res.XResources_sv;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class P89GrayCode {
    public static void main(String[] args) {
        Solution solution = new P89GrayCode().new Solution();
        System.out.println(solution.grayCode(2));
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        List<Integer> result = new LinkedList<>();
        int record = 0;

        public List<Integer> grayCode(int n) {

            List<Integer> result = new ArrayList<>();
            // n = 0 的 grayCode
            result.add(0);

            for (int i = 0; i < n; i++) {
                //最前面的位置
                int first = 1 << i;
                int size = result.size();
                for (int j = size - 1; j >= 0; j--) {
                    result.add(result.get(j) | first);
                }
            }
            return result;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}
