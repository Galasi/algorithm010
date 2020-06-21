package com.galasi.algorithm.leetCode.sixMoth.six21;

import java.util.*;

// 49.字母异位词分组
//https://leetcode-cn.com/problems/group-anagrams/
public class GroupAnagrams {

    public static List<List<String>> groupAnagrams(String[] strs) {
        if (strs == null || strs.length == 0) return new ArrayList();
        Map<String, List> ans = new HashMap<String, List>();
        for (String s : strs) {
            char[] ca = s.toCharArray();
            Arrays.sort(ca);
            //将 char 变量 ca 转换成字符串
            String key = String.valueOf(ca);
            if (!ans.containsKey(key)) {
                ans.put(key, new ArrayList<String>());
            }
            ans.get(key).add(s);
        }
        return new ArrayList(ans.values());
    }

    //时间复杂度：O(NK \log K)O(NKlogK)
    //空间复杂度：O(NK)O(NK)
    public static List<List<String>> groupAnagrams2(String[] strs) {
        if (strs == null || strs.length == 0) {
            return new ArrayList<>();
        }
        HashMap<String, List<String>> ansMap = new HashMap<>();
        for (String str : strs) {
            char[] ca = str.toCharArray();
            Arrays.sort(ca);
            String key = String.valueOf(ca);
            if (!ansMap.containsKey(key)) {
                ansMap.put(key, new ArrayList<>());
            }
            ansMap.get(key).add(str);
        }
        return new ArrayList<>(ansMap.values());
    }


    public static List<List<String>> groupAnagrams3(String[] strs) {
        if (strs == null || strs.length == 0) return new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();
        for (String s : strs) {
            char[] ca = new char[26];
            //这里本质上也是排序
            for (char c : s.toCharArray()) {
                //加一
                ca[c - 'a']++;
            }
            String keyStr = String.valueOf(ca);
            if (!map.containsKey(keyStr)) {
                map.put(keyStr, new ArrayList<>());
            }
            map.get(keyStr).add(s);
        }
        return new ArrayList<>(map.values());
    }

    public static void main(String[] args) {
        String[] strs = new String[]{"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println(groupAnagrams3(strs));
    }
}
