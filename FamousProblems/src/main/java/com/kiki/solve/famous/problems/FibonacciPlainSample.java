package com.kiki.solve.famous.problems;

/**
 * Prints the Fibonacci numbers for count of 10
 */
public class FibonacciPlainSample {

    public static void main(String[] args) {
        //0112358
        int count = 10;
        int previousFirst = 1;
        int previousSecond = 0;
        System.out.print(previousSecond);
        System.out.print(previousFirst);
        int result;
        for (int i = 1; i <= count; i++) {
            result = previousFirst + previousSecond;
            previousSecond = previousFirst;
            previousFirst= result;
            System.out.print(result);
        }
    }
}
