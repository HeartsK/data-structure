package com.heartstone.structure.linkedlist;

/**
 * @author code generator
 * @date 2022-05-27 14:15
 */
public class CircleSingleListNodeDemo {

    public static void main(String[] args) {

        CircleListNode circleListNode = new CircleListNode();
        circleListNode.addNode(5);
        circleListNode.list();
        circleListNode.josephProblem(1,2,5);

    }
}

class CircleListNode{

    private CircleNode first;

    public CircleListNode(){}

    public void addNode(int nums){
        CircleNode cur = null;
        for (int i = 1; i <= nums; i++) {
            CircleNode circleNode = new CircleNode(i);
            if (i==1){
                first = circleNode;
                cur = circleNode;
                cur.next = first;
            }else {
                cur.next = circleNode;
                circleNode.next = first;
                cur = circleNode;
            }
        }
    }

    //约瑟夫问题处理
    public void josephProblem(int startNum, int countNum, int totalNum){
        //参数判断
        if(first == null || startNum <1 || startNum > totalNum){
            System.out.println("参数有误");
            return;
        }
        CircleNode helper = first;
        while (helper.next != first) {
            helper = helper.next;
        }
        for (int i = 0; i < startNum-1; i++) {
            helper = helper.next;
            first = first.next;
        }
        //然后在从进行移动抽出
        while (true){
            if (helper == first){
                break;
            }
            for (int i = 0; i < countNum-1 ; i++) {
                helper = helper.next;
                first = first.next;
            }
            System.out.printf("要抽出的节点是：%d\n",first.getNo());
            first = first.next;
            helper.next = first;
        }
        System.out.printf("最后留在圈内的节点是：%d\n",first.getNo());
    }

    public void list(){
        CircleNode temp = first;
        if (temp == null){
            System.out.println("链表为空");
            return;
        }
        while (true){
            if (temp.next != first){
                System.out.println(temp);
            }else {
                System.out.println(temp);
                break;
            }
            temp = temp.next;
        }
    }
}

class CircleNode{

    private int no;
    public CircleNode next;


    public CircleNode(int no){
        this.no = no;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    @Override
    public String toString() {
        return "CircleNode{" +
                "no=" + no +
                '}';
    }

}
