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

    public void insertionSort() {
       for (int i = 0; i < arraySize; i++) {
           for(int j = i; j > 0 && array[j] < array[j-1]; j--) {
                swap(j, j-1);
           }
       }


    }
//        for(int i = 0; i < arraySize; i++) {
//            for(int j = i; j > 0 && array[i] < array[j-1]; j--) {
//                array[j] = array[j-1];
//            }
//        }
//    }

//    public void shellSort() {
//        int k = arraySize / 2;
//        while(k >= 1) {
//            for(int i = 0; i < arraySize; i+=k) {
//
//            }
//        }
//    }

    public void mergeSort() {
        mergeSort(array, 0, arraySize - 1);
    }

    public void mergeSort(int arr[], int lo, int hi) {
        int midpoint = (lo + hi) / 2;
        if(lo >= hi) return;

        mergeSort(arr, lo, midpoint);
        mergeSort(arr, midpoint + 1, hi);

    }

    public int[] getData() {
        return array;
    }

    public boolean isEmpty() {
        boolean empty = true;
        for(int i = 0; i < arraySize; i++) if(array[i] != 0) empty = false;
        return empty;
    }

    public void printHead() {
        for(int i = 0; i < 10; i++) {
            System.out.println(array[i]);
        }
    }

    public boolean isSorted() {
        isSorted = true;
        for(int i = 1; i < arraySize; i++) {
            if(array[i] < array[i-1]) isSorted = false;
        }
        return isSorted;
    }

}
