package com.haxul.computing.AlishevCourse;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ThreadPool {

    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        for (int i = 0; i < 5 ; i++) {
            executorService.submit(new Worker2(i));
        }

        executorService.shutdown();
        System.out.println("Tasks are submitted");

        executorService.awaitTermination(1, TimeUnit.MINUTES);

        System.out.println("Tasks are finished");
    }
}

class Worker2 implements Runnable {

    private int id;

    public Worker2 (int _id) {
        id = _id;
    }
    @Override
    public void run() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Work specified by id " + id + " is done");
    }
}
