package com.preparation.projecteuler;

/**
 * Created by aleth on 1/24/2017.
 */
public class AbstractSolution {
    boolean solved = false;

    public AbstractSolution() {
    }

    ;

    public void printSolution() {
        System.out.println("Abstract printSolution method.");
    }

    public void solve() {
        System.out.println("Abstract solve method.");
    }

    public boolean isSolved() {
        return solved;
    }
}
