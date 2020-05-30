package com.kiki.solve.multithreading;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Queue;

public class ProducerConsumer {


    public static void main(String[] args) {
        ProducerConsumer producerConsumer = new ProducerConsumer();
        producerConsumer.call();
    }

    private void call() {
        Queue sharedQueue = new LinkedList();

        producer producer = new producer(4, sharedQueue);
        consumer consumer = new consumer(4, sharedQueue);

        Thread pThread = new Thread(producer, "producer");
        Thread cThread = new Thread(consumer, "consumer");

        pThread.start();
        cThread.start();
    }

    class producer implements Runnable {
        int size;
        Queue sharedQueue;

        public producer(int size, Queue sharedQueue) {
            this.size = size;
            this.sharedQueue = sharedQueue;
        }

        public void run() {
           /* for (int i = 0; i < 7; i++) {
                produce(i);
            }*/

            for (int i = 0; i <= 10; i++) {
                synchronized (sharedQueue) {

                    if (sharedQueue.size() == size) {
                        try {
                            System.out.println("thread is full");
                            sharedQueue.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }

                synchronized (sharedQueue) {
                    System.out.println("adding i " + i + " " + sharedQueue.size());
                    sharedQueue.add(i);
                    sharedQueue.notify();

                }

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

        /*public void produce(int i) {
            while (sharedQueue.size() == size) {
                synchronized (sharedQueue) {
                    try {
                        sharedQueue.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

            }

            synchronized (sharedQueue) {
                System.out.println(Thread.currentThread().getName() + i);
                sharedQueue.add(i);
                sharedQueue.notifyAll();
            }
        }*/
    }


    class consumer implements Runnable {
        int size;
        Queue sharedQueue;

        public consumer(int size, Queue sharedQueue) {
            this.size = size;
            this.sharedQueue = sharedQueue;
        }

        public void run() {

            while (true) {
                synchronized (sharedQueue) {
                    while (sharedQueue.isEmpty()) {
                        System.out.println("Queue is empty");
                        try {
                            sharedQueue.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }

                synchronized (sharedQueue) {
                    System.out.println("consuming " + sharedQueue.poll() + " " + sharedQueue.size());
                    sharedQueue.notify();
                    /*try {
                        Thread.sleep(1500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }*/
                }

                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        }
    }
}
