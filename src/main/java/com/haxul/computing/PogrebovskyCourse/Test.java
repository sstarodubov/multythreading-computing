package com.haxul.computing.PogrebovskyCourse;

import com.sun.jmx.remote.internal.ArrayQueue;

import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

public class Test {
    public static void main(String[] args) {
        Queue<Integer> queue = (Queue<Integer>) new ArrayQueue<Integer>(2);
        queue.add(10);
        queue.add(23);
        System.out.println(queue.remove());
        for (Integer num: queue) {
            System.out.println(num);
        }

    }
}
