package com.zylear.problem.leetcode.editor.en;

//Suppose an array sorted in ascending order is rotated at some pivot unknown to
// you beforehand. 
//
// (i.e., [0,1,2,4,5,6,7] might become [4,5,6,7,0,1,2]). 
//
// Find the minimum element. 
//
// The array may contain duplicates. 
//
// Example 1: 
//
// 
//Input: [1,3,5]
//Output: 1 
//
// Example 2: 
//
// 
//Input: [2,2,2,0,1]
//Output: 0 
//
// Note: 
//
// 
// This is a follow up problem to Find Minimum in Rotated Sorted Array. 
// Would allow duplicates affect the run-time complexity? How and why? 
// 
// Related Topics Array Binary Search 
// 👍 1354 👎 262


public class P154FindMinimumInRotatedSortedArrayIi{
    public static void main(String[] args) {
        // Solution solution = new P154FindMinimumInRotatedSortedArrayIi().new Solution();
        // TO TEST
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int findMin(int[] nums) {
            int lower = 0;
            int upper = nums.length - 1;

            while (lower < upper) {

                int mid = lower + (upper - lower) / 2;
                //单调递增
                if (nums[lower] < nums[upper]) {
                    return nums[lower];
                } else {
                    //最小值在两点之间，用中间点缩小范围
                    if (nums[lower] < nums[mid]) {
                        //中间点在左半部分,最小值肯定还在右边，所以+1
                        lower = mid + 1;
                    } else if (nums[lower] > nums[mid]) {
                        //中间点在右半部分，最小值可能是mid，所以不加1
                        upper = mid;
                    } else {
                        //存在重复的节点，不能判断 中间点的位置，只能++做下一次判断
                        //本题目不存在重复的节点，所以先注释掉
                        lower++;
                    }
                }
            }

            return nums[lower];
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}
