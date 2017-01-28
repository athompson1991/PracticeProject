package com.preparation.projecteuler;

/**
 * Created by aleth on 1/24/2017.
 */
public class Solution42 extends AbstractSolution implements Solution {

    Solution42() {
        solutionNumber = 42;
    }

    private int triangleNumberCalculation(int n) {
        return (n * (n + 1)) / 2;
    }

}
