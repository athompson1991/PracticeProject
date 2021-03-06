package com.preparation.helpers;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Random;

/**
 * Created by aleth on 3/6/2017.
 */
public class NameHandler {
    private HashSet<String> firstNames;
    private HashSet<String> lastNames;
    private ResourcesHandler reader = new ResourcesHandler();
    private Random random;

    public NameHandler(Random random) {
        this.random = random;
    }

    public NameHandler() {
        this.random = new Random();
    }

    public void setRandom(Random random) {
        this.random = random;
    }

    public void readNames() {
        String[] firstNamesRaw = reader.getFile("first-names.txt").split("\n");
        String[] lastNamesRaw = reader.getFile("last-names.txt").split("\n");
        firstNames = new HashSet<>(Arrays.asList(firstNamesRaw));
        lastNames = new HashSet<>(Arrays.asList(lastNamesRaw));
    }

    public String getRandomName() {
        String out = "";
        int firstNamesN = firstNames.size();
        int lastNamesN = lastNames.size();
        int randomFirstIndex = random.nextInt(firstNamesN);
        int randomLastIndex = random.nextInt(lastNamesN);


        int i = 0;
        for (Object obj : firstNames) {
            if (i == randomFirstIndex)
                out = out + obj;
            i++;
        }

        out = out + " ";

        i = 0;
        for (Object obj : lastNames) {
            if (i == randomLastIndex)
                out = out + obj;
            i++;
        }

        return out;
    }

}
