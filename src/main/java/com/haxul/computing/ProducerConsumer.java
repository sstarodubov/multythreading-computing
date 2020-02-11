package com.haxul.computing;

import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class ProducerConsumer {
    public static void main(String[] args) throws InterruptedException {
        Thread thread1 = new Thread(()-> {
            try {
                producer();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        Thread thread2 = new Thread(()-> {
            try {
                consumer();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();


    }

    public static BlockingQueue<Integer> queue = new ArrayBlockingQueue<>(10);

    public static void producer() throws InterruptedException {
        Random random = new Random();
        while (true) {
            queue.put(random.nextInt(100));
        }
    }
    public static void consumer() throws InterruptedException {
        while (true) {
            Thread.sleep(1000);
            System.out.println(queue.take());
            System.out.println(queue.size() + " is size of queue");
        }
    }
}
