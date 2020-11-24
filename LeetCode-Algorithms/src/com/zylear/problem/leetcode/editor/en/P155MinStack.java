package com.zylear.problem.leetcode.editor.en;

//Design a stack that supports push, pop, top, and retrieving the minimum elemen
//t in constant time. 
//
// 
// push(x) -- Push element x onto stack. 
// pop() -- Removes the element on top of the stack. 
// top() -- Get the top element. 
// getMin() -- Retrieve the minimum element in the stack. 
// 
//
// 
// Example 1: 
//
// 
//Input
//["MinStack","push","push","push","getMin","pop","top","getMin"]
//[[],[-2],[0],[-3],[],[],[],[]]
//
//Output
//[null,null,null,null,-3,null,0,-2]
//
//Explanation
//MinStack minStack = new MinStack();
//minStack.push(-2);
//minStack.push(0);
//minStack.push(-3);
//minStack.getMin(); // return -3
//minStack.pop();
//minStack.top();    // return 0
//minStack.getMin(); // return -2
// 
//
// 
// Constraints: 
//
// 
// Methods pop, top and getMin operations will always be called on non-empty sta
//cks. 
// 
// Related Topics Stack Design 
// 👍 4159 👎 383


public class P155MinStack {
    public static void main(String[] args) {
//        Solution solution = new P155MinStack().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class MinStack {

        class Node {
            private int value;
            private int min;
            private Node next;
        }

        private Node head;

        /**
         * initialize your data structure here.
         */
        public MinStack() {
        }

        public void push(int x) {
            if (head == null) {
                head = new Node();
                head.value = x;
                head.min = x;
            } else {
                Node node = new Node();
                node.value = x;
                node.min = Math.min(head.min, x);
                node.next = head;
                head = node;
            }

        }

        public void pop() {
            head = head.next;

        }

        public int top() {
            return head.value;
        }

        public int getMin() {
            return head.min;
        }
    }

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
//leetcode submit region end(Prohibit modification and deletion)


}