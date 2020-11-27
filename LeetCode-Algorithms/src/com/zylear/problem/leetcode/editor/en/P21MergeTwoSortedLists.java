package com.zylear.problem.leetcode.editor.en;

//Merge two sorted linked lists and return it as a new sorted list. The new list
// should be made by splicing together the nodes of the first two lists. 
//
// 
// Example 1: 
//
// 
//Input: l1 = [1,2,4], l2 = [1,3,4]
//Output: [1,1,2,3,4,4]
// 
//
// Example 2: 
//
// 
//Input: l1 = [], l2 = []
//Output: []
// 
//
// Example 3: 
//
// 
//Input: l1 = [], l2 = [0]
//Output: [0]
// 
//
// 
// Constraints: 
//
// 
// The number of nodes in both lists is in the range [0, 50]. 
// -100 <= Node.val <= 100 
// Both l1 and l2 are sorted in non-decreasing order. 
// 
// Related Topics Linked List 
// 👍 5382 👎 676


import com.zylear.problem.leetcode.editor.en.base.ListNode;

public class P21MergeTwoSortedLists {
    public static void main(String[] args) {
//        Solution solution = new Solution();
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
        public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
            if (l1 == null && l2 == null) {
                return null;
            }
            ListNode head = new ListNode();
            ListNode list = head;
            while (l1 != null || l2 != null) {

                if (l1 == null) {
                    list.next = l2;
                    l2 = null;
                    continue;
                }
                if (l2 == null) {
                    list.next = l1;
                    l1 = null;
                    continue;
                }

                if (l1.val < l2.val) {
                    list.next = l1;
                    l1 = l1.next;
                    list = list.next;
                } else {
                    list.next = l2;
                    l2 = l2.next;
                    list = list.next;
                }
            }
            return head.next;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}




