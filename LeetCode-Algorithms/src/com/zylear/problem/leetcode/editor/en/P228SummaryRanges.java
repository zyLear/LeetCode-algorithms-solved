package com.zylear.problem.leetcode.editor.en;

//You are given a sorted unique integer array nums.
//
// Return the smallest sorted list of ranges that cover all the numbers in the a
//rray exactly. That is, each element of nums is covered by exactly one of the ran
//ges, and there is no integer x such that x is in one of the ranges but not in nu
//ms.
//
// Each range [a,b] in the list should be output as: 
//
// 
// "a->b" if a != b 
// "a" if a == b 
// 
//
// 
// Example 1: 
//
// 
//Input: nums = [0,1,2,4,5,7]
//Output: ["0->2","4->5","7"]
//Explanation: The ranges are:
//[0,2] --> "0->2"
//[4,5] --> "4->5"
//[7,7] --> "7"
// 
//
// Example 2: 
//
// 
//Input: nums = [0,2,3,4,6,8,9]
//Output: ["0","2->4","6","8->9"]
//Explanation: The ranges are:
//[0,0] --> "0"
//[2,4] --> "2->4"
//[6,6] --> "6"
//[8,9] --> "8->9"
// 
//
// Example 3: 
//
// 
//Input: nums = []
//Output: []
// 
//
// Example 4: 
//
// 
//Input: nums = [-1]
//Output: ["-1"]
// 
//
// Example 5: 
//
// 
//Input: nums = [0]
//Output: ["0"]
// 
//
// 
// Constraints: 
//
// 
// 0 <= nums.length <= 20 
// -231 <= nums[i] <= 231 - 1 
// All the values of nums are unique. 
// nums is sorted in ascending order. 
// 
// Related Topics Array 
// 👍 848 👎 629


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class P228SummaryRanges {
    public static void main(String[] args) {
        // Solution solution = new P228SummaryRanges().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<String> summaryRanges(int[] nums) {
            if (nums == null || nums.length == 0) {
                return Collections.emptyList();
            }

            List<String> result = new ArrayList<>();
//            StringBuilder current = new StringBuilder(nums[0]).append("->");
            int start = nums[0];
            int end = nums[0];
            for (int i = 1; i < nums.length; i++) {
                if (nums[i] - end != 1) {
                    buildNode(result, start, end);
                    start = nums[i];
                    end = nums[i];
                } else {
                    end = nums[i];
                }
            }
            buildNode(result, start, end);

            return result;
        }

        private void buildNode(List<String> result, int start, int end) {
            if (start == end) {
                result.add(String.valueOf(start));
            } else {
                result.add(start + "->" + end);
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
