package com.zylear.problem.leetcode.editor.en;

//Given a sorted array of distinct integers and a target value, return the index
// if the target is found. If not, return the index where it would be if it were i
//nserted in order. 
//
// 
// Example 1: 
// Input: nums = [1,3,5,6], target = 5
//Output: 2
// Example 2: 
// Input: nums = [1,3,5,6], target = 2
//Output: 1
// Example 3: 
// Input: nums = [1,3,5,6], target = 7
//Output: 4
// Example 4: 
// Input: nums = [1,3,5,6], target = 0
//Output: 0
// Example 5: 
// Input: nums = [1], target = 0
//Output: 0
// 
// 
// Constraints: 
//
// 
// 1 <= nums.length <= 104 
// -104 <= nums[i] <= 104 
// nums contains distinct values sorted in ascending order. 
// -104 <= target <= 104 
// 
// Related Topics Array Binary Search 
// 👍 2886 👎 274


public class P35SearchInsertPosition {
    public static void main(String[] args) {
//        Solution solution = new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int searchInsert(int[] nums, int target) {

            int lower = 0;
            int upper = nums.length - 1;
            //节省内存   可以去掉
            if (nums[lower] > target) {
                return 0;
            }
            if (nums[upper] < target) {
                return nums.length;
            }
//            int temp = 0;
            while (lower <= upper) {
                int mid = lower + ((upper - lower) / 2);
                if (nums[mid] == target) {
                    return mid;
                } else if (target < nums[mid]) {
                    upper = mid - 1;
                    //协助理解
//                    temp = mid;
                } else {
                    lower = mid + 1;
                    //协助理解
//                    temp = mid + 1;
                }
            }

            //  while (lower < upper)  这个判断条件跳出去的最终lower==upper
            //  所以用下面的条件判断好理解 也可以整合到while (lower <= upper)  最终直接返回lower
            //  可以用一个中间变量temp帮助理解
//            if (target < nums[lower] ) {
//                return lower;
//            } else {
//                return lower + 1;
//            }


            /*
            延申结论： 重要！！！！！
             一、while (lower < upper)  这个判断条件跳出去的最终lower==upper
             二、while (lower <= upper)
                这个情况最终跳出去是
                 lower = upper + 1
                 upper < lower
                 array[upper]  <  target  <  array[lower]   这个关系很重要

                 这道题的意思是找大于等于target的第一个index位置  从上面公式来看就是取lower
                 开平方那道题就是取小于等于target的第一个index位置  从上面公式来看就是取upper
             */

            return lower;
        }


    }
//leetcode submit region end(Prohibit modification and deletion)

}

