package com.haxul.computing;

import java.util.Random;
import java.util.concurrent.*;

public class CallableTask {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(1);
        Future<Integer> future = executorService.submit(() -> {
            Thread.sleep(4000);
            Random random = new Random();
            return random.nextInt(100);
        });

        executorService.shutdown();
        System.out.println("start...");
        executorService.awaitTermination(1, TimeUnit.MINUTES);
        int result = future.get();
        System.out.println(result);
    }
}
