package com.preparation.datastructures;

import junit.framework.TestCase;
import org.junit.Test;

import java.util.NoSuchElementException;

/**
 * Created by aleth on 12/6/2016.
 */
public class SorterTest extends TestCase {

    Sorter mySorter;

    public void setUp() {
        mySorter = new Sorter();
        mySorter.populateRandomArray();
    }

    public void testPopulateArray() {
        Sorter testSorter = new Sorter();
        assertTrue(testSorter.isEmpty());
        testSorter.populateRandomArray();
        assertNotSame(0, testSorter.getData()[0]);
        assertNotSame(0, testSorter.getData()[10]);
        assertNotSame(0, testSorter.getData()[testSorter.getData().length - 1]);
        assertFalse(testSorter.isSorted());
        testSorter.populateSortedArray();
        assertTrue(testSorter.isSorted());
    }

    public void testSwap() {
        int second = mySorter.getData()[1];
        mySorter.swap(0, 1);
        assertEquals(mySorter.getData()[0], second);
    }

    public void testInsertionSort() {
        mySorter.insertionSort();
        assertTrue(mySorter.isSorted());
    }

    public void testSelectionSort() {
        mySorter.selectionSort();
        assertTrue(mySorter.isSorted());
    }

    public void testBubble() {
        mySorter.bubbleSort();
        assertTrue(mySorter.isSorted());
    }

    public void testMergeSort() {
        mySorter.mergeSort();
        assertTrue(mySorter.isSorted());
    }

    public void testHeapSort() {
        mySorter.heapSort();
        assertTrue(mySorter.isSorted());
    }

    public void testQuickSort() {
        mySorter.quickSort();
        assertTrue(mySorter.isSorted());
    }

    public void tearDown() {
        mySorter = null;
    }
}
