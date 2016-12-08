package com.preparation.datastructures.linkedlists;

/**
 * Created by aleth on 12/2/2016.
 */

public class LinkedListNode<String> {
    public String data;
    public LinkedListNode<String> next;

    public LinkedListNode(String data, LinkedListNode<String> next) {
        this.data = data;
        this.next = next;
    }
}
