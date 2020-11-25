package com.zylear.problem.leetcode.editor.en;

//Given an array of integers, find if the array contains any duplicates. 
//
// Your function should return true if any value appears at least twice in the a
//rray, and it should return false if every element is distinct. 
//
// Example 1: 
//
// 
//Input: [1,2,3,1]
//Output: true 
//
// Example 2: 
//
// 
//Input: [1,2,3,4]
//Output: false 
//
// Example 3: 
//
// 
//Input: [1,1,1,3,3,4,3,2,4,2]
//Output: true 
// Related Topics Array Hash Table 
// 👍 1225 👎 796


import java.util.HashSet;
import java.util.Set;

public class P217ContainsDuplicate {
    public static void main(String[] args) {
        Solution solution = new P217ContainsDuplicate().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean containsDuplicate(int[] nums) {
            Set<Integer> set = new HashSet<>();
            for (int num : nums) {
                if (!set.contains(num)) {
                    set.add(num);
                } else {
                    return true;
                }
            }
            return false;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}

