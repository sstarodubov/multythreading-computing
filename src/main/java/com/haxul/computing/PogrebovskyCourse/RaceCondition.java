package com.haxul.computing.PogrebovskyCourse;

public class RaceCondition {
    public static void main(String[] args) throws InterruptedException {
        Task task = new Task();
        Thread thread = new Thread(()-> {
            for (int i = 0; i < 1000 ; i++) {
                task.increment();
            }
        });

        Thread thread2 = new Thread(()-> {
            for (int i = 0; i < 1000 ; i++) {
                task.dicrement();
            }
        });

        thread.start();
        thread2.start();
        thread.join();
        thread2.join();

        System.out.println(task.getCounter());
    }
}

class Task {
    private int counter;
    private Object lock = new Object();
    public void increment() {
        synchronized (lock) {
            counter++;
        }
    }
    public void dicrement() {
        synchronized (lock) {
            counter--;
        }
    }

    public int getCounter() {
        return counter;
    }
}
