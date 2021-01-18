package com.zylear.problem.leetcode.editor.en;

//There are a total of numCourses courses you have to take, labeled from 0 to nu
//mCourses-1. 
//
// Some courses may have prerequisites, for example to take course 0 you have to
// first take course 1, which is expressed as a pair: [0,1] 
//
// Given the total number of courses and a list of prerequisite pairs, is it pos
//sible for you to finish all courses? 
//
// 
// Example 1: 
//
// 
//Input: numCourses = 2, prerequisites = [[1,0]]
//Output: true
//Explanation: There are a total of 2 courses to take. 
//             To take course 1 you should have finished course 0. So it is poss
//ible.
// 
//
// Example 2: 
//
// 
//Input: numCourses = 2, prerequisites = [[1,0],[0,1]]
//Output: false
//Explanation: There are a total of 2 courses to take. 
//             To take course 1 you should have finished course 0, and to take c
//ourse 0 you should
//             also have finished course 1. So it is impossible.
// 
//
// 
// Constraints: 
//
// 
// The input prerequisites is a graph represented by a list of edges, not adjace
//ncy matrices. Read more about how a graph is represented. 
// You may assume that there are no duplicate edges in the input prerequisites. 
//
// 1 <= numCourses <= 10^5 
// 
// Related Topics Depth-first Search Breadth-first Search Graph Topological Sort
// 
// 👍 5075 👎 203


public class P207CourseSchedule {
    public static void main(String[] args) {
        // Solution solution = new P207CourseSchedule().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        boolean[] show;
        boolean[] visited;

        public boolean canFinish(int numCourses, int[][] prerequisites) {
            if (prerequisites.length == 0) {
                return true;
            }
            visited = new boolean[numCourses];
            show = new boolean[prerequisites.length];

            int[] countt = new int[numCourses];
            for (int i = 0; i < prerequisites.length; i++) {
                countt[prerequisites[i][0]] += 1;
                countt[prerequisites[i][1]] -= 1;
            }

//            visited[prerequisites[0][0]]=true;
//            visited[prerequisites[0][1]]=true;
            for (int i = 0; i < prerequisites.length; i++) {
//                if (!show[i]) {

                if (countt[prerequisites[i][0]] > 0) {
                    show[i] = true;
                    boolean dfs = dfs(numCourses, prerequisites, prerequisites[0][1]);
                    if (!dfs) {
                        return false;
                    }
                }

//                }
            }
            return true;
        }

        private boolean dfs(int numCourses, int[][] prerequisites, int number) {
            for (int i = 0; i < prerequisites.length; i++) {
                if (prerequisites[i][0] == number) {
                    if (show[i]) {
                        return false;
                    } else {
                        show[i] = true;
                        boolean dfs = dfs(numCourses, prerequisites, prerequisites[i][1]);
                        if (!dfs) {
                            return false;
                        }
                    }
                }
            }
            return true;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}
