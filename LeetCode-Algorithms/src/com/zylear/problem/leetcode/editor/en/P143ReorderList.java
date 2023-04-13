package com.zylear.problem.leetcode.editor.en;

//You are given the head of a singly linked-list. The list can be represented 
//as: 
//
// 
//L0 → L1 → … → Ln - 1 → Ln
// 
//
// Reorder the list to be on the following form: 
//
// 
//L0 → Ln → L1 → Ln - 1 → L2 → Ln - 2 → …
// 
//
// You may not modify the values in the list's nodes. Only nodes themselves may 
//be changed. 
//
// 
// Example 1: 
// 
// 
//Input: head = [1,2,3,4]
//Output: [1,4,2,3]
// 
//
// Example 2: 
// 
// 
//Input: head = [1,2,3,4,5]
//Output: [1,5,2,4,3]
// 
//
// 
// Constraints: 
//
// 
// The number of nodes in the list is in the range [1, 5 * 10⁴]. 
// 1 <= Node.val <= 1000 
// 
//
// Related Topics Linked List Two Pointers Stack Recursion 👍 8531 👎 290


import com.zylear.problem.leetcode.editor.en.base.ListNode;

public class P143ReorderList {
    public static void main(String[] args) {
        Solution solution = new P143ReorderList().new Solution();

        solution.reorderList(new ListNode(1));
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
        public void reorderList(ListNode head) {

            if (head == null) {
                return;
            }

            ListNode fast = head;
            ListNode slow = head;

            //find mid point
            while (fast != null && fast.next != null) {
                fast = fast.next.next;
                slow = slow.next;
            }

            //reverse part2 link
            ListNode reverseNode = reverse(slow.next);
            slow.next = null;

            //merge two link
            while (head != null) {
                if (reverseNode != null) {
                    ListNode part1next = head.next;
                    ListNode part2Next = reverseNode.next;
                    head.next = reverseNode;
                    reverseNode.next = part1next;
                    head = part1next;
                    reverseNode = part2Next;
                } else {
                    break;
                }
            }
        }

        private ListNode reverse(ListNode node) {
            ListNode pre = null;
            ListNode current = node;
            while (current != null) {
                ListNode next = current.next;
                current.next = pre;
                pre = current;
                current = next;
            }
            return pre;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}