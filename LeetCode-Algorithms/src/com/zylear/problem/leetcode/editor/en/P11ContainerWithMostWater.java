package com.zylear.problem.leetcode.editor.en;

//Given n non-negative integers a1, a2, ..., an , where each represents a point 
//at coordinate (i, ai). n vertical lines are drawn such that the two endpoints of
// the line i is at (i, ai) and (i, 0). Find two lines, which, together with the x
//-axis forms a container, such that the container contains the most water. 
//
// Notice that you may not slant the container. 
//
// 
// Example 1: 
//
// 
//Input: height = [1,8,6,2,5,4,8,3,7]
//Output: 49
//Explanation: The above vertical lines are represented by array [1,8,6,2,5,4,8,
//3,7]. In this case, the max area of water (blue section) the container can conta
//in is 49.
// 
//
// Example 2: 
//
// 
//Input: height = [1,1]
//Output: 1
// 
//
// Example 3: 
//
// 
//Input: height = [4,3,2,1,4]
//Output: 16
// 
//
// Example 4: 
//
// 
//Input: height = [1,2,1]
//Output: 2
// 
//
// 
// Constraints: 
//
// 
// n = height.length 
// 2 <= n <= 3 * 104 
// 0 <= height[i] <= 3 * 104 
// 
// Related Topics Array Two Pointers 
// 👍 7787 👎 643


public class P11ContainerWithMostWater {
    public static void main(String[] args) {
        Solution solution = new P11ContainerWithMostWater().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxArea(int[] height) {

            //思维解法   太难了  能想到brute force解法写出来就行了
            int max = 0;
            int lower = 0;
            int upper = height.length - 1;
            while (lower < upper) {
                max = Math.max(Math.min(height[upper], height[lower]) * (upper - lower), max);
                if (height[upper] > height[lower]) {
                    lower++;
                } else {
                    upper--;
                }
            }
            return max;
        }


        public int maxArea1(int[] height) {
            //brute force
            int max = 0;
            for (int i = 0; i < height.length; i++) {
                for (int j = i + 1; j < height.length; j++) {
                    max = Math.max(Math.min(height[j], height[i]) * (j - i), max);
                }
            }
            return max;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}