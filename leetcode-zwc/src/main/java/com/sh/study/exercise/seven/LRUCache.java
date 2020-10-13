package com.sh.study.exercise.seven;

import java.util.HashMap;
import java.util.Map;

/**
 * 146. LRU缓存机制
 * 运用你所掌握的数据结构，设计和实现一个  LRU (最近最少使用) 缓存机制。它应该支持以下操作： 获取数据 get 和 写入数据 put 。
 *
 * 获取数据 get(key) - 如果关键字 (key) 存在于缓存中，则获取关键字的值（总是正数），否则返回 -1。
 * 写入数据 put(key, value) - 如果关键字已经存在，则变更其数据值；如果关键字不存在，则插入该组「关键字/值」。当缓存容量达到上限时，它应该在写入新数据之前删除最久未使用的数据值，从而为新的数据值留出空间。
 *
 *
 *
 * 进阶:
 *
 * 你是否可以在 O(1) 时间复杂度内完成这两种操作？
 *
 *
 *
 * 示例:
 *
 * LRUCache cache = new LRUCache( 2  缓存容量  );
        *
        *cache.put(1,1);
        *cache.put(2,2);
        *cache.get(1);       // 返回  1
        *cache.put(3,3);    // 该操作会使得关键字 2 作废
        *cache.get(2);       // 返回 -1 (未找到)
        *cache.put(4,4);    // 该操作会使得关键字 1 作废
        *cache.get(1);       // 返回 -1 (未找到)
        *cache.get(3);       // 返回  3
        *cache.get(4);       // 返回  4
 *
 * @Author zhouwenchen
 * @Date  2020-09-27
 **/
public class LRUCache {

    class ListNode{
        public int key,val;
        public ListNode next;
        public ListNode(int key,int val){
            this.key = key;
            this.val = val;
            this.next = null;
        }
    }

    /**
     * 使用双向链表 和 Hash实现
     * @param capacity
     */
    private  int capacity,size;
    private  ListNode dummy, tail;
    private  Map<Integer, ListNode> keyToPrev;
    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.keyToPrev = new HashMap<>();
        this.dummy = new ListNode(0,0);
        this.tail = dummy;
    }

    private void moveToTail(int key){
        ListNode pre = keyToPrev.get(key);
        ListNode cur = pre.next;
        if(tail == cur){
            return;
        }

        pre.next = pre.next.next; // 删除key 这个节点
        tail.next = cur; // 将这个节点放置到链表的末尾处

        if(pre.next != null){
            keyToPrev.put(pre.next.key,pre);
        }
        keyToPrev.put(cur.key,tail);

        tail = cur;
    }

    public int get(int key) {
        if(!keyToPrev.containsKey(key)){
            return -1;
        }
        moveToTail(key);
        return tail.val;
    }

    public void put(int key, int value) {
        if(get(key)!= -1){
            ListNode pre = keyToPrev.get(key);
            pre.next.val = value;
            return;
        }

        if(size < capacity){
            size++;
            ListNode cur = new ListNode(key,value);
            tail.next = cur;
            keyToPrev.put(key,tail);

            tail = cur;
            return;
        }

        // replace the first node with new key, value
        ListNode first = dummy.next;
        keyToPrev.remove(first.key);
        first.key= key;
        first.val = value;

        keyToPrev.put(key,dummy);

        moveToTail(key);
    }

    /**
     * cache.put(1, 1);
     * cache.put(2, 2);
     * cache.get(1);       // 返回  1
     * cache.put(3, 3);    // 该操作会使得关键字 2 作废
     * cache.get(2);       // 返回 -1 (未找到)
     * cache.put(4, 4);    // 该操作会使得关键字 1 作废
     * cache.get(1);       // 返回 -1 (未找到)
     * cache.get(3);       // 返回  3
     * cache.get(4);       // 返回  4
     * @param args
     */
    public static void main(String[] args) {
        LRUCache lruCache = new LRUCache(2);
        lruCache.put(1,1);
        lruCache.put(2,2);
        System.out.println(lruCache.get(1));
        lruCache.put(3,3);
        System.out.println(lruCache.get(2));
        lruCache.put(4,4);
        System.out.println(lruCache.get(1));
        System.out.println(lruCache.get(3));
        System.out.println(lruCache.get(4));
    }
}
