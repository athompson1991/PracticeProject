package com.preparation.commandline;

import java.io.IOException;

/**
 * Created by aleth on 1/20/2017.
 */
public abstract class CommandLine implements CommandLineInterface {
    private static void run() {
        System.out.println("Abstract Command Line");
    }

    ;

    private void createObjects() {
        System.out.println("Abstract Create Objects");
    }

    public static void main(String[] args) throws IOException {
        run();
    }
}
