package com.github.angads25.javaplayground.concepts.multithreading.locks;

import java.util.Random;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockInterfaceDemo {

    public static void main(String[] args) {
        ProcessingClass processingClass = new ProcessingClass();
        for (int i = 0; i < 10; i++) {
            Thread T1 = new Thread(processingClass::process);
            T1.setName(String.valueOf(i));
            T1.start();
        }
    }
}

class ProcessingClass {
    private final Lock lock;

    ProcessingClass() {
        lock = new ReentrantLock();
    }

    void process() {
        lock.lock();
        System.out.println("Thread " + Thread.currentThread().getName() + " has locked the process");
        try {
            Random random = new Random();
            Thread.sleep(random.nextInt(3000));
            System.out.println("Thread " + Thread.currentThread().getName() + " is Processing");
        } catch(InterruptedException e) {
            e.printStackTrace();
        } finally {
            System.out.println("Thread " + Thread.currentThread().getName() + " has Processed");
            lock.unlock();
        }
    }
}