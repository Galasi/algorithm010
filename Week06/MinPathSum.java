package com.galasi.algorithm.leetCode.sevenMonth.tewDay;


//64. 最小路径和
//https://leetcode-cn.com/problems/minimum-path-sum/

public class MinPathSum {

    //时间复杂度 O(M×N) ： 遍历整个 ints 矩阵元素。
    public static int minPathSum(int[][] ints) {
        int m = ints.length;
        int n = ints[0].length;

        for(int i=1;i<n;i++){
            ints[0][i] += ints[0][i-1];
        }

        for(int i=1;i<m;i++){
            ints[i][0] += ints[i-1][0];
        }

        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
                ints[i][j] += Math.min(ints[i-1][j], ints[i][j-1]);
            }
        }
        return ints[m-1][n-1];
    }


    public static void main(String[] args) {
        int[][] ints = {new int[]{1, 3, 1},
                new int[]{1, 5, 1},
                new int[]{4, 2, 1}};
        System.out.println(minPathSum(ints));
    }

}
