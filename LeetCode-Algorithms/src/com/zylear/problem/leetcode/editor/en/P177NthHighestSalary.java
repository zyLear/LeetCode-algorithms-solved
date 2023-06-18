package com.zylear.problem.leetcode.editor.en;

//Table: Employee 
//
// 
//+-------------+------+
//| Column Name | Type |
//+-------------+------+
//| id          | int  |
//| salary      | int  |
//+-------------+------+
//id is the primary key column for this table.
//Each row of this table contains information about the salary of an employee.
// 
//
// 
//
// Write an SQL query to report the nᵗʰ highest salary from the Employee table. 
//If there is no nᵗʰ highest salary, the query should report null. 
//
// The query result format is in the following example. 
//
// 
// Example 1: 
//
// 
//Input: 
//Employee table:
//+----+--------+
//| id | salary |
//+----+--------+
//| 1  | 100    |
//| 2  | 200    |
//| 3  | 300    |
//+----+--------+
//n = 2
//Output: 
//+------------------------+
//| getNthHighestSalary(2) |
//+------------------------+
//| 200                    |
//+------------------------+
// 
//
// Example 2: 
//
// 
//Input: 
//Employee table:
//+----+--------+
//| id | salary |
//+----+--------+
//| 1  | 100    |
//+----+--------+
//n = 2
//Output: 
//+------------------------+
//| getNthHighestSalary(2) |
//+------------------------+
//| null                   |
//+------------------------+
// 
//
// Related Topics Database 👍 1624 👎 857


public class P177NthHighestSalary {
    public static void main(String[] args) {
//        Solution solution = new P177NthHighestSalary().new Solution();
    }

//There is no code of Java type for this problem


    /*
CREATE FUNCTION getNthHighestSalary(N INT) RETURNS INT
BEGIN
SET N = N -1;
  RETURN (
      # Write your MySQL query statement below.
      select max(salary) from Employee group by salary order by salary desc limit N,1
  );
END
     * */
}