package com.haxul.computing;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        new Worker().main();
    }
}


class Worker {
    private List<Integer> list1 = new ArrayList<>();
    private List<Integer> list2 = new ArrayList<>();

    private Random random = new Random();

    private Object lock1 = new Object();
    private Object lock2 = new Object();

    private  void addToList1() {
        synchronized (lock1) {
            list1.add(random.nextInt(100));
        }
    }

    private  void addToList2() {
        synchronized (lock2) {
            list2.add(random.nextInt(100));
        }
    }

    public void work() {
        for (int i = 0; i < 1000000 ; i++) {
            addToList1();
            addToList2();
        }
    }

    public void main() throws InterruptedException {
        long before = System.currentTimeMillis();

        Thread thread1 = new Thread(() -> work());
        Thread thread2 = new Thread(() -> work());

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();

        long after = System.currentTimeMillis();

        System.out.println("spent time is " + (after - before));
        System.out.println(list1.size());
        System.out.println(list2.size());
    }
}