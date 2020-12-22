package com.zylear.problem.leetcode.editor.en;

//Given a linked list, swap every two adjacent nodes and return its head. 
//
// You may not modify the values in the list's nodes. Only nodes itself may be c
//hanged. 
//
// 
// Example 1: 
//
// 
//Input: head = [1,2,3,4]
//Output: [2,1,4,3]
// 
//
// Example 2: 
//
// 
//Input: head = []
//Output: []
// 
//
// Example 3: 
//
// 
//Input: head = [1]
//Output: [1]
// 
//
// 
// Constraints: 
//
// 
// The number of nodes in the list is in the range [0, 100]. 
// 0 <= Node.val <= 100 
// 
// Related Topics Linked List 
// 👍 2955 👎 192


import com.zylear.problem.leetcode.editor.en.base.ListNode;

public class P24SwapNodesInPairs {
    public static void main(String[] args) {
        Solution solution = new P24SwapNodesInPairs().new Solution();
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
        public ListNode swapPairs(ListNode head) {
            ListNode result = new ListNode();
            result.next = head;
            ListNode current = result;
            //成对处理
            while (current.next != null && current.next.next != null) {
                //用图形化思维求解
                //先连到下一个  再插入第一个
                ListNode temp = current.next;
                current.next = temp.next;
                temp.next = current.next.next;
                current.next.next = temp;

                current = current.next.next;
            }


            return result.next;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)


}