package com.preparation.commandline;

import com.preparation.datastructures.linkedlist.LinkedList;

import java.io.IOException;
import java.util.Scanner;

/**
 * Created by aleth on 1/20/2017.
 */
public class CommandLineLinkedList extends CommandLine {

    private static LinkedList myLinkedList = new LinkedList();
    private static Scanner scanner = new Scanner(System.in);

    private static void getDataFromUser() throws IOException {
        System.out.print("Add item to list: ");
        String newItem = scanner.next();
        myLinkedList.push(newItem);
        myLinkedList.println();
    }

    public static void run() throws IOException {
        for (int i = 0; i < 10; i++)
            getDataFromUser();
    }

    public static void interrupt() {
        Runtime.getRuntime().addShutdownHook(new Thread() {

        });
    }

    public static void main(String[] args) throws IOException {
        run();
    }
}
