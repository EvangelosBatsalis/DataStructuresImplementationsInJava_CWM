package org.example;

public class Node {

    private int value;
    private Node next;

    //instead of using getter and setter i will use constructor because there is no need of creating a node without a value
    public Node(int value){
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }
}
