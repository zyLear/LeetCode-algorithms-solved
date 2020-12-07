package com.zylear.problem.leetcode.editor.en;

//Given a list of non-negative integers nums, arrange them such that they form t
//he largest number. 
//
// Note: The result may be very large, so you need to return a string instead of
// an integer. 
//
// 
// Example 1: 
//
// 
//Input: nums = [10,2]
//Output: "210"
// 
//
// Example 2: 
//
// 
//Input: nums = [3,30,34,5,9]
//Output: "9534330"
// 
//
// Example 3: 
//
// 
//Input: nums = [1]
//Output: "1"
// 
//
// Example 4: 
//
// 
//Input: nums = [10]
//Output: "10"
// 
//
// 
// Constraints: 
//
// 
// 1 <= nums.length <= 100 
// 0 <= nums[i] <= 109 
// 
// Related Topics Sort 
// 👍 2611 👎 281


import java.util.Arrays;
import java.util.Comparator;
import java.util.StringJoiner;

public class P179LargestNumber {
    public static void main(String[] args) {
        Solution solution = new P179LargestNumber().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String largestNumber(int[] nums) {


            String[] strings = new String[nums.length];


            for (int i = 0; i < nums.length; i++) {
                strings[i] = String.valueOf(nums[i]);
            }

            Arrays.sort(strings, (o1, o2) -> {
                String one = o1 + o2;
                String two = o2 + o1;
                return -one.compareTo(two);
            });

            if (strings[0].equals("0")) {
                return "0";
            }

            StringBuilder stringBuilder = new StringBuilder();
            for (String numAsStr : strings) {
                stringBuilder.append(numAsStr);
            }
            return stringBuilder.toString();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}