package com.preparation.datastructures;

import java.util.NoSuchElementException;
import java.util.Random;

/**
 * Created by aleth on 12/6/2016.
 */
public class Sorter {

    private int arraySize = 1000;
    private int maxSize = 1000;
    private boolean isSorted;
    private Random randomizer = new Random();
    private final int[] array = new int[arraySize];

    public void populateRandomArray() {
        for (int i = 0; i < arraySize; i++) {
            array[i] = randomizer.nextInt(maxSize);
        }
    }

    public void populateSortedArray() {
        for (int i = 0; i < arraySize; i++) {
            array[i] = i;
        }
    }

    public void swap(int i, int j) {
        if (i < 0 || j >= arraySize) throw new NoSuchElementException();
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public int[] getData() {
        return array;
    }

    public boolean isEmpty() {
        boolean empty = true;
        for (int i = 0; i < arraySize; i++) if (array[i] != 0) empty = false;
        return empty;
    }

    public boolean isSorted() {
        isSorted = true;
        for (int i = 1; i < arraySize; i++) {
            if (array[i] < array[i - 1]) isSorted = false;
        }
        return isSorted;
    }

    public void selectionSort() {
        for (int i = 0; i < arraySize; i++) {
            int tempMin = i;
            for (int j = i + 1; j < arraySize; j++) {
                if (array[j] < array[tempMin])
                    tempMin = j;
            }
            swap(i, tempMin);
        }
    }

    public void insertionSort() {
        for (int i = 0; i < arraySize; i++) {
            for (int j = i; j > 0 && array[j] < array[j - 1]; j--) {
                swap(j, j - 1);
            }
        }
    }

    public void bubbleSort() {
        for (int i = 0; i < arraySize; i++) {
            boolean swapped = false;
            for (int j = arraySize - 1; j > i; j--) {
                if (array[j] < array[j - 1]) {
                    swap(j, j - 1);
                    swapped = true;
                }
            }
            if (!swapped) break;
        }
    }

    // Merge Sort methods

    public void mergeSort() {
        int[] workArray = new int[arraySize];
        workArray = copyArray(array, 0, arraySize, workArray);
        split(workArray, 0, arraySize - 1, array);
    }

    private void split(int[] inArr, int begin, int end, int[] sortArray) {
        if (end - begin < 2)
            return;
        int middle = (end + begin) / 2;
        split(sortArray, begin, middle, inArr);
        split(sortArray, middle, end, inArr);
        merge(inArr, begin, middle, end, sortArray);
    }

    private void merge(int[] inArr, int begin, int middle, int end, int[] outArr) {
        int i = begin;
        int j = middle;

        for (int k = begin; k < end; k++) {
            if (i < middle && (j >= end || inArr[i] <= inArr[j])) {
                outArr[k] = inArr[j];
                i++;
            } else {
                outArr[k] = inArr[j];
                j++;
            }
        }
    }

    private int[] copyArray(int[] oldArray, int begin, int end, int[] newArray) {
        for (int i = begin; i < end; i++) {
            newArray[i] = oldArray[i];
        }
        return newArray;
    }

    // Heap Sort methods

    public void heapSort() {
    }

    // Quick Sort methods

    public void quickSort() {
    }
}
