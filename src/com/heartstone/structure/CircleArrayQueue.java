package com.heartstone.structure;

import java.util.Scanner;

/**
 *
 * @author code generator
 * @date 2022-05-20 16:08
 */
public class CircleArrayQueue {

    public static void main(String[] args) {
        CircleQueue aQueue = new CircleQueue(4);
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

class CircleQueue{

    //队列最大容量
    private int maxSize;
    //队列读取游标
    private int front;
    //队列存储游标
    private int rear;
    //队列存储元素
    private int[] arr;

    public CircleQueue(int maxSize) {
        this.maxSize = maxSize;
        this.arr = new int[maxSize];
    }

    public boolean isEmpty() {
        return rear  == front;
    }

    public boolean isFull(){
        return  (rear+1)%maxSize == front;
    }

    public void add(int n) {
        if (isFull()) {
            throw new RuntimeException("队列已满");
        }
        arr[rear] = n;
        rear = (rear+1)%maxSize;
    }

    public int get() {
        if (isEmpty()){
            throw new RuntimeException("队列已空");
        }
        int n = arr[front];
        front = (front+1)%maxSize;
        return n;
    }

    public int head(){
        if (isEmpty()){
            throw new RuntimeException("队列为空");
        }
        return arr[front];
    }

    public void list(){
        if (isEmpty()){
            throw new RuntimeException("队列为空");
        }
        for (int i = front; i < front+effectiveNum(); i++) {
            System.out.printf("arr[%d] =%d\n", i, arr[i]);
        }
    }

    private int effectiveNum(){
        return (rear - front + maxSize)%maxSize;
    }
}