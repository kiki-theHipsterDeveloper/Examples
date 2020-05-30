package com.kiki.solve.multithreading.codingInterviews.arrays;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PairInttoSum {

    //find if pair of integers matches given sum in an array.

    public static void main(String[] args) {

        //below approach is for  O(n^2)
        int givenNum=9;
        int a[] = new int[]{0,1,3,6,9,10};

       /* for (int i=0; i <=a.length-1;i++){
            System.out.println(a[i]);
            for (int j=i +1;j<=a.length-1; j++){
                System.out.println(a[j]);
                if (a[i]+a[j] == givenNum) {
                    System.out.println("sum matches for pair {" + a[i]+"," +a[j]+"}");
                }
            }
        }*/

        //below appraoch is o(n) with additional space
        Set<Integer> temp = new HashSet();




      /*  Set<Integer> set = new HashSet(a.length);

        for(int value : a){
            int target = givenNum - value;

            // if target number is not in set then add
            if(!set.contains(target)){
                set.add(value);
            }else {
                System.out.printf("(%d, %d) %n", value, target);
            }


        }
        System.out.println(set);
*/


        //below approach is best approach
        Arrays.sort(a);

        int left =0;
        int right = a.length-1;

        while(left < right){

            int k = a[left] + a[right];

            if (givenNum==k) {
                System.out.println("sum " + givenNum + " a[right] " + a[right] + " left " + a[left] );
                left = left +1;
                right = right - 1;
            }else if (givenNum > k ){
                left = left + 1;
            }else if (givenNum < k){
                right = right -1;
            }
        }



    }
}
