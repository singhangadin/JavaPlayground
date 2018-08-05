package com.github.angads25.javaplayground.concepts.multithreading.locks;

import java.util.Random;

public class SynchronizedDemo {

    public static void main(String[] args) {
        SynchronizedProcessingClass processingClass = new SynchronizedProcessingClass();
        for (int i = 0; i < 10; i++) {
            Thread T1 = new Thread(processingClass::process);
            T1.setName(String.valueOf(i));
            T1.start();
        }
    }
}

class SynchronizedProcessingClass {

    void process() {
        synchronized (this) {
            System.out.println("Thread " + Thread.currentThread().getName() + " has locked the process");
            try {
                Random random = new Random();
                Thread.sleep(random.nextInt(3000));
                System.out.println("Thread " + Thread.currentThread().getName() + " is Processing");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                System.out.println("Thread " + Thread.currentThread().getName() + " has Processed");
            }
        }
    }
}