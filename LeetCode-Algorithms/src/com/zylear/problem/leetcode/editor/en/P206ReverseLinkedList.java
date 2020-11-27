package com.zylear.problem.leetcode.editor.en;

//Reverse a singly linked list. 
//
// Example: 
//
// 
//Input: 1->2->3->4->5->NULL
//Output: 5->4->3->2->1->NULL
// 
//
// Follow up: 
//
// A linked list can be reversed either iteratively or recursively. Could you im
//plement both? 
// Related Topics Linked List 
// 👍 5677 👎 109


import com.zylear.problem.leetcode.editor.en.base.ListNode;

public class P206ReverseLinkedList {
    public static void main(String[] args) {
        Solution solution = new P206ReverseLinkedList().new Solution();
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

        public ListNode reverseList(ListNode head) {

            if (head == null) {
                return null;
            }

            ListNode prevNode = null;
            ListNode currentNode = head;

            while (currentNode != null) {
                ListNode temp = currentNode.next;
                currentNode.next = prevNode;
                prevNode = currentNode;
                currentNode = temp;
            }
            return prevNode;

        }

        public ListNode reverseList1(ListNode head) {
            if (head == null || head.next == null) {
                return head;
            } else {
                ListNode next = head.next;
                ListNode reverse = reverseList1(next);
                next.next = head;
                head.next = null;
                return reverse;
            }
        }

//        public ListNode reverse(ListNode first, ListNode second) {
//            if (second == null) {
//                return first;
//            }else {
//                ListNode reverse = reverse(second, second.next);
//                second.next = first;
//                return reverse;
//            }
//        }

    }
    //leetcode submit region end(Prohibit modification and deletion)


}

