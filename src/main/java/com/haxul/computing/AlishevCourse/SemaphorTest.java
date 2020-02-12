package com.haxul.computing.AlishevCourse;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

public class SemaphorTest {

    public static void main(String[] args) throws InterruptedException {
        Connection connection = Connection.getConnection();
        ExecutorService executorService = Executors.newFixedThreadPool(200);
        for (int i = 0; i < 200; i++) {
            executorService.submit(()-> {
                try {
                    connection.work();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }
        executorService.shutdown();
    }
}

class Connection {
    private Connection() {}
    private static Connection connection = new Connection();
    private int countConnection;
    private Semaphore semaphore = new Semaphore(5);
    public static Connection getConnection() {
        return connection;
    }

    public void work() throws InterruptedException {
        semaphore.acquire();
        try {
            doWork();
        }finally {
            semaphore.release();
        }
    }
    private void doWork() throws InterruptedException {
        synchronized (this) {
            countConnection++;
            System.out.println(countConnection);
        }
        Thread.sleep(4000);
        synchronized (this) {
            countConnection--;
        }
    }


}
