package com.preparation.projecteuler;

/**
 * Created by Alex on 2/12/2017 at 1:17 PM.
 */
public class Utilities {

    public boolean isPrime(int in) {
        boolean out = true;
        if(in < 2)
            out = false;
        else if (in == 2 | in == 3)
            out = true;
        else if (in % 2 == 0)
            out = false;
        else if (in % 3 == 0)
            out = false;

        int i = 5;
        int w = 2;

        while (i * i <= in) {
            if (in % i == 0)
                out = false;
            i += w;
            w = 6 - w;
        }
        return out;
    }

}
