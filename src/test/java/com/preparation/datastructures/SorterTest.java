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
    }

    public void testPopulateArray() {
        assertTrue(mySorter.isEmpty());
        mySorter.populateRandomArray();
        assertNotSame(0, mySorter.getData()[0]);
        assertNotSame(0, mySorter.getData()[10]);
        assertNotSame(0, mySorter.getData()[mySorter.getData().length - 1]);
        assertFalse(mySorter.isSorted());
        mySorter.populateSortedArray();
        assertTrue(mySorter.isSorted());
    }

    public void testSwap() {
        int second = mySorter.getData()[1];
        mySorter.swap(0, 1);
        assertEquals(mySorter.getData()[0], second);
    }

    public void testInsertionSort() {
        mySorter.populateRandomArray();
        mySorter.insertionSort();
        assertTrue(mySorter.isSorted());
    }

    public void testMergeSort() {
        mySorter.populateRandomArray();
        mySorter.mergeSort();
        assertTrue(mySorter.isSorted());
    }
//
//    public void testShellSort() {
//        mySorter.populateRandomArray();
//        mySorter.shellSort();
//        assertTrue(mySorter.isSorted());
//    }

    public void tearDown() {
        mySorter = null;
    }
}
