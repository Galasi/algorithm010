package com.galasi.algorithm.leetCode.sixMoth.six21;

import java.util.*;

//347. 前 K 个高频元素
//给定一个非空的整数数组，返回其中出现频率前 k 高的元素。
//输入: nums = [1,1,1,2,2,3], k = 2
//输出: [1,2]
public class TopKFrequent {

    public static List<Integer> topKFrequent(int[] nums, int K) {
        HashMap<Integer,Integer> hashMap = new HashMap<>();
        for(int n:nums){
            hashMap.put(n,hashMap.getOrDefault(n,0)+1);
        }
        //优先队列
        PriorityQueue<Integer> priorityQueue =
                new PriorityQueue<Integer>((n1,n2) -> hashMap.get(n1) - hashMap.get(n2));
        //map包含的键的 set 视图
        for(int n: hashMap.keySet()){
            priorityQueue.add(n);
            if(priorityQueue.size()>K){
                priorityQueue.poll();
            }
        }

        List<Integer> topK = new ArrayList<Integer>();
        while (!priorityQueue.isEmpty()){
            topK.add(priorityQueue.poll());
        }
        Collections.reverse(topK);
        return topK;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 1, 1, 2, 2, 3};
        System.out.println(topKFrequent2(nums,2));
    }

    public static List<Integer> topKFrequent2(int[] nums, int k) {
        // build hash map : character and how often it appears
        HashMap<Integer, Integer> count = new HashMap();
        for (int n: nums) {
            count.put(n, count.getOrDefault(n, 0) + 1);
        }

        // init heap 'the less frequent element first'
        PriorityQueue<Integer> heap =
                new PriorityQueue<Integer>((n1, n2) -> count.get(n1) - count.get(n2));

        // keep k top frequent elements in the heap
        for (int n: count.keySet()) {
            heap.add(n);
            if (heap.size() > k)
                heap.poll();
        }

        // build output list
        List<Integer> top_k = new LinkedList();
        while (!heap.isEmpty())
            top_k.add(heap.poll());
        Collections.reverse(top_k);
        return top_k;
    }



}
