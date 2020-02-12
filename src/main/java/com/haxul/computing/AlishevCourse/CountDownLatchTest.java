package com.haxul.computing.AlishevCourse;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CountDownLatchTest {
    public static void main(String[] args) throws InterruptedException {
        long before = System.currentTimeMillis();

        CountDownLatch countDownLatch = new CountDownLatch(3);
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        for (int i = 0; i < 3; i++) {
            executorService.submit(new AnotherWorker(countDownLatch));
        }
        executorService.shutdown();
        System.out.println("Here");
        countDownLatch.await();
        long after = System.currentTimeMillis();
        System.out.println(after - before);
    }
}

class AnotherWorker implements Runnable {
    private CountDownLatch countDownLatch;

    public AnotherWorker(CountDownLatch countDownLatch) {
        this.countDownLatch = countDownLatch;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        countDownLatch.countDown();
    }
}


