package com.zylear.problem.leetcode.editor.en;

//Given the head of a linked list and a value x, partition it such that all node
//s less than x come before nodes greater than or equal to x. 
//
// You should preserve the original relative order of the nodes in each of the t
//wo partitions. 
//
// 
// Example 1: 
//
// 
//Input: head = [1,4,3,2,5,2], x = 3
//Output: [1,2,2,4,3,5]
// 
//
// Example 2: 
//
// 
//Input: head = [2,1], x = 2
//Output: [1,2]
// 
//
// 
// Constraints: 
//
// 
// The number of nodes in the tree is in the range [0, 200]. 
// -100 <= Node.val <= 100 
// -200 <= x <= 200 
// 
// Related Topics Linked List Two Pointers 
// 👍 1784 👎 356


import com.zylear.problem.leetcode.editor.en.base.ListNode;

public class P86PartitionList {
    public static void main(String[] args) {
        // Solution solution = new P86PartitionList().new Solution();
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
        public ListNode partition(ListNode head, int x) {
            if (head == null) {
                return null;
            }
            ListNode firstList = new ListNode();
            ListNode firstPrev = firstList;
            ListNode secondList = new ListNode();
            ListNode secondPrev = secondList;
            //拆成两组链表  easy
            while (head != null) {
                if (head.val < x) {
                    firstPrev.next = head;
                    ListNode next = head.next;
                    head.next = null;
                    firstPrev = firstPrev.next;
                    head = next;
                }else {
                    secondPrev.next = head;
                    ListNode next = head.next;
                    head.next = null;
                    secondPrev = secondPrev.next;
                    head = next;
                }

            }

            firstPrev.next = secondList.next;
            return firstList.next;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}
