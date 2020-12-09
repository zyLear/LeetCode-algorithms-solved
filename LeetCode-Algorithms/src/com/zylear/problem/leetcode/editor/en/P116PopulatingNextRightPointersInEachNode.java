package com.zylear.problem.leetcode.editor.en;

//You are given a perfect binary tree where all leaves are on the same level, an
//d every parent has two children. The binary tree has the following definition: 
//
// 
//struct Node {
//  int val;
//  Node *left;
//  Node *right;
//  Node *next;
//}
// 
//
// Populate each next pointer to point to its next right node. If there is no ne
//xt right node, the next pointer should be set to NULL. 
//
// Initially, all next pointers are set to NULL. 
//
// 
//
// Follow up: 
//
// 
// You may only use constant extra space. 
// Recursive approach is fine, you may assume implicit stack space does not coun
//t as extra space for this problem. 
// 
//
// 
// Example 1: 
//
// 
//
// 
//Input: root = [1,2,3,4,5,6,7]
//Output: [1,#,2,3,#,4,5,6,7,#]
//Explanation: Given the above perfect binary tree (Figure A), your function sho
//uld populate each next pointer to point to its next right node, just like in Fig
//ure B. The serialized output is in level order as connected by the next pointers
//, with '#' signifying the end of each level.
// 
//
// 
// Constraints: 
//
// 
// The number of nodes in the given tree is less than 4096. 
// -1000 <= node.val <= 1000 
// Related Topics Tree Depth-first Search Breadth-first Search 
// 👍 2811 👎 155


import com.zylear.problem.leetcode.editor.en.base.Node;

import java.util.*;

public class P116PopulatingNextRightPointersInEachNode {
    public static void main(String[] args) {
        // Solution solution = new P116PopulatingNextRightPointersInEachNode().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

    class Solution {


        public Node connect1(Node root) {
            if (root == null) {
                return null;
            }
            connect1(root.left, root.right);
            return root;
        }

        private void connect1(Node left, Node right) {
            if (left == null || right == null) {
                return;
            }
            left.next = right;
            connect1(left.left, left.right);
            connect1(left.right, right.left);
            connect1(right.left, right.right);

        }


        public Node connect(Node root) {

            if (root == null) {
                return null;
            }
            Queue<Node> queue = new LinkedList<>();
            queue.add(root);

            while (!queue.isEmpty()) {
                int size = queue.size();
                Node prev = null;
                for (int i = 0; i < size; i++) {
                    Node node = queue.poll();

                    if (prev != null) {
                        prev.next = node;
                    }
                    prev = node;
                    if (node.left != null) {
                        queue.add(node.left);
                    }
                    if (node.right != null) {
                        queue.add(node.right);
                    }
                }
            }
            return root;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
