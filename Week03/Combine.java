package com.galasi.algorithm.leetCode.sixMoth.six28;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 77. 组合
 * https://leetcode-cn.com/problems/combinations/
 * */
public class Combine {

    private static List<List<Integer>> returnPut = new LinkedList();

    public static final int n = 0;
    public static final int k=0;

    public static void backtrack(int first, LinkedList<Integer> curr) {
        // 校验
        if (curr.size() == k) {
            returnPut.add(new LinkedList(curr));
        }

        for (int i = first; i < n + 1; ++i) {
            curr.add(i);
            backtrack(i + 1, curr);
            curr.removeLast();
        }
    }

    public static List<List<Integer>> combine(int n, int k) {
        n = n;
        k = k;
        backtrack(1, new LinkedList<Integer>());
        return returnPut;
    }


    public static List<List<Integer>> combine2(int n, int k) {
        LinkedList<Integer> nums = new LinkedList<Integer>();
        for(int i = 1; i < k + 1; ++i) {
            nums.add(i);
            nums.add(n + 1);
        }

        List<List<Integer>> output = new ArrayList<List<Integer>>();
        int j = 0;
        while (j < k) {
            output.add(new LinkedList(nums.subList(0, k)));
            j = 0;
            while ((j < k) && (nums.get(j + 1) == nums.get(j) + 1)) {
                nums.set(j, j++ + 1);
                nums.set(j, nums.get(j) + 1);
            }
        }
        return output;
    }


    public static void main(String[] args) {
        System.out.println(combine2(4,2));
    }

}
