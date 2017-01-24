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

    private static char[][] permutationCalculation(int k, char[] charArray) {
        int n = charArray.length;
        int total = (int) Math.pow(n, k);
        int[] index = new int[k];
        char[][] out = new char[total][k];
        int i = total;

        while (i-- > 0) {
            for (int j = 0; j < k; j++) {
                if (index[j] >= n - 1) {
                    index[j] = 0;
                } else {
                    index[j]++;
                    break;
                }
            }
            for (int j = 0; j < k; j++) {
                out[i][j] = charArray[index[j]];
            }
        }
        return out;
    }

    private static ArrayList listFromCharArray(char[] charArray) {
        ArrayList out = new ArrayList();
        for (int i = 0; i < charArray.length; i++) {
            out.add(charArray[i]);
        }
        return out;
    }

    private static String listToString(List in) {
        String out = "";
        for (int i = 0; i < in.size(); i++) {
            out = out + in.get(i);
        }
        return out;
    }

    private static HashMap<String, List> produceAllSums() throws ScriptException {
        HashMap out = new HashMap<String, List>();
        List<Integer> sums = new ArrayList();
        List<String> strings = new ArrayList();
        List oneToNine = Arrays.asList("1", "2", "3", "4", "5", "6", "7", "8", "9");
        char[] operators = {'+', '-', ' '};
        char[][] outChar = permutationCalculation(8, operators);
        for (int i = 0; i < outChar.length; i++) {
            char[] fromArray = outChar[i];
            ArrayList permutations = listFromCharArray(fromArray);
            List arithmetic = combineLists(oneToNine, permutations);
            String stringRepresentation = listToString(arithmetic).replace(" ", "");
            int sum = evalString(stringRepresentation);
            sums.add(sum);
            strings.add(stringRepresentation);
        }
        out.put("string", strings);
        out.put("sum", sums);
        return out;
    }

    public static ArrayList get100Combinations() throws ScriptException {
        ArrayList out = new ArrayList();
        HashMap<String, List> main = produceAllSums();
        for (int i = 0; i < main.get("string").size(); i++) {
            if ((Integer) main.get("sum").get(i) == 100)
                out.add(main.get("string").get(i));

        }
        return out;
    }
}
