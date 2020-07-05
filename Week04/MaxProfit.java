package com.galasi.algorithm.leetCode.sevenMonth.fiveDay;

//122. 买卖股票的最佳时机 II
//https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-ii/description/
public class MaxProfit {

    public static int maxProfit(int[] prices) {
        return calculate(prices, 0);
    }

    //暴力求解法
    //时间复杂度：O(n^n)
    public static int calculate(int prices[], int s) {
        if (s >= prices.length)
            return 0;
        int max = 0;
        for (int start = s; start < prices.length; start++) {
            int maxprofit = 0;
            for (int i = start + 1; i < prices.length; i++) {
                if (prices[start] < prices[i]) {
                    int profit = calculate(prices, i + 1) + prices[i] - prices[start];
                    if (profit > maxprofit)
                        maxprofit = profit;
                }
            }
            if (maxprofit > max)
                max = maxprofit;
        }
        return max;
    }

    //峰谷法 时间复杂度：O(n)O(n)。遍历一次
    public static int maxProfit2(int[] prices) {
        int i = 0;
        int valley = prices[0];
        int peak = prices[0];
        int maxprofit = 0;
        while (i < prices.length - 1) {
            while (i < prices.length - 1 && prices[i] >= prices[i + 1])
                i++;
            valley = prices[i];
            while (i < prices.length - 1 && prices[i] <= prices[i + 1])
                i++;
            peak = prices[i];
            maxprofit += peak - valley;
        }
        return maxprofit;
    }

    //简单的一次遍历
    // 时间复杂度：O(n)O(n)，遍历一次
    public static int maxProfit3(int[] prices) {
        int maxprofit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1])
                maxprofit += prices[i] - prices[i - 1];
        }
        return maxprofit;
    }

    public static void main(String[] args) {
        int[]  ints = new int[]{7,1,5,3,6,4};
        System.out.println(maxProfit(ints));
        System.out.println(maxProfit2(ints));
        System.out.println(maxProfit3(ints));
    }

}
