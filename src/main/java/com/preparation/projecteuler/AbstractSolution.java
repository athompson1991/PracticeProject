package com.preparation.projecteuler;

/**
 * Created by aleth on 1/24/2017.
 */
public class AbstractSolution {
    protected boolean solved = false;
    protected int solutionNumber;
    protected Object solution;

    protected AbstractSolution() {
        solutionNumber = 0;
    }

    public void printSolution() {
        System.out.println("Solution " + String.valueOf(solutionNumber) + ": " + String.valueOf(solution));
    }

    public Object getSolution() {
        return solution;
    }

    public void solve() {
        solution = null;
        System.out.println("Abstract solve method.");
    }

    public boolean isSolved() {
        System.out.println("Abstract isSolved method.");
        return solved;
    }

}
