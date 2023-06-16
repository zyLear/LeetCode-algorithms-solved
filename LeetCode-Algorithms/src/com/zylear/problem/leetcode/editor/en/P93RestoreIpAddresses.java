package com.zylear.problem.leetcode.editor.en;

//A valid IP address consists of exactly four integers separated by single dots.
// Each integer is between 0 and 255 (inclusive) and cannot have leading zeros. 
//
// 
// For example, "0.1.2.201" and "192.168.1.1" are valid IP addresses, but "0.011
//.255.245", "192.168.1.312" and "192.168@1.1" are invalid IP addresses. 
// 
//
// Given a string s containing only digits, return all possible valid IP 
//addresses that can be formed by inserting dots into s. You are not allowed to reorder 
//or remove any digits in s. You may return the valid IP addresses in any order. 
//
// 
// Example 1: 
//
// 
//Input: s = "25525511135"
//Output: ["255.255.11.135","255.255.111.35"]
// 
//
// Example 2: 
//
// 
//Input: s = "0000"
//Output: ["0.0.0.0"]
// 
//
// Example 3: 
//
// 
//Input: s = "101023"
//Output: ["1.0.10.23","1.0.102.3","10.1.0.23","10.10.2.3","101.0.2.3"]
// 
//
// 
// Constraints: 
//
// 
// 1 <= s.length <= 20 
// s consists of digits only. 
// 
//
// Related Topics String Backtracking 👍 4739 👎 749


import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class P93RestoreIpAddresses {
    public static void main(String[] args) {
        Solution solution = new P93RestoreIpAddresses().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        private Stack<String> record = new Stack<>();
        private List<String> result = new LinkedList<>();

        public List<String> restoreIpAddresses(String s) {

            backtrack(s);

            return result;
        }

        private void backtrack(String s) {

            if (record.size() == 3) {
                if ("".equals(s) || s.length() > 3) {
                    return;
                }
                int number = Integer.parseInt(s);
                if ("0".equals(s)
                        || (!s.startsWith("0") && 1 <= number && number <= 255)) {
                    record.push(s);
                    result.add(String.join(".", record));
                    record.pop();
                }
                return;
            }

            for (int i = 0; (i < s.length() && i < 3); i++) {
                String string = s.substring(0, i + 1);
                int number = Integer.parseInt(string);
                if ("0".equals(string)
                        || (!string.startsWith("0") && 1 <= number && number <= 255)) {
                    record.push(string);
                    backtrack(s.substring(i + 1));
                    record.pop();
                }
            }

        }


    }
//leetcode submit region end(Prohibit modification and deletion)


}