package com.zylear.problem.leetcode.editor.en;

//You are a product manager and currently leading a team to develop a new produc
//t. Unfortunately, the latest version of your product fails the quality check. Si
//nce each version is developed based on the previous version, all the versions af
//ter a bad version are also bad. 
//
// Suppose you have n versions [1, 2, ..., n] and you want to find out the first
// bad one, which causes all the following ones to be bad. 
//
// You are given an API bool isBadVersion(version) which returns whether version
// is bad. Implement a function to find the first bad version. You should minimize
// the number of calls to the API. 
//
// 
// Example 1: 
//
// 
//Input: n = 5, bad = 4
//Output: 4
//Explanation:
//call isBadVersion(3) -> false
//call isBadVersion(5) -> true
//call isBadVersion(4) -> true
//Then 4 is the first bad version.
// 
//
// Example 2: 
//
// 
//Input: n = 1, bad = 1
//Output: 1
// 
//
// 
// Constraints: 
//
// 
// 1 <= bad <= n <= 231 - 1 
// 
// Related Topics Binary Search 
// 👍 1785 👎 753


import com.zylear.problem.leetcode.editor.en.base.VersionControl;

public class P278FirstBadVersion {
    public static void main(String[] args) {
        Solution solution = new P278FirstBadVersion().new Solution();
    }

//leetcode submit region begin(Prohibit modification and deletion)
/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

    public class Solution extends VersionControl {
        public int firstBadVersion(int n) {
            int lower = 1;
            int upper = n;

            while (lower <= upper) {
                int mid = lower + ((upper - lower) / 2);

                if (isBadVersion(mid)) {

                    if (!isBadVersion(mid - 1)) {
                        return mid;
                    } else {
                        upper = mid - 1;
                    }
                } else {
                    lower = mid + 1;
                }
            }
            return lower;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}