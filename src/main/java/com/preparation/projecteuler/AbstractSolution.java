package com.preparation.projecteuler;

/**
 * Created by aleth on 1/24/2017.
 */
public class AbstractSolution {
    protected boolean solved = false;
    protected int solutionNumber;

    public AbstractSolution() {
        solutionNumber = 0;
    }

    public void printSolution() {
        System.out.println("Solution " + String.valueOf(solutionNumber) + ":");
    }

    public void solve() {
        System.out.println("Abstract solve method.");
    }

    public boolean isSolved() {
        return solved;
    }
}
