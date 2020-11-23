package com.zylear.problem.leetcode.editor.en;

//Given a non-empty array of integers nums, every element appears twice except f
//or one. Find that single one. 
//
// Follow up: Could you implement a solution with a linear runtime complexity an
//d without using extra memory? 
//
// 
// Example 1: 
// Input: nums = [2,2,1]
//Output: 1
// Example 2: 
// Input: nums = [4,1,2,1,2]
//Output: 4
// Example 3: 
// Input: nums = [1]
//Output: 1
// 
// 
// Constraints: 
//
// 
// 1 <= nums.length <= 3 * 104 
// -3 * 104 <= nums[i] <= 3 * 104 
// Each element in the array appears twice except for one element which appears 
//only once. 
// 
// Related Topics Hash Table Bit Manipulation 
// 👍 5261 👎 180


import java.util.HashSet;
import java.util.Set;

public class SingleNumber136 {
    public static void main(String[] args) {
        Solution solution = new SingleNumber136().new Solution();
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int singleNumber(int[] nums) {
            Set<Integer> set = new HashSet<>(nums.length);
            for (int num : nums) {
                if (!set.contains(num)) {
                    set.add(num);
                }else {
                    set.remove(num);
                }
            }

            return set.iterator().next();

        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    
}