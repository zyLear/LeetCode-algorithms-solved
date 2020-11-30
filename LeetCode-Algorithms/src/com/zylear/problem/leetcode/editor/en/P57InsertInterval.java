package com.zylear.problem.leetcode.editor.en;

//Given a set of non-overlapping intervals, insert a new interval into the inter
//vals (merge if necessary). 
//
// You may assume that the intervals were initially sorted according to their st
//art times. 
//
// 
// Example 1: 
//
// 
//Input: intervals = [[1,3],[6,9]], newInterval = [2,5]
//Output: [[1,5],[6,9]]
// 
//
// Example 2: 
//
// 
//Input: intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
//Output: [[1,2],[3,10],[12,16]]
//Explanation: Because the new interval [4,8] overlaps with [3,5],[6,7],[8,10]. 
//
//
// Example 3: 
//
// 
//Input: intervals = [], newInterval = [5,7]
//Output: [[5,7]]
// 
//
// Example 4: 
//
// 
//Input: intervals = [[1,5]], newInterval = [2,3]
//Output: [[1,5]]
// 
//
// Example 5: 
//
// 
//Input: intervals = [[1,5]], newInterval = [2,7]
//Output: [[1,7]]
// 
//
// 
// Constraints: 
//
// 
// 0 <= intervals.length <= 104 
// intervals[i].length == 2 
// 0 <= intervals[i][0] <= intervals[i][1] <= 105 
// intervals is sorted by intervals[i][0] in ascending order. 
// newInterval.length == 2 
// 0 <= newInterval[0] <= newInterval[1] <= 105 
// 
// Related Topics Array Sort 
// 👍 2342 👎 226


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class P57InsertInterval {
    public static void main(String[] args) {
        // Solution solution = new P57InsertInterval().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[][] insert(int[][] intervals, int[] newInterval) {

//            Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));
            List<int[]> result = new ArrayList<>();

            int[] current = Arrays.copyOf(newInterval, 2);
            for (int i = 0; i < intervals.length; i++) {
                //current==null 说明已经插入了  处理完了  后面的就拼接就好了
                if (current == null || intervals[i][1] < current[0]) {
                    result.add(intervals[i]);
                } else if (intervals[i][0] > current[1]) {
                    result.add(current);
                    result.add(intervals[i]);
                    current = null;
                } else {
                    current[0] = Math.min(current[0], intervals[i][0]);
                    current[1] = Math.max(current[1], intervals[i][1]);
                }
            }
            if (current != null) {
                result.add(current);
            }

            return result.toArray(new int[result.size()][]);

        }

//        private int findIndex(int[] newInterval, List<int[]> ints, int lower, int upper) {
//            while (lower <= upper) {
//
//                int mid = lower + ((upper - lower) / 2);
//                if (ints.get(mid)[0] == newInterval[0]) {
//                    return mid;
//                } else if (newInterval[0] < ints.get(mid)[0]) {
//                    upper = mid - 1;
//                } else {
//                    lower = mid + 1;
//                }
//
//                lower++;
//                upper--;
//            }
//            return upper;
//        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
