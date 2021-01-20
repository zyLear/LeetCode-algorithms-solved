package com.zylear.problem.leetcode.editor.en;

//There are a total of n courses you have to take labelled from 0 to n - 1. 
//
// Some courses may have prerequisites, for example, if prerequisites[i] = [ai, 
//bi] this means you must take the course bi before the course ai. 
//
// Given the total number of courses numCourses and a list of the prerequisite p
//airs, return the ordering of courses you should take to finish all courses. 
//
// If there are many valid answers, return any of them. If it is impossible to f
//inish all courses, return an empty array. 
//
// 
// Example 1: 
//
// 
//Input: numCourses = 2, prerequisites = [[1,0]]
//Output: [0,1]
//Explanation: There are a total of 2 courses to take. To take course 1 you shou
//ld have finished course 0. So the correct course order is [0,1].
// 
//
// Example 2: 
//
// 
//Input: numCourses = 4, prerequisites = [[1,0],[2,0],[3,1],[3,2]]
//Output: [0,2,1,3]
//Explanation: There are a total of 4 courses to take. To take course 3 you shou
//ld have finished both courses 1 and 2. Both courses 1 and 2 should be taken afte
//r you finished course 0.
//So one correct course order is [0,1,2,3]. Another correct ordering is [0,2,1,3
//].
// 
//
// Example 3: 
//
// 
//Input: numCourses = 1, prerequisites = []
//Output: [0]
// 
//
// 
// Constraints: 
//
// 
// 1 <= numCourses <= 2000 
// 0 <= prerequisites.length <= numCourses * (numCourses - 1) 
// prerequisites[i].length == 2 
// 0 <= ai, bi < numCourses 
// ai != bi 
// All the pairs [ai, bi] are distinct. 
// 
// Related Topics Depth-first Search Breadth-first Search Graph Topological Sort
// 
// 👍 3198 👎 159


import java.util.*;

public class P210CourseScheduleIi{
    public static void main(String[] args) {
        Solution solution = new P210CourseScheduleIi().new Solution();
        solution.findOrder(1, new int[][]{});
        // TO TEST
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        //bfs
        public int[] findOrder(int numCourses, int[][] prerequisites) {

            boolean[] handle = new boolean[numCourses];

            Map<Integer, Set<Integer>> deadjacency = new HashMap<>(numCourses);

            int[] prerequisitesCount = new int[numCourses];


            for (int[] prerequisite : prerequisites) {
                Set<Integer> set = deadjacency.computeIfAbsent(prerequisite[1], k -> new HashSet<>());
                set.add(prerequisite[0]);

                prerequisitesCount[prerequisite[0]] += 1;
            }

            Queue<Integer> queue = new LinkedList<>();

            for (int i = 0; i < numCourses; i++) {
                if (prerequisitesCount[i] == 0) {
                    queue.add(i);
                }
            }
            int count = 0;
            int[] result = new int[numCourses];
            while (!queue.isEmpty()) {
                while (!queue.isEmpty()) {
                    Integer poll = queue.poll();
                    result[count++] = poll;
                    handle[poll] = true;
                    Set<Integer> set = deadjacency.get(poll);
                    if (set != null) {
                        for (Integer integer : set) {
                            prerequisitesCount[integer] -= 1;
                        }
                    }
                }

                for (int i = 0; i < numCourses; i++) {
                    if (prerequisitesCount[i] == 0 && !handle[i]) {
                        queue.add(i);
                    }
                }
            }


            for (int i = 0; i < numCourses; i++) {
                if (prerequisitesCount[i] != 0) {
                    return new int[]{};
                }
            }

            return result;
        }

    }
    //leetcode submit region end(Prohibit modification and deletion)

}
