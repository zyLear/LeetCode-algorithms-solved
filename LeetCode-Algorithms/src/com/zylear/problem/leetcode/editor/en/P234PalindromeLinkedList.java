package com.zylear.problem.leetcode.editor.en;

//Given a singly linked list, determine if it is a palindrome. 
//
// Example 1: 
//
// 
//Input: 1->2
//Output: false 
//
// Example 2: 
//
// 
//Input: 1->2->2->1
//Output: true 
//
// Follow up: 
//Could you do it in O(n) time and O(1) space? 
// Related Topics Linked List Two Pointers 
// 👍 4120 👎 396


import com.zylear.problem.leetcode.editor.en.base.ListNode;

public class P234PalindromeLinkedList {
    public static void main(String[] args) {
        // Solution solution = new P234PalindromeLinkedList().new Solution();
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
        public boolean isPalindrome(ListNode head) {

            if (head == null) {
                return true;
            }

            //此方法更改了入参  不太规范

            //prev slow  fast
            // 1 -  2  -  1  - null
            //prev slow   fast
            // 1 -  1  -  null
            ListNode slow = head;
            ListNode fast = head;

            while (fast != null && fast.next != null) {
                slow = slow.next;
                fast = fast.next.next;
            }

            ListNode reverseHead = reverseNew(slow);
            while (reverseHead != null) {

                if (head.val != reverseHead.val) {
                    return false;
                }
                reverseHead = reverseHead.next;
                head = head.next;
            }

            return true;
        }

        private ListNode reverseNew(ListNode node) {
            if (node == null || node.next == null) {
                return node;
            }
            ListNode tail = reverseNew(node.next);
            node.next.next = node;
            node.next = null;
            return tail;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
