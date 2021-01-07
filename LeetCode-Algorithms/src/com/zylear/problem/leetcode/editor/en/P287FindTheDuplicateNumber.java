package com.zylear.problem.leetcode.editor.en;

//Given an array of integers nums containing n + 1 integers where each integer i
//s in the range [1, n] inclusive. 
//
// There is only one repeated number in nums, return this repeated number. 
//
// 
// Example 1: 
// Input: nums = [1,3,4,2,2]
//Output: 2
// Example 2: 
// Input: nums = [3,1,3,4,2]
//Output: 3
// Example 3: 
// Input: nums = [1,1]
//Output: 1
// Example 4: 
// Input: nums = [1,1,2]
//Output: 1
// 
// 
// Constraints: 
//
// 
// 2 <= n <= 3 * 104 
// nums.length == n + 1 
// 1 <= nums[i] <= n 
// All the integers in nums appear only once except for precisely one integer wh
//ich appears two or more times. 
// 
//
// 
// Follow up: 
//
// 
// How can we prove that at least one duplicate number must exist in nums? 
// Can you solve the problem without modifying the array nums? 
// Can you solve the problem using only constant, O(1) extra space? 
// Can you solve the problem with runtime complexity less than O(n2)? 
// 
// Related Topics Array Two Pointers Binary Search 
// 👍 6439 👎 707


import java.util.HashSet;
import java.util.Set;

public class P287FindTheDuplicateNumber{
    public static void main(String[] args) {
        // Solution solution = new P287FindTheDuplicateNumber().new Solution();
        // TO TEST
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int findDuplicate(int[] nums) {

            Set<Integer> set = new HashSet<>(nums.length - 1);
            for (int num : nums) {
                if (set.contains(num)) {
                    return num;
                }else {
                    set.add(num);
                }
            }
            return 0;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}
