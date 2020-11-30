package com.zylear.problem.leetcode.editor.en;

//Given an array of integers and an integer k, find out whether there are two di
//stinct indices i and j in the array such that nums[i] = nums[j] and the absolute
// difference between i and j is at most k. 
//
// 
// Example 1: 
//
// 
//Input: nums = [1,2,3,1], k = 3
//Output: true
// 
//
// 
// Example 2: 
//
// 
//Input: nums = [1,0,1,1], k = 1
//Output: true
// 
//
// 
// Example 3: 
//
// 
//Input: nums = [1,2,3,1,2,3], k = 2
//Output: false
// 
// 
// 
// 
// Related Topics Array Hash Table 
// 👍 1088 👎 1217


import java.util.HashMap;
import java.util.Map;

public class P219ContainsDuplicateIi {
    public static void main(String[] args) {
        Solution solution = new P219ContainsDuplicateIi().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean containsNearbyDuplicate(int[] nums, int k) {
            Map<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < nums.length; i++) {
                Integer integer = map.get(nums[i]);
                if (integer == null) {
                    map.put(nums[i], i);
                } else {
                    if (i - integer <= k) {
                        return true;
                    } else {
                        map.put(nums[i], i);
                    }
                }
            }
            return false;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}