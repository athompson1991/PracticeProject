package com.preparation.datastructures.linkedlists;

import java.util.NoSuchElementException;

/**
 * Created by aleth on 12/2/2016.
 */
public class LinkedList {

    private LinkedListNode<String> head;
    public int size = 0;

    public LinkedList() {
        head = null;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public void addFirst(String data) {
        head = new LinkedListNode(data, head);
        size++;
    }

    public String getFirst() {
        if (head.data == null) throw new NoSuchElementException();
        return head.data;
    }

    public void removeFirst() {
        if (head.data == null) throw new NoSuchElementException();
        head = head.next;
        size--;
    }

    public void addLast(String data) {
        LinkedListNode<String> tempNode = head;
        while (tempNode.next != null) {
            tempNode = tempNode.next;
        }
        tempNode.next = new LinkedListNode<String>(data, null);
        size++;
    }

    public String getLast() {
        return get(size - 1);
    }

    public void clear() {

    }

    public String get(int position) {
        LinkedListNode<String> tempNode = head;
        for (int i = 0; i < position; i++) {
            tempNode = tempNode.next;
        }
        return tempNode.data;
    }

    public void insertAfter(String data, int position) {
        LinkedListNode<String> tempNode = head;
        for (int i = 0; i < position; i++) {
            tempNode = tempNode.next;
        }
        tempNode.next = new LinkedListNode<String>(data, tempNode.next);
        size++;
    }

    public void insertBefore(String data, int position) {
        LinkedListNode<String> previousNode = null;
        LinkedListNode<String> currentNode = head;
        int i = 0;

        if (position == 0) {
            addFirst(data);
        } else {
            while (currentNode != null & i < position) {
                previousNode = currentNode;
                currentNode = currentNode.next;
                i++;
            }
            if (currentNode != null) {
                previousNode.next = new LinkedListNode<String>(data, currentNode);
            }

            size++;
        }
    }

    public void delete(int position) {
        LinkedListNode<String> previousNode = null;
        LinkedListNode<String> currentNode = head;
        int i = 0;

        if (position == 0) {
            removeFirst();
        } else if (position >= size) {
            throw new IndexOutOfBoundsException("Can't delete, not enough data in list");
        } else {
            while (currentNode != null & i < position) {
                previousNode = currentNode;
                currentNode = currentNode.next;
                i++;
            }
            previousNode.next = currentNode.next;
            size--;
        }
    }

    public void printList() {
        int i = 0;
        while (i < size) {
            System.out.println("index " + i + ":   " + get(i));
            i++;
        }
    }

    public void printListOneliner() {
        String outString = "[";
        int i = 0;
        while (i < size - 1) {
            outString = outString + " " + get(i) + ",";
            i++;
        }
        outString = outString + " " + getLast() + " ]";
        System.out.println(outString);
    }

    public void reverse() {
        LinkedListNode currentNode = head;
        LinkedListNode previousNode = null;
        LinkedListNode nextNode = null;

        while (currentNode != null) {
            nextNode = currentNode.next;
            currentNode.next = previousNode;
            previousNode = currentNode;
            currentNode = nextNode;
        }
        head = previousNode;
    }
}




