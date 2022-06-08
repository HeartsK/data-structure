package com.heartstone.structure.linkedlist;

import java.util.Stack;

/**
 *
 * @author code generator
 * @date 2022-05-21 10:58
 */
public class SingleListNodeDemo {

    public static void main(String[] args) {

        Node node1 = new Node("ONE",1);
        Node node2 = new Node("TWO",2);
        Node node3 = new Node("THREE",3);
        Node node4 = new Node("FOUR",4);
        SingleList singleList = new SingleList();
        singleList.addByOrder(node4);
        singleList.addByOrder(node1);
        singleList.addByOrder(node3);
        singleList.addByOrder(node2);
        singleList.listNode();
        /*System.out.println("删除节点之后打印");
        singleList.removeNode(2);
        singleList.listNode();
        System.out.println("修改节点之后打印");
        singleList.update(new Node("update_two",1));
        singleList.listNode();*/
        int nodeLength = singleList.getNodeLength(singleList.getHead());
        System.out.printf("链表长度：%d\n", nodeLength);
        singleList.getReciprocalNode(singleList.getHead(), 3);
        /*System.out.println("反转之后的链表~~");
        singleList.reversalNode(singleList.getHead());
        singleList.listNode();*/
        System.out.println("反向打印链表~~");
        singleList.reverseTraversalNode();
    }
}
class SingleList{

    private Node head = new Node("",0);

    public Node getHead() {
        return head;
    }

    public void addNode(Node node){
        Node temp = head;
        while (temp.next != null){
            temp = temp.next;
        }
        temp.next = node;
    }

    public int getNodeLength(Node head){
        Node temp = head.next;
        int length = 0;
        while (temp != null){
            temp = temp.next;
            length++;
        }
        return length;
    }

    public void reversalNode(Node head){
        //这是空和不需要反转节点判断--之前缺少了
        if (head.next == null || head.next.next == null){
            return;
        }
        Node newHead = new Node("",0);
        Node cur = head.next;
        Node next;
        while (cur != null){
            next = cur.next;
            cur.next = newHead.next;
            newHead.next = cur;
            cur = next;
        }
        head.next = newHead.next;
    }

    public void reverseTraversalNode(){
        Stack<Node> stack = new Stack<Node>();
        if (head.next == null){
            System.out.println("链表为空");
        }
        Node temp = head.next;
        while (temp != null){
            stack.push(temp);
            temp = temp.next;
        }
        while (!stack.isEmpty()){
            System.out.println(stack.pop());
        }
    }

    public void getReciprocalNode(Node head, int no){
        if (head.next == null){
            System.out.println("链表为空");
        }
        Node temp = head.next;
        int nodeLength = getNodeLength(head);
        if (no <= 0 || no >nodeLength){
            System.out.println("无输入编号node");
            return;
        }
        for (int i = 0; i< nodeLength -no; i++){
            temp = temp.next;
        }
        System.out.println(temp);
    }

    public void addByOrder(Node node){
        Node temp = head;
        boolean flag = false;
        while (true){
            //已经最后一个
            if (temp.next == null){
                break;
            }
            if (temp.next.getNo() > node.getNo()){
                break;
            }else if (temp.next.getNo() == node.getNo()){
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if (flag){
            System.out.printf("该编号%d已经存在\n",node.getNo());
        }else {
            node.next = temp.next;
            temp.next = node;
        }
    }

    public void update(Node node){
        Node temp = head;
        while (true){
            if (temp.next == null){
                System.out.println("链表为空");
                break;
            }
            if (temp.next.getNo() == node.getNo()){
                temp.next.setName(node.getName());
                break;
            }else {
                System.out.println("没有可更新的指定节点");
            }
            temp = temp.next;
        }
    }

    public void removeNode(int no){
        Node temp = head;
        while (true){
            if (temp.next == null){
                System.out.println("链表为空");
                break;
            }
            if (temp.next.getNo() == no){
                temp.next = temp.next.next;
                break;
            }
            temp = temp.next;
        }

    }

    public void listNode(){
        Node temp = head.next;
        if (temp == null){
            System.out.println("链表为空");
        }
        while (temp != null){
            System.out.println(temp.toString());
            temp = temp.next;
        }
    }
}

class Node{
    private int no;
    private String name;
    public Node next;


    public Node(String name, int no){
        this.no = no;
        this.name = name;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Node{" +
                "no=" + no +
                ", name='" + name + '\'' +
                '}';
    }
}
