package com.heartstone.structure.sort;

import java.util.Arrays;

/**
 * 希尔排序
 */
public class ShellSort {

    public static void main(String[] args) {
        int[] arr = new int[]{8,9,1,7,2,3,5,4,6,0};
        shellSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void shellSort(int[] arr){
        int group = arr.length/2;
        int temp;
        for (int i = group; i !=1 ; i /= 2) {
            for (int j = 0; j < arr.length-i; j++) {
                if (arr[j] > arr[j+i]){
                    temp = arr[j];
                    arr[j] = arr[j+i];
                    arr[j+i] = temp;
                }
            }
            System.out.println(Arrays.toString(arr));
        }
    }
}
