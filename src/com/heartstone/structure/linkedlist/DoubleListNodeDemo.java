package com.heartstone.structure.linkedlist;

/**
 * @author code generator
 * @date 2022-05-27 10:31
 */
public class DoubleListNodeDemo {

    public static void main(String[] args) {
        DoubleNode node1 = new DoubleNode("ONE",1);
        DoubleNode node2 = new DoubleNode("TWO",2);
        DoubleNode node3 = new DoubleNode("THREE",3);
        DoubleNode node4 = new DoubleNode("FOUR",4);
        DoubleListNode listNode = new DoubleListNode();
        /*listNode.addNode(node1);
        listNode.addNode(node2);
        listNode.addNode(node4);
        listNode.addNode(node3);
        listNode.listNode();
        listNode.update(new DoubleNode("二",2));
        System.out.println("修改后的打印~~");
        listNode.listNode();
        listNode.removeNode(2);
        listNode.removeNode(3);
        listNode.removeNode(1);
        listNode.removeNode(4);
        System.out.println("移除节点后的打印~~");
        listNode.listNode();*/
        listNode.addNodeByOrder(node1);
        listNode.addNodeByOrder(node3);
        listNode.addNodeByOrder(node2);
        listNode.addNodeByOrder(node4);
        listNode.listNode();
    }

}

class DoubleListNode{

    private DoubleNode head;

    public DoubleListNode(){
        this.head = new DoubleNode("", 0);
    }

    //删除节点
    public void removeNode(int no){
        DoubleNode temp = head.next;
        if (temp == null){
            System.out.println("链表为空");
        }
        while (true){
            if (temp == null){
                System.out.println("未找到对应节点");
                break;
            }
            if (temp.getNo() == no){
                //找到节点
                temp.pre.next = temp.next;
                if (temp.next != null){
                    temp.next.pre = temp.pre;
                }
                break;
            }
            temp = temp.next;
        }

    }

    //更新节点
    public void update(DoubleNode node){
        DoubleNode temp = head.next;
        if (temp == null){
            System.out.println("链表为空");
        }
        while (temp != null){
            if (temp.getNo() == node.getNo()){
                temp.setName(node.getName());
                break;
            }
            temp = temp.next;
        }
    }

    //将新节点按no顺序插入
    public void addNodeByOrder(DoubleNode node){
        //找到节点cur,将cur.pre.next = node,node.pre = cur.pre,
        // cur.pre =node,node.next=cur
        DoubleNode temp = head;
        boolean flag = false;
        while (temp.next != null){
            if (temp.next.getNo() > node.getNo()){
                flag = true;
                temp = temp.next;
                break;
            }
            temp = temp.next;
        }
        if (flag){
            temp.pre.next = node;
            node.pre = temp.pre;
            temp.pre = node;
            node.next = temp;
        }else {
            temp.next = node;
            node.pre = temp;
        }
    }

    //将新节点插入到最后
    public void addNode(DoubleNode node){
        DoubleNode temp = head;
        //找到最后一个节点，插入
        while (temp.next != null){
            temp = temp.next;
        }
        //插入
        temp.next = node;
        node.pre = temp;
    }

    public void listNode(){
        DoubleNode temp = head.next;
        if (temp.next == null){
            System.out.println("链表为空");
        }
        while (temp != null) {
            System.out.println(temp);
            temp = temp.next;
        }
    }

}

class DoubleNode{
    private int no;
    private String name;
    public DoubleNode next;//下一节点指针
    public DoubleNode pre;//上一节点指针


    public DoubleNode(String name, int no){
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
        return "DoubleNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                '}';
    }
}