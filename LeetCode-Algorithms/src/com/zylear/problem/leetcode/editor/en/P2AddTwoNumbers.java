package com.zylear.problem.leetcode.editor.en;

//You are given two non-empty linked lists representing two non-negative integer
//s. The digits are stored in reverse order, and each of their nodes contains a si
//ngle digit. Add the two numbers and return the sum as a linked list. 
//
// You may assume the two numbers do not contain any leading zero, except the nu
//mber 0 itself. 
//
// 
// Example 1: 
//
// 
//Input: l1 = [2,4,3], l2 = [5,6,4]
//Output: [7,0,8]
//Explanation: 342 + 465 = 807.
// 
//
// Example 2: 
//
// 
//Input: l1 = [0], l2 = [0]
//Output: [0]
// 
//
// Example 3: 
//
// 
//Input: l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
//Output: [8,9,9,9,0,0,0,1]
// 
//
// 
// Constraints: 
//
// 
// The number of nodes in each linked list is in the range [1, 100]. 
// 0 <= Node.val <= 9 
// It is guaranteed that the list represents a number that does not have leading
// zeros. 
// 
// Related Topics Linked List Math 
// 👍 9809 👎 2470


import com.zylear.problem.leetcode.editor.en.base.ListNode;

public class P2AddTwoNumbers {
    public static void main(String[] args) {
        Solution solution = new P2AddTwoNumbers().new Solution();
        // TO TEST
    }


    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode() {}
     * ListNode(int val) { this.val = val; }
     * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */
    class Solution {
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            int add = 0;
            ListNode head = new ListNode();
            ListNode current = head;
            while (l1 != null || l2 != null || add > 0) {
                int l1Value = 0;
                int l2Value = 0;
                if (l1 != null) {
                    l1Value = l1.val;
                }
                if (l2 != null) {
                    l2Value = l2.val;
                }
                int count = l1Value + l2Value + add;
                ListNode node = new ListNode();

                if (count >= 10) {
                    node.val = count % 10;
                    add = count / 10;
                } else {
                    node.val = count;
                    add = 0;
                }

                current.next = node;
                current = node;
                if (l1 != null) {
                    l1 = l1.next;
                }
                if (l2 != null) {
                    l2 = l2.next;
                }
            }

            return head.next;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}

