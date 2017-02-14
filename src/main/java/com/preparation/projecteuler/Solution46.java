package com.preparation.projecteuler;


import java.util.LinkedList;
import java.util.List;

/**
 * Created by Alex on 2/13/2017 at 9:29 PM.
 */
public class Solution46 extends AbstractSolution {
    List<Integer> primeList;
    Utilities utilities = new Utilities();

    public Solution46() {
        this.solutionNumber = 46;
    }

    private void populatePrimeList(int n) {
        primeList = new LinkedList();
        for (int i = 1; i < n; i++) {
            if (utilities.isPrime(i))
                primeList.add(i);
        }
    }

    private int generateSum(int primeValue, int baseValue) {
        int sum = primeValue + 2 * baseValue * baseValue;
        return sum;
    }

    public boolean valueSupportsConjecture(int n) {
        boolean meetsProblemCriteria = !utilities.isPrime(n) & n % 2 != 0;
        if (!meetsProblemCriteria)
            throw new IllegalArgumentException("Must be odd composite number");
        populatePrimeList(n);

        boolean out = false;

        int highestBaseValue = (int) Math.sqrt(n / 2);
        for (int i = 0; i < highestBaseValue + 1; i++) {
            for (int j = 0; j < primeList.size(); j++) {
                int thisPrime = primeList.get(j);
                int mainSum = generateSum(thisPrime, i);
                if (mainSum == n)
                    out = true;
            }
        }

        return out;
    }

    public void solve() {
        int i = 9;
        while (valueSupportsConjecture(i)) {
            while (utilities.isPrime(i + 2))
                i += 2;
            i += 2;
        }
        this.solution = i;
    }
}
