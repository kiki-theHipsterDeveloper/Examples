package com.kiki.solve.multithreading;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Prints the Fibonacci numbers for count of 10
 */
public class ThreadExample  {

    public static void main(String[] args) {

        ThreadExample threadExample = new ThreadExample();
        myrunnable myrunnable = threadExample.new myrunnable();
        Thread t1 = new Thread(myrunnable,"t1");
        Thread t2 = new Thread(myrunnable,"t2");
       //Thread t3 = new Thread(myrunnable,"t3");

        try {
           /* t1.start();
            System.out.println("joining 1");
            t1.join(2000);
            System.out.println("joining 11");
            System.out.println("starting 2");
            t2.start();
            System.out.println("joining 2");
            t1.join();
            System.out.println("starting 3");
            t3.start();*/
           t1.start();
           t2.start();
           t1.join();
           t2.join();
            System.out.println("getting count " + myrunnable.getCount());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    class myrunnable implements Runnable{

        public int getCount() {
            return count.get();
        }

        private final AtomicInteger count = new AtomicInteger();

        public void run() {
            /*System.out.println("before sleep " + Thread.currentThread().getName());
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("after sleep " + Thread.currentThread().getName());*/

            for (int i=1 ;i < 5 ; i++){
                try {
                    process(i);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                //System.out.println(Thread.currentThread().getName() + " before " + count);
                count.getAndIncrement();
               // System.out.println(Thread.currentThread().getName() + " after " + count);
            }
        }

        private void process(int i) throws InterruptedException {
            Thread.sleep(i * 1000);
        }
    }
}
