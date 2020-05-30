package com.kiki.solve.multithreading.codingInterviews.arrays;

import java.util.Arrays;

public class FindDuplicatesArray {

    public static void main(String[] args) {
        //to find duplicates in array without using collections eg. SEt


        int a[] = {1,2,2,3,4,5,6,6};
        Arrays.sort(a);
        int adjacent;

        int first = a[0];

/*
        for (int i =1; i < a.length ;i ++) {
        adjacent = a[i];
            if (i==1) {
                if (first == adjacent) {
                    System.out.println("duplicate " + adjacent);
                }
                else
                {
                    a[1] = adjacent;
                }
            }else {

                if (a[i -1] == adjacent) {
                    System.out.println("duplicate ");
                    a[i] =0;
                }
                else{
                    a[i] = adjacent;
                }
            }
        }
*/

int previous = a[0];

int result [] = new int[a.length];
for(int i = 0; i < a.length;i++){
int ch = a[i];

    if (previous!=ch) {
        result[i] =ch;
    }
    previous = ch;
}
        System.out.println(Arrays.toString(result));

    }
}
