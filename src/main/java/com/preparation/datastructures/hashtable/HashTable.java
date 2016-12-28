package com.preparation.datastructures.hashtable;


import java.util.LinkedList;

/**
 * Created by aleth on 12/12/2016.
 */
public class HashTable {

    private class TableEntry {
        String key;
        String value;
        TableEntry next;

        TableEntry(String key, String value) {
            this.key = key;
            this.value = value;
            this.next = null;
        }
    }

    private int size = 100;
    private TableEntry[] table = new TableEntry[size];

    public int getSize() {
        return size;
    }

    boolean indexIsEmpty(int index) {
        return table[index] == null;
    }

    int hash(String in) {
        int out = 0;
        for (int i = 0; i < in.length(); i++)
            out += (int) in.charAt(i);
        out = out % size;
        return out;
    }

    public void add(String key, String value) {
        int index = hash(key);
        TableEntry entry = new TableEntry(key, value);
        if (indexIsEmpty(index)) {
            table[index] = entry;
        } else {
            TableEntry temp = table[index];
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = entry;
        }
    }

    public String get(String key) {
        int index = hash(key);
        TableEntry entry = table[index];
        if (entry == null) throw new IndexOutOfBoundsException("No entry");
        if (entry.key == key) {
            return entry.value;
        } else {
            while (entry.next != null & entry.key != key) {
                entry = entry.next;
            }
            return entry.value;
        }
    }

}
