package com.zylear.problem.leetcode.editor.en;

//Given a sorted array nums, remove the duplicates in-place such that duplicates
// appeared at most twice and return the new length. 
//
// Do not allocate extra space for another array; you must do this by modifying 
//the input array in-place with O(1) extra memory. 
//
// Clarification: 
//
// Confused why the returned value is an integer, but your answer is an array? 
//
// Note that the input array is passed in by reference, which means a modificati
//on to the input array will be known to the caller. 
//
// Internally you can think of this: 
//
// 
//// nums is passed in by reference. (i.e., without making a copy)
//int len = removeDuplicates(nums);
//
//// any modification to nums in your function would be known by the caller.
//// using the length returned by your function, it prints the first len element
//s.
//for (int i = 0; i < len; i++) {
//    print(nums[i]);
//}
// 
//
// 
// Example 1: 
//
// 
//Input: nums = [1,1,1,2,2,3]
//Output: 5, nums = [1,1,2,2,3]
//Explanation: Your function should return length = 5, with the first five eleme
//nts of nums being 1, 1, 2, 2 and 3 respectively. It doesn't matter what you leav
//e beyond the returned length.
// 
//
// Example 2: 
//
// 
//Input: nums = [0,0,1,1,1,1,2,3,3]
//Output: 7, nums = [0,0,1,1,2,3,3]
//Explanation: Your function should return length = 7, with the first seven elem
//ents of nums being modified to 0, 0, 1, 1, 2, 3 and 3 respectively. It doesn't m
//atter what values are set beyond the returned length.
// 
//
// 
// Constraints: 
//
// 
// 1 <= nums.length <= 3 * 104 
// -104 <= nums[i] <= 104 
// nums is sorted in ascending order. 
// 
// Related Topics Array Two Pointers 
// 👍 1655 👎 765


public class P80RemoveDuplicatesFromSortedArrayIi{
    public static void main(String[] args) {
        // Solution solution = new P80RemoveDuplicatesFromSortedArrayIi().new Solution();
        // TO TEST
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int removeDuplicates(int[] nums) {
            if (nums.length <= 2) {
                return nums.length;
            }
            int index = 0;
            for (int i = 2; i < nums.length; i++) {
                if (nums[i] != nums[index]) {
                    nums[index + 2] = nums[i];
                    index++;
                }
            }

            return index + 2;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}
