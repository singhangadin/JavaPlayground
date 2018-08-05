package com.github.angads25.javaplayground.concepts.multithreading;

public class RunVsStartDemo {

    public static void main(String[] args) {
        // Run in the newly created thread
        Thread T1 = new Thread(RunVsStartDemo::run);
        T1.start();

        // Runs in the main thread
        Thread T2 = new Thread(RunVsStartDemo::run);
        T2.run();
    }

    private static void run() {
        System.out.println(Thread.currentThread().getName());
    }
}
