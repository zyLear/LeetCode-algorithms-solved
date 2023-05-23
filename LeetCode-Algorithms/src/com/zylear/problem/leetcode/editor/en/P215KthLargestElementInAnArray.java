package com.zylear.problem.leetcode.editor.en;

//Find the kth largest element in an unsorted array. Note that it is the kth lar
//gest element in the sorted order, not the kth distinct element. 
//
// Example 1: 
//
// 
//Input: [3,2,1,5,6,4] and k = 2
//Output: 5
// 
//
// Example 2: 
//
// 
//Input: [3,2,3,1,2,4,5,5,6] and k = 4
//Output: 4 
//
// Note: 
//You may assume k is always valid, 1 ≤ k ≤ array's length. 
// Related Topics Divide and Conquer Heap 
// 👍 4662 👎 304


import java.util.PriorityQueue;
import java.util.Queue;

public class P215KthLargestElementInAnArray {
    public static void main(String[] args) {
        // Solution solution = new P215KthLargestElementInAnArray().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public int findKthLargest1(int[] nums, int k) {
            int destIndex = nums.length - k;
            sort(nums, 0, nums.length - 1, destIndex);
            return nums[destIndex];
        }


        public void sort(int[] nums, int start, int end, int destIndex) {
            if (start >= end) {
                return;
            }
            int temp = nums[start];
            int endIndex = end;
            int startIndex = start;

            while (startIndex < endIndex) {

                while (startIndex < endIndex && temp <= nums[endIndex]) {
                    endIndex--;
                }
                swap(nums, startIndex, endIndex);

                while (startIndex < endIndex && temp >= nums[startIndex]) {
                    startIndex++;
                }
                swap(nums, startIndex, endIndex);
            }
            //跳出循环的时候  startIndex == endIndex  也就是找到的那个坐标
            if (startIndex == destIndex) {
                return;
            } else if (destIndex < startIndex) {
                sort(nums, start, startIndex - 1, destIndex);
            } else {
                sort(nums, startIndex + 1, end, destIndex);
            }


        }

        private void swap(int[] nums, int start, int end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
        }

        public int findKthLargest(int[] nums, int k) {
            Queue<Integer> heap = new PriorityQueue<>();
            for (int i = 0; i < nums.length; i++) {
                if (i < k) {
                    heap.add(nums[i]);
                } else {
                    if (nums[i] > heap.element()) {
                        heap.add(nums[i]);
                        heap.remove();
                    }
                }

            }
            return heap.remove();
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}
