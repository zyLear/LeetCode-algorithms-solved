package com.zylear.problem.leetcode.editor.en;

//Given an absolute path for a file (Unix-style), simplify it. Or in other words
//, convert it to the canonical path. 
//
// In a UNIX-style file system, a period '.' refers to the current directory. Fu
//rthermore, a double period '..' moves the directory up a level. 
//
// Note that the returned canonical path must always begin with a slash '/', and
// there must be only a single slash '/' between two directory names. The last dir
//ectory name (if it exists) must not end with a trailing '/'. Also, the canonical
// path must be the shortest string representing the absolute path. 
//
// 
// Example 1: 
//
// 
//Input: path = "/home/"
//Output: "/home"
//Explanation: Note that there is no trailing slash after the last directory nam
//e.
// 
//
// Example 2: 
//
// 
//Input: path = "/../"
//Output: "/"
//Explanation: Going one level up from the root directory is a no-op, as the roo
//t level is the highest level you can go.
// 
//
// Example 3: 
//
// 
//Input: path = "/home//foo/"
//Output: "/home/foo"
//Explanation: In the canonical path, multiple consecutive slashes are replaced 
//by a single one.
// 
//
// Example 4: 
//
// 
//Input: path = "/a/./b/../../c/"
//Output: "/c"
// 
//
// 
// Constraints: 
//
// 
// 1 <= path.length <= 3000 
// path consists of English letters, digits, period '.', slash '/' or '_'. 
// path is a valid Unix path. 
// 
// Related Topics String Stack 
// 👍 985 👎 2002


import java.util.Stack;

public class P71SimplifyPath {
    public static void main(String[] args) {
        Solution solution = new P71SimplifyPath().new Solution();

        System.out.println(solution.simplifyPath("/home/"));
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String simplifyPath(String path) {
            Stack<String> stack = new Stack<>();

            String[] strings = path.split("/");

            for (String string : strings) {
                if ("..".equals(string)) {
                    if (!stack.isEmpty()) {
                        stack.pop();
                    }
                } else if (!".".equals(string) && !"".equals(string)) {
                    stack.push(string);
                }
            }
            return "/" + String.join("/", stack);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
