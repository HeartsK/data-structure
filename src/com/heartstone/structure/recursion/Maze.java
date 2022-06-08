package com.heartstone.structure.recursion;

/**
 * @author code generator
 * @date 2022-06-02 14:50
 */
public class Maze {

    public static void main(String[] args) {
        int[][] map = new int[8][7];
        for (int i = 0; i < 8; i++) {
            map[i][0] = 1;
            map[i][6] = 1;
        }
        for (int j = 0; j < 7; j++) {
            map[0][j] = 1;
            map[7][j]=1;
        }
        map[3][1] = 1;
        map[3][2] = 1;
        for (int[] ints : map) {
            for (int anInt : ints) {
                System.out.print(anInt + " ");
            }
            System.out.println();
        }
        System.out.println("迷宫路径");
        setWay(map,1,1);
        for (int[] ints : map) {
            for (int anInt : ints) {
                System.out.print(anInt + " ");
            }
            System.out.println();
        }
    }

    public static boolean setWay(int[][] map, int i, int j){
        if (map[6][5] == 2){
            return true;
        }else {
            if (map[i][j] == 0){
                map[i][j] = 2;
                if (setWay(map, i+1, j)){
                    return true;
                }else if (setWay(map, i, j+1)){
                    return true;
                }else if (setWay(map, i-1, j)){
                    return true;
                }else if (setWay(map, i, j-1)){
                    return true;
                }else {
                    map[i][j] = 3;
                    return false;
                }
            }else {
                return false;
            }
        }
    }

    public static void factorial(int num){
        if (num > 2){
            factorial(num-1);
        }
        System.out.println(num);
    }

}
