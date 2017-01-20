package com.preparation.randompractice;

import java.lang.reflect.Array;
import java.util.*;
import java.util.function.Predicate;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

/**
 * Created by aleth on 1/17/2017.
 */
public class FiveProblems {

    public static int forLoopSum(List<Integer> myList) {
        int out = 0;
        for (int i = 0; i < myList.size(); i++) {
            out = out + myList.get(i);
        }
        return out;
    }

    public static int whileLoopSum(List<Integer> myList) {
        int out = 0;
        int i = 0;
        while (i < myList.size()) {
            out += myList.get(i);
            i++;
        }
        return out;
    }


    public static int recursiveSum(List<Integer> myList, int tempIndex, int tempSum) {
        if (tempIndex == myList.size()) {
            return tempSum;
        } else {
            int newSum = tempSum + myList.get(tempIndex);
            return recursiveSum(myList, tempIndex + 1, newSum);
        }
    }

    public static List combineLists(List firstList, List secondList) {
        List outList = new LinkedList();
        boolean firstListBigger = firstList.size() > secondList.size();
        if (firstListBigger) {
            int i = 0;
            while (i < secondList.size()) {
                outList.add(firstList.get(i));
                outList.add(secondList.get(i));
                i++;
            }
            while (i < firstList.size()) {
                outList.add(firstList.get(i));
                i++;
            }
        } else {
            int i = 0;
            while (i < firstList.size()) {
                outList.add(firstList.get(i));
                outList.add(secondList.get(i));
                i++;
            }
            while (i < secondList.size()) {
                outList.add(firstList.get(i));
                i++;
            }
        }
        return outList;
    }


    public static List makeFibbonaciList(int size) {
        List<Integer> out = new LinkedList();
        if (size == 0) {
            out.add(0);
        } else if (size == 1) {
            out.add(0);
            out.add(1);
        } else {
            out.add(0);
            out.add(1);
            for (int i = 0; i < size - 2; i++) {
                out.add(out.get(i) + out.get(i + 1));
            }
        }

        return out;
    }

    public static int maxNumber(List<Integer> in) {
        int out;
        String outString = "";
        for (Integer i = 9; i > 0; i--) {
            List tempList = new LinkedList();
            for (int j = 0; j < in.size(); j++) {
                Integer number = in.get(j);
                if (number.toString().charAt(0) == i.toString().charAt(0)) {
                    tempList.add(number);
                }
                Collections.sort(tempList);
            }
            for (int k = 0; k < tempList.size(); k++) {
                outString = outString + tempList.get(k);
            }
        }
        out = Integer.valueOf(outString);
        return out;
    }

    private static Integer evalString(String in) throws ScriptException {
        Integer out = 0;
        ScriptEngineManager manager = new ScriptEngineManager();
        ScriptEngine engine = manager.getEngineByName("JavaScript");
        out = (Integer) engine.eval(in);
        return out;
    }

    private static char[][] permutationCalculation() {
        int total = (int) Math.pow(3, 8);
        char[] operations = {'+', '-', ' '};
        int[] index = new int[8];
        char[][] out = new char[total][8];
        int i = total;

        while (i-- > 0) {
            char[] temp = out[i];
            for (int j = 0; j < 8; j++) {
                if (index[j] >= 2) {
                    index[j] = 0;
                } else {
                    index[j]++;
                    break;
                }
            }
            for (int k = 0; k < 8; k++) {
                temp[k] = operations[index[k]];
            }
        }
        return out;
    }

    private static ArrayList produceAllSums() {
        ArrayList out = new ArrayList();
        List oneToNine = Arrays.asList("1", "2", "3", "4", "5", "6", "7", "8", "9");

        return out;
    }

    public static ArrayList get100Combinations() throws ScriptException {
        ArrayList out = new ArrayList();
        char[] chars = {'+', ' ', '-'};
        char[][] outChar = permutationCalculation();
        return out;
    }
}
