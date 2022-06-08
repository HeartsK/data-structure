package com.heartstone.structure.stack;

/**
 * @author code generator
 * @date 2022-05-30 12:20
 */
public class ArrayStackDemo {
}

class ArrayStack{

    private int maxSize;

    private int[] stack;

    private int top = -1;

    public ArrayStack(int maxSize){
        this.maxSize = maxSize;
        this.stack = new int[this.maxSize];
    }

    public boolean isFull(){
        return this.top  == this.maxSize-1;
    }

    public boolean isEmpty(){
        return this.top == -1;
    }

    public void push(int value){
        if (isFull()){
            System.out.println("栈满");
            return;
        }
        this.top++;
        this.stack[this.top] = value;
    }

    public int pop(){
        if (isEmpty()){
            throw new RuntimeException("栈空");
        }
        int  value  = this.stack[this.top];
        this.top--;
        return value;
    }

    public void list(){
        if (isEmpty()){
            System.out.println("栈为空");
            return;
        }
        for (int i = top; i >=0 ; i--) {
            System.out.printf("stack[%d] = %d", i, stack[i]);
        }
    }
}
