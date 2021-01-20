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


import java.util.*;

public class P207CourseSchedule {
    public static void main(String[] args) {
        Solution solution = new P207CourseSchedule().new Solution();
        solution.canFinish(3, new int[][]{{2, 0}, {2, 1}});
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        boolean[] visited;
        boolean[] handle;

        int[] indegree;
        Map<Integer, Set<Integer>> adjacency;


        //bfs
        public boolean canFinish(int numCourses, int[][] prerequisites) {
            if (prerequisites.length == 0) {
                return true;
            }
//            visited = new boolean[numCourses];
            handle = new boolean[numCourses];

//            indegree = new int[numCourses];

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
            while (!queue.isEmpty()) {
                while (!queue.isEmpty()) {
                    Integer poll = queue.poll();
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
                    return false;
                }
            }

            return true;
        }


        //dfs
        public boolean canFinish2(int numCourses, int[][] prerequisites) {
            if (prerequisites.length == 0) {
                return true;
            }
            visited = new boolean[numCourses];
            handle = new boolean[numCourses];

            indegree = new int[numCourses];

            adjacency = new HashMap<>(numCourses);

            for (int[] prerequisite : prerequisites) {
                Set<Integer> set = adjacency.computeIfAbsent(prerequisite[0], k -> new HashSet<>());
                set.add(prerequisite[1]);

                indegree[prerequisite[1]] += 1;
            }

            //优先搜索
            for (int i = 0; i < numCourses; i++) {
                if (indegree[i] == 0) {
                    boolean dfs = improveDfs(i);
                    if (!dfs) {
                        return false;
                    }
                }
            }

            for (int i = 0; i < numCourses; i++) {
                if (!handle[i]) {
                    boolean dfs = improveDfs(i);
                    if (!dfs) {
                        return false;
                    }
                }
            }
            return true;
        }

        private boolean improveDfs(int number) {
            handle[number] = true;
            if (visited[number]) {
                return false;
            } else {
                visited[number] = true;
                Set<Integer> set = adjacency.get(number);
                if (set != null) {
                    for (Integer integer : set) {
                        boolean dfs = improveDfs(integer);
                        if (!dfs) {
                            return false;
                        }
                    }
                }
                visited[number] = false;
            }
            return true;
        }


        //邻接表表示图 找邻接点的方式通过for循环，可改进
        public boolean canFinish1(int numCourses, int[][] prerequisites) {
            if (prerequisites.length == 0) {
                return true;
            }
            visited = new boolean[numCourses];
            handle = new boolean[numCourses];


            for (int i = 0; i < numCourses; i++) {
                if (handle[i]) {
                    continue;
                }
                boolean dfs = dfs(prerequisites, i);
                if (!dfs) {
                    return false;
                }
            }
            return true;
        }

        private boolean dfs(int[][] prerequisites, int number) {
            handle[number] = true;
            if (visited[number]) {
                return false;
            } else {
                for (int i = 0; i < prerequisites.length; i++) {
                    if (prerequisites[i][0] == number) {
                        visited[number] = true;
                        boolean dfs = dfs(prerequisites, prerequisites[i][1]);
                        visited[number] = false;
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
