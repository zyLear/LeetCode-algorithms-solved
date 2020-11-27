package com.zylear.problem.leetcode.editor.en;

//Given a sorted linked list, delete all duplicates such that each element appea
//r only once. 
//
// Example 1: 
//
// 
//Input: 1->1->2
//Output: 1->2
// 
//
// Example 2: 
//
// 
//Input: 1->1->2->3->3
//Output: 1->2->3
// 
// Related Topics Linked List 
// 👍 1978 👎 131


import com.zylear.problem.leetcode.editor.en.base.ListNode;

public class P83RemoveDuplicatesFromSortedList {
    public static void main(String[] args) {
//        Solution solution = new P83RemoveDuplicatesFromSortedList().new Solution();
//                Solution solution =new Solution();

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
        public ListNode deleteDuplicates(ListNode head) {
            if (head == null) {
                return null;
            }
            ListNode current = head;
            while (current != null && current.next != null) {
                if (current.val == current.next.val) {
                    current.next = current.next.next;
                } else {
                    current = current.next;
                }
            }

            return head;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)
}

