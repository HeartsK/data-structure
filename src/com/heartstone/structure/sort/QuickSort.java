package com.heartstone.structure.sort;

import java.util.Arrays;

/**
 * @author code generator
 * @date 2022-05-31 10:31
 */
public class QuickSort {

    /*private final int reference;*/

    public static void main(String[] args) {
        int[] originalArrays = new int[]{3,7,2,9,1,4,6,8,10,5};
        //每次使用最后一位数作为标签
        sort(originalArrays,0,originalArrays.length-1);
        System.out.println(Arrays.toString(originalArrays));
    }

    public static int divide(int[] originalArrays, int start, int end){
        while (start < end){
            while (start < end && originalArrays[start] <= originalArrays[end]){
                start++;
            }
            //交换位置
            if (start < end){
                int temp = originalArrays[start];
                originalArrays[start] = originalArrays[end];
                originalArrays[end] = temp;
                end--;
            }
            while (start < end && originalArrays[start] <= originalArrays[end]){
                end--;
            }
            //交换位置
            if (start < end){
                int temp = originalArrays[start];
                originalArrays[start] = originalArrays[end];
                originalArrays[end] = temp;
                start++;
            }
        }
        return start;
    }

    public static void sort(int[] originalArrays, int start, int end){
        if (start > end){
            return;
        }
        int divide = divide(originalArrays, start, end);
        sort(originalArrays,start,divide-1);
        sort(originalArrays, divide+1,end);
    }
}
