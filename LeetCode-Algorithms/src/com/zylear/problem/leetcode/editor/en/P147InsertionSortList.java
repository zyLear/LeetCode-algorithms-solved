package com.zylear.problem.leetcode.editor.en;

//Sort a linked list using insertion sort. 
//
// 
// 
//
// 
//A graphical example of insertion sort. The partial sorted list (black) initial
//ly contains only the first element in the list. 
//With each iteration one element (red) is removed from the input data and inser
//ted in-place into the sorted list 
// 
//
// 
// 
//
// Algorithm of Insertion Sort: 
//
// 
// Insertion sort iterates, consuming one input element each repetition, and gro
//wing a sorted output list.
// At each iteration, insertion sort removes one element from the input data, fi
//nds the location it belongs within the sorted list, and inserts it there.
// It repeats until no input elements remain.
// 
//
// 
//Example 1: 
//
// 
//Input: 4->2->1->3
//Output: 1->2->3->4
// 
//
// Example 2: 
//
// 
//Input: -1->5->3->4->0
//Output: -1->0->3->4->5
// 
// Related Topics Linked List Sort 
// 👍 897 👎 652


import com.zylear.problem.leetcode.editor.en.base.ListNode;

public class P147InsertionSortList {
    public static void main(String[] args) {
        Solution solution = new P147InsertionSortList().new Solution();
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

        public ListNode insertionSortList(ListNode head) {
            ListNode result = new ListNode();
            while (head != null) {

                ListNode current = result;
                while (current.next != null && head.val >= current.next.val) {
                    current = current.next;
                }

                ListNode currentNext = current.next;
                ListNode headNext = head.next;
                current.next = head;
                head.next=currentNext;
                head = headNext;
            }

            return result.next;
        }
    }


//leetcode submit region end(Prohibit modification and deletion)


}