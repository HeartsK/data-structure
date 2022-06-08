package com.heartstone.structure.sort;

import java.util.Arrays;

/**
 * @author code generator
 * @date 2022-06-06 15:09
 */
public class MergeSort {

    public static void main(String[] args) {
        int[] arr = new int[]{8,4,5,7,1,3,6,2};
        int[] temp = new int[arr.length];
        mergeSort(arr, 0, arr.length-1, temp);
        System.out.println(Arrays.toString(arr));
    }


    public static void mergeSort(int[] arr, int left, int right, int[] temp){
        if (left < right){
            int mid = (left + right)/2;
            //向左递归拆分
            mergeSort(arr, left, mid, temp);
            //向右递归拆分
            mergeSort(arr, mid+1, right, temp);
            //合并
            merge(arr, left, mid, right, temp);
        }
    }

    public static void merge(int[] arr, int left, int mid, int right, int[] temp){
        int i = left;
        int j = mid+1;
        int t = 0;
        //将有之前有序的分段，有序拷贝到临时temp数组中
        while (i <= mid && j <= right){
            if (arr[i] < arr[j]){
                temp[t] = arr[i];
                t++;
                i++;
            }else {
                temp[t] = arr[j];
                j++;
                t++;
            }
        }
        //将对比后余下的数据拷贝到temp中
        while (i <= mid){
            temp[t] = arr[i];
            i++;
            t++;
        }
        while (j <= right){
            temp[t] = arr[j];
            t++;
            j++;
        }
        //拷贝，将temp拷贝到arr
        t = 0;
        int tempLeft = left;
        while (tempLeft <= right){
            arr[tempLeft] = temp[t];
            t++;
            tempLeft++;
        }
    }
}
