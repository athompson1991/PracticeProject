package com.preparation.projecteuler;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Alex on 2/12/2017 at 8:21 PM.
 */
public class Solution50 extends AbstractSolution {
    Utilities utillities = new Utilities();
    List<Integer> primeList;
    List<Integer> currentMaxList = new LinkedList<>();
    private int n;

    public Solution50() {
        this.solution = 0;
        this.solutionNumber = 50;
        this.n = 100;
    }

    private void populatePrimeList() {
        primeList = new LinkedList<>();
        for (int i = 1; i < n; i++) {
            if (utillities.isPrime(i))
                primeList.add(i);
        }
    }

    private int sumFromList(List<Integer> in) {
        int out = 0;
        for(int i = 0; i < in.size(); i++)
            out+=in.get(i);
        return out;
    }

    public void solve() {
        populatePrimeList();
        int maxIndex = 0;
        int x = 0;
        while (primeList.get(x) + primeList.get(x + 1) <= n) {
            maxIndex = x;
            x++;
        }

        for (int i = 0; i < maxIndex; i++) {
            int tempSum = 0;
            List<Integer> tempList = new LinkedList<>();
            for (int j = i; j < maxIndex & tempSum < n; j++) {
                int currentPrime = primeList.get(j);
                tempList.add(currentPrime);
                tempSum += currentPrime;
                if (utillities.isPrime(tempSum)) {
                    System.out.println(sumFromList(currentMaxList));
                    if (tempList.size() >= currentMaxList.size() & sumFromList(tempList) < n) {
//                        System.out.println("Sum: " + tempSum + " List: " + tempList + " length: " + tempList.size() );
                        currentMaxList = tempList;
                        this.solution = tempSum;
                    }
                }
            }
        }
    }

    public void setN(int n) {
        this.n = n;
    }
}

