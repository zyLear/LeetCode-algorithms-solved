package com.zylear.problem.leetcode.editor.en;

//Given a linked list, reverse the nodes of a linked list k at a time and return
// its modified list. 
//
// k is a positive integer and is less than or equal to the length of the linked
// list. If the number of nodes is not a multiple of k then left-out nodes, in the
// end, should remain as it is. 
//
// Follow up: 
//
// 
// Could you solve the problem in O(1) extra memory space? 
// You may not alter the values in the list's nodes, only nodes itself may be ch
//anged. 
// 
//
// 
// Example 1: 
//
// 
//Input: head = [1,2,3,4,5], k = 2
//Output: [2,1,4,3,5]
// 
//
// Example 2: 
//
// 
//Input: head = [1,2,3,4,5], k = 3
//Output: [3,2,1,4,5]
// 
//
// Example 3: 
//
// 
//Input: head = [1,2,3,4,5], k = 1
//Output: [1,2,3,4,5]
// 
//
// Example 4: 
//
// 
//Input: head = [1], k = 1
//Output: [1]
// 
//
// 
// Constraints: 
//
// 
// The number of nodes in the list is in the range sz. 
// 1 <= sz <= 5000 
// 0 <= Node.val <= 1000 
// 1 <= k <= sz 
// 
// Related Topics Linked List 
// 👍 3167 👎 391


import com.zylear.problem.leetcode.editor.en.base.ListNode;

public class P25ReverseNodesInKGroup {
    public static void main(String[] args) {
        Solution solution = new P25ReverseNodesInKGroup().new Solution();
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
        public ListNode reverseKGroup(ListNode head, int k) {

            ListNode result = new ListNode();

            result.next = head;

            ListNode lastPrevNode = result;

            ListNode current = head;
            ListNode fast = head;

            int n = k;

            while (fast != null) {
                while (n-- > 0) {
                    if (fast == null) {
                        return result.next;
                    }
                    fast = fast.next;
                }

                n = k;
                lastPrevNode.next = reverse(current, fast);
                lastPrevNode = current;

                current.next = fast;
                current = fast;

            }

            return result.next;
        }

        private ListNode reverse(ListNode current, ListNode fast) {

            if (current.next == fast) {
                return current;
            }

            ListNode next = current.next;
            ListNode tail = reverse(next, fast);
            next.next = current;
            current.next = null;
            return tail;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)


}