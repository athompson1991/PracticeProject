package com.preparation.datastructures.linkedlists;

import com.preparation.datastructures.linkedlists.LinkedList;

/**
 * Created by aleth on 12/2/2016.
 */
public class RunLinkedList {
    public static void printHeader(String message) {
        String repeated;

        repeated = String.format(String.format("%%%ds", message.length() + 4) , " ").replace(" ","-");
        System.out.println("\n");

        System.out.println(repeated);
        System.out.println("| " + message + " |");
        System.out.println(repeated);
    }

    public static void main(String[] args) {
        LinkedList myList = new LinkedList();

        myList.addFirst("Alex");
        myList.addFirst("Lucas");
        myList.addFirst("Bob");
        myList.addFirst("Sue");
        myList.addFirst("Old MacDonald");
        myList.addFirst("Dinosaurs");
        printHeader("Initial data");
        myList.printListOneliner();

        myList.delete(0);
        printHeader("After deletion");
        myList.printListOneliner();

        myList.insertBefore("Joe", 1);
        printHeader("Before insert");
        myList.printListOneliner();

        myList.insertBefore("zeroth", 0);
        printHeader("Before insert");
        myList.printListOneliner();

        myList.insertAfter("Fail?", 4);
        printHeader("After insert");
        myList.printListOneliner();

    }
}
