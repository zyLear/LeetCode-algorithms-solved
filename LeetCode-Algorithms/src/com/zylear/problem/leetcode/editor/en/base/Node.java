package com.zylear.problem.leetcode.editor.en.base;

import com.zylear.problem.leetcode.editor.en.P133CloneGraph;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xiezongyu
 * @date 2020/12/9
 */
public class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;
    public Node random;
    public List<Node> neighbors;

    public Node() {}

    public Node(int _val) {
        val = _val;
        this.next = null;
        this.random = null;
        neighbors = new ArrayList<Node>();
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }

    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
};
