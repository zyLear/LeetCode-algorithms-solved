package com.zylear.problem.leetcode.editor.en;

//You are given an array of k linked-lists lists, each linked-list is sorted in 
//ascending order. 
//
// Merge all the linked-lists into one sorted linked-list and return it. 
//
// 
// Example 1: 
//
// 
//Input: lists = [[1,4,5],[1,3,4],[2,6]]
//Output: [1,1,2,3,4,4,5,6]
//Explanation: The linked-lists are:
//[
//  1->4->5,
//  1->3->4,
//  2->6
//]
//merging them into one sorted list:
//1->1->2->3->4->4->5->6
// 
//
// Example 2: 
//
// 
//Input: lists = []
//Output: []
// 
//
// Example 3: 
//
// 
//Input: lists = [[]]
//Output: []
// 
//
// 
// Constraints: 
//
// 
// k == lists.length 
// 0 <= k <= 10^4 
// 0 <= lists[i].length <= 500 
// -10^4 <= lists[i][j] <= 10^4 
// lists[i] is sorted in ascending order. 
// The sum of lists[i].length won't exceed 10^4. 
// 
// Related Topics Linked List Divide and Conquer Heap 
// 👍 5905 👎 319


import com.zylear.problem.leetcode.editor.en.base.ListNode;

public class P23MergeKSortedLists {
    public static void main(String[] args) {
        Solution solution = new P23MergeKSortedLists().new Solution();
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
        public ListNode mergeKLists(ListNode[] lists) {

            return mergeKLists(lists, 0, lists.length - 1);

        }

        public ListNode mergeKLists(ListNode[] lists, int start, int end) {
            if (start == end) {
                return lists[start];
            } else if (start > end) {
                return null;
            } else {

                int mid = start + ((end - start) / 2);

                ListNode left = mergeKLists(lists, start, mid);
                ListNode right = mergeKLists(lists, mid + 1, end);
                return mergeTwoLists(left, right);
            }
        }

        private ListNode mergeTwoLists(ListNode left, ListNode right) {

            if (left == null) {
                return right;
            } else if (right == null) {
                return left;
            }
            ListNode result = new ListNode();
            ListNode head = result;
            while (left != null && right != null) {

                if (left.val < right.val) {
                    result.next = left;
                    left = left.next;
                    result = result.next;
                    result.next = null;
                } else {
                    result.next = right;
                    right = right.next;
                    result = result.next;
                    result.next = null;
                }
            }
            result.next = (left == null ? right : left);


            return head.next;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}