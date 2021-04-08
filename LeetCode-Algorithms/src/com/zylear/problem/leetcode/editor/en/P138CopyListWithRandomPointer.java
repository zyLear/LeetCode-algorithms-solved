package com.zylear.problem.leetcode.editor.en;

//A linked list of length n is given such that each node contains an additional 
//random pointer, which could point to any node in the list, or null. 
//
// Construct a deep copy of the list. The deep copy should consist of exactly n 
//brand new nodes, where each new node has its value set to the value of its corre
//sponding original node. Both the next and random pointer of the new nodes should
// point to new nodes in the copied list such that the pointers in the original li
//st and copied list represent the same list state. None of the pointers in the ne
//w list should point to nodes in the original list. 
//
// For example, if there are two nodes X and Y in the original list, where X.ran
//dom --> Y, then for the corresponding two nodes x and y in the copied list, x.ra
//ndom --> y. 
//
// Return the head of the copied linked list. 
//
// The linked list is represented in the input/output as a list of n nodes. Each
// node is represented as a pair of [val, random_index] where: 
//
// 
// val: an integer representing Node.val 
// random_index: the index of the node (range from 0 to n-1) that the random poi
//nter points to, or null if it does not point to any node. 
// 
//
// Your code will only be given the head of the original linked list. 
//
// 
// Example 1: 
//
// 
//Input: head = [[7,null],[13,0],[11,4],[10,2],[1,0]]
//Output: [[7,null],[13,0],[11,4],[10,2],[1,0]]
// 
//
// Example 2: 
//
// 
//Input: head = [[1,1],[2,1]]
//Output: [[1,1],[2,1]]
// 
//
// Example 3: 
//
// 
//
// 
//Input: head = [[3,null],[3,0],[3,null]]
//Output: [[3,null],[3,0],[3,null]]
// 
//
// Example 4: 
//
// 
//Input: head = []
//Output: []
//Explanation: The given linked list is empty (null pointer), so return null.
// 
//
// 
// Constraints: 
//
// 
// 0 <= n <= 1000 
// -10000 <= Node.val <= 10000 
// Node.random is null or is pointing to some node in the linked list. 
// 
// Related Topics Hash Table Linked List 
// 👍 4967 👎 809


import com.zylear.problem.leetcode.editor.en.base.Node;

import java.util.HashMap;
import java.util.Map;

public class P138CopyListWithRandomPointer {
    public static void main(String[] args) {
        // Solution solution = new P138CopyListWithRandomPointer().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

    class Solution {
        //利用map   先遍历一遍初始化map 再遍历一遍查询random easy
        public Node copyRandomList(Node head) {
            if (head == null) {
                return null;
            }

            Map<Node, Node> map = new HashMap<>();

            Node sentinel = new Node(0);
            Node current = sentinel;

            Node node = head;
            while (node != null) {

                Node next = new Node(node.val);
                map.put(node, next);


                current.next = next;

                current = current.next;
                node = node.next;
            }
            node = head;
            current = sentinel.next;
            while (node != null) {
                if (node.random != null) {
                    current.random = map.get(node.random);
                }
                node = node.next;
                current = current.next;
            }


            return sentinel.next;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}
