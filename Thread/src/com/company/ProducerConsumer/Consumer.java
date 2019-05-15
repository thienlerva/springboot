package com.company.ProducerConsumer;

import java.util.Queue;

public class Consumer implements Runnable {

    private Queue<Integer> sharedQueue;

    public Consumer(Queue<Integer> sharedQueue) {
        this.sharedQueue = sharedQueue;
    }

    public void run() {
        while (true) {
            synchronized (sharedQueue) {
                while (sharedQueue.isEmpty()) {
                    try {
                        System.out.println("Consumer is waiting to produce objects by Producer..");
                        sharedQueue.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                Integer data = sharedQueue.poll();
                System.out.println("Consumer::" + data);
                sharedQueue.notify();
            }

        }
    }
}
