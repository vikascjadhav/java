package com.parallelstream;

import java.util.stream.Stream;

public class ParallelStream {
    public static void main(String[] args) {
        System.setProperty("java.util.concurrent.ForkJoinPool.common.parallelism", "2");
        Stream.iterate("+", s -> s + "+").parallel().limit(10)
                .peek(s -> System.out
                        .println("s = " + s + " processed by " + Thread.currentThread().getName()))
                .forEach(System.out::println);
    }
}
