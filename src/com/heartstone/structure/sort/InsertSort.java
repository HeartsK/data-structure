package com.heartstone.structure.sort;

import java.util.Arrays;

/**
 * 插入排序
 */
public class InsertSort {

    public static void main(String[] args) {
        int[] arr = new int[]{109, 34, 110, 1};
        insertSort(arr);

    }

    public static void insertSort(int[] arr){
        for (int i = 1; i < arr.length; i++) {
            int index = i-1;
            int indexArr = arr[i];
            while (index >= 0 && indexArr < arr[index]){
                arr[index+1] = arr[index];
                index--;
            }
            arr[index+1] = indexArr;
            System.out.println(Arrays.toString(arr));
        }

    }
}
