package com.zylear;

import java.util.List;

public class TreeTest {

    public static void main(String[] args) {
        TreeNode node = null; //
        int depth = handleDepth(node);
        System.out.println(depth);
    }


    /**
     * 求树的深度，返回的结果从 1 开始， 也就是 {"title" : "Root", "nodeId" : "id-1"} 深度为 1，
     * {"title" : "Root", "nodeId" : "id-1", "children" : [{"title" : "C", "nodeId" : "id-2"}]} 深度为 2
     *
     * @param node node
     * @return 求树的深度
     */
    private static int handleDepth(TreeNode node) {

        if (node == null) {
            return 0;
        }
        int maxDepth = 0;
        for (TreeNode child : node.children) {
            maxDepth = Math.max(maxDepth, handleDepth(child) + 1);
        }

        return maxDepth;
    }

    public static class TreeNode {

        private String nodeId;

        private String parentId;

        private String title;

        private List<TreeNode> children;

        public String getNodeId() {
            return nodeId;
        }

        public void setNodeId(String nodeId) {
            this.nodeId = nodeId;
        }

        public String getParentId() {
            return parentId;
        }

        public void setParentId(String parentId) {
            this.parentId = parentId;
        }

        public List<TreeNode> getChildren() {
            return children;
        }

        public void setChildren(List<TreeNode> children) {
            this.children = children;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }
    }
}