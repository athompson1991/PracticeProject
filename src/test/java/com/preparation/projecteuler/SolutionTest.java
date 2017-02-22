package com.preparation.projecteuler;

import org.junit.Before;
import org.junit.Ignore;
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

    @Ignore
    @Test
    public void solutionNotSolved() throws NoSuchMethodException {
        for (Class solution : allSolutions) {
            try {
                AbstractSolution temp = (AbstractSolution) solution.newInstance();
                temp.solve();
                temp.printSolution();
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
    }

    @Test
    public void problem15() {
        Solution15 solution = new Solution15();
        solution.setGridSize(2);
        solution.solve();
        assertEquals(Long.valueOf(6), solution.getSolution());

        solution.setGridSize(20);
        solution.solve();
        solution.printSolution();
    }

    @Test
    public void problem42() {
        Solution42 solution = new Solution42();
        assertEquals(55, solution.triangleNumberCalculation(10));
        assertEquals(55, solution.valueOfString("SKY"));
        assertTrue(solution.isTriangle("SKY"));
        assertFalse(solution.isTriangle("SKZ"));

        solution.handleFile();
        solution.solve();
        solution.printSolution();

        assertEquals(162, solution.getSolution());
    }

    @Test
    public void problem48() {
        Solution48 solution = new Solution48();
        solution.setN(10);
        solution.solve();
        assertEquals("0405071317", solution.getSolution());
        solution.setN(1000);
        solution.solve();
        solution.printSolution();
    }

    @Ignore
    @Test
    public void problem50() {
        Solution50 solution50 =  new Solution50();
        solution50.solve();
        assertEquals(41, solution50.getSolution());
        solution50.setN(1000);
        solution50.solve();
        assertEquals(953, solution50.getSolution());
        solution50.setN(1000000);
        solution50.solve();
        solution50.printSolution();
    }

    @Ignore
    @Test
    public void problem46() {
        Solution46 solution46 = new Solution46();
        assertTrue(solution46.valueSupportsConjecture(33));
        assertTrue(solution46.valueSupportsConjecture(27));
        solution46.solve();
        solution46.printSolution();
    }
}
