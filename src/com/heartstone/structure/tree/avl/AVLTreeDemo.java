package com.heartstone.structure.tree.avl;

/**
 * 平衡二叉树
 * @author
 * @date 2022-06-13 17:34
 */
public class AVLTreeDemo {

    public static void main(String[] args) {
        int[] arr = new int[]{4,3,6,5,7,8};
        AVLTree avlTree = new AVLTree();
        for (int i : arr) {
            avlTree.add(new Node(i));
        }
        avlTree.infixList();
        System.out.println("树的高度："+avlTree.height(avlTree.getRoot()));
        System.out.println("左子树的高度："+avlTree.height(avlTree.getRoot().getLeft()));
        System.out.println("右子树的高度："+avlTree.height(avlTree.getRoot().getRight()));
    }

}

class AVLTree{

    private Node root;

    public int height(Node node){
        return Math.max(node.getLeft() == null ? 0 : height(node.getLeft()),
                node.getRight() == null ? 0 : height(node.getRight()))+1;
    }

    public void add(Node node){
        if (root == null){
            root = node;
        }else {
            root.add(node);
        }
    }

    public void infixList(){
        if (root == null){
            System.out.println("树为空");
        }else {
            root.infixList();
        }
    }

    public Node getRoot() {
        return root;
    }
}

class Node{

    private int value;
    private Node left;
    private Node right;

    public void infixList(){
        if (this.left != null){
            this.left.infixList();
        }
        System.out.println(this);
        if (this.right != null){
            this.right.infixList();
        }
    }

    public void add(Node node){
        if (this.value > node.value){
            if (this.left != null){
                this.left.add(node);
            }else {
                this.left = node;
            }
        }else {
            if (this.right != null){
                this.right.add(node);
            }else {
                this.right = node;
            }
        }
    }

    public Node(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    @Override
    public String toString() {
        return "Node{" +
                "value=" + value +
                '}';
    }
}
