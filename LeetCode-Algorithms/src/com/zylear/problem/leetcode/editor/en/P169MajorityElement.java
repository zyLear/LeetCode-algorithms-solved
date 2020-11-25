package com.zylear.problem.leetcode.editor.en;

//Given an array of size n, find the majority element. The majority element is t
//he element that appears more than ⌊ n/2 ⌋ times. 
//
// You may assume that the array is non-empty and the majority element always ex
//ist in the array. 
//
// Example 1: 
//
// 
//Input: [3,2,3]
//Output: 3 
//
// Example 2: 
//
// 
//Input: [2,2,1,1,1,2,2]
//Output: 2
// 
// Related Topics Array Divide and Conquer Bit Manipulation 
// 👍 4023 👎 236


import java.util.HashMap;
import java.util.Map;

public class P169MajorityElement{
    public static void main(String[] args) {
        Solution solution = new P169MajorityElement().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int majorityElement(int[] nums) {
            Map<Integer, Integer> map = new HashMap<>();
            double majority = nums.length / 2.0;
            for (int i = 0; i < nums.length; i++) {
                Integer count = map.get(nums[i]);
                if (count == null) {
                    count = 1;
                }else {
                    count = count + 1;
                }

                if (count >= majority) {
                    return nums[i];
                }else {
                    map.put(nums[i], count);
                }
            }
            return 0;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)


    //分治可以学一学  先用map解决

}

