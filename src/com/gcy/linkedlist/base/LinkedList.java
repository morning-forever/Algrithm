package com.gcy.linkedlist.base;

public class LinkedList {

    public Node head = new Node(0);

    public void addNode(int data){
        Node temp = head;
        while(temp.next != null){
            temp = temp.next;
        }
        temp.next = new Node(data);
    }

    public void headInsert(int data){
        Node nodeNew = new Node(data);
        nodeNew.next = head.next;
        head.next = nodeNew;
    }

    public void print(){
        System.out.print("head");
        Node node = head.next;
        while(node != null){
            System.out.print("-->"+node.data);
            node = node.next;
        }
        System.out.println();
    }

    public void deleteNode(Node node){
        //把要删除节点的下一个节点的值赋给要删除的节点，则问题转化为“删除下一个节点”
        node.data = node.next.data;
        //删除下一个节点
        Node delNode = node.next;
        node.next = delNode.next;
        delNode.next = null;
    }
}

