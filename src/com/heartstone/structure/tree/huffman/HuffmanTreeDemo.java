package com.heartstone.structure.tree.huffman;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author code generator
 * @date 2022-06-10 14:34
 */
public class HuffmanTreeDemo {

    public static void main(String[] args) {
        int[] arr = new int[]{13,7,8,3,29,6,1};
        HuffmanTree huffmanTree = new HuffmanTree();
        Node node = huffmanTree.transferHuffman(arr);
        node.preOrder();
    }
}

class HuffmanTree{

    public Node transferHuffman(int[] arr){
        List<Node> list = new ArrayList<>();
        for (int value : arr) {
            list.add(new Node(value));
        }
        Collections.sort(list);
        while (list.size()>1){
            Node rightNode = list.get(1);
            Node leftNode = list.get(0);
            Node parentNode = new Node(leftNode.getValue()+rightNode.getValue());
            parentNode.setLeft(leftNode);
            parentNode.setRight(rightNode);
            list.remove(leftNode);
            list.remove(rightNode);
            list.add(parentNode);
            Collections.sort(list);
        }
        return list.get(0);
    }

}

class Node implements Comparable<Node>{

    private int value;
    private Node left;
    private Node right;

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

    public void preOrder(){
        System.out.println(this);
        if (this.left != null){
            this.left.preOrder();
        }
        if (this.right != null){
            this.right.preOrder();
        }
    }

    @Override
    public String toString() {
        return "Node{" +
                "value=" + value +
                '}';
    }

    @Override
    public int compareTo(Node o) {
        return this.value - o.value;
    }
}