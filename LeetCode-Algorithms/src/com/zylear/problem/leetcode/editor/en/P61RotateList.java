package com.zylear.problem.leetcode.editor.en;

//Given the head of a linked list, rotate the list to the right by k places. 
//
// 
// Example 1: 
//
// 
//Input: head = [1,2,3,4,5], k = 2
//Output: [4,5,1,2,3]
// 
//
// Example 2: 
//
// 
//Input: head = [0,1,2], k = 4
//Output: [2,0,1]
// 
//
// 
// Constraints: 
//
// 
// The number of nodes in the list is in the range [0, 500]. 
// -100 <= Node.val <= 100 
// 0 <= k <= 2 * 109 
// 
// Related Topics Linked List Two Pointers 
// 👍 1996 👎 1114


import com.zylear.problem.leetcode.editor.en.base.ListNode;

public class P61RotateList {
    public static void main(String[] args) {
        // Solution solution = new P61RotateList().new Solution();
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
        public ListNode rotateRight(ListNode head, int k) {
            if (head == null || k == 0) {
                return head;
            }
            //找到 尾结点 长度
            int size = 0;
            ListNode tail = head;
            ListNode current = head;
            while (current != null) {
                tail = current;
                size++;
                current = current.next;
            }
            k = k % size;
            if (k == 0) {
                return head;
            }
            //找到倒数第k+1个结点
            int n = k + 1;

            ListNode slow = head;
            ListNode fast = head;
            while (n-- > 0) {
                fast = fast.next;
            }
            while (fast != null) {
                fast = fast.next;
                slow = slow.next;
            }

            //断开 重新连接
            ListNode next = slow.next;
            slow.next = null;
            tail.next = head;

            return next;
        }

    }
    //leetcode submit region end(Prohibit modification and deletion)

}
