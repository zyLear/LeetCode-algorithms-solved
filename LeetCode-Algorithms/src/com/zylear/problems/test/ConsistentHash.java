package com.zylear.problems.test;

import java.util.SortedMap;
import java.util.TreeMap;

public class ConsistentHash {

    // 环形节点（包括虚拟节点）   SortedMap有序map实现  方便
    private TreeMap<Long, Node> circle = new TreeMap<>();
    // 每个机器节点关联的虚拟节点个数
    private int numberOfReplicas = 1;


    public Node get(String id) {

        if (circle.isEmpty()) {
            return null;
        }

        Long hash = hash(id);
        if (!circle.containsKey(hash)) {
            // 沿环的顺时针找到下一个虚拟节点
            //tailMap方法返回一个map里面的key都大于等于key，所以firstKey就是要找的节点
            SortedMap<Long, Node> tailMap = circle.tailMap(hash);
            //如果没有比它大的映射到第一个节点
            hash = tailMap.isEmpty() ? circle.firstKey() : tailMap.firstKey();
        }
        // 返回该虚拟节点对应的真实机器节点的信息
        return circle.get(hash);
    }


    /**
     * 增加机器节点
     *
     * @param node
     */
    public void add(Node node) {
        for (int i = 0; i < this.numberOfReplicas; i++) {
            circle.put(hash(node.getIp() + i), node);
        }
    }

    /**
     * 删除机器节点
     *
     * @param node
     */
    public void remove(Node node) {
        for (int i = 0; i < this.numberOfReplicas; i++) {
            circle.remove(hash(node.getIp() + i));
        }
    }

    //hash 方法 先随便实现
    private Long hash(String id) {
//        return (long) id.hashCode();
        return Long.valueOf(id);

    }


    public static class Node {
        private String ip;
        private String name;

        public Node(String ip, String name) {
            this.ip = ip;
            this.name = name;
        }

        public String getIp() {
            return ip;
        }

        public void setIp(String ip) {
            this.ip = ip;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }


    public static void main(String[] args) {
        ConsistentHash consistentHash = new ConsistentHash();
        consistentHash.add(new Node("1", "1"));
        consistentHash.add(new Node("2", "2"));

        System.out.println(consistentHash.get("4").getName());
        System.out.println(consistentHash.get("3").getName());
        System.out.println();
        System.out.println(consistentHash.get("20").getName());
        System.out.println(consistentHash.get("1").getName());

    }

}
