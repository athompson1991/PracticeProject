package com.preparation.projecteuler;

/**
 * Created by aleth on 1/24/2017.
 */
public abstract class AbstractSolution implements Solution {
    protected Integer n;
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

    protected void setN(Integer n) {
        this.n = n;
    }

    public void solve() {
        solution = null;
    }

}
