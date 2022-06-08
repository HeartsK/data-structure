package com.heartstone.structure;

import java.util.Scanner;

/**
 * TODO
 *
 * @author code generator
 * @date 2022-05-18 14:43
 */
public class ArrayQueue {

    public static void main(String[] args) {
        AQueue aQueue = new AQueue(3);
        try (Scanner scanner = new Scanner(System.in)) {
            boolean loop = true;
            System.out.println("输入a：向队列添加数据");
            System.out.println("输入g：从队列获取数据");
            System.out.println("输入h：显示队列头");
            System.out.println("输入l：显示队列所有值");
            System.out.println("输入e：推出队列");
            while (loop){
                switch (scanner.next()){
                    case "a":
                        System.out.println("请输入要添加数据");
                        int i = scanner.nextInt();
                        try {
                            aQueue.add(i);
                        } catch (Exception e) {
                            System.out.println(e.getMessage());
                        }
                        break;
                    case "g":
                        try {
                            System.out.println("取出的值是 = " + aQueue.get());
                        } catch (Exception e) {
                            System.out.println(e.getMessage());
                        }
                        break;
                    case "h":
                        try {
                            System.out.println("当前队列头为 = " + aQueue.head());
                        } catch (Exception e) {
                            System.out.println(e.getMessage());
                        }
                        break;
                    case "l":
                        System.out.println("当前队列值如下：");
                        try {
                            aQueue.list();
                        } catch (Exception e) {
                            System.out.println(e.getMessage());
                        }
                        break;
                    case "e":
                        loop = false;
                        break;
                    default:
                }
            }
            System.out.println("程序退出~~");
        }
    }
}

class AQueue {

    //队列最大容量
    private int maxSize;
    //队列读取游标
    private int front;
    //队列存储游标
    private int rear;
    //队列存储元素
    private int[] arr;

    public AQueue(int maxSize) {
        this.maxSize = maxSize;
        this.front = -1;
        this.rear = -1;
        this.arr = new int[maxSize];
    }

    public boolean isEmpty() {
        return front == rear;
    }

    public boolean isFull() {
        return rear == maxSize - 1;
    }

    public void add(int n) {
        if (isFull()) {
           throw new RuntimeException("队列已满");
        }
        rear++;
        arr[rear] = n;
    }

    public int get(){
        if (isEmpty()){
            throw new RuntimeException("队列已空");
        }
        front++;
        return arr[front];
    }

    public int head(){
        if (isEmpty()){
            throw new RuntimeException("队列为空");
        }
        return arr[front+1];
    }

    public void list(){
        if (isEmpty()){
            throw new RuntimeException("队列为空");
        }
        for (int i = front+1; i < arr.length; i++) {
            System.out.printf("i = %d, value=%d\n", i, arr[i]);
        }
    }




}
