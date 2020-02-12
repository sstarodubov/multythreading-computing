package com.haxul.computing.AlishevCourse;

import java.util.Scanner;

public class WaitNotify {
    public static void main(String[] args) throws InterruptedException {
        Test test = new Test();

        Thread thread1 = new Thread(()-> {
            try {
                test.produce();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        Thread thread2 = new Thread(()-> {
            try {
                test.consume();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();
    }
}

class Test {
    /**
     * conditions waking up the waited threads are
     * 1. the lock is free
     * 2. invoke notify method synchronized on the same object
     * */
    Object lock = new Object();
    public void produce() throws InterruptedException {
        synchronized (lock) {
            System.out.println("produce is starting");
            lock.wait(); // stops and gives the lock
            System.out.println("produce is resume");
        }
    }
    public void consume() throws InterruptedException {
        synchronized (lock) {
            Thread.sleep(1000);
            System.out.println("press to pass lock");
            Scanner scanner = new Scanner(System.in);
            scanner.nextLine();
            lock.notify();
            Thread.sleep(2000);
            System.out.println("consume end");
        }
    }
}
