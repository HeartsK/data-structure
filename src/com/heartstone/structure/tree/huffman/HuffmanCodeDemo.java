package com.heartstone.structure.tree.huffman;

import java.util.*;

/**
 * @author code generator
 * @date 2022-06-10 17:05
 */
public class HuffmanCodeDemo {

    public static void main(String[] args) {
        String content = "i like like like java do you like a java";
        byte[] bytes = content.getBytes();
        System.out.println(bytes.length);
        List<CodeNode> codeNodes = getCodeNodes(bytes);
        System.out.println(codeNodes);
        CodeNode huffmanTree = createHuffmanTree(codeNodes);
        System.out.println("赫夫曼树");
        preOrder(huffmanTree);
    }

    //获取赫夫曼编码表
    public static void huffmanCodeTable(Map<Byte, String> map, CodeNode node, StringBuilder stringBuilder, String code){
        if (node != null){
            if (node.getC() == null){

            }
        }

    }

    //创建huffmanTree
    public static CodeNode createHuffmanTree(List<CodeNode> list){
        while (list.size() > 1){
            Collections.sort(list);
            CodeNode leftNode = list.get(0);
            CodeNode rightNode = list.get(1);
            CodeNode parentNode = new CodeNode(null, leftNode.getWeight()+rightNode.getWeight());
            parentNode.setLeft(leftNode);
            parentNode.setRight(rightNode);
            list.remove(leftNode);
            list.remove(rightNode);
            list.add(parentNode);
        }
        return list.get(0);
    }

    public static List<CodeNode> getCodeNodes(byte[] bytes){
        //将字节数组进行统计
        Map<Byte, Integer> map = new HashMap<>();
        for (byte aByte : bytes) {
            map.merge(aByte, 1, Integer::sum);
        }
        //将map转化成codeNode,并放入集合中
        List<CodeNode> list = new ArrayList<>();
        for (Map.Entry<Byte, Integer> entry : map.entrySet()) {
            list.add(new CodeNode(entry.getKey(), entry.getValue()));
        }
        return list;
    }

    public static void preOrder(CodeNode root){
        if (root != null){
            root.preOrder();
        }else {
            System.out.println("树为空");
        }
    }
}

class CodeNode implements Comparable<CodeNode>{

    private Byte c;
    private Integer weight;
    private CodeNode left;
    private CodeNode right;

    public CodeNode(Byte c, Integer weight) {
        this.c = c;
        this.weight = weight;
    }

    public Byte getC() {
        return c;
    }

    public void setC(Byte c) {
        this.c = c;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public CodeNode getLeft() {
        return left;
    }

    public void setLeft(CodeNode left) {
        this.left = left;
    }

    public CodeNode getRight() {
        return right;
    }

    public void setRight(CodeNode right) {
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
        return "CodeNode{" +
                "c=" + c +
                ", weight=" + weight +
                '}';
    }

    @Override
    public int compareTo(CodeNode o) {
        return this.weight - o.weight;
    }
}