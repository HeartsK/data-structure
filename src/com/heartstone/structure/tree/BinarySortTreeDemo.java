package com.heartstone.structure.tree;

/**
 * 二叉排序树（BST）
 * @author code generator
 * @date 2022-06-13 10:45
 */
public class BinarySortTreeDemo {

    public static void main(String[] args) {
        int[] arr = new int[]{7,3,10,12,5,1,9,2};
        BinarySortTree sortTree = new BinarySortTree();
        for (int value : arr) {
            SortNode node = new SortNode(value);
            sortTree.add(node);
        }
        sortTree.infixList();
//        SortNode targetNode = sortTree.search(3);
//        System.out.println(targetNode);
//        SortNode parentNode = sortTree.searchParent(7);
//        System.out.println(parentNode);
        System.out.println("删除节点");
//        sortTree.delNode(2);
        sortTree.delNode(10);
        sortTree.infixList();
    }

}

class BinarySortTree{
    private SortNode root;

    public void add(SortNode node){
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

    public void delNode(int value){
        if (root == null){
            System.out.println("树为空");
            return;
        }
        SortNode targetNode = search(value);
        if (targetNode == null){
            return;
        }
        //要注意targetNode没有父节点
        SortNode parentNode = searchParent(value);

        if (targetNode.getLeft() == null && targetNode.getRight() == null){
            //判断当前节点是父节点的左子节点还是右子节点
            if (parentNode.getLeft() != null && parentNode.getLeft().getValue() == targetNode.getValue()){
                parentNode.setLeft(null);
            }else if (parentNode.getRight() != null && parentNode.getRight().getValue() == targetNode.getValue()){
                parentNode.setRight(null);
            }
        }else if (targetNode.getLeft() != null && targetNode.getRight() != null){
            //左子节点和右子节点都不为空
            //以目标节点为根节点，从右子树开始找到最小的那个的值和目标节点互换
            SortNode temp = targetNode.getRight();
            while (temp.getLeft() != null){
                temp = temp.getLeft();
            }
            delNode(temp.getValue());
            targetNode.setValue(temp.getValue());
        }else {
            //目标节点为单子节点树
            if (parentNode.getLeft() != null && parentNode.getLeft().getValue() == targetNode.getValue()){
                if (targetNode.getLeft() != null){
                    parentNode.setLeft(targetNode.getLeft());
                }else {
                    parentNode.setLeft(targetNode.getRight());
                }
            }else if (parentNode.getRight() != null && parentNode.getRight().getValue() == targetNode.getValue()){
                if (targetNode.getLeft() != null){
                    parentNode.setRight(targetNode.getLeft());
                }else {
                    parentNode.setRight(targetNode.getRight());
                }
            }
        }
    }

    public SortNode searchParent(int value){
        if (root == null){
            return null;
        }
        if (root.getValue() == value){
            return root;
        }else {
            return root.searchParent(value);
        }
    }

    public SortNode search(int value){
        if (root == null){
            return null;
        }else {
            return root.search(value);
        }
    }
}

class SortNode{

    private int value;
    private SortNode left;
    private SortNode right;

    /*public SortNode searchParent(int value){
        if (this.left != null && this.left.value == value){
            return this;
        }else if (this.left != null && this.value > value) {
            return this.left.searchParent(value);
        } else if (this.right != null && this.right.getValue() == value){
            return this;
        }else if (this.right != null && this.value < value){
            return this.right.searchParent(value);
        }else {
            return null;
        }
    }*/

    public SortNode searchParent(int value){
        if ((this.left != null && this.left.value == value) ||
            (this.right != null && this.right.value == value)){
            return this;
        }else{
            if (value < this.value && this.left != null){
                return this.left.searchParent(value);
            }else if (value >= this.value && this.right != null){
                return this.right.searchParent(value);
            }else {
                return null;
            }
        }
    }


    public SortNode search(int value){
        //当前节点就是目标节点
        if (this.value == value){
            return this;
        }
        if (this.left != null && this.value > value){
            return this.left.search(value);
        }else if (this.right != null && this.value < value){
            return this.right.search(value);
        }else {
            return null;
        }
    }

    public void add(SortNode node){
        if(this.value > node.getValue()){
            if (this.left == null){
                this.left = node;
            }else {
                this.left.add(node);
            }
        }else {
            if (this.right == null){
                this.right = node;
            }else {
                this.right.add(node);
            }
        }
    }

    public void infixList(){
        if (this.left != null){
            this.left.infixList();
        }
        System.out.println(this);
        if (this.right != null){
            this.right.infixList();
        }
    }

    public SortNode(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public SortNode getLeft() {
        return left;
    }

    public void setLeft(SortNode left) {
        this.left = left;
    }

    public SortNode getRight() {
        return right;
    }

    public void setRight(SortNode right) {
        this.right = right;
    }

    @Override
    public String toString() {
        return "SortNode{" +
                "value=" + value +
                '}';
    }
}
