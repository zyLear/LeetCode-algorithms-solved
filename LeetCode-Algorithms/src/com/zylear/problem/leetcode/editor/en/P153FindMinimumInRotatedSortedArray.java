package com.zylear.problem.leetcode.editor.en;

//Suppose an array of length n sorted in ascending order is rotated between 1 an
//d n times. For example, the array nums = [0,1,2,4,5,6,7] might become: 
//
// 
// [4,5,6,7,0,1,2] if it was rotated 4 times. 
// [0,1,2,4,5,6,7] if it was rotated 7 times. 
// 
//
// Notice that rotating an array [a[0], a[1], a[2], ..., a[n-1]] 1 time results 
//in the array [a[n-1], a[0], a[1], a[2], ..., a[n-2]]. 
//
// Given the sorted rotated array nums, return the minimum element of this array
//. 
//
// 
// Example 1: 
//
// 
//Input: nums = [3,4,5,1,2]
//Output: 1
//Explanation: The original array was [1,2,3,4,5] rotated 3 times.
// 
//
// Example 2: 
//
// 
//Input: nums = [4,5,6,7,0,1,2]
//Output: 0
//Explanation: The original array was [0,1,2,4,5,6,7] and it was rotated 4 times
//.
// 
//
// Example 3: 
//
// 
//Input: nums = [11,13,15,17]
//Output: 11
//Explanation: The original array was [11,13,15,17] and it was rotated 4 times. 
//
// 
//
// 
// Constraints: 
//
// 
// n == nums.length 
// 1 <= n <= 5000 
// -5000 <= nums[i] <= 5000 
// All the integers of nums are unique. 
// nums is sorted and rotated between 1 and n times. 
// 
// Related Topics Array Binary Search 
// 👍 2980 👎 281


public class P153FindMinimumInRotatedSortedArray {
    public static void main(String[] args) {
        // Solution solution = new P153FindMinimumInRotatedSortedArray().new Solution();
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
                        lower++;
                    }
                }
            }

            return nums[lower];
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}
