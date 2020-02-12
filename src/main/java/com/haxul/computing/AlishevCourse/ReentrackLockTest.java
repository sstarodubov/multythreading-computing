package com.haxul.computing.AlishevCourse;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrackLockTest {
    public static void main(String[] args) throws InterruptedException {
        Task task = new Task();

        Thread thread1 = new Thread(()-> task.first());
        Thread thread2 = new Thread(()-> task.second());

        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();

        task.show();
    }
}

class Task {
    private int count;
    private Lock lock = new ReentrantLock();
    private void increment() {
        for (int i = 0; i < 10000 ; i++) {
            count++;
        }
    }

    public void first() {
        lock.lock();
        increment();
        lock.unlock();
    }

    public void second() {
        lock.lock();
        increment();
        lock.unlock();
    }

    public void show() {
        System.out.println(count);
    }
}
