package com.heartstone.structure.tree;

/**
 * @author code generator
 * @date 2022-06-08 15:47
 */
public class ArrBinaryTreeDemo {

    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3, 4, 5, 6, 7};
        ArrBinaryTree arrBinaryTree = new ArrBinaryTree(arr);
        arrBinaryTree.sufOrder();
    }

}

class ArrBinaryTree {
    private int[] arr;

    public ArrBinaryTree(int[] arr) {
        this.arr = arr;
    }

    public void sufOrder(){
        sufOrder(0);
    }

    public void infixOrder(){
        infixOrder(0);
    }

    public void preOrder() {
        preOrder(0);
    }

    private void preOrder(int num) {
        System.out.println(arr[num]);
        //向左
        if (2 * num + 1 < arr.length) {
            preOrder(2 * num + 1);
        }
        //向右
        if (2 * num + 2 < arr.length) {
            preOrder(2 * num + 2);
        }
    }

    private void infixOrder(int num) {
        if (2 * num + 1 < arr.length) {
            infixOrder(2 * num + 1);
        }
        System.out.println(arr[num]);
        if (2 * num + 2 < arr.length) {
            infixOrder(2 * num + 2);
        }
    }

    private void sufOrder(int num){
        if (2*num+1 < arr.length){
            sufOrder(2*num+1);
        }
        if (2*num+2 < arr.length){
            sufOrder(2*num+2);
        }
        System.out.println(arr[num]);
    }
}
