package com.kiki.solve.multithreading.codingInterviews.arrays;

import java.util.ArrayList;
import java.util.List;

public class LongSeqFlip {

    public static void main(String[] args) {
        //to display longest sequence of 1 when flipped
        List<Integer> newArray = new ArrayList();
        int[] arr = {1,1,0,1,1,1,1,0,1,1};
        int count =0;

        for (int i =0;i<=arr.length-1;i++){
            int temp =arr[i];
            if (temp==0) {
                newArray.add(count);
                newArray.add(0);
                count=0;
                continue;
            }
            count ++;
             if (temp==1 && i == arr.length -1){
                newArray.add(count);
            }
        }
        int max=0;
        for(int i = 0;i <= newArray.size()-1;i++ ){
            if (newArray.get(i)==0) {
            int temp=  newArray.get(i-1)+ newArray.get(i+1) + 1;
                if (temp > max) {
                    max=temp;
                }
            }

        }
        
      /*  for (int i : arr){
        if(i==0){
            newArray.add(count);
            newArray.add(i);
            count=0;
        }
        else {
            count++;
            if(i==arr.length){
                newArray.add(count);
            }
        }

        }
*/

        System.out.println(newArray);
        System.out.println(max);

    }
}
