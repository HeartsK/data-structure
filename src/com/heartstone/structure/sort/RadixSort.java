package com.heartstone.structure.sort;

import java.util.Arrays;

/**
 * @author code generator
 * @date 2022-06-06 16:33
 */
public class RadixSort {

    public static void main(String[] args) {
        int[] arr = new int[]{53,3,542,748,14,214};
        radixSort(arr);
    }

    public static void radixSort(int[] arr){

        //基数排序是在桶排序基的一种应用
        //1、创建是个桶，桶下标代表数的位数
        int[][] bucket = new int[10][arr.length];
        //2、创建计入对应位数桶存储的数据个数
        int[] bucketCounts = new int[10];
        //3、求出数组最大值
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max){
                max = arr[i];
            }
        }
        int length = (max+"").length();
        for (int i = 0, n = 1; i < length; i++, n *= 10) {
            for (int value : arr) {
                //获取对应数据个位数
                int k = value / n % 10;
                //将对应下标数据放入桶中
                bucket[k][bucketCounts[k]] = value;
                //进行对应下标桶中数据计数
                bucketCounts[k]++;
            }
            int index = 0;
            //在将桶中数据依次放回到arr数组中
            for (int j = 0; j < bucketCounts.length; j++) {
                if (bucketCounts[j] > 0){
                    for (int h = 0; h < bucketCounts[j]; h++) {
                        arr[index] = bucket[j][h];
                        index++;
                    }
                }
                bucketCounts[j] = 0;
            }
            System.out.println(Arrays.toString(arr));
        }

    }
}
