package com.heartstone.structure.tree;

import java.util.Arrays;

/**
 * @author code generator
 * @date 2022-06-10 10:09
 */
public class HeapTreeDemo {

    public static void main(String[] args) {
        int[] arr = new int[]{4, 6, 8, 5, 9};
//        adjust(arr, 1, arr.length);
//        System.out.println("第一次："+ Arrays.toString(arr));
//        adjust(arr, 0, arr.length);
//        System.out.println("第二次："+ Arrays.toString(arr));

        headSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    /**
     * 堆排序
     * @param arr 待排序数组
     */
    public static void headSort(int[] arr){
        for (int i = arr.length/2-1; i>=0 ; i--) {
            adjust(arr, i, arr.length);
        }
        for (int i = arr.length-1; i >0 ; i--) {
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
            adjust(arr, 0,i);
        }
    }

    /**
     * 将普通二叉树，转成大堆二叉树
     * @param arr 数组
     * @param i 从下到上，从左到右的第一个非叶子节点
     * @param length 要比较数组长度
     */
    public static void adjust(int[] arr, int i, int length){
        int temp = arr[i];
        //找到当前非叶子节点下子节点数据最大的那
        for (int k = i*2+1; k < length; k = k*2+1) {
            if (k+1 < length && arr[k] < arr[k+1]){
                k++;
            }
            if(temp < arr[k]){
                arr[i] = arr[k];
                i = k;
            }else {
                break;
            }
        }
        arr[i] = temp;
    }
}
