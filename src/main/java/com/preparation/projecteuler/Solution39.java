package com.preparation.projecteuler;

import java.util.*;


/**
 * Created by aleth on 3/27/2017.
 */
public class Solution39 extends AbstractSolution {

    private int p;
    private List<Integer[]> combinations;
    private HashMap<Integer, Set<Set<Integer>>> mapFromPToSet;

    public Solution39() {
        this.p = 1000;
        this.combinations = new LinkedList<>();
        this.mapFromPToSet = new HashMap<>();
        this.solutionNumber = 39;
    }

    public void setP(int p) {
        this.p = p;
    }

    private boolean validTriangle(int a, int b, int c) {
        return (a < b + c) & (b < a + c) & (c < a + b);
    }

    public void generateTriangles() {
        int a = 1;
        while (a < p) {
            int b = 1;
            while (b < p) {
                Integer[] tempComb = new Integer[]{0, 0, 0};
                double c = Math.sqrt(a * a + b * b);
                if (c % 1 == 0) {
                    if (validTriangle(a, b, (int) c)) {
                        tempComb[0] = a;
                        tempComb[1] = b;
                        tempComb[2] = (int) c;
                        combinations.add(tempComb);
                    }
                }
                b++;
            }
            a++;
        }
    }

    private Set IntegerArrToSet(Integer[] integer) {
        Set outSet = new HashSet<Integer>();
        for (int i = 0; i < integer.length; i++)
            outSet.add(integer[i]);
        return outSet;
    }

    private Integer sumFromIntegerArr(Integer[] integer) {
        Integer out = 0;
        for (int i = 0; i < integer.length; i++) {
            out += integer[i];
        }
        return out;
    }

    private Integer maxLength(Map<Integer, Set<Set<Integer>>> mainMapping) {
        int currentMaxSize = 0;
        int currentMaxIndex = 0;
        Set vals = mainMapping.keySet();
        Iterator<Integer> index = vals.iterator();
        while (index.hasNext()) {
            Integer current = index.next();
            Set checkLength = mainMapping.get(current);
            if (checkLength.size() > currentMaxSize) {
                currentMaxIndex = current;
                currentMaxSize = checkLength.size();
            }
        }
        return currentMaxIndex;
    }

    public void solve() {
        for (int i = 1; i < p; i++) {
            Set<Set<Integer>> tempPSet = new HashSet<>();
            for (int j = 0; j < combinations.size(); j++) {
                Integer[] tempTriangle = combinations.get(j);
                if (sumFromIntegerArr(tempTriangle).equals(i))
                    tempPSet.add(IntegerArrToSet(tempTriangle));
            }
            mapFromPToSet.put(i, tempPSet);
        }
        System.out.println(mapFromPToSet);
        this.solution = maxLength(mapFromPToSet);
    }

    @Override
    public String toString() {
        StringBuilder out = new StringBuilder();
        Iterator<Integer[]> iterator = combinations.iterator();
        while (iterator.hasNext()) {
            Integer[] current = iterator.next();
            out.append("A: " + current[0] + " B: " + current[1] + " C: " + current[2]);
            out.append("\n");
        }
        return (out.toString());
    }

}
