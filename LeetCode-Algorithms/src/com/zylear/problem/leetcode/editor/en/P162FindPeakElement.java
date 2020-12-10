package com.zylear.problem.leetcode.editor.en;

//A peak element is an element that is strictly greater than its neighbors. 
//
// Given an integer array nums, find a peak element, and return its index. If th
//e array contains multiple peaks, return the index to any of the peaks. 
//
// You may imagine that nums[-1] = nums[n] = -∞. 
//
// 
// Example 1: 
//
// 
//Input: nums = [1,2,3,1]
//Output: 2
//Explanation: 3 is a peak element and your function should return the index num
//ber 2. 
//
// Example 2: 
//
// 
//Input: nums = [1,2,1,3,5,6,4]
//Output: 5
//Explanation: Your function can return either index number 1 where the peak ele
//ment is 2, or index number 5 where the peak element is 6. 
//
// 
// Constraints: 
//
// 
// 1 <= nums.length <= 1000 
// -231 <= nums[i] <= 231 - 1 
// nums[i] != nums[i + 1] for all valid i. 
// 
//
// 
//Follow up: Could you implement a solution with logarithmic complexity? Related
// Topics Array Binary Search 
// 👍 2295 👎 2360


import java.util.Scanner;

public class P162FindPeakElement {
//    public static void main(String[] args) {
//        // Solution solution = new P162FindPeakElement().new Solution();
//        // TO TEST
//    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNextLine()) {
            String string = scanner.nextLine();
            Double count = Double.parseDouble(string);

            calc(count);

        }
    }

    public static void calc(Double count) {

        boolean flag = false;
        if (count < 0) {
            flag = true;
            count = -count;
        }
        int lower = 0;
        int upper = count.intValue();

        while (lower <= upper) {
            int mid = lower + (upper - lower) / 2;

            int number = mid * mid * mid;
            if (number == count) {
                upper = mid;
                break;
            } else if (number > count) {
                upper = mid - 1;
            } else {
                lower = mid + 1;
            }
        }
        double temp = upper;
        while (temp * temp * temp < count) {

            temp += 0.01;
        }
        if (flag) {
            temp = -temp;
        }

        System.out.println(String.format("%.1f", temp));
    }


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int findPeakElement(int[] nums) {

            int lower = 0;
            int upper = nums.length - 1;
            //跳出去的时候 lower==upper
            while (lower < upper) {
                int mid = lower + (upper - lower) / 2;
                //当找到一个点 小于他
                if (nums[mid] < nums[mid + 1]) {
                    lower = mid + 1;
                }else {
                    upper = mid;
                }
            }

            return lower;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
