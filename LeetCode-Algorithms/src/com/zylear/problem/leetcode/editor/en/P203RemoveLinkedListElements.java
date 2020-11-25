package com.zylear.problem.leetcode.editor.en;

//Remove all elements from a linked list of integers that have value val. 
//
// Example: 
//
// 
//Input:  1->2->6->3->4->5->6, val = 6
//Output: 1->2->3->4->5
// 
// Related Topics Linked List 
// 👍 2171 👎 107


import com.zylear.problem.leetcode.editor.en.P160IntersectionOfTwoLinkedLists.ListNode;

public class P203RemoveLinkedListElements{
    public static void main(String[] args) {
        Solution solution = new P203RemoveLinkedListElements().new Solution();
        // TO TEST
    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    /**
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode() {}
     *     ListNode(int val) { this.val = val; }
     *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */
    class Solution {
        public ListNode removeElements(ListNode head, int val) {
            ListNode first = new ListNode();
            first.next = head;
            ListNode current = first;
            while (current.next != null) {
                if (current.next.val == val) {
                    current.next = current.next.next;
                }else {
                    current = current.next;
                }
            }
            return first.next;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)
}

