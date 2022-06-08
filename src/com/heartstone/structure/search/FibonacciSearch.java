package com.heartstone.structure.search;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author code generator
 * @date 2022-06-07 12:12
 */
public class FibonacciSearch {

    public static int maxSize = 20;

    public static void main(String[] args) {

        int[] arr = new int[]{1,8,10,89,1000,1234};

        List<Integer> search = search(arr, 0, arr.length - 1, -1);
        System.out.println(search);
    }

    public static void fib(int i, int[] arr){
        if (i < maxSize){
            if (i < 2){
                arr[i] = 1;
            }else {
                arr[i] = arr[i-1] + arr[i-2];
            }
            i++;
            fib(i,arr);
        }

    }

    public static List<Integer> search(int[] arr, int left, int right, int findVal){
        List<Integer> list = new ArrayList<>();
        int mid;
        int k = 0;
        //获取斐波那契队列
        int[] f = new int[maxSize];
        fib(0, f);
        //找出斐波那契函数的k值
        while (right > f[k]-1){
            k++;
        }
        //将arr的长度补全
        /*int[] temp = new int[f[k]];
        for (int i = 0; i < temp.length; i++) {
            if (i < arr.length){
                temp[i] = arr[i];
            }else {
                temp[i] = arr[right];
            }
        }*/
        int[] temp = Arrays.copyOf(arr, f[k]);
        for (int i = right+1; i < temp.length; i++) {
            temp[i] = arr[right];
        }
        System.out.println(Arrays.toString(temp));
        //标定mid点，然后开始查找
        while (left <= right){
            mid = left + f[k-1] -1;
            if (findVal > temp[mid]){
                left = mid + 1;
                k--;
            }else if (findVal < temp[mid]){
                right = mid - 1;
                k-=2;
            }else {
                list.add(Math.min(mid, right));
                break;
            }
        }
        return list;
    }
}
