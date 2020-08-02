package com.galasi.algorithm.leetCode.fiveMoth.five30;

import java.util.LinkedHashMap;
import java.util.Map;

/**
* 实现本题的两种操作，需要用到一个哈希表和一个双向链表。
 * 在面试中，面试官一般会期望读者能够自己实现一个简单的双向链表，
 * 而不是使用语言自带的、封装好的数据结构。在 Python 语言中，
 * 有一种结合了哈希表与双向链表的数据结构 OrderedDict，
 * 只需要短短的几行代码就可以完成本题。
 *
 * 在 Java 语言中，同样有类似的数据结构 LinkedHashMap。
 * 这些做法都不会符合面试官的要求，
 * 因此下面只给出使用封装好的数据结构实现的代码，而不多做任何阐述。
 *
 * 本题解法采用LinkedHashMap
* */

public class LRUcache extends LinkedHashMap<Integer,Integer> {

    private int capacity;

    public LRUcache(int capacity){
      super(capacity,0.75F,true);
      this.capacity = capacity;
    }

    public int getCapacity(int key){
        return  super.getOrDefault(key,-1);
    }

    public void put(int key,int value){
        super.put(key,value);
    }

    @Override
    public boolean removeEldestEntry(Map.Entry<Integer,Integer> eldest){
        return size() > capacity;
    }

    public static void main(String[] args) {
        LRUcache cache = new LRUcache(2);

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
