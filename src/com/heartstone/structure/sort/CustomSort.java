package com.heartstone.structure.sort;

import java.util.Arrays;

/**
 * @author code generator
 * @date 2022-05-31 14:42
 */
public class CustomSort {

    public static void main(String[] args) {
        int[] originalArrays = new int[]{3,7,2,9,1,4,6,8,10,5};
//        sort(originalArrays);
        bubbleSort(originalArrays);
        System.out.println(Arrays.toString(originalArrays));
    }

    public static void sort(int[] originalArrays){
        for (int i = 0; i < originalArrays.length; i++) {
            for (int j = i+1; j < originalArrays.length; j++) {
                if (originalArrays[i] > originalArrays[j]){
                    int temp = originalArrays[i];
                    originalArrays[i] = originalArrays[j];
                    originalArrays[j] = temp;
                    i = i-1;
                    break;
                }
            }
        }
    }

    public static void bubbleSort(int[] originalArrays){
        for (int i = 0; i < originalArrays.length; i++) {
            for (int j = 0; j < originalArrays.length-1; j++) {
                if (originalArrays[j] > originalArrays[j+1]){
                    int temp = originalArrays[j];
                    originalArrays[j] = originalArrays[j+1];
                    originalArrays[j+1] = temp;
                }
            }
        }
    }

    public static void quickSort(int[] arr, int start, int end){
        if (start < end){
            return;
        }
        int index = getIndex(arr, start, end);
        quickSort(arr, start, index-1);
        quickSort(arr, index+1, end);
    }

    public static int getIndex(int[] arr, int start, int end){
        while (start < end){
            while (start < end && arr[start] < arr[end]){
                start++;
            }
            if (start < end){
                int temp = arr[end];
                arr[end] = arr[start];
                arr[start] = temp;
                end--;
            }
            while (start < end && arr[end] > arr[start]){
                end--;
            }
            if (start < end){
                int temp = arr[start];
                arr[start] = arr[end];
                arr[end] = temp;
                start++;
            }
        }
        return start;
    }
}
