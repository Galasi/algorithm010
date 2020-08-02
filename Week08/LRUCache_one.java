package com.galasi.algorithm.leetCode.fiveMoth.five30;

import java.util.HashMap;
import java.util.Map;
//https://leetcode-cn.com/problems/lru-cache/
// 146. LRU缓存机制
public class LRUCache_one {

    class DLinkedNode{
        int key;
        int value;
        public DLinkedNode prev;
        public DLinkedNode next;
        public DLinkedNode(){};
        public DLinkedNode(int key,int value){
            this.key = key;
            this.value = value;
        }
    }

    private Map<Integer,DLinkedNode> cache = new HashMap<Integer,DLinkedNode>();
    private int size;
    private int capacity;
    private DLinkedNode head;
    private DLinkedNode tail;

    public LRUCache_one (int capacity) {
        this.size = 0;
        this.capacity = capacity;
        // 使用伪头部和伪尾部节点
        head = new DLinkedNode();
        tail = new DLinkedNode();
        this.head.next = tail;
        this.tail.prev = head;
    }

    public int get(int key) {
       DLinkedNode node = cache.get(key);
       if( node == null){
           return -1;
       }
       //如果存在key,先通过哈希表定位，再移到头部
        moveToHead(node);
        return node.value;
    }

    private void moveToHead(DLinkedNode node) {
        //先移除
        moveNode(node);
        //添加到头部
        addToHead(node);
    }

    private void addToHead(DLinkedNode node) {
        node.prev = head;
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
    }

    private void moveNode(DLinkedNode node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    public void put(int key, int value) {
        DLinkedNode node = cache.get(key);
        if( node == null ){
            //如果key不存在，创建一个新的节点
            DLinkedNode newNode  = new DLinkedNode(key ,value);
            //添加进 哈希表
            cache.put(key,newNode);
            //添加进双向链表的头部
            addToHead(newNode);
            ++size;
            if(size > capacity){
                //如果size大于初始容量，移除双向链表的尾部节点
                DLinkedNode tail = removeTail();
                cache.remove(tail.key);
                --size;
            }
        }else{
            //如果key存在，想通过哈希表获取，再修改value，并移到头部
            node.value = value;
            moveToHead(node);
        }
    }

    private DLinkedNode removeTail() {
        DLinkedNode res = tail.prev;
        moveNode(res);
        return res;
    }

    public static void main(String[] args) {
        LRUCache_one cache = new LRUCache_one(2);
        cache.put(1, 1);
        cache.put(2, 2);
        cache.get(1);       // 返回  1
        cache.put(3, 3);    // 该操作会使得关键字 2 作废
        cache.get(2);       // 返回 -1 (未找到)
        cache.put(4, 4);    // 该操作会使得关键字 1 作废
        cache.get(1);       // 返回 -1 (未找到)
        cache.get(3);       // 返回  3
        cache.get(4);       // 返回  4

    }
}
