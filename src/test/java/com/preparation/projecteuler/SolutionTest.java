package com.preparation.projecteuler;

import org.junit.Before;
import org.junit.Test;
import org.reflections.Reflections;

import java.util.Set;

import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;

/**
 * Created by aleth on 1/24/2017.
 */
public class SolutionTest {
    Reflections reflections;
    Set<Class<? extends AbstractSolution>> allSolutions;

    @Before
    public void setUp() {
        reflections = new Reflections("com.preparation.projecteuler");
        allSolutions = reflections.getSubTypesOf(AbstractSolution.class);
    }

    @Test
    public void solutionNotSolved() throws NoSuchMethodException {
        for (Class solution : allSolutions) {
            try {
                AbstractSolution temp = (AbstractSolution) solution.newInstance();
                assertFalse(temp.isSolved());
                temp.printSolution();
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
    }

    @Test
    public void problem42() {
        Solution42 solution = new Solution42();
        assertEquals(55, solution.triangleNumberCalculation(10));
        assertEquals(55, solution.valueOfString("SKY"));

        solution.handleFile();
    }
}
