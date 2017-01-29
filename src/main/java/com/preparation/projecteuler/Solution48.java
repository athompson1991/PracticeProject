package com.preparation.projecteuler;

/**
 * Created by Alex on 1/28/2017.
 */
public class Solution48 extends AbstractSolution{
    private int n;

    public Solution48() {
        this.solutionNumber = 48;
        this.n = 1000;
    }

    public void setN(int in) {
        n = in;
    }

    private String padZero(Long inLong) {
        String outString = inLong.toString();
        for(int i = 0; i < 10 - outString.length(); i++){
            outString = "0" + outString;
        }
        return outString;
    }

    public Long customPower(int a, int n) {
        Long out = (long) a;
        for(int i = 0; i < n - 1; i++) {
            out = (out * a) % 10000000000L;
        }
        return out;
    }

    public void solve() {
        long sum = 0;
        for(int i = 1; i < n; i++) {
            long tempExp = (long) customPower(i, i);
            sum = sum + tempExp;
        }
        sum = sum % 10000000000L;
        String out = padZero(sum);
        solution = out;
    }
}
