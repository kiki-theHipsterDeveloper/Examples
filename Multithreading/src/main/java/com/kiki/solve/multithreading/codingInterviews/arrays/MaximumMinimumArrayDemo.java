package com.kiki.solve.multithreading.codingInterviews.arrays;

public class MaximumMinimumArrayDemo {
    public static void main(String[] args) {

        minMax(new int[] {1400,800,99,1000});

    }

    public static void minMax(int a[]){
        int largest = Integer.MIN_VALUE;
        int smallest = Integer.MAX_VALUE;

        for (Integer i : a){
            if (i > largest) {
                largest = i;
            }
            if (i < smallest){
                smallest = i;
            }
        }
        System.out.println( largest + "  " + smallest);
    }
}
