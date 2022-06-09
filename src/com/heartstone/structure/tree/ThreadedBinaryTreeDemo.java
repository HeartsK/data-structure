package com.heartstone.structure.tree;

/**
 * @author code generator
 * @date 2022-06-08 16:34
 */
public class ThreadedBinaryTreeDemo {

    public static void main(String[] args) {
        ThreadedBinaryNode node1 = new ThreadedBinaryNode(1, "one");
        ThreadedBinaryNode node2 = new ThreadedBinaryNode(3, "three");
        ThreadedBinaryNode node3 = new ThreadedBinaryNode(6, "six");
        ThreadedBinaryNode node4 = new ThreadedBinaryNode(8, "eight");
        ThreadedBinaryNode node5 = new ThreadedBinaryNode(10, "ten");
        ThreadedBinaryNode node6 = new ThreadedBinaryNode(14, "fourteen");

        ThreadedBinaryTree threadedBinaryTree = new ThreadedBinaryTree();
        threadedBinaryTree.setRoot(node1);
        node1.setLeft(node2);
        node1.setRight(node3);
        node2.setLeft(node4);
        node2.setRight(node5);
        node3.setLeft(node6);
//        System.out.println("中序线索转换后的二叉树");
//        threadedBinaryTree.infixThreadedNode();
//        System.out.printf("left=%s, leftType=%d \n", node6.getLeft(), node6.getLeftType());
//        System.out.printf("right=%s, rightType=%d \n", node6.getRight(), node6.getRightType());
//        threadedBinaryTree.infixOrder();
//        threadedBinaryTree.perThreadedNode();
//        System.out.println("前序线索转换后的二叉树");
//        System.out.printf("left=%s, leftType=%d \n", node4.getLeft(), node4.getLeftType());
//        threadedBinaryTree.preOrder();
        threadedBinaryTree.sufThreadedNode();
        System.out.println("后续序线索转换后的二叉树");
//        System.out.printf("left=%s, leftType=%d \n", node3.getLeft(), node3.getLeftType());
//        System.out.printf("right=%s, rightType=%d \n", node3.getRight(), node3.getRightType());
        threadedBinaryTree.sufOrder();
    }

}

class ThreadedBinaryTree {

    private ThreadedBinaryNode root;

    //当前节点的前一个节点
    private ThreadedBinaryNode pre = null;

    public void setRoot(ThreadedBinaryNode root) {
        this.root = root;
    }

    public void perThreadedNode() {
        preThreadedNode(root);
    }

    public void infixThreadedNode() {
        infixThreadedNode(root);
    }

    public void sufThreadedNode(){
        sufThreadedNode(root);
    }

    //后序遍历线索二叉树,需要建立当前节点的父节点
    public void sufOrder(){
        ThreadedBinaryNode node = root;
    }

    //前序遍历线索二叉树
    public void preOrder() {
        ThreadedBinaryNode node = root;
        while (node != null) {
            System.out.println(node);
            while (node.getLeftType() == 0) {
                node = node.getLeft();
                System.out.println(node);
            }
            while (node.getRightType() == 1) {
                node = node.getRight();
                System.out.println(node);
            }
            node = node.getRight();
        }
    }

    //中序线索二叉树遍历
    public void infixOrder() {
        ThreadedBinaryNode node = root;
        while (node != null) {
            //先左节点
            while (node.getLeftType() == 0) {
                node = node.getLeft();
            }
            //这个是要找的当前节点
            System.out.println(node);
            //再右节点
            while (node.getRightType() == 1) {
                node = node.getRight();
                //这是下一节点
                System.out.println(node);
            }
            //如果没有则自然向后移动
            node = node.getRight();
        }
    }

    private void sufThreadedNode(ThreadedBinaryNode node) {
        if (node == null) {
            return;
        }
        sufThreadedNode(node.getLeft());
        sufThreadedNode(node.getRight());
        if (node.getLeft() == null) {
            node.setLeft(pre);
            node.setLeftType(1);
        }
        if (pre != null && pre.getRight() == null) {
            pre.setRight(node);
            pre.setRightType(1);
        }
        pre = node;
    }

    private void preThreadedNode(ThreadedBinaryNode node) {
        if (node == null) {
            return;
        }
        //处理当前节点
        if (node.getLeft() == null) {
            node.setLeft(pre);
            node.setLeftType(1);
        }
        if (pre != null && pre.getRight() == null) {
            pre.setRight(node);
            pre.setRightType(1);
        }
        pre = node;
        //处理左节点
        if (node.getLeftType() != 1) {
            preThreadedNode(node.getLeft());
        }
        //处理右节点
        if (node.getRightType() != 1) {
            preThreadedNode(node.getRight());
        }
    }

    //将二叉树节点转换成中序线索二叉树节点
    private void infixThreadedNode(ThreadedBinaryNode node) {

        if (node == null) {
            return;
        }
        //左子节点转换
        infixThreadedNode(node.getLeft());
        //当前节点转换
        //前驱节点
        if (node.getLeft() == null) {
            node.setLeft(pre);
            node.setLeftType(1);
        }
        //后继节点
        if (pre != null && pre.getRight() == null) {
            pre.setRight(node);
            pre.setRightType(1);
        }
        pre = node;
        //右子节点转换
        infixThreadedNode(node.getRight());
    }
}

class ThreadedBinaryNode {

    private int id;
    private String name;
    private ThreadedBinaryNode left;
    private ThreadedBinaryNode right;
    //左指针类别 0 左子节点 1前驱节点
    private int leftType;
    //右指针类别 0 右子节点 1后继节点
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
