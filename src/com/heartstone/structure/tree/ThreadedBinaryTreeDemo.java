package com.heartstone.structure.tree;

/**
 * @author code generator
 * @date 2022-06-08 16:34
 */
public class ThreadedBinaryTreeDemo {

    public static void main(String[] args) {

    }

}

class ThreadedBinaryTree {

    private ThreadedBinaryNode root;

    //当前节点的前一个节点
    private ThreadedBinaryNode pre = null;

    public void setRoot(ThreadedBinaryNode root) {
        this.root = root;
    }


}

class ThreadedBinaryNode {

    private int id;
    private String name;
    private ThreadedBinaryNode left;
    private ThreadedBinaryNode right;
    //左指针类别 0 左子节点 1前继节点
    private int leftType;
    //右指针类别 0 右子节点 1后驱节点
    private int rightType;

    public ThreadedBinaryNode(int id, String name) {
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

    public ThreadedBinaryNode getLeft() {
        return left;
    }

    public void setLeft(ThreadedBinaryNode left) {
        this.left = left;
    }

    public ThreadedBinaryNode getRight() {
        return right;
    }

    public void setRight(ThreadedBinaryNode right) {
        this.right = right;
    }

    public int getLeftType() {
        return leftType;
    }

    public void setLeftType(int leftType) {
        this.leftType = leftType;
    }

    public int getRightType() {
        return rightType;
    }

    public void setRightType(int rightType) {
        this.rightType = rightType;
    }

    @Override
    public String toString() {
        return "ThreadedBinaryNode{" +
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
}
