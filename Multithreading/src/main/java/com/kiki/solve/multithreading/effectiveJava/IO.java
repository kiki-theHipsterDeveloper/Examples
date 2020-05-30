package com.kiki.solve.multithreading.effectiveJava;

import java.io.*;

public class IO {
    public static void main(String[] args) {
        //old approach
        /*OutputStream outputStream = null;

        try{
            outputStream = new FileOutputStream("out.txt");

        } catch (IOException e) {
            e.printStackTrace();
        }finally {
           outputStream.close();
        }*/

        //using java 8 try with resources
        try(OutputStream outputStream = new FileOutputStream("ot.txt"); InputStream inputStream = new FileInputStream("in.txt")){

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
