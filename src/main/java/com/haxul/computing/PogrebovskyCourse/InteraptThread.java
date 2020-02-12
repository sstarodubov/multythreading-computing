package com.haxul.computing.PogrebovskyCourse;

public class InteraptThread {
    public static void main(String[] args) {
        Thread thread = new Thread(()->{
            try {
                System.out.println("thread is starting");
                Thread.sleep(5000000);
            } catch (InterruptedException e) {
                System.out.println("Thread has stoped");
            }
        });

        thread.start();

        thread.interrupt();
    }

}
