package com.zylear.problem.leetcode.editor.en;

//Given an integer array nums where every element appears three times except 
//for one, which appears exactly once. Find the single element and return it. 
//
// You must implement a solution with a linear runtime complexity and use only 
//constant extra space. 
//
// 
// Example 1: 
// Input: nums = [2,2,3,2]
//Output: 3
// 
// Example 2: 
// Input: nums = [0,1,0,1,0,1,99]
//Output: 99
// 
// 
// Constraints: 
//
// 
// 1 <= nums.length <= 3 * 10⁴ 
// -2³¹ <= nums[i] <= 2³¹ - 1 
// Each element in nums appears exactly three times except for one element 
//which appears once. 
// 
//
// Related Topics Array Bit Manipulation 👍 5672 👎 549


import java.util.HashMap;
import java.util.Map;

public class P137SingleNumberIi {
    public static void main(String[] args) {
        Solution solution = new P137SingleNumberIi().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int singleNumber(int[] nums) {
            Map<Integer, Integer> map = new HashMap<>();
            for (int n : nums) {
                if (map.containsKey(n)) {
                    map.put(n, map.get(n) + 1);
                } else {
                    map.put(n, 1);
                }
            }
            for (int key : map.keySet()) {
                if (map.get(key) == 1) return key;
            }
            return 0;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}