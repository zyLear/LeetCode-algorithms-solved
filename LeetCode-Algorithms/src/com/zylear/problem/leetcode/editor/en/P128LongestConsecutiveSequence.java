package com.zylear.problem.leetcode.editor.en;

//Given an unsorted array of integers nums, return the length of the longest con
//secutive elements sequence. 
//
// You must write an algorithm that runs in O(n) time. 
//
// 
// Example 1: 
//
// 
//Input: nums = [100,4,200,1,3,2]
//Output: 4
//Explanation: The longest consecutive elements sequence is [1, 2, 3, 4]. Theref
//ore its length is 4.
// 
//
// Example 2: 
//
// 
//Input: nums = [0,3,7,2,5,8,4,6,0,1]
//Output: 9
// 
//
// 
// Constraints: 
//
// 
// 0 <= nums.length <= 105 
// -109 <= nums[i] <= 109 
// 
// Related Topics Array Union Find 
// 👍 5261 👎 259


import java.util.HashSet;
import java.util.Set;

public class P128LongestConsecutiveSequence {
    public static void main(String[] args) {
        Solution solution = new P128LongestConsecutiveSequence().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int longestConsecutive(int[] nums) {
            //暴力解法  遍历数组，然后一次在数组里面找array[i]+1 =1 +1 +1  O(n^3)
            //排序法  O(nlogn)
            //HashSet

            Set<Integer> set = new HashSet<>();
            for (int num : nums) {
                set.add(num);
            }


            int max = 0;

            for (int num : nums) {
                //说明一定会被递增处理，只处理递增的，减少时间复杂度
                if (set.contains(num - 1)) {
                    continue;
                }
                int count = 1;
                int currentNumber = num;
                while (set.contains(++currentNumber)) {
                    count++;
                }

                max = Math.max(max, count);

            }

            return max;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)


}