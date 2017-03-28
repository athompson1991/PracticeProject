package com.preparation.projecteuler;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by aleth on 3/27/2017.
 */
public class Solution45 extends AbstractSolution {

    private long n;
    private List<Long> allThreeList;

    public Solution45() {
        this.solutionNumber = 45;
        allThreeList = new LinkedList<>();

        this.n = 10000;
    }

    public void setN(Long n) {
        this.n = n;
    }

    private boolean isTriangle(Long n) {
        return (-1 + Math.sqrt(1 + 8 * n)) % 2 == 0;
    }

    public boolean isHexagon(Long checkVal) {
        return (1 + Math.sqrt(1 + 8 * (double) checkVal)) % 4 == 0;
    }

    public boolean isPentagon(Long checkVal) {
        return (1 + Math.sqrt(1 + 24 * (double) checkVal)) % 6 == 0;
    }

    public boolean allTests(Long n) {
        return isTriangle(n) & isPentagon(n) & isHexagon(n);
    }

    public Long triangleCalculation(Long i) {
        return (i * (i + 1)) / 2;
    }

    public void solve() {
        Long i = new Long(1);
        Long k = new Long(0);
        while (k < n) {
            if (allTests(k))
                allThreeList.add(k);
            k = triangleCalculation(i);
            i++;
        }
        this.solution = allThreeList.get(allThreeList.size() - 1);
    }

}
