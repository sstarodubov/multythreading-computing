package com.haxul.computing;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Runner runner = new Runner();
        Thread thread1 = new Thread(runner);
        thread1.start();
        System.out.println("main thread is here");
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();
        runner.shutdown();
    }
}


class Runner implements Runnable {

    private volatile boolean running = true;

    @Override
    public void run() {
        while (running) {
            System.out.println("Hello");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void shutdown() {
        running = false;
    }
}