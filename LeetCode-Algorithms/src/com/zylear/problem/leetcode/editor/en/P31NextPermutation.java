package com.zylear.problem.leetcode.editor.en;

//Implement next permutation, which rearranges numbers into the lexicographicall
//y next greater permutation of numbers. 
//
// If such an arrangement is not possible, it must rearrange it as the lowest po
//ssible order (i.e., sorted in ascending order). 
//
// The replacement must be in place and use only constant extra memory. 
//
// 
// Example 1: 
// Input: nums = [1,2,3]
//Output: [1,3,2]
// Example 2: 
// Input: nums = [3,2,1]
//Output: [1,2,3]
// Example 3: 
// Input: nums = [1,1,5]
//Output: [1,5,1]
// Example 4: 
// Input: nums = [1]
//Output: [1]
// 
// 
// Constraints: 
//
// 
// 1 <= nums.length <= 100 
// 0 <= nums[i] <= 100 
// 
// Related Topics Array 
// 👍 5376 👎 1847


import java.util.Arrays;
import java.util.Comparator;

public class P31NextPermutation {
    public static void main(String[] args) {
         Solution solution = new P31NextPermutation().new Solution();
        int[] nums = {1, 2, 4, 9, 5, 3};
        solution.nextPermutation(nums);
        System.out.println(Arrays.toString(nums));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // 1  2   4  9  5  3
        // 1  2   9  4  5  3
        // ---- 1  2  5  3  4  9
//        public void nextPermutation(int[] nums) {
//            nextPermutation(nums, 0, nums.length - 1);
//        }

        public void nextPermutation(int[] nums) {
            if (nums == null || nums.length == 1) {
                return;
            }
            for (int i = nums.length - 1; i > 0; i--) {
                if (nums[i] > nums[i - 1]) {
                    int count = nums[i - 1];
                    int min = nums[i];
                    int minIndex = i;
                    int index = i;
                    //发现比前面一个数大  找出最小一个数放前面，后面从小到大排序
                    while (index < nums.length) {
                        if (nums[index] > count && nums[index] < min) {
                            min = nums[index];
                            minIndex = index;
                        }
                        index++;
                    }

                    int temp = nums[minIndex];
                    nums[minIndex] = nums[i - 1];
                    nums[i - 1] = temp;
                    Arrays.sort(nums, i, nums.length);
                    return;
                }
            }

            Arrays.sort(nums);
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}
