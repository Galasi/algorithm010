package com.galasi.algorithm.leetCode.sixMoth.six10;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {

    public static int[] twoSum(int[] ints ,int target){
        if(ints.length == 0){
            return ints;
        }
        for (int i=0; i<ints.length; i++) {
            for(int j=i+1; j<ints.length; j++){
                if(ints[i]+ints[j] == target){
                    return new int[]{i,j};
                }
            }
        }
        return ints;
    }

    public static int[] twoSum2(int[] numbers , int target){
        int[] result = new int[2];
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < numbers.length; i++) {
            if (map.containsKey(target - numbers[i])) {
                result[1] = i;
                result[0] = map.get(target - numbers[i]);
                return result;
            }
            map.put(numbers[i], i);
        }
        return result;
    }

    public static void main(String[] args) {
        int[] a = {3,2,3};
//        int[] a = {2, 7, 11, 15};
        System.out.println(twoSum2(a,9));
    }
}
