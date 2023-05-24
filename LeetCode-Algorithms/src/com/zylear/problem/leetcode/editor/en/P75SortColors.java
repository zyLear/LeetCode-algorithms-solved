package com.zylear.problem.leetcode.editor.en;

//Given an array nums with n objects colored red, white, or blue, sort them in-p
//lace so that objects of the same color are adjacent, with the colors in the orde
//r red, white, and blue. 
//
// Here, we will use the integers 0, 1, and 2 to represent the color red, white,
// and blue respectively. 
//
// Follow up: 
//
// 
// Could you solve this problem without using the library's sort function? 
// Could you come up with a one-pass algorithm using only O(1) constant space? 
// 
//
// 
// Example 1: 
// Input: nums = [2,0,2,1,1,0]
//Output: [0,0,1,1,2,2]
// Example 2: 
// Input: nums = [2,0,1]
//Output: [0,1,2]
// Example 3: 
// Input: nums = [0]
//Output: [0]
// Example 4: 
// Input: nums = [1]
//Output: [1]
// 
// 
// Constraints: 
//
// 
// n == nums.length 
// 1 <= n <= 300 
// nums[i] is 0, 1, or 2. 
// 
// Related Topics Array Two Pointers Sort 
// 👍 4402 👎 254


import java.util.Arrays;
import java.util.Collections;

public class P75SortColors {
    public static void main(String[] args) {
         Solution solution = new P75SortColors().new Solution();
        int[] a = {2, 0, 1};
        solution.sortColors(a);
        for (int i : a) {
            System.out.print(i);
        }
        System.out.println();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public void sortColors(int[] nums) {
            int lower = 0;
            int upper = nums.length - 1;
            int mid = 0;
            while (mid <= upper) {

                if (nums[mid] == 0) {
                    swap(nums, lower, mid);
                    mid++;
                    lower++;
                } else if (nums[mid] == 1) {
                    mid++;
                } else if (nums[mid] == 2) {
                    swap(nums, mid, upper);
                    upper--;
                }
            }
        }

        private void swap(int[] nums, int lower, int upper) {
            int temp = nums[lower];
            nums[lower] = nums[upper];
            nums[upper] = temp;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
