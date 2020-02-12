package com.haxul.computing.PogrebovskyCourse;

import java.lang.reflect.Array;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Join {
    public static void main(String[] args) throws InterruptedException {
        List<Long> list = Arrays.asList(23L, 31L, 434L);
        List<Thread> threads = new ArrayList<>();
        for(long number: list) {
            threads.add(new MultyThread(number));
        }
        for(Thread thread : threads) {
            thread.start();
        }
        for(Thread thread : threads) {
            thread.join();
        }
        for (Thread thread : threads) {
            MultyThread multyThread = (MultyThread) thread;
            System.out.println(multyThread.getResult());
        }
    }

    public static class MultyThread  extends Thread{
        private boolean isFinished = false;
        private long number;
        private long result = 1;

        public MultyThread(long number) {
            this.number = number;
        }

        public boolean isFinished() {
            return isFinished;
        }

        public void setFinished(boolean finished) {
            isFinished = finished;
        }

        @Override
        public void run() {
            result = number;
            for (long i = 1; i < 1_00000000L; i++) {
                result += i;
            }
            this.isFinished = true;
        }

        public long getNumber() {
            return number;
        }

        public void setNumber(long number) {
            this.number = number;
        }

        public long getResult() {
            return result;
        }

        public void setResult(long result) {
            this.result = result;
        }
    }
}
