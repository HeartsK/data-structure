package com.heartstone.structure.stack;

/**
 * @author code generator
 * @date 2022-05-30 11:44
 */
public class LinkedListStackDemo {

    //单链表模拟栈，使用头插法会比较合适
    public static void main(String[] args) {
        LinkedListStack linkedListStack = new LinkedListStack(5);
        linkedListStack.push(new SingleListNode(0));
        linkedListStack.push(new SingleListNode(1));
        linkedListStack.push(new SingleListNode(2));
        linkedListStack.push(new SingleListNode(3));
        linkedListStack.push(new SingleListNode(4));
        linkedListStack.push(new SingleListNode(5));
        int pop = linkedListStack.pop();
        int pop1 = linkedListStack.pop();
        int pop2 = linkedListStack.pop();
        int pop3 = linkedListStack.pop();
        int pop4 = linkedListStack.pop();
        int pop5 = linkedListStack.pop();
    }
}

class LinkedListStack{

    private SingleListNode topNode =new SingleListNode(-1);

    private int count = -1;

    private int maxSize;

    public LinkedListStack(int size){
        this.maxSize = size;
    }

    public boolean isFull(){
        return count == maxSize -1;
    }

    public boolean isEmpty(){
        return count == -1;
    }

    //使用头插法添加
    public void push(SingleListNode node){
        if (isFull()){
            System.out.println("栈已满");
            return;
        }
        node.setNext(topNode.getNext());
        topNode.setNext(node);
        count++;
    }

    public int pop(){
        if (isEmpty()){
            throw new RuntimeException("栈已空");
        }
        SingleListNode temp = topNode.getNext();
        int num = temp.getNum();
        topNode.setNext(temp.getNext());
        count--;
        return num;
    }
}

class SingleListNode{

    private int num;
    private SingleListNode next;

    public SingleListNode(int num){
        this.num = num;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public SingleListNode getNext() {
        return next;
    }

    public void setNext(SingleListNode next) {
        this.next = next;
    }
}
