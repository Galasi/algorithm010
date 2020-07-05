package com.galasi.algorithm.leetCode.sevenMonth.fiveDay;

import java.util.Arrays;

//455. 分发饼干
//https://leetcode-cn.com/problems/assign-cookies/description/
public class FindContentChildren {


    public static int findContentChildren(int[] g, int[] s)
    {
        Arrays.sort(g);
        Arrays.sort(s);
        int i = 0;
        int j = 0;
        int count = 0;
        while (i < g.length && j < s.length)
        {
            if(s[j] >= g[i])
            {
                count++;
                i++;
            }
            j++;
        }
        return count;
    }

    public static int findContentChildren2(int[] children, int[] cookies) {
        Arrays.sort(children);
        Arrays.sort(cookies);

        int child = 0;
        for (int cookie = 0; child < children.length && cookie < cookies.length; cookie ++) {
            if (cookies[cookie] >= children[child]) {
                child ++;
            }
        }

        return child;
    }

    public static void main(String[] args) {
        int[] g = new int[]{1,2,3};
        int[] s = new int[]{1,1};
        System.out.println(findContentChildren(g,s));
        System.out.println(findContentChildren2(g,s));
}

}
