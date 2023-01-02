package com.practice.java8;


public class RunnableLambda {

    public static void main(String[] args) throws InterruptedException {
        Runnable r = () -> {
            for (int i = 0; i < 10; i++) {
                System.out.println("hello");
            }

        };
        Thread t = new Thread(r);
        t.start();
        t.join();
    }

}
