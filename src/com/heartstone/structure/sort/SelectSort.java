package com.heartstone.structure.sort;

import java.util.Arrays;

/**
 * 选择排序
 */
public class SelectSort {

    public static void main(String[] args) {
        int[] arrays = new int[]{110,34,109,1};
        sort(arrays);
        System.out.println(Arrays.toString(arrays));
    }

    public static void sort(int[] arrays){
        //思路：每轮中挑选最小的一个数，与当前轮的下标数进行交换
        for (int i = 0; i < arrays.length-1; i++) {
            int minIndex = i;
            int min = arrays[i];
            for (int j = i+1; j < arrays.length; j++) {
                if (min > arrays[j]){
                    //赋值最小值和新的下标
                    min = arrays[j];
                    minIndex = j;
                }
            }
            //交换
            if (minIndex != i){
                arrays[minIndex] = arrays[i];
                arrays[i] = min;
            }
        }
    }
}
