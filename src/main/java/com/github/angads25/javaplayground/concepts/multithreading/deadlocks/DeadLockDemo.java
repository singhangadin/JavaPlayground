package com.github.angads25.javaplayground.concepts.multithreading.deadlocks;

public class DeadLockDemo {

    private static void method1() {
        synchronized (String.class) {
            System.out.println("Method 1 locked String class");
            try {
                Thread.sleep(100);
            } catch(InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (Integer.class) {
                System.out.println("Method 1 locked Integer class");
            }
        }
    }

    private static void method2() {
        synchronized (Integer.class) {
            System.out.println("Method 2 locked Integer class");
            synchronized (String.class) {
                System.out.println("Method 2 locked String class");
            }
        }
    }

    public static void main(String args[]) {
        Thread T1 = new Thread(DeadLockDemo::method1);
        Thread T2 = new Thread(DeadLockDemo::method2);

        T1.start();
        T2.start();
    }
}
