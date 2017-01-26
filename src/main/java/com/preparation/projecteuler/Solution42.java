package com.preparation.projecteuler;

import com.preparation.helpers.ResourcesHandler;

/**
 * Created by aleth on 1/24/2017.
 */
public class Solution42 extends AbstractSolution implements Solution {

    private ResourcesHandler resourcesHandler;
    private String raw;

    Solution42() {
        solutionNumber = 42;
        resourcesHandler = new ResourcesHandler();
    }

    private int triangleNumberCalculation(int n) {
        return (n * (n + 1)) / 2;
    }

    private void handleFile() {
        raw = resourcesHandler.getFile("p042_words.txt");
    }

}
