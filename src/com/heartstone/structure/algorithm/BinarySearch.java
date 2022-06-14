package com.heartstone.structure.algorithm;

/**
 * 二分查找非递归
 * @author
 * @date 2022-06-14 15:56
 */
public class BinarySearch {

    public static void main(String[] args) {
        int[] arr = new int[]{1,2,3,4,5,6,7,8,9};
        int i = binarySearch(2, arr, 0, arr.length-1);
        System.out.println(i);
    }

    public static int binarySearch(int findVal, int[] arr, int start, int end){
        if (start > end){
            return -1;
        }
        int index = (start+end)*(findVal-arr[start])/(arr[end]-arr[start]);
        if (index > end || index < start){
            return -1;
        }
        if (arr[index] > findVal){
            return binarySearch(findVal, arr, start, index-1);
        }else if (arr[index] < findVal){
            return binarySearch(findVal, arr, index+1, end);
        }else {
            return index;
        }
    }
}
