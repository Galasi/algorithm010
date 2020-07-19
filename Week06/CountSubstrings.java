package com.galasi.algorithm.leetCode.sevenMonth.tewDay;

//647. 回文子串
//https://leetcode-cn.com/problems/palindromic-substrings/
public class CountSubstrings {

    //时间复杂度为O(N^2)
    // 空间复杂度为O(N^2)
    public static int countSubstrings (String s) {
        int n = s.length();
        //动态规划法
        int dp[][] = new int[n][n];
        int nums = s.length();

        for (int i = n - 1; i >= 0; i--) {
            dp[i][i] = 1;
            for (int j = i + 1; j < n; j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    if (j - i < 3) {
                        dp[i][j] = 1;
                    } else {
                        dp[i][j] = dp[i + 1][j - 1];
                    }
                }
                if (dp[i][j] == 1) {
                    nums++;
                }
            }
        }
        return nums;

    }


    static int count = 0;

    //双指针递归法
    public static int countSubstrings2 (String s) {
        if (s == null || s.length() == 0) return 0;

        for (int i = 0; i < s.length(); i++) { // i is the mid point
            extendPalindrome(s, i, i); // odd length;
            extendPalindrome(s, i, i + 1); // even length
        }

        return count;
    }

    private static void extendPalindrome (String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            count++;
            left--;
            right++;
        }
    }

    public static void main(String[] args) {
        System.out.println(countSubstrings("aaa"));
        System.out.println(countSubstrings2("aaa"));
    }
}
