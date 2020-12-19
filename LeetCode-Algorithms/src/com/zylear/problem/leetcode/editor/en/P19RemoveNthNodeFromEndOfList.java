package com.zylear.problem.leetcode.editor.en;

//Given the head of a linked list, remove the nth node from the end of the list 
//and return its head. 
//
// Follow up: Could you do this in one pass? 
//
// 
// Example 1: 
//
// 
//Input: head = [1,2,3,4,5], n = 2
//Output: [1,2,3,5]
// 
//
// Example 2: 
//
// 
//Input: head = [1], n = 1
//Output: []
// 
//
// Example 3: 
//
// 
//Input: head = [1,2], n = 1
//Output: [1]
// 
//
// 
// Constraints: 
//
// 
// The number of nodes in the list is sz. 
// 1 <= sz <= 30 
// 0 <= Node.val <= 100 
// 1 <= n <= sz 
// 
// Related Topics Linked List Two Pointers 
// 👍 4354 👎 269


import com.zylear.problem.leetcode.editor.en.base.ListNode;

public class P19RemoveNthNodeFromEndOfList {
    public static void main(String[] args) {
        Solution solution = new P19RemoveNthNodeFromEndOfList().new Solution();
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


        public ListNode removeNthFromEnd(ListNode head, int n) {

            ListNode dummy = new ListNode();
            dummy.next = head;
            ListNode first = head;
            ListNode second = dummy;
            // Advances first pointer so that the gap between first and second is n nodes apart
            while (--n > 0) {
                first = first.next;
            }
            // Move first to the end, maintaining the gap
            while (first.next != null) {
                first = first.next;
                second = second.next;
            }
            second.next = second.next.next;
            return dummy.next;

        }


        public ListNode removeNthFromEnd1(ListNode head, int n) {

            head = reverse(head);

            ListNode result = new ListNode();
            result.next = head;
            ListNode current = result;
            while (current.next != null && --n > 0) {
                current = current.next;
            }

            if (current.next != null) {
                current.next = current.next.next;
            }

            return reverse(result.next);

        }

        private ListNode reverse(ListNode head) {
            if (head == null || head.next == null) {
                return head;
            }else {
                ListNode tail = reverse(head.next);

                head.next.next = head;
                head.next = null;
                return tail;
            }
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)


}