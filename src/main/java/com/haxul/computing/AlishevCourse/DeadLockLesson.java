package com.haxul.computing.AlishevCourse;

public class DeadLockLesson {
    public static void main(String[] args) throws InterruptedException {

        Task1 task1 = new Task1();
        Thread thread1 = new Thread(()-> task1.do1());
        Thread thread2 = new Thread(()-> task1.do2());

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();

        task1.finish();
    }
}

class Task1 {
    public void do1() {

    }

    public void do2() {

    }

    public void finish() {}
}