package com.heartstone.structure.search;

import java.util.ArrayList;
import java.util.List;

/**
 * 二分查找算法
 */
public class BinarySearch {

    public static void main(String[] args) {
        int[] arr = new int[]{1,8,10,89,1000,1000,1000,1234};
        /*int i = binarySearch(arr, 0, arr.length - 1, 100);
        System.out.println(i);*/
        List<Integer> integers = binarySearch2(arr, 0, arr.length - 1, 100);
        System.out.println(integers);
    }

    public static int binarySearch(int[] arr, int left, int right, int findVal){
        if (left > right){
            return -1;
        }
        int mid = (left+right)/2;
        int midVal = arr[mid];
        if (findVal < midVal){
            return binarySearch(arr,left,mid-1,findVal);
        }else if (findVal > midVal){
            return binarySearch(arr, mid+1, right, findVal);
        }else {
            //判断当前节点的左右两边是否还有相同的数据

            return mid;
        }
    }

    public static List<Integer> binarySearch2(int[] arr, int left, int right, int findVal){
        if (left > right){
            return null;
        }
        int mid = (left+right)/2;
        int midVal = arr[mid];
        if (findVal < midVal){
            return binarySearch2(arr,left,mid-1,findVal);
        }else if (findVal > midVal){
            return binarySearch2(arr, mid+1, right, findVal);
        }else {
            //判断当前节点的左右两边是否还有相同的数据
            List<Integer> resIndexList = new ArrayList<>();
            int temp = mid -1;
            while (temp >= 0 && arr[temp] == findVal) {
                resIndexList.add(temp);
                temp--;
            }
            resIndexList.add(mid);
            temp = mid+1;
            while (temp <= right && arr[temp] == findVal) {
                resIndexList.add(temp);
                temp++;
            }
            return resIndexList;
        }
    }
}
