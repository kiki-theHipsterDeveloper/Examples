package com.kiki.solve.multithreading.codingInterviews.arrays;

import java.util.BitSet;

public class MissingNumberinArray {
    public static void main(String[] args) {
        int a[] = new int[]{1,3,5};

        int totalCount = 5;
        int givenCount = a.length;

        // sum of n numbers n ((n+1)/2)

        int expectedSum = totalCount * ((totalCount + 1 ) / 2);
        int actualSum =0;

        for (Integer i : a
             ) {
            actualSum += i;
        }

      //  System.out.println(expectedSum - actualSum);

        BitSet bitSet = new BitSet(totalCount);

        int missingCount = totalCount - givenCount;


        for (Integer i : a){
            bitSet.set(i -1);
        }

        int lastMissingIndex = 0;
        for (int i = 0 ; i < missingCount ; i++){
            lastMissingIndex = bitSet.nextClearBit(lastMissingIndex);
            System.out.println(++lastMissingIndex);
        }



    }
}
