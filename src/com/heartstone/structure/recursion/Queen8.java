package com.heartstone.structure.recursion;

import java.util.List;

public class Queen8 {

    static int max = 8;

    static int count = 0;

    public static void main(String[] args) {
        int[] arrays = new int[max];
        check(0,arrays);
        System.out.printf("总共有多少种方法%d\n",count);
    }
    
    //打印方案
    public static void print(int[] arrays){
        count++;
        for (int array : arrays) {
            System.out.print(array+" ");
        }
        System.out.println();
    }
    //判断是否在同一列，以及同一斜线上
    public static boolean judge(int n, int[] arrays){
        for (int i = 0; i < n; i++) {
            if (arrays[i] == arrays[n] || Math.abs(n-i) == Math.abs(arrays[n]-arrays[i])){
                return false;
            }
        }
        return true;
    }

    public static void check(int n, int[] arrays){
        if (n >= max){
            print(arrays);
            return;
        }
        for (int i = 0; i < max; i++) {
            arrays[n] = i;
            if (judge(n, arrays)){
                check(n+1,arrays);
            }
        }
    }
}
