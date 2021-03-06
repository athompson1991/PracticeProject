package com.preparation.projecteuler;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Alex on 2/12/2017 at 8:21 PM.
 */
public class Solution50 extends AbstractSolution {
    Utilities utilities = new Utilities();
    List<Integer> primeList;
    List<Integer> currentMaxList;

    public Solution50() {
        this.solution = 0;
        this.solutionNumber = 50;
        this.n = 100;
    }

    private void populatePrimeList() {
        primeList = new LinkedList<>();
        for (int i = 1; i < n; i++) {
            if (utilities.isPrime(i))
                primeList.add(i);
        }
    }

    public void solve() {
        currentMaxList = new LinkedList<>();
        populatePrimeList();
        int maxIndex = 0;
        int x = 0;
        while (primeList.get(x) + primeList.get(x + 1) <= this.n) {
            maxIndex = x;
            x++;
        }

        int maxLength = 0;
        for (int i = 0; i < maxIndex; i++) {
            List tempList = new LinkedList();
            int tempSum = 0;
            for (int j = i; j < maxIndex & tempSum < n; j++) {
                int currentPrime = primeList.get(j);
                tempList.add(currentPrime);
                tempSum+=currentPrime;
                if(checkList(tempSum)) {
                    if(tempList.size() > maxLength) {
                        solution = tempSum;
                        maxLength = tempList.size();
                    }
                }

            }
        }
    }

    private boolean checkList(int tempSum) {
        return utilities.isPrime(tempSum) & tempSum < n;
    }

}

