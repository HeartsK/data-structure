package com.heartstone.structure.hashtab;

/**
 * @author code generator
 * @date 2022-06-07 16:02
 */
public class HashTableDemo {

    public static void main(String[] args) {
        Node node = new Node(1, "one");
        Node node2 = new Node(2, "two");
        Node node3 = new Node(3, "three");
        Node node4 = new Node(8, "four");

        HashTab hashTab = new HashTab(7);
        hashTab.add(node);
        hashTab.add(node2);
        hashTab.add(node3);
        hashTab.add(node4);
        hashTab.list();
    }
}

class Node {
    private int id;
    private String name;
    private Node next;

    public Node(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return "Node{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}

class LinkedNodeList {

    private Node head;

    public void add(Node node) {
        if (head == null) {
            head = node;
            return;
        }
        Node cur = head;
        while (cur.getNext() != null) {
            cur.setNext(cur.getNext());
        }
        cur.setNext(node);
    }

    public void list() {
        if (head == null) {
            return;
        }
        Node cur = head;
        while (true) {
            System.out.println(cur.toString());
            if (cur.getNext() == null) {
                break;
            }
            cur = cur.getNext();
        }
    }
}

class HashTab {

    private LinkedNodeList[] linkedListArrays;

    private int size;

    public HashTab(int size) {
        this.size = size;
        linkedListArrays = new LinkedNodeList[size];
        for (int i = 0; i < size; i++) {
            linkedListArrays[i] = new LinkedNodeList();
        }
    }

    public void add(Node node) {
        int hash = hash(node.getId());
        linkedListArrays[hash].add(node);
    }

    public void list() {
        for (int i = 0; i < size; i++) {
            LinkedNodeList nodeList = linkedListArrays[i];
            nodeList.list();
        }
    }

    private int hash(int id) {
        return id % size;
    }
}
