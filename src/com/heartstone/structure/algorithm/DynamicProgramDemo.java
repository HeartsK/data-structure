package com.heartstone.structure.algorithm;

/**
 * 动态规划算法-处理背包问题demo
 * @author
 * @date 2022-06-15 10:04
 */
public class DynamicProgramDemo {

    public static void main(String[] args) {
        Knapsack knapsack = new Knapsack();
        knapsack.project();
    }
}

class Knapsack{
    //物品重量
    int[] w = new int[]{1,4,3};
    //物品价格
    int[] val = new int[]{1500,3000,2000};
    //背包容量
    int capacity = 4;
    //背包动态价值规划方案
    int[][] v = new int[val.length+1][capacity+1];
    //物品存放记录
    int[][] path = new int[val.length+1][capacity+1];

    public void project(){
        //初始化空物品背包价值(初始第一行值)
        for (int i = 0; i < v.length; i++) {
            v[i][0] = 0;
        }
        //初始化空重量背包价值（初始第一列值）
        for (int j = 0; j <v[0].length ; j++) {
            v[0][j] = 0;
        }
        //开始动态存放
        for (int i = 1; i < v.length; i++) {
            for (int j = 1; j < v[0].length; j++) {
                if (w[i-1] > j){
                    v[i][j] = v[i-1][j];
                }else {
//                    v[i][j] = Math.max(v[i-1][j],val[i-1]+v[i-1][j-w[i-1]]);
                    if (v[i-1][j] < val[i-1]+v[i-1][j-w[i-1]]){
                        v[i][j] = val[i-1]+v[i-1][j-w[i-1]];
                        path[i][j] = 1;
                    }else {
                        v[i][j] = v[i-1][j];
                    }
                }
            }
        }
        /*for (int[] ints : v) {
            for (int j = 0; j < v[0].length; j++) {
                System.out.printf("%d ", ints[j]);
            }
            System.out.println();
        }*/
        int n = path.length-1;
        int m = path[0].length-1;
        while (n > 0 && m > 0){
            if (path[n][m] == 1){
                System.out.printf("第%d个物品放入背包 ",n);
                m -= w[n-1];
            }
            n--;
        }
        /*for (int i = 0; i < path.length; i++) {
            for (int j = 0; j < path[0].length; j++) {
                if (path[i][j] == 1){
                    System.out.printf("第%d个物品放入背包 ",i);
                }
            }
            System.out.println();
        }*/
    }
}
