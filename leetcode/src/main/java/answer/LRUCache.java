package main.java.answer;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class LRUCache {

    public class LRUCacheNode {
        Integer key;
        Integer val;
        LRUCacheNode next;
        LRUCacheNode pre;
        public LRUCacheNode() {

        }
        public LRUCacheNode(Integer key, Integer value) {
            this.key = key;
            this.val = value;
        }
    }

    private final Map<Integer, LRUCacheNode> hashMap;
    private final LRUCacheNode head = new LRUCacheNode();
    private final LRUCacheNode tail = new LRUCacheNode();
    int size;
    public LRUCache(int capacity) {
        hashMap = new HashMap<>(capacity);
        this.size = capacity;
        head.next = tail;
        tail.pre = head;
    }

    public int get(int key) {
        if (hashMap.containsKey(key)) {
            LRUCacheNode nowNode = hashMap.get(key);
            nowNode.next.pre = nowNode.pre;
            nowNode.pre.next = nowNode.next;
            nowNode.next = head.next;
            nowNode.pre = head;
            head.next.pre = nowNode;
            head.next = nowNode;
            return nowNode.val;
        }
        else {
            return -1;
        }
    }

    public void put(int key, int value) {
        LRUCacheNode newNode = new LRUCacheNode(key, value);
        if (hashMap.containsKey(key)) {
            LRUCacheNode nowNode = hashMap.get(key);
            nowNode.next.pre = nowNode.pre;
            nowNode.pre.next = nowNode.next;
        }
        else {
            if (hashMap.size() == size) {
                hashMap.remove(tail.pre.key);
                tail.pre = tail.pre.pre;
                tail.pre.next = tail;
            }
        }
        hashMap.put(key, newNode);
        newNode.next = head.next;
        newNode.pre = head;
        head.next.pre = newNode;
        head.next = newNode;
    }
//    ["LRUCache","put","put","get","put","get","put","get","get","get"]
//    [[2],       [1,0], [2,2],[1],  [3,3],[2],  [4,4],[1],  [3],  [4]]
    public static void main(String[] args) {
        LRUCache lRUCache = new LRUCache(2);
        lRUCache.put(1, 0); // 缓存是 {1=1}
        lRUCache.put(2, 2); // 缓存是 {1=1}
        lRUCache.get(1);    // 返回 1
        lRUCache.put(3, 3); // 该操作会使得关键字 2 作废，缓存是 {1=1, 3=3}
        lRUCache.get(2);    // 返回 -1 (未找到)
        lRUCache.put(4, 4); // 该操作会使得关键字 1 作废，缓存是 {4=4, 3=3}
        lRUCache.get(1);    // 返回 -1 (未找到)
        lRUCache.get(3);    // 返回 3
        lRUCache.get(4);    // 返回 4
    }
}
