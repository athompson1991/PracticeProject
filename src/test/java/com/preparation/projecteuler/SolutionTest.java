package com.preparation.projecteuler;

import org.junit.Before;
import org.junit.Test;
import org.reflections.Reflections;

import java.util.Set;

import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertTrue;

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
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
    }
}
