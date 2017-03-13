package com.preparation.randompractice;

import java.util.HashMap;
import java.util.Objects;

/**
 * Created by aleth on 3/10/2017.
 */
public class NumberToWords {

    private HashMap<String, String> randomMap;
    private HashMap<String, String> normalMap;
    private HashMap<String, String> prefixList;

    public NumberToWords() {
        randomMap = new HashMap<>();
        normalMap = new HashMap<>();
        prefixList = new HashMap<>();
        randomMap.put("10", "ten");
        randomMap.put("11", "eleven");
        randomMap.put("12", "twelve");
        randomMap.put("14", "fourteen");
        prefixList.put("2", "twen");
        prefixList.put("3", "thir");
        prefixList.put("4", "for");
        prefixList.put("5", "fif");
        prefixList.put("6", "six");
        prefixList.put("7", "seven");
        prefixList.put("8", "eigh");
        prefixList.put("9", "nine");
        prefixList.put("0", "");
        String[] tempArray = {"", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
        for (int i = 0; i < 10; i++)
            normalMap.put(String.valueOf(i), tempArray[i]);
    }

    public String fromText(String in) {
        String out = null;
        if (Integer.valueOf(in) < 1000)
            out = parseString(in);
        else {
            int length = in.length();
            String firstThree = in.substring(0, length - 3);
            String lastThree = in.substring(length - 3, length);
            out = parseString(firstThree) + " thousand " + parseString(lastThree);
        }
        return out;
    }

    private String parseString(String in) {
        String out = null;
        int length = in.length();
        if (randomMap.keySet().contains(in))
            out = randomMap.get(in);
        else if (length == 1)
            out = normalMap.get(in);
        else if (length == 2) out = parseTens(in);
        else if (length == 3) {
            String hundredsChar = String.valueOf(in.charAt(0));
            String hundreds;
            if (hundredsChar.equals("0")) {
                hundreds = "";
            } else {
                hundreds = normalMap.get(hundredsChar) + " hundred ";
            }
            String tensRaw = in.substring(1, 3);
            out = hundreds + parseTens(tensRaw);
        }
        return out;
    }

    private String parseTens(String in) {
        String out;
        String tensChar = String.valueOf(in.charAt(0));
        String onesChar = String.valueOf(in.charAt(1));
        if (randomMap.keySet().contains(in))
            out = randomMap.get(in);
        else if (Objects.equals(tensChar, "1"))
            out = prefixList.get(onesChar) + "teen ";
        else if (Objects.equals(tensChar, "0"))
            out = normalMap.get(onesChar);
        else {
            String ones = normalMap.get(onesChar);
            if (onesChar.equals("0")) out = prefixList.get(tensChar) + "ty";
            else out = prefixList.get(tensChar) + "ty-" + ones;
        }
        return out;
    }

}
