package com.zylear.problem.leetcode.editor.en;

//Given an array nums of n integers where n > 1, return an array output such tha
//t output[i] is equal to the product of all the elements of nums except nums[i]. 
//
//
// Example: 
//
// 
//Input:  [1,2,3,4]
//Output: [24,12,8,6]
// 
//
// Constraint: It's guaranteed that the product of the elements of any prefix or
// suffix of the array (including the whole array) fits in a 32 bit integer. 
//
// Note: Please solve it without division and in O(n). 
//
// Follow up: 
//Could you solve it with constant space complexity? (The output array does not 
//count as extra space for the purpose of space complexity analysis.) 
// Related Topics Array 
// 👍 6094 👎 485


public class P238ProductOfArrayExceptSelf {
    public static void main(String[] args) {
        Solution solution = new P238ProductOfArrayExceptSelf().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] productExceptSelf(int[] nums) {
            int[] result = new int[nums.length];
            //存储之前计算的乘积

//            result[0] = 1;
//            result[nums.length - 1] = 1;

            //当前遍历点之前的乘积和
            int temp = 1;
            for (int i = 0; i < nums.length; i++) {
                result[i] = temp;
                temp = temp * nums[i];
            }

            temp = 1;
            for (int i = nums.length - 1; i >= 0; i--) {
                result[i] = result[i] * temp;
                temp = temp * nums[i];
            }


            return result;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}