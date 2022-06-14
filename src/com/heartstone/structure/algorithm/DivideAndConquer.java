package com.heartstone.structure.algorithm;

/**
 * 分治算法
 * @author
 * @date 2022-06-14 17:13
 */
public class DivideAndConquer {

    public static void main(String[] args) {
        hanoiTower(5,'A','B','C');
    }

    public static void hanoiTower(int num, char a, char b, char c){
        if (num == 1){
            System.out.println(a+"->"+c);
        }else {
            hanoiTower(num-1, a,c,b);
            System.out.println(a+"->"+c);
            hanoiTower(num-1, b,a,c);
        }
    }
}
