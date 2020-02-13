package com.haxul.computing.PogrebovskyCourse;

public class DeadLock {
    public static void main(String[] args) {
        Intersection intersection = new Intersection();
        Thread thread1 = new Thread(()->intersection.takeRoadA());
        Thread thread2 = new Thread(()->intersection.takeRoadB());
        thread1.start();
        thread2.start();
    }
}


class Intersection {
    private Object lock1 = new Object();
    private Object lock2 = new Object();

    public void takeRoadA() {
        synchronized (lock1) {
            System.out.println("Road A is busy");
            synchronized (lock2) {
                System.out.println("Train is passing through road A");
            }
        }

    }

    public void takeRoadB() {
        synchronized (lock2) {
            System.out.println("Road B is busy");
            synchronized (lock1) {
                System.out.println("Train is passing through road B");
            }
        }

    }
}
