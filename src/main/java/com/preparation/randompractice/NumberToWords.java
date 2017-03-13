package com.preparation.randompractice;

import java.util.HashMap;

/**
 * Created by aleth on 3/10/2017.
 */
public class NumberToWords {
    private static HashMap<String, String> randomMap;
    private static HashMap<String, String> normalMap;

    public NumberToWords() {
        randomMap = new HashMap<>();
        normalMap = new HashMap<>();
        randomMap.put("11", "eleven");
        randomMap.put("12", "twelve");
        randomMap.put("13", "thirteen");
        String[] tempArray = {"one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
        for (int i = 1; i < 10; i++)
            normalMap.put(String.valueOf(i), tempArray[i]);
    }

    public static String fromText(String in) {
        String out = null;
        if (randomMap.keySet().contains(in))
            out = in;
        else {
            if (Integer.valueOf(in) < 1000) {
                out = parseString(in);
            } else {
                out = parseString(in.substring(0, 2)) + "thousand" + parseString(in.substring(3, in.length()));
            }
        }
        return out;
    }

    private static String parseString(String in) {
        String out = null;
        int length = in.length();
        if (randomMap.keySet().contains(in))
            out = randomMap.get(in);
        else if (length == 1) {
            out = normalMap.get(in);
        } else if (length == 2) {
            out = normalMap.get(in.charAt(0)) + "ty" + normalMap.get(in.charAt(1));
        } else if (length == 3) {
            out = normalMap.get(in.charAt(0)) + "hundred" + normalMap.get(in.charAt(1)) + "ty" + normalMap.get(in.charAt(2));
        }
        return out;
    }

    public static void main(String args[]) {
        String testString = "100";
        System.out.println(fromText(testString));
    }
}
