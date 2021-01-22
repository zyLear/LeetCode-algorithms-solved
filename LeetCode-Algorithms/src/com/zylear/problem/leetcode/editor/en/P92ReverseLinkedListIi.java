package com.zylear.problem.leetcode.editor.en;

//Reverse a linked list from position m to n. Do it in one-pass. 
//
// Note: 1 ≤ m ≤ n ≤ length of list. 
//
// Example: 
//
// 
//Input: 1->2->3->4->5->NULL, m = 2, n = 4
//Output: 1->4->3->2->5->NULL
// 
// Related Topics Linked List 
// 👍 3213 👎 166


import com.zylear.problem.leetcode.editor.en.base.ListNode;

public class P92ReverseLinkedListIi {
    public static void main(String[] args) {
        // Solution solution = new P92ReverseLinkedListIi().new Solution();
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
        public ListNode reverseBetween(ListNode head, int m, int n) {
            if (head == null || m == n) {
                return head;
            }


            ListNode sentinel = new ListNode();



            return sentinel.next;
        }


    }
    //leetcode submit region end(Prohibit modification and deletion)

}
