package com.heartstone.structure.tree.avl;

/**
 * 平衡二叉树
 * @author
 * @date 2022-06-13 17:34
 */
public class AVLTreeDemo {

    public static void main(String[] args) {
//        int[] arr = new int[]{4,3,6,5,7,8};
//        int[] arr = new int[]{10,12,8,9,7,6};
//        int[] arr = new int[]{10,11,7,6,8,9};
        int[] arr = new int[]{2,1,6,5,7,3};
        AVLTree avlTree = new AVLTree();
        for (int i : arr) {
            avlTree.add(new Node(i));
        }
//        avlTree.infixList();
//        System.out.println("树的高度："+avlTree.height(avlTree.getRoot()));
//        System.out.println("左子树的高度："+avlTree.height(avlTree.getRoot().getLeft()));
//        System.out.println("右子树的高度："+avlTree.height(avlTree.getRoot().getRight()));
//        avlTree.rightRotate(avlTree.getRoot());
        avlTree.infixList();
        System.out.println("转成avl后树的高度："+ avlTree.height(avlTree.getRoot()));
        System.out.println("转成avl后左子树的高度："+ avlTree.height(avlTree.getRoot().getLeft()));
        System.out.println("转成avl后右子树的高度："+ avlTree.height(avlTree.getRoot().getRight()));
    }

}

class AVLTree{

    private Node root;

    public int height(Node node){
        if (node == null){
            return 0;
        }
        return Math.max(node.getLeft() == null ? 0 : height(node.getLeft()),
                node.getRight() == null ? 0 : height(node.getRight()))+1;
    }

    public void add(Node node){
        if (root == null){
            root = node;
        }else {
            root.add(node);
        }
        if (height(root.getLeft()) - height(root.getRight()) > 1){
            if (height(root.getLeft().getRight()) >
                    height(root.getLeft().getLeft())){
                //如果左子树的右节点大于左节点，则需要先以该节点为根节点进行先左旋
                //再对根节点右旋
                leftRotate(root.getLeft());
            }
            rightRotate(root);
        }else if (height(root.getRight()) - height(root.getLeft()) > 1){
            if (height(root.getRight().getLeft()) >
                    height(root.getRight().getRight())){
                rightRotate(root.getRight());
            }
            leftRotate(root);
        }
    }

    public void leftRotate(Node root){
        //左旋
        Node node = new Node(root.getValue());
        node.setLeft(root.getLeft());
        node.setRight(root.getRight().getLeft());
        root.setValue(root.getRight().getValue());
        root.setRight(root.getRight().getRight());
        root.setLeft(node);
    }

    public void rightRotate(Node root){
        //右旋
        Node node = new Node(root.getValue());
        node.setRight(root.getRight());
        node.setLeft(root.getLeft().getRight());
        root.setValue(root.getLeft().getValue());
        root.setLeft(root.getLeft().getLeft());
        root.setRight(node);
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
