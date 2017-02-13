package com.preparation.projecteuler;

/**
 * Created by aleth on 1/24/2017.
 */
public abstract class AbstractSolution implements SolutionInterface{
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
    }

    public boolean isSolved() {
        return solved;
    }

}
