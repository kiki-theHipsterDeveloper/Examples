/*
 * Copyright (c) 2018. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.kiki.solve.famous.problems;

/**
 *Program to print Fibonacci series for count of 10 using recursion
 */
public class FibonacciUsingRecursion {
    static int n1 = 0;
    static int n2 = 1;

    public static void printFibonacci(int count) {
        if (count > 0) {
            int n3 = n1 + n2;
            n1 = n2;
            n2 = n3;
            System.out.print(n3);
            printFibonacci(count - 1);
        }
    }

    public static void main(String[] args) {
        System.out.print(n1);
        System.out.print(n2);
        printFibonacci(10);
    }
}
