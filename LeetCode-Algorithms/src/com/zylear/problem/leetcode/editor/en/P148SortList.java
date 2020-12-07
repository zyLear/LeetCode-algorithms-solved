package com.zylear.problem.leetcode.editor.en;

//Given the head of a linked list, return the list after sorting it in ascending
// order. 
//
// Follow up: Can you sort the linked list in O(n logn) time and O(1) memory (i.
//e. constant space)? 
//
// 
// Example 1: 
//
// 
//Input: head = [4,2,1,3]
//Output: [1,2,3,4]
// 
//
// Example 2: 
//
// 
//Input: head = [-1,5,3,4,0]
//Output: [-1,0,3,4,5]
// 
//
// Example 3: 
//
// 
//Input: head = []
//Output: []
// 
//
// 
// Constraints: 
//
// 
// The number of nodes in the list is in the range [0, 5 * 104]. 
// -105 <= Node.val <= 105 
// 
// Related Topics Linked List Sort 
// 👍 3616 👎 157


import com.zylear.problem.leetcode.editor.en.base.ListNode;

public class P148SortList {
    public static void main(String[] args) {
        Solution solution = new P148SortList().new Solution();
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


        public ListNode sortList(ListNode head) {
            if (head == null || head.next == null) {
                return head;
            }
            ListNode midNode = getMidNodeAndCut(head);

            head = sortList(head);
            midNode = sortList(midNode);

            return merge(head, midNode);
        }

        private ListNode merge(ListNode head, ListNode tail) {
            ListNode result = new ListNode();
            ListNode current = result;

            while (head != null || tail != null) {

                if (head == null) {
                    current.next = tail;
                    break;
                } else if (tail == null) {
                    current.next = head;
                    break;
                } else {
                    if (head.val < tail.val) {
                        current.next = head;
                        head = head.next;
                    } else {
                        current.next = tail;
                        tail = tail.next;
                    }
                    current = current.next;
                    current.next = null;
                }
            }

            return result.next;
        }


        //get and cut
        private ListNode getMidNodeAndCut(ListNode head) {

            if (head == null) {
                return null;
            } else {
                ListNode prev = null;
                ListNode fast = head;
                ListNode slow = head;
                while (fast != null && fast.next != null) {
                    prev = slow;
                    fast = fast.next.next;
                    slow = slow.next;
                }
                if (prev != null) {
                    prev.next = null;
                }
                return slow;

            }


        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}