package com.zylear.problem.leetcode.editor.en;

//Write a SQL query to get the second highest salary from the Employee table. 
//
// 
//+----+--------+
//| Id | Salary |
//+----+--------+
//| 1  | 100    |
//| 2  | 200    |
//| 3  | 300    |
//+----+--------+
// 
//
// For example, given the above Employee table, the query should return 200 as t
//he second highest salary. If there is no second highest salary, then the query s
//hould return null. 
//
// 
//+---------------------+
//| SecondHighestSalary |
//+---------------------+
//| 200                 |
//+---------------------+
// 
// 👍 937 👎 486


public class P176SecondHighestSalary{
    public static void main(String[] args) {
        // Solution solution = new P176SecondHighestSalary().new Solution();
        // TO TEST

        //select max(salary) as SecondHighestSalary from Employee
        //where salary not in (select max(salary) as Salary  from Employee);
    }
    
    //There is no code of Java type for this problem
}
