package com.heartstone.structure.tree.huffman;

import java.util.*;

/**
 * @author code generator
 * @date 2022-06-10 17:05
 */
public class HuffmanCodeDemo {

    static Map<Byte, String> huffmanCodesMap = new HashMap<>();

    public static void main(String[] args) {
        String content = "hello world";
        byte[] contentBytes = content.getBytes();
        System.out.println(contentBytes.length);
        List<CodeNode> codeNodes = getCodeNodes(contentBytes);
        System.out.println(codeNodes);
        CodeNode huffmanTree = createHuffmanTree(codeNodes);
//        System.out.println("赫夫曼树");
//        preOrder(huffmanTree);
        System.out.println("赫夫曼编码表");
        Map<Byte, String> huffmanCodeTable = huffmanCodeTable(huffmanTree);
        System.out.println(huffmanCodeTable);
        Byte[] bytes = transferBytes(contentBytes);
        System.out.println("赫夫曼编码"+ Arrays.toString(bytes));

        System.out.println("赫夫曼解码");
        String huffmanCode = transferHuffmanCode(bytes);
        byte[] decode = decode(huffmanCode);
        System.out.println(new String(decode));
    }

    public static byte[] decode(String huffmanCode){
        Map<String, Byte> map = new HashMap<>();
        for (Map.Entry<Byte, String> entry : huffmanCodesMap.entrySet()) {
            map.put(entry.getValue(), entry.getKey());
        }
        int len = (huffmanCode.length() + 7) / 8;
        byte[] bytes = new byte[40];
        int index = 0;
        for (int i = 0; i < huffmanCode.length();) {
            int count = 1;
            while (map.get(huffmanCode.substring(i,i+count)) == null){
                count++;
            }
            bytes[index] = map.get(huffmanCode.substring(i,i+count));
            i+=count;
            index++;
        }
        return bytes;
    }

    //将字节数组转换成二进制huffmanCode
    public static String transferHuffmanCode(Byte[] bytes){
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < bytes.length-1; i++) {
            int temp = bytes[i];
            temp |= 256;
            String s = Integer.toBinaryString(temp);
            if (s.length() > 8){
                s = s.substring(s.length() - 8);
            }
            stringBuilder.append(s);
        }
        //转换最后一个数据
        int last = bytes[bytes.length - 1];
        if (last > 0){
            stringBuilder.append(Integer.toBinaryString(last));
        }else {
            String s = Integer.toBinaryString(last);
            stringBuilder.append(s.substring(s.length()-8));
        }
        return stringBuilder.toString();
    }

    //将原始字节数组转成huffmanCode字符串
    public static Byte[] transferBytes(byte[] contentByte){
        StringBuilder stringBuilder = new StringBuilder();
        for (byte b : contentByte) {
            stringBuilder.append(huffmanCodesMap.get(b));
        }
        System.out.println(stringBuilder.toString());
        //涉及到%8不够的补充，及不满8按8算
        int len = (stringBuilder.length()+7)/8;
        Byte[] bytes = new Byte[len];
        int index = 0;
        for (int i = 0; i < stringBuilder.length(); i+=8) {
            //将二进制转成bit
            String substring;
            if (i+8 > stringBuilder.length()){
                substring = stringBuilder.substring(i);
            }else {
                substring = stringBuilder.substring(i, i + 8);
            }
            byte b = (byte) Integer.parseInt(substring, 2);
            bytes[index] = b;
            index++;
        }
        return bytes;
    }

    public static Map<Byte, String> huffmanCodeTable(CodeNode root){
        if (root == null){
            return null;
        }
        StringBuilder stringBuilder = new StringBuilder();
        //向左
        huffmanCodeTable(root.getLeft(),stringBuilder,"0");
        //向右
        huffmanCodeTable(root.getRight(),stringBuilder,"1");
        return huffmanCodesMap;
    }

    //获取赫夫曼编码表
    public static void huffmanCodeTable(CodeNode node, StringBuilder stringBuilder, String code){
        StringBuilder stringBuilder1 = new StringBuilder(stringBuilder);
        stringBuilder1.append(code);
        if (node != null){
            if (node.getC() == null){
                huffmanCodeTable(node.getLeft(),stringBuilder1,"0");
                huffmanCodeTable(node.getRight(), stringBuilder1, "1");
            }else {
                huffmanCodesMap.put(node.getC(), stringBuilder1.toString());
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