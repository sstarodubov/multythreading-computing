package com.haxul.computing.PogrebovskyCourse;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CreateThread {
    public static final int MAX_VALUE = 9999;

    public static void main(String[] args) {
        Vault vault = new Vault(new Random().nextInt(MAX_VALUE));
        List<Thread> list = new ArrayList<>();
        list.add(new DiscandingHacker(vault));
        list.add(new AcsendicHacker(vault));
        list.add(new Defender());
        for (Thread thread : list) {
            thread.start();
        }
    }

    public static class Vault {
        private int password;

        public Vault(int num) {
            this.password = num;
        }

        public boolean isCorrectPassword(int guess) throws InterruptedException {
            Thread.sleep(1);
            return this.password == guess;
        }
    }

    public abstract static class ThreadHacker extends Thread {
        protected Vault vault;

        public ThreadHacker(Vault vault) {
            this.vault = vault;
            this.setName(this.getClass().getName());
            this.setPriority(Thread.MAX_PRIORITY);
        }

        @Override
        public void start() {
            System.out.println(this.getName() + " is starting");
            super.start();
        }

    }

    public static class DiscandingHacker extends ThreadHacker {

        public DiscandingHacker(Vault vault) {
            super(vault);
        }

        @Override
        public void run() {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            for (int i = MAX_VALUE; i > 0; i--) {
                try {
                    if (vault.isCorrectPassword(i)) {
                        System.out.println("vault is broken");
                        System.exit(0);
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static class AcsendicHacker extends ThreadHacker {

        public AcsendicHacker(Vault vault) {
            super(vault);
        }

        @Override
        public void run() {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            for (int i = 0; i < MAX_VALUE; i++) {
                try {
                    if (vault.isCorrectPassword(i)) {
                        System.out.println("vault is broken");
                        System.exit(0);
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static class Defender extends Thread {
        @Override
        public void run() {
            for (int i = 10; i > 0; i--) {
                try {
                    Thread.sleep(1000);
                    System.out.println(i);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("The game is over");
            System.exit(0);
        }
    }
}
