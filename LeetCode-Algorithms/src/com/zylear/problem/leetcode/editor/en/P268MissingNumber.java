package com.zylear.problem.leetcode.editor.en;

//Given an array nums containing n distinct numbers in the range [0, n], return 
//the only number in the range that is missing from the array. 
//
// Follow up: Could you implement a solution using only O(1) extra space complex
//ity and O(n) runtime complexity? 
//
// 
// Example 1: 
//
// 
//Input: nums = [3,0,1]
//Output: 2
//Explanation: n = 3 since there are 3 numbers, so all numbers are in the range 
//[0,3]. 2 is the missing number in the range since it does not appear in nums.
// 
//
// Example 2: 
//
// 
//Input: nums = [0,1]
//Output: 2
//Explanation: n = 2 since there are 2 numbers, so all numbers are in the range 
//[0,2]. 2 is the missing number in the range since it does not appear in nums.
// 
//
// Example 3: 
//
// 
//Input: nums = [9,6,4,2,3,5,7,0,1]
//Output: 8
//Explanation: n = 9 since there are 9 numbers, so all numbers are in the range 
//[0,9]. 8 is the missing number in the range since it does not appear in nums.
// 
//
// Example 4: 
//
// 
//Input: nums = [0]
//Output: 1
//Explanation: n = 1 since there is 1 number, so all numbers are in the range [0
//,1]. 1 is the missing number in the range since it does not appear in nums.
// 
//
// 
// Constraints: 
//
// 
// n == nums.length 
// 1 <= n <= 104 
// 0 <= nums[i] <= n 
// All the numbers of nums are unique. 
// 
// Related Topics Array Math Bit Manipulation 
// 👍 2294 👎 2380


public class P268MissingNumber {
    public static void main(String[] args) {
        // Solution solution = new P268MissingNumber().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public int missingNumber1(int[] nums) {

            int count = 0;
            for (int i = 0; i <= nums.length; i++) {
                count += i;
            }
            for (int num : nums) {
                count -= num;
            }

            return count;
        }

        public int missingNumber(int[] nums) {

            int count = (nums.length * (nums.length + 1)) / 2;

            for (int num : nums) {
                count -= num;
            }

            return count;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
