package com.preparation.randompractice;

import org.junit.Test;

import javax.script.ScriptException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by aleth on 1/17/2017.
 */
public class FiveProblemsTest {
    @Test
    public void sumTest() {
        List<Integer> myList = Arrays.asList(3, 12, 4, 6, 36, 9, 1);
        int trueSum = 71;
        assertEquals(trueSum, FiveProblems.forLoopSum(myList));
        assertEquals(trueSum, FiveProblems.whileLoopSum(myList));
        assertEquals(trueSum, FiveProblems.recursiveSum(myList, 0, 0));
    }

    @Test
    public void combineLists() {
        List firstList = Arrays.asList("a", "b", "c");
        List secondList = Arrays.asList(1, 2, 3);
        List combinedList = Arrays.asList("a", 1, "b", 2, "c", 3);
        assertEquals(combinedList, FiveProblems.combineLists(firstList, secondList));

        firstList = Arrays.asList("a", "b", "c", "d", "e");
        combinedList = Arrays.asList("a", 1, "b", 2, "c", 3, "d", "e");
        assertEquals(combinedList, FiveProblems.combineLists(firstList, secondList));
    }

    @Test
    public void makeFibonacciList() {
        List testList = Arrays.asList(0, 1, 1, 2, 3, 5, 8);
        assertEquals(testList, FiveProblems.makeFibbonaciList(7));
    }

    @Test
    public void maxNumberConcat() {
        List testList = Arrays.asList(1, 20, 100);
        assertEquals(201100, FiveProblems.maxNumber(testList));
    }

    @Test
    public void makeAllCombinations() throws ScriptException {
        ArrayList testList = new ArrayList();
        testList = FiveProblems.get100Combinations();
        assertTrue(testList.contains("1+2+34-5+67-8+9"));
    }

}
