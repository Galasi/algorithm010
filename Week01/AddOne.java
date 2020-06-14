package com.galasi.algorithm.leetCode.sixMoth.six14;

import java.util.Arrays;

public class AddOne {

    public static int[] addOne(int[] ints) {
        if (ints.length == 0) {
            return ints;
        }
        //末位小于9，直接加一
        for (int i = ints.length - 1; i >= 0; i--) {
            if (ints[i] == 9) {
                ints[i] = 0;
            }else {
                ints[i] = ints[i] + 1;
                return ints;
            }
        }
        //最后一种情况，所有位都是9，则ints需要进一位
        int[] ints2 = new int[ints.length+1];
        ints2[0] = 1;
        return ints2;
    }

    //简化代码
    public static int[] addOne2(int[] ints) {
        for (int i = ints.length - 1; i >= 0; i--) {
            ints[i] += 1;
            if (ints[i] <= 9) {
                return ints;
            }else {
                ints[i] = 0;
            }
        }
        //最后一种情况，所有位都是9，则ints需要进一位
        int[] ints2 = new int[ints.length+1];
        ints2[0] = 1;
        return ints2;
    }

    public static void main(String[] args) {
        int[] a = {8, 9, 9,9};
        System.out.println(Arrays.toString(addOne2(a)));
    }
}
