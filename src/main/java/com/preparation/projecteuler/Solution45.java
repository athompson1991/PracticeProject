package com.preparation.projecteuler;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by aleth on 3/27/2017.
 */
public class Solution45 extends AbstractSolution {

    private Integer generationLength;

    private List<Integer> triangleList;
    private List<Integer> allThreeList;

    public Solution45() {
        this.solutionNumber = 45;
        triangleList = new LinkedList<>();
        allThreeList = new LinkedList<>();

        this.generationLength = 10000;
    }

    public void setN(Integer n){
        this.generationLength = n;
    }

    private Integer triangleFunction(int n) {return (n * (n + 1)) / 2;}

    public boolean isPentagon(double n) {

    }

    private boolean isHexagon(double n) {return ( (double) n * ( 2.0 * (double) n - 1)) % 1 == 0;}

    private void generateSeries(int n) {
        for (int i = 0; i < n; i++)
            triangleList.add(triangleFunction(i));
    }

    public void solve() {
        generateSeries(generationLength);
        for (int i = 0; i < generationLength - 1; i++) {
            Integer checkTriangle = triangleList.get(i);
            if(isPentagon(checkTriangle) & isHexagon(checkTriangle))
                allThreeList.add(checkTriangle);
        }
        System.out.println(allThreeList);
    }
}
