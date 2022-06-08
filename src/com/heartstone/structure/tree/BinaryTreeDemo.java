package com.heartstone.structure.tree;

/**
 * @author code generator
 * @date 2022-06-08 10:09
 */
public class BinaryTreeDemo {

    public static void main(String[] args) {

        BinaryNode node1 = new BinaryNode(1, "one");
        BinaryNode node2 = new BinaryNode(2, "two");
        BinaryNode node3 = new BinaryNode(3, "three");
        BinaryNode node4 = new BinaryNode(4, "four");
        BinaryNode node5 = new BinaryNode(5, "five");
        BinaryTree binaryTree = new BinaryTree();
        binaryTree.setRoot(node1);
        node1.setLeft(node2);
        node1.setRight(node3);
        node3.setRight(node4);
        node3.setLeft(node5);
        /*System.out.println("前序输出");
        binaryTree.preOrder();
        System.out.println("中序输出");
        binaryTree.infixOrder();
        System.out.println("后序输出");
        binaryTree.sufOrder();*/
//        BinaryNode node = binaryTree.infixSearch(5);
//        System.out.println(node);
        binaryTree.preOrder();
        System.out.println("删除后~~");
        binaryTree.delTreeNode(5);
        binaryTree.preOrder();
    }
}

class BinaryTree {

    private BinaryNode root;

    public void setRoot(BinaryNode root) {
        this.root = root;
    }

    public void preOrder() {
        if (root == null) {
            System.out.println("树为空");
        }
        root.preOrderList();
    }

    public void infixOrder() {
        if (root == null) {
            System.out.println("树为空");
        }
        root.infixOrderList();
    }

    public void sufOrder() {
        if (root == null) {
            System.out.println("树为空");
        }
        root.sufOrderList();
    }

    public BinaryNode preSearch(int num){
        if (root != null){
            return root.preSearch(num);
        }
        return null;
    }

    public BinaryNode infixSearch(int num){
        if (root != null){
            return root.infixSearch(num);
        }
        return null;
    }

    public BinaryNode sufSearch(int num){
        if (root != null){
            return root.sufSearch(num);
        }
        return null;
    }

    public void delTreeNode(int num){
        if (root != null){
            if(root.getId() == num){
                root = null;
            }else {
                root.delNode(num);
            }
        }else {
            System.out.println("树接口为空，无法删除");
        }
    }
}

class BinaryNode {

    private int id;
    private String name;
    private BinaryNode left;
    private BinaryNode right;

    public BinaryNode(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BinaryNode getLeft() {
        return left;
    }

    public void setLeft(BinaryNode left) {
        this.left = left;
    }

    public BinaryNode getRight() {
        return right;
    }

    public void setRight(BinaryNode right) {
        this.right = right;
    }

    @Override
    public String toString() {
        return "BinaryNode{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    /**
     * 前序遍历
     */
    public void preOrderList() {
        System.out.println(this);
        if (this.left != null) {
            this.left.preOrderList();
        }
        if (this.right != null) {
            this.right.preOrderList();
        }
    }

    /**
     * 中序遍历
     */
    public void infixOrderList() {
        if (this.left != null) {
            this.left.infixOrderList();
        }
        System.out.println(this);
        if (this.right != null) {
            this.right.infixOrderList();
        }
    }

    /**
     * 后序遍历
     */
    public void sufOrderList() {
        if (this.left != null) {
            this.left.sufOrderList();
        }
        if (this.right != null) {
            this.right.sufOrderList();
        }
        System.out.println(this);
    }

    /**
     * 前序查找
     *
     * @param num 带查找id
     * @return 查询到的节点
     */
    public BinaryNode preSearch(int num) {
        System.out.println("计算比对~~");
        if (this.id == num) {
            return this;
        }
        BinaryNode node = null;
        if (this.left != null) {
            node = this.left.preSearch(num);
        }
        if (node != null) {
            return node;
        }
        if (this.right != null) {
            node = this.right.preSearch(num);
        }
        return node;
    }

    public BinaryNode infixSearch(int num) {
        BinaryNode node = null;
        if (this.left != null) {
            node = this.left.infixSearch(num);
        }
        if (node != null) {
            return node;
        }
        System.out.println("计算比对~~");
        if (this.id == num) {
            return this;
        }
        if (this.right != null) {
            node = this.right.infixSearch(num);
        }
        return node;
    }

    public BinaryNode sufSearch(int num) {
        BinaryNode node = null;
        if (this.left != null) {
            node = this.left.sufSearch(num);
        }
        if (node != null){
            return node;
        }
        if (this.right != null) {
            node = this.right.sufSearch(num);
        }
        if (node != null){
            return node;
        }
        System.out.println("计算比对~~");
        if (this.id == num){
            return this;
        }
        return node;
    }

    public void delNode(int num){

        if (this.left != null && this.left.id == num){
            this.left = null;
            return;
        }
        if (this.right != null && this.right.id == num){
            this.right = null;
            return;
        }
        if (this.left != null) {
            this.left.delNode(num);
        }
        if (this.right != null){
            this.right.delNode(num);
        }
    }
}
