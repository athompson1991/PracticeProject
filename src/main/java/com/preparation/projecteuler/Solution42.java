package com.preparation.projecteuler;

import com.preparation.helpers.ResourcesHandler;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by aleth on 1/24/2017.
 */
public class Solution42 extends AbstractSolution implements Solution {

    private ResourcesHandler resourcesHandler;
    private String raw;
    private String[] cleaned;
    HashMap<String, Integer> alphabet = new HashMap<String, Integer>();
    List<Integer> triangleValues = new LinkedList<Integer>();

    public Solution42() {
        solutionNumber = 42;
        resourcesHandler = new ResourcesHandler();
        this.makeAlphabet();
        this.populateList();
        this.handleFile();
    }

    private void populateList() {
        for (int i = 0; i < 10000; i++) {
            triangleValues.add(triangleNumberCalculation(i));
        }
    }

    protected int triangleNumberCalculation(int n) {
        return (n * (n + 1)) / 2;
    }

    public void handleFile() {
        raw = resourcesHandler.getFile("p042_words.txt");
        raw = raw.split("\n", 2)[0];
        raw = raw.replaceAll("\"", "");
        cleaned = raw.split(",");
    }

    private void makeAlphabet() {
        int j = 1;
        for (char i = 'A'; i <= 'Z'; i++) {
            alphabet.put(String.valueOf(i), j);
            j++;
        }
    }


    public void solve() {
        int sum = 0;
        for(int i = 0; i < cleaned.length; i++) {
            if(isTriangle(cleaned[i]))
                sum++;
        }
        this.solution = sum;
    }

    public int valueOfString(String in) {
        int out = 0;
        for (int i = 0; i < in.length(); i++) {
            String checkVal = String.valueOf(in.charAt(i));
            out = out + alphabet.get(checkVal);
        }
        return out;
    }

    public boolean isTriangle(String in) {
        int checkValue = valueOfString(in);
        return triangleValues.contains(checkValue);
    }
}
