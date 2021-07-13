package com.gcy.linkedlist.base;

public class Node {

    public int data;
    public Node next = null;

    public Node(int data){
        this.data = data;
    }

    @Override
    public String toString() {
        return String.valueOf(data);
    }
}
