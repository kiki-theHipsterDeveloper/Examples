package com.kiki.solve.multithreading.codingInterviews;

public class BinearySearch {

    public static void search(int a[],int key,int low, int high){
        int comparison = a[Math.round(high/2)];
        if (key == comparison ){
            System.out.println("Match Found" + high/2 + " " +comparison);
        }
        else if (key < comparison){
            search(a,key,low,comparison -1);
        }else if (key > comparison){
            search(a,key,comparison +1,high);
        }
    }


    public static void main(String[] args) {
        int a[] = {1,2,3,4,5,6,7,8,9,10};

     //   search(a,8,0,9);
        iterativeBinarySearch(a,7);
    }

    public static void iterativeBinarySearch(int arr[],int x){

        int r = arr.length-1;
        int l =0;

        while(l<=r){

            int m = l + (r-l) /2;

            if (x==arr[m]) {
                System.out.println("element found " + x);
                break;
            }
            else if (x> arr[m]){
                l = m+1;
                System.out.println("X is greater than middle  m " + m + " l " + l + " r " + r +" middle " + arr[m]);
            }else if (x < arr[m]){
                r = m-1;
                System.out.println("X is less than middle  m " + m + " l " + l + "r " + r +" middle " + arr[m]);
            }

        }

    }
}
