package com.preparation.datastructures;

import java.util.NoSuchElementException;
import java.util.Random;

/**
 * Created by aleth on 12/6/2016.
 */
public class Sorter {

    private int arraySize = 10000;
    private int maxSize = 1000;
    private boolean isSorted;
    private Random randomizer = new Random();
    private final int[] array = new int[arraySize];

    public void populateRandomArray() {
        for(int i = 0; i < arraySize; i++){
            array[i] = randomizer.nextInt(maxSize);
        }
    }

    public void populateSortedArray() {
        for(int i = 0; i < arraySize; i++) {
            array[i] = i;
        }
    }

    public void swap(int i, int j){
        if(i < 0 || j >= arraySize) throw new NoSuchElementException();
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public int[] getData() {
        return array;
    }

    public boolean isEmpty() {
        boolean empty = true;
        for(int i = 0; i < arraySize; i++) if(array[i] != 0) empty = false;
        return empty;
    }

    public boolean isSorted() {
        isSorted = true;
        for(int i = 1; i < arraySize; i++) {
            if(array[i] < array[i-1]) isSorted = false;
        }
        return isSorted;
    }

    public void selectionSort() {
    }

    public void insertionSort() {
        for (int i = 0; i < arraySize; i++) {
            for(int j = i; j > 0 && array[j] < array[j-1]; j--) {
                swap(j, j-1);
            }
        }
    }

    public void bubbleSort() {
    }

    public void mergeSort() {

    }

    public void heapSort() {
    }

    public void quickSort() {
    }
}
